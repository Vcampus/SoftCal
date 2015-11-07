package com.seu.ui.cal;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.List;

import com.seu.ui.main.AddVersionShell;

public class CompWorkCal extends Composite {
	private Text textlblExternalInputFile;
	private Text textExternalInputData;
	private Text textExternalOutputFile;
	private Text text_3;
	private Text textExternalSearchFile;
	private Text textExternalSearchData;
	private Text textInsideLogicFileMemory;
	private Text textlInsideLogicFileData;
	private Text textExternalInterfaceFileMemory;
	private Text textExternalInterfaceFileData;
	private Text textAdjustScale;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CompWorkCal(Composite parent, int style) {
		super(parent, style);
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		tabFolder.setBounds(10, 57, 574, 407);

		
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("软件规模SizeM");
		Composite cpSizeM= new Composite(tabFolder, SWT.NONE);
		tabItem.setControl(cpSizeM);
		
		Label lblExternalInputFile = new Label(cpSizeM, SWT.NONE);
		lblExternalInputFile.setBounds(33, 32, 115, 21);
		lblExternalInputFile.setText("外部输入文件类型数");
		
		textlblExternalInputFile = new Text(cpSizeM, SWT.BORDER);
		textlblExternalInputFile.setBounds(173, 29, 73, 21);
		
		Label lblExternalInputData = new Label(cpSizeM, SWT.NONE);
		lblExternalInputData.setBounds(302, 32, 123, 21);
		lblExternalInputData.setText("外部输入数据类型数");
		
		textExternalInputData = new Text(cpSizeM, SWT.BORDER);
		textExternalInputData.setBounds(447, 29, 73, 21);
		
		Label lblExternalOutputFile = new Label(cpSizeM, SWT.NONE);
		lblExternalOutputFile.setText("外部输出文件类型数");
		lblExternalOutputFile.setBounds(33, 78, 115, 15);
		
		textExternalOutputFile = new Text(cpSizeM, SWT.BORDER);
		textExternalOutputFile.setBounds(173, 75, 73, 21);
		
		Label lblExternalOutputData = new Label(cpSizeM, SWT.NONE);
		lblExternalOutputData.setText("外部输出数据类型数");
		lblExternalOutputData.setBounds(302, 75, 123, 15);
		
		text_3 = new Text(cpSizeM, SWT.BORDER);
		text_3.setBounds(447, 75, 73, 21);
		
		Label lblExternalSearchFile = new Label(cpSizeM, SWT.NONE);
		lblExternalSearchFile.setText("外部查询文件类型数");
		lblExternalSearchFile.setBounds(33, 124, 115, 15);
		
		textExternalSearchFile = new Text(cpSizeM, SWT.BORDER);
		textExternalSearchFile.setBounds(173, 121, 73, 21);
		
		Label lblExternalSearchData = new Label(cpSizeM, SWT.NONE);
		lblExternalSearchData.setText("外部查询数据类型数");
		lblExternalSearchData.setBounds(302, 121, 123, 18);
		
		textExternalSearchData = new Text(cpSizeM, SWT.BORDER);
		textExternalSearchData.setBounds(447, 121, 73, 21);
		
		Label lblInsideLogicFileMemory = new Label(cpSizeM, SWT.NONE);
		lblInsideLogicFileMemory.setAlignment(SWT.CENTER);
		lblInsideLogicFileMemory.setText("内部逻辑文件记录元素数");
		lblInsideLogicFileMemory.setBounds(33, 169, 134, 18);
		
		textInsideLogicFileMemory = new Text(cpSizeM, SWT.BORDER);
		textInsideLogicFileMemory.setBounds(173, 166, 73, 21);
		
		Label lblInsideLogicFileData = new Label(cpSizeM, SWT.NONE);
		lblInsideLogicFileData.setText("内部逻辑文件数据类型数");
		lblInsideLogicFileData.setBounds(302, 166, 139, 21);
		
		textlInsideLogicFileData = new Text(cpSizeM, SWT.BORDER);
		textlInsideLogicFileData.setBounds(447, 166, 73, 21);
		
		Label lblExternalInterfaceFileMemory = new Label(cpSizeM, SWT.NONE);
		lblExternalInterfaceFileMemory.setText("外部接口文件记录元素数");
		lblExternalInterfaceFileMemory.setBounds(33, 211, 134, 18);
		
		textExternalInterfaceFileMemory = new Text(cpSizeM, SWT.BORDER);
		textExternalInterfaceFileMemory.setBounds(173, 208, 73, 21);
		
		Label lblExternalInterfaceFileData = new Label(cpSizeM, SWT.NONE);
		lblExternalInterfaceFileData.setText("外部接口文件数据类型数");
		lblExternalInterfaceFileData.setBounds(302, 208, 139, 21);
		
		textExternalInterfaceFileData = new Text(cpSizeM, SWT.BORDER);
		textExternalInterfaceFileData.setBounds(447, 208, 73, 21);
		
		Label lblSoftKnowing = new Label(cpSizeM, SWT.NONE);
		lblSoftKnowing.setBounds(33, 260, 78, 15);
		lblSoftKnowing.setText("软件理解因子");
		
		Label lblProgramUnfamili = new Label(cpSizeM, SWT.NONE);
		lblProgramUnfamili.setBounds(302, 260, 103, 15);
		lblProgramUnfamili.setText("程序不熟悉性因子");
		
		Combo cbSoftKnowing = new Combo(cpSizeM, SWT.NONE);
		cbSoftKnowing.setBounds(173, 257, 73, 18);
		cbSoftKnowing.add("很低",0);
		cbSoftKnowing.add("低",1);
		cbSoftKnowing.add("标称",2);
		cbSoftKnowing.add("高",3);
		cbSoftKnowing.add("很高",4);
		
		Combo cbProgramUnfamili = new Combo(cpSizeM, SWT.NONE);
		cbProgramUnfamili.setBounds(447, 257, 73, 23);
		cbProgramUnfamili.add("完全不熟悉", 0);
		cbProgramUnfamili.add("大部分不熟悉", 1);
		cbProgramUnfamili.add("有点熟悉", 2);
		cbProgramUnfamili.add("部分熟悉", 3);
		cbProgramUnfamili.add("大部分熟悉",4);
		cbProgramUnfamili.add("完全熟悉", 5);
		
		Label lblAdjustScale = new Label(cpSizeM, SWT.NONE);
		lblAdjustScale.setBounds(33, 314, 61, 15);
		lblAdjustScale.setText("修改规模");
		
		textAdjustScale = new Text(cpSizeM, SWT.BORDER);
		textAdjustScale.setBounds(173, 311, 73, 21);
		
		TabItem tabfolderEIndex = new TabItem(tabFolder, SWT.NONE);
		tabfolderEIndex.setText("指数E");
		Composite cpEIndex= new Composite(tabFolder, SWT.NONE);
		tabfolderEIndex.setControl(cpEIndex);
		
		Label lblPREC = new Label(cpEIndex, SWT.NONE);
		lblPREC.setText("先例性：");
		lblPREC.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblPREC.setBounds(51, 29, 80, 25);
		
		Label lblFLEX = new Label(cpEIndex, SWT.NONE);
		lblFLEX.setText("开发灵活性：");
		lblFLEX.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblFLEX.setBounds(51, 83, 80, 25);
		
		Label lblRESL = new Label(cpEIndex, SWT.NONE);
		lblRESL.setText("体系结构/风险化解性：");
		lblRESL.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblRESL.setBounds(51, 145, 167, 24);
		
		Label lblTEAM = new Label(cpEIndex, SWT.NONE);
		lblTEAM.setText("团队凝聚力：");
		lblTEAM.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblTEAM.setBounds(51, 204, 96, 25);
		
		Label lblPMAT = new Label(cpEIndex, SWT.NONE);
		lblPMAT.setText("过程成熟度：");
		lblPMAT.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblPMAT.setBounds(51, 262, 123, 24);
		
		Combo cbPREC = new Combo(cpEIndex, SWT.NONE);
		cbPREC.setBounds(245, 29, 111, 23);
		cbPREC.add("全新的",0);
		cbPREC.add("绝大部分新",1);
		cbPREC.add("有一些新",2);
		cbPREC.add("基本熟悉",3);
		cbPREC.add("绝大部分熟悉",4);
		cbPREC.add("完全熟悉",5);
		
		Combo cbFLEX = new Combo(cpEIndex, SWT.NONE);
		cbFLEX.setBounds(245, 83, 111, 23);
		cbFLEX.add("严格", 0);
		cbFLEX.add("偶尔放宽", 1);
		cbFLEX.add("放宽", 2);
		cbFLEX.add("基本一致", 3);
		cbFLEX.add("部分一致", 4);
		cbFLEX.add("通用目标", 5);
		
		Combo cbRESL = new Combo(cpEIndex, SWT.NONE);
		cbRESL.setBounds(245, 145, 111, 23);
		cbRESL.add("很少",0);
		cbRESL.add("一些",1);
		cbRESL.add("常常",2);
		cbRESL.add("通常",3);
		cbRESL.add("绝大多数",4);
		cbRESL.add("安全",5);
		
		Combo cbTEAM = new Combo(cpEIndex, SWT.NONE);
		cbTEAM.setBounds(245, 206, 111, 23);
		cbTEAM.add("交流非常困难", 0);
		cbTEAM.add("交流有些障碍", 1);
		cbTEAM.add("基本的交流协作", 2);
		cbTEAM.add("广泛地协作", 3);
		cbTEAM.add("高度协作", 4);
		cbTEAM.add("无缝协作", 5);
		
		Combo cbPMAT = new Combo(cpEIndex, SWT.NONE);
		cbPMAT.setBounds(245, 262, 111, 23);
		cbPMAT.add("SW-CMM1级较低部分", 0);
		cbPMAT.add("SW-CMM1级较高部分", 0);
		cbPMAT.add("SW-CMM2级", 0);
		cbPMAT.add("SW-CMM3级", 0);
		cbPMAT.add("SW-CMM4级", 0);
		cbPMAT.add("SW-CMM5级", 0);
		
		TabItem tbtmem = new TabItem(tabFolder, SWT.NONE);
		tbtmem.setText("工作量乘数EM");
		Composite cpEM= new Composite(tabFolder, SWT.NONE);
		tbtmem.setControl(cpEM);
		
		Label lblRELY = new Label(cpEM, SWT.NONE);
		lblRELY.setBounds(47, 30, 61, 15);
		lblRELY.setText("软件可靠性");
		Combo cbRELY = new Combo(cpEM, SWT.NONE);
		cbRELY.setBounds(135, 22, 88, 23);
		cbRELY.add("很低",0 );
		cbRELY.add("低", 1);
		cbRELY.add("标称",2 );
		cbRELY.add("高", 3);
		cbRELY.add("很高",4 );
		
		Label lblDOCU = new Label(cpEM, SWT.NONE);
		lblDOCU.setText("文档编制");
		lblDOCU.setBounds(47, 70, 61, 15);
		Combo cbDOCU = new Combo(cpEM, SWT.NONE);
		cbDOCU.setBounds(135, 67, 88, 23);
		cbDOCU.add("很低",0);
		cbDOCU.add("低",1);
		cbDOCU.add("标称",2);
		cbDOCU.add("高",3);
		cbDOCU.add("很高",4);
		
		Label lblSTOR = new Label(cpEM, SWT.NONE);
		lblSTOR.setText("主存储约束");
		lblSTOR.setBounds(47, 110, 61, 15);
		Combo cbSTOR = new Combo(cpEM, SWT.NONE);
		cbSTOR.setBounds(135, 107, 88, 23);
		cbSTOR.add("标称",0);
		cbSTOR.add("高",1);
		cbSTOR.add("很高",2);
		cbSTOR.add("极高",3);
		
		Label lblACAP = new Label(cpEM, SWT.NONE);
		lblACAP.setText("分析员能力");
		lblACAP.setBounds(47, 150, 61, 15);
		Combo cbACAP = new Combo(cpEM, SWT.NONE);
		cbACAP.setBounds(135, 147, 88, 23);
		cbACAP.add("很低",0 );
		cbACAP.add("低",1 );
		cbACAP.add("标称",2 );
		cbACAP.add("高", 3);
		cbACAP.add("很高",4 );
		
		Label lblPCAP = new Label(cpEM, SWT.NONE);
		lblPCAP.setText("程序员能力");
		lblPCAP.setBounds(47, 190, 61, 15);
		Combo cbPCAP = new Combo(cpEM, SWT.NONE);
		cbPCAP.setBounds(135, 187, 88, 23);
		cbPCAP.add("很低",0);
		cbPCAP.add("低", 1);
		cbPCAP.add("标称",2);
		cbPCAP.add("高", 3);
		cbPCAP.add("很高", 4);
		
		Label lblPLEX = new Label(cpEM, SWT.NONE);
		lblPLEX.setText("平台经验");
		lblPLEX.setBounds(47, 230, 61, 15);
		Combo cbPLEX = new Combo(cpEM, SWT.NONE);
		cbPLEX.setBounds(135, 227, 88, 23);
		cbPLEX.add("很低",0);
		cbPLEX.add("低", 1);
		cbPLEX.add("标称",2);
		cbPLEX.add("高", 3);
		cbPLEX.add("很高", 4);
		
		Label lblTOOL = new Label(cpEM, SWT.NONE);
		lblTOOL.setText("软件工具使用");
		lblTOOL.setBounds(47, 270, 61, 15);
		Combo cbTOOL = new Combo(cpEM, SWT.NONE);
		cbTOOL.setBounds(135, 267, 88, 23);
		cbTOOL.add("很低",0);
		cbTOOL.add("低", 1);
		cbTOOL.add("标称",2);
		cbTOOL.add("高", 3);
		cbTOOL.add("很高", 4);
		
		Label lblCPLX = new Label(cpEM, SWT.NONE);
		lblCPLX.setText("产品复杂性");
		lblCPLX.setBounds(293, 25, 61, 15);
		Combo cbCPLX = new Combo(cpEM, SWT.NONE);
		cbCPLX.setBounds(381, 17, 88, 23);
		cbCPLX.add("很低",0);
		cbCPLX.add("低", 1);
		cbCPLX.add("标称",2);
		cbCPLX.add("高", 3);
		cbCPLX.add("很高", 4);
		
		Label lblTIME = new Label(cpEM, SWT.NONE);
		lblTIME.setText("执行时间约束");
		lblTIME.setBounds(293, 65, 61, 15);
		Combo cbTIME = new Combo(cpEM, SWT.NONE);
		cbTIME.setBounds(381, 62, 88, 23);
		cbTIME.add("标称",0);
		cbTIME.add("高",1);
		cbTIME.add("很高",2);
		cbTIME.add("极高",3);
		
		Label lblPVOL = new Label(cpEM, SWT.NONE);
		lblPVOL.setText("平台易变性");
		lblPVOL.setBounds(293, 105, 61, 15);
		Combo cbPVOL = new Combo(cpEM, SWT.NONE);
		cbPVOL.setBounds(381, 102, 88, 23);
		cbPVOL.add("标称",0);
		cbPVOL.add("高",1);
		cbPVOL.add("很高",2);
		cbPVOL.add("极高",3);
		
		Label lblPCON = new Label(cpEM, SWT.NONE);
		lblPCON.setText("人员连续性");
		lblPCON.setBounds(293, 145, 61, 15);
		Combo cbPCON = new Combo(cpEM, SWT.NONE);
		cbPCON.setBounds(381, 142, 88, 23);
		cbPCON.add("很低",0);
		cbPCON.add("低", 1);
		cbPCON.add("标称",2);
		cbPCON.add("高", 3);
		cbPCON.add("很高", 4);
		
		Label lblAPEX = new Label(cpEM, SWT.NONE);
		lblAPEX.setText("应用经验");
		lblAPEX.setBounds(293, 185, 61, 15);
		Combo cbAPEX = new Combo(cpEM, SWT.NONE);
		cbAPEX.setBounds(381, 182, 88, 23);
		cbAPEX.add("很低",0);
		cbAPEX.add("低", 1);
		cbAPEX.add("标称",2);
		cbAPEX.add("高", 3);
		cbAPEX.add("很高", 4);
		
		Label lblLTEX = new Label(cpEM, SWT.NONE);
		lblLTEX.setText("语言和工具经验");
		lblLTEX.setBounds(293, 225, 61, 15);
		Combo cbLTEX = new Combo(cpEM, SWT.NONE);
		cbLTEX.setBounds(381, 222, 88, 23);
		cbLTEX.add("很低",0);
		cbLTEX.add("低", 1);
		cbLTEX.add("标称",2);
		cbLTEX.add("高", 3);
		cbLTEX.add("很高", 4);
		
		Label lblSITE = new Label(cpEM, SWT.NONE);
		lblSITE.setText("多点开发");
		lblSITE.setBounds(293, 265, 61, 15);
		Combo cbSITE = new Combo(cpEM, SWT.NONE);
		cbSITE.setBounds(381, 262, 88, 23);
		cbSITE.add("很低",0);
		cbSITE.add("低", 1);
		cbSITE.add("标称",2);
		cbSITE.add("高", 3);
		cbSITE.add("很高", 4);
		cbSITE.add("极高", 5);
		
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
