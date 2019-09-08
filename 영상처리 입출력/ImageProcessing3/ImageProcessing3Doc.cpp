
// ImageProcessing3Doc.cpp : CImageProcessing3Doc 클래스의 구현
//

#include "stdafx.h"
// SHARED_HANDLERS는 미리 보기, 축소판 그림 및 검색 필터 처리기를 구현하는 ATL 프로젝트에서 정의할 수 있으며
// 해당 프로젝트와 문서 코드를 공유하도록 해 줍니다.
#ifndef SHARED_HANDLERS
#include "ImageProcessing3.h"
#endif

#include "ImageProcessing3Doc.h"

#include <propkey.h>

#ifdef _DEBUG
#define new DEBUG_NEW
#endif

#include "DownSampleDlg.h"//드디어 _ㅠㅠㅠ_ㅠ_ㅠ_ㅠ응헝헝헝허어헝헝허엏엏엏어
#include "UpsampleDlg.h"

#include "QuantizationDlg.h"
#include "math.h"

#include "ConstantDlg.h"

// CImageProcessing3Doc

IMPLEMENT_DYNCREATE(CImageProcessing3Doc, CDocument)

BEGIN_MESSAGE_MAP(CImageProcessing3Doc, CDocument)
	ON_COMMAND(ID_SUM_CONSTANT, &CImageProcessing3Doc::OnSumConstant)
	ON_COMMAND(ID_SUB_CONSTANT, &CImageProcessing3Doc::OnSubConstant)
	ON_COMMAND(ID_MUL_CONSTANT, &CImageProcessing3Doc::OnMulConstant)
	ON_COMMAND(ID_DIV_CONSTANT, &CImageProcessing3Doc::OnDivConstant)
END_MESSAGE_MAP()


// CImageProcessing3Doc 생성/소멸

CImageProcessing3Doc::CImageProcessing3Doc()
	: m_InputImage(NULL)
	, m_width(0)
	, m_height(0)
	, m_size(0)
	, m_OutputImage(NULL)
	, m_Re_width(0)
	, m_Re_height(0)
	, m_Re_size(0)
{
	// TODO: 여기에 일회성 생성 코드를 추가합니다.

}

CImageProcessing3Doc::~CImageProcessing3Doc()
{
}

BOOL CImageProcessing3Doc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: 여기에 재초기화 코드를 추가합니다.
	// SDI 문서는 이 문서를 다시 사용합니다.

	return TRUE;
}




// CImageProcessing3Doc serialization

void CImageProcessing3Doc::Serialize(CArchive& ar)
{
	if (ar.IsStoring())
	{
		// TODO: 여기에 저장 코드를 추가합니다.
	}
	else
	{
		// TODO: 여기에 로딩 코드를 추가합니다.
	}
}

#ifdef SHARED_HANDLERS

// 축소판 그림을 지원합니다.
void CImageProcessing3Doc::OnDrawThumbnail(CDC& dc, LPRECT lprcBounds)
{
	// 문서의 데이터를 그리려면 이 코드를 수정하십시오.
	dc.FillSolidRect(lprcBounds, RGB(255, 255, 255));
	

	CString strText = _T("TODO: implement thumbnail drawing here");
	LOGFONT lf;

	CFont* pDefaultGUIFont = CFont::FromHandle((HFONT) GetStockObject(DEFAULT_GUI_FONT));
	pDefaultGUIFont->GetLogFont(&lf);
	lf.lfHeight = 36;

	CFont fontDraw;
	fontDraw.CreateFontIndirect(&lf);

	CFont* pOldFont = dc.SelectObject(&fontDraw);
	dc.DrawText(strText, lprcBounds, DT_CENTER | DT_WORDBREAK);
	dc.SelectObject(pOldFont);
}

