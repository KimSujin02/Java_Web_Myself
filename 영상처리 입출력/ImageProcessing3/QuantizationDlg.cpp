// QuantizationDlg.cpp : 구현 파일입니다.
//

#include "stdafx.h"
#include "ImageProcessing3.h"
#include "QuantizationDlg.h"
#include "afxdialogex.h"


// CQuantizationDlg 대화 상자입니다.

IMPLEMENT_DYNAMIC(CQuantizationDlg, CDialog)

CQuantizationDlg::CQuantizationDlg(CWnd* pParent /*=NULL*/)
	: CDialog(IDD_DIALOG3, pParent)
	, m_QuantBit(0)
{

}

CQuantizationDlg::~CQuantizationDlg()
{
}

void CQuantizationDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	DDX_Text(pDX, IDC_EDIT1, m_QuantBit);
	DDV_MinMaxInt(pDX, m_QuantBit, 1, 8);
}


BEGIN_MESSAGE_MAP(CQuantizationDlg, CDialog)
END_MESSAGE_MAP()


// CQuantizationDlg 메시지 처리기입니다.
