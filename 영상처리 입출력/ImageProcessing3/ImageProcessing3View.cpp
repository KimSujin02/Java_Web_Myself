
// ImageProcessing3View.cpp : CImageProcessing3View Ŭ������ ����
//

#include "stdafx.h"
// SHARED_HANDLERS�� �̸� ����, ����� �׸� �� �˻� ���� ó���⸦ �����ϴ� ATL ������Ʈ���� ������ �� ������
// �ش� ������Ʈ�� ���� �ڵ带 �����ϵ��� �� �ݴϴ�.
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
	// ǥ�� �μ� ����Դϴ�.
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

// CImageProcessing3View ����/�Ҹ�

CImageProcessing3View::CImageProcessing3View()
{
	// TODO: ���⿡ ���� �ڵ带 �߰��մϴ�.

}

CImageProcessing3View::~CImageProcessing3View()
{
}

BOOL CImageProcessing3View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: CREATESTRUCT cs�� �����Ͽ� ���⿡��
	//  Window Ŭ���� �Ǵ� ��Ÿ���� �����մϴ�.

	return CView::PreCreateWindow(cs);
}

// CImageProcessing3View �׸���

void CImageProcessing3View::OnDraw(CDC* pDC)
{
	// TODO: ���⿡ ���� �����Ϳ� ���� �׸��� �ڵ带 �߰��մϴ�.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);

	int i, j;
	unsigned char R, G, B;
	//�Է¿��� ���
	for (i = 0; i < pDoc->m_height; i++) {
		for (j = 0; j < pDoc->m_width; j++) {
			R = G = B = pDoc->m_InputImage[i*pDoc->m_width + j];
			pDC->SetPixel(j + 5, i + 5, RGB(R, G, B));
		}
	}
	
	//��ҿ��� ���
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


// CImageProcessing3View �μ�

BOOL CImageProcessing3View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// �⺻���� �غ�
	return DoPreparePrinting(pInfo);
}

void CImageProcessing3View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: �μ��ϱ� ���� �߰� �ʱ�ȭ �۾��� �߰��մϴ�.
}

void CImageProcessing3View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: �μ� �� ���� �۾��� �߰��մϴ�.
}


// CImageProcessing3View ����

#ifdef _DEBUG
void CImageProcessing3View::AssertValid() const
{
	CView::AssertValid();
}

void CImageProcessing3View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CImageProcessing3Doc* CImageProcessing3View::GetDocument() const // ����׵��� ���� ������ �ζ������� �����˴ϴ�.
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CImageProcessing3Doc)));
	return (CImageProcessing3Doc*)m_pDocument;
}
#endif //_DEBUG


// CImageProcessing3View �޽��� ó����


void CImageProcessing3View::OnDownSampling()
{
	// TODO: ���⿡ ��� ó���� �ڵ带 �߰��մϴ�.
	CImageProcessing3Doc* pDoc = GetDocument(); //DocŬ���� ����
	ASSERT_VALID(pDoc);

	pDoc->OnDownSampling(); //Doc Ŭ������ OnDownSampling �Լ� ȣ��
	Invalidate(TRUE); //ȭ�� ����
}


void CImageProcessing3View::OnUpSampling()
{
	// TODO: ���⿡ ��� ó���� �ڵ带 �߰��մϴ�.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);

	pDoc->OnUpSampling();
	Invalidate(TRUE);
}


void CImageProcessing3View::OnQuantization()
{
	// TODO: ���⿡ ��� ó���� �ڵ带 �߰��մϴ�.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);

	pDoc->OnQuantization();
	Invalidate(TRUE);
}


void CImageProcessing3View::OnSumConstant()
{
	// TODO: ���⿡ ��� ó���� �ڵ带 �߰��մϴ�.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	pDoc->OnSumConstant();
	Invalidate(TRUE);
}


void CImageProcessing3View::OnSubConstant()
{
	// TODO: ���⿡ ��� ó���� �ڵ带 �߰��մϴ�.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);

	pDoc->OnSubConstant();
	Invalidate(TRUE);
}


void CImageProcessing3View::OnMulConstant()
{
	// TODO: ���⿡ ��� ó���� �ڵ带 �߰��մϴ�.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	pDoc->OnMulConstant();
	Invalidate(TRUE);
}


void CImageProcessing3View::OnDivConstant()
{
	// TODO: ���⿡ ��� ó���� �ڵ带 �߰��մϴ�.
	CImageProcessing3Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);

	pDoc->OnDivConstant();
	Invalidate(TRUE);
}