// 검색 처리기를 지원합니다.
void CImageProcessing3Doc::InitializeSearchContent()
{
	CString strSearchContent;
	// 문서의 데이터에서 검색 콘텐츠를 설정합니다.
	// 콘텐츠 부분은 ";"로 구분되어야 합니다.

	// 예: strSearchContent = _T("point;rectangle;circle;ole object;");
	SetSearchContent(strSearchContent);
}

void CImageProcessing3Doc::SetSearchContent(const CString& value)
{
	if (value.IsEmpty())
	{
		RemoveChunk(PKEY_Search_Contents.fmtid, PKEY_Search_Contents.pid);
	}
	else
	{
		CMFCFilterChunkValueImpl *pChunk = NULL;
		ATLTRY(pChunk = new CMFCFilterChunkValueImpl);
		if (pChunk != NULL)
		{
			pChunk->SetTextValue(PKEY_Search_Contents, value, CHUNK_TEXT);
			SetChunkValue(pChunk);
		}
	}
}

#endif // SHARED_HANDLERS

// CImageProcessing3Doc 진단

#ifdef _DEBUG
void CImageProcessing3Doc::AssertValid() const
{
	CDocument::AssertValid();
}

void CImageProcessing3Doc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG


// CImageProcessing3Doc 명령


BOOL CImageProcessing3Doc::OnOpenDocument(LPCTSTR lpszPathName)
{
	if (!CDocument::OnOpenDocument(lpszPathName))
		return FALSE;

	// TODO:  여기에 특수화된 작성 코드를 추가합니다.
	CFile File;
	File.Open(lpszPathName, CFile::modeRead | CFile:: typeBinary);

	if (File.GetLength() == 256 * 256) {
		m_height = 256;
		m_width = 256;
	}
	else if (File.GetLength() == 512 * 512) {
		m_height = 512;
		m_width = 512;
	}
	else if (File.GetLength() == 640 * 480) {
		m_height = 480;
		m_width = 640;
	}

	////////////////////////////////////////////////////////////////////////
	//***************320x240크기의 파일열기추가********************/////////
	else if (File.GetLength() == 320 * 240) {
		m_height = 320;
		m_width = 240;
	}
	else {
		AfxMessageBox(LPCTSTR("Not Suppport Image Size"));
		return 0;
	}

	m_size = m_width*m_height;
	m_InputImage = (new unsigned char[m_size]);

	for (int i = 0; i < m_size; i++)
		m_InputImage[i] = 255;

	File.Read(m_InputImage, m_size);
	File.Close();

	return TRUE;
}




void CImageProcessing3Doc::OnDownSampling()
{
	int i, j;
	CDownSampleDlg dlg;
	if (dlg.DoModal() == IDOK)
	{
		m_Re_height = m_height / dlg.m_DownSampleRate; //축소영상의 세로 길이 계산
		m_Re_width = m_width / dlg.m_DownSampleRate; //축소영상의 가로 길이 계산
		m_Re_size = m_Re_height*m_Re_width; //축소영상의 크기를 계산

		m_OutputImage = new unsigned char[m_Re_size]; //축소영상을 위한 메모리 할당

		for (i = 0; i < m_Re_height; i++) {
			for (j = 0; j < m_Re_width; j++) {
				m_OutputImage[i*m_Re_width + j] = m_InputImage[(i*dlg.m_DownSampleRate*m_width) + dlg.m_DownSampleRate*j];
				//축소영상을 생성
			}
		}
	}
}


void CImageProcessing3Doc::OnUpSampling()
{
	int i, j;
	CUpSampleDlg dlg;
	if (dlg.DoModal() == IDOK) {
		m_Re_height = m_height * dlg.m_UpSampleRate;
		m_Re_width = m_width * dlg.m_UpSampleRate;
		m_Re_size = m_Re_height *m_Re_width;
		m_OutputImage = new unsigned char[m_Re_size];

		for (i = 0; i < m_height; i++) {
			for (j = 0; j < m_width; j++) {
				m_OutputImage[i*dlg.m_UpSampleRate*m_Re_width + dlg.m_UpSampleRate*j] = m_InputImage[i*m_width + j];
			}
		}
	}
}


