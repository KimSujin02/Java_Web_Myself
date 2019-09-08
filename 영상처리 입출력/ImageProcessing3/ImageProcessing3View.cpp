
// ImageProcessing3View.cpp : CImageProcessing3View 클래스의 구현
//

#include "stdafx.h"
// SHARED_HANDLERS는 미리 보기, 축소판 그림 및 검색 필터 처리기를 구현하는 ATL 프로젝트에서 정의할 수 있으며
// 해당 프로젝트와 문서 코드를 공유하도록 해 줍니다.
#ifndef SHARED_HANDLERS
#include "ImageProcessing3.h"
#endif

#include "ImageProcessing3Doc.h"
#include "ImageProcessing3View.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CImageProcessing3View

IMPLEMENT_DYNCREATE(CImageProcessing3View, CView)

BEGIN_MESSAGE_MAP(CImageProcessing3View, CView)
	// 표준 인쇄 명령입니다.
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CView::OnFilePrintPreview)
	ON_COMMAND(ID_DOWN_SAMPLING, &CImageProcessing3View::OnDownSampling)
	ON_COMMAND(ID_UP_SAMPLING, &CImageProcessing3View::OnUpSampling)
	ON_COMMAND(ID_QUANTIZATION, &CImageProcessing3View::OnQuantization)
	ON_COMMAND(ID_SUM_CONSTANT, &CImageProcessing3View::OnSumConstant)
	ON_COMMAND(ID_SUB_CONSTANT, &CImageProcessing3View::OnSubConstant)
	ON_COMMAND(ID_MUL_CONSTANT, &CImageProcessing3View::OnMulConstant)
	ON_COMMAND(ID_DIV_CONSTANT, &CImageProcessing3View::OnDivConstant)
END_MESSAGE_MAP()

// CImageProcessing3View 생성/소멸

CImageProcessing3View::CImageProcessing3View()
{
	// TODO: 여기에 생성 코드를 추가합니다.

}

CImageProcessing3View::~CImageProcessing3View()
{
}

BOOL CImageProcessing3View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: CREATESTRUCT cs를 수정하여 여기에서
	//  Window 클래스 또는 스타일을 수정합니다.

	return CView::PreCreateWindow(cs);
}

// CImageProcessing3View 그리기

void CImageProcessing3View::OnDraw(CDC* pDC)
{
	// TODO: 여기에 원시 데이터에 대한 그리기 코드를 추가합니다.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);

	int i, j;
	unsigned char R, G, B;
	//입력영상 출력
	for (i = 0; i < pDoc->m_height; i++) {
		for (j = 0; j < pDoc->m_width; j++) {
			R = G = B = pDoc->m_InputImage[i*pDoc->m_width + j];
			pDC->SetPixel(j + 5, i + 5, RGB(R, G, B));
		}
	}
	
	//축소영상 출력
	for (i = 0; i < pDoc->m_Re_height; i++) {
		for (j = 0; j < pDoc->m_Re_width; j++) {
			R = pDoc->m_OutputImage[i*pDoc->m_Re_width + j];
			G = B = R;
		
			pDC->SetPixel(j + pDoc->m_width + 10, i + 5, RGB(R, G, B));
		}
	}
	//if (!pDoc)
	//	return;

	
}


// CImageProcessing3View 인쇄

BOOL CImageProcessing3View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// 기본적인 준비
	return DoPreparePrinting(pInfo);
}

void CImageProcessing3View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 인쇄하기 전에 추가 초기화 작업을 추가합니다.
}

void CImageProcessing3View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 인쇄 후 정리 작업을 추가합니다.
}


// CImageProcessing3View 진단

#ifdef _DEBUG
void CImageProcessing3View::AssertValid() const
{
	CView::AssertValid();
}

void CImageProcessing3View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CImageProcessing3Doc* CImageProcessing3View::GetDocument() const // 디버그되지 않은 버전은 인라인으로 지정됩니다.
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CImageProcessing3Doc)));
	return (CImageProcessing3Doc*)m_pDocument;
}
#endif //_DEBUG


// CImageProcessing3View 메시지 처리기


void CImageProcessing3View::OnDownSampling()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	CImageProcessing3Doc* pDoc = GetDocument(); //Doc클래스 참조
	ASSERT_VALID(pDoc);

	pDoc->OnDownSampling(); //Doc 클래스에 OnDownSampling 함수 호출
	Invalidate(TRUE); //화면 갱신
}


void CImageProcessing3View::OnUpSampling()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);

	pDoc->OnUpSampling();
	Invalidate(TRUE);
}


void CImageProcessing3View::OnQuantization()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);

	pDoc->OnQuantization();
	Invalidate(TRUE);
}


void CImageProcessing3View::OnSumConstant()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	pDoc->OnSumConstant();
	Invalidate(TRUE);
}


void CImageProcessing3View::OnSubConstant()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);

	pDoc->OnSubConstant();
	Invalidate(TRUE);
}


void CImageProcessing3View::OnMulConstant()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	pDoc->OnMulConstant();
	Invalidate(TRUE);
}


void CImageProcessing3View::OnDivConstant()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);

	pDoc->OnDivConstant();
	Invalidate(TRUE);
}