void CImageProcessing3Doc::OnQuantization()
{
	CQuantizationDlg dlg;

	if (dlg.DoModal() == IDOK)
	{
		int i, j, value, LEVEL;
		double HIGH, *TEMP;

		m_Re_height = m_height;
		m_Re_width = m_width;
		m_Re_size = m_Re_height * m_Re_width;

		m_OutputImage = new unsigned char[m_Re_size];

		TEMP = new double[m_size];

		LEVEL = 256;
		HIGH = 256;

		value = (int)pow(2, dlg.m_QuantBit);

		for (i = 0; i < m_size; i++) {
			for (j = 0; j < value; j++) {
				if (m_InputImage[i] >= (LEVEL / value)*j&&m_InputImage[i] < (LEVEL / value)*(j + 1)) {
					TEMP[i] = (double)(HIGH / value)*j;
				}
			}
		}
		for (i = 0; i < m_size; i++) {
			m_OutputImage[i] = (unsigned char)TEMP[i];
		}
	}
}


void CImageProcessing3Doc::OnSumConstant()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	CConstantDlg dlg;

	int i;
	m_Re_height = m_height;
	m_Re_width = m_width;
	m_Re_size = m_Re_height*m_Re_width;

	m_OutputImage = new unsigned char[m_Re_size];

	if (dlg.DoModal() == IDOK) {
		for (i = 0; i < m_size; i++) {
			if (m_InputImage[i] + dlg.m_Constant >= 255)
				m_OutputImage[i] = 255;
			else
				m_OutputImage[i] = (unsigned char)(m_InputImage[i] + dlg.m_Constant);
		}
	}
}


void CImageProcessing3Doc::OnSubConstant()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	CConstantDlg dlg;
	int i;
	m_Re_height = m_height;
	m_Re_width = m_width;
	m_Re_size = m_Re_height * m_Re_width;

	m_OutputImage = new unsigned char[m_Re_size];

	if (dlg.DoModal() == IDOK) {
		for (i = 0; i < m_size; i++) {
			if (m_InputImage[i] - dlg.m_Constant < 0)
				m_OutputImage[i] = 0;
			else
				m_OutputImage[i] = (unsigned char)(m_InputImage[i] - dlg.m_Constant);
		}
	}
}


void CImageProcessing3Doc::OnMulConstant()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	CConstantDlg dlg;
	int i;
	m_Re_height = m_height;
	m_Re_width = m_width;
	m_Re_size = m_Re_height*m_Re_width;

	m_OutputImage = new unsigned char[m_Re_size];

	if (dlg.DoModal() == IDOK) {
		for (i = 0; i < m_size; i++) {
			if (m_InputImage[i] * dlg.m_Constant>255)
				m_OutputImage[i] = 255;
			else if (m_InputImage[i] * dlg.m_Constant < 0)
				m_OutputImage[i] = 0;
			else
				m_OutputImage[i] = (unsigned char)(m_InputImage[i] * dlg.m_Constant);
		}
	}
}


void CImageProcessing3Doc::OnDivConstant()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	CConstantDlg dlg;
	int i;

	m_Re_height = m_height;
	m_Re_width = m_width;
	m_Re_size = m_Re_height * m_Re_width;

	m_OutputImage = new unsigned char[m_Re_size];

	if (dlg.DoModal() == IDOK) {
		for (i = 0; i < m_size; i++) {
			if (m_InputImage[i] / dlg.m_Constant>255)
				m_OutputImage[i] = 255;
			else if (m_InputImage[i] / dlg.m_Constant < 0)
				m_OutputImage[i] = 0;
			else
				m_OutputImage[i] = (unsigned char)(m_InputImage[i] / dlg.m_Constant);

		}
	}
}
