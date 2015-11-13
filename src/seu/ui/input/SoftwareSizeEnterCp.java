package com.seu.ui.input;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class SoftwareSizeEnterCp extends Composite {
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
	public SoftwareSizeEnterCp(Composite parent, int style) {
		super(parent, style);
		Label lblExternalInputFile = new Label(this, SWT.NONE);
		lblExternalInputFile.setBounds(33, 32, 115, 21);
		lblExternalInputFile.setText("外部输入文件类型数");
		
		textlblExternalInputFile = new Text(this, SWT.BORDER);
		textlblExternalInputFile.setBounds(173, 29, 73, 21);
		
		Label lblExternalInputData = new Label(this, SWT.NONE);
		lblExternalInputData.setBounds(302, 32, 123, 21);
		lblExternalInputData.setText("外部输入数据类型数");
		
		textExternalInputData = new Text(this, SWT.BORDER);
		textExternalInputData.setBounds(447, 29, 73, 21);
		
		Label lblExternalOutputFile = new Label(this, SWT.NONE);
		lblExternalOutputFile.setText("外部输出文件类型数");
		lblExternalOutputFile.setBounds(33, 78, 115, 15);
		
		textExternalOutputFile = new Text(this, SWT.BORDER);
		textExternalOutputFile.setBounds(173, 75, 73, 21);
		
		Label lblExternalOutputData = new Label(this, SWT.NONE);
		lblExternalOutputData.setText("外部输出数据类型数");
		lblExternalOutputData.setBounds(302, 75, 123, 15);
		
		text_3 = new Text(this, SWT.BORDER);
		text_3.setBounds(447, 75, 73, 21);
		
		Label lblExternalSearchFile = new Label(this, SWT.NONE);
		lblExternalSearchFile.setText("外部查询文件类型数");
		lblExternalSearchFile.setBounds(33, 124, 115, 15);
		
		textExternalSearchFile = new Text(this, SWT.BORDER);
		textExternalSearchFile.setBounds(173, 121, 73, 21);
		
		Label lblExternalSearchData = new Label(this, SWT.NONE);
		lblExternalSearchData.setText("外部查询数据类型数");
		lblExternalSearchData.setBounds(302, 121, 123, 18);
		
		textExternalSearchData = new Text(this, SWT.BORDER);
		textExternalSearchData.setBounds(447, 121, 73, 21);
		
		Label lblInsideLogicFileMemory = new Label(this, SWT.NONE);
		lblInsideLogicFileMemory.setAlignment(SWT.CENTER);
		lblInsideLogicFileMemory.setText("内部逻辑文件记录元素数");
		lblInsideLogicFileMemory.setBounds(33, 169, 134, 18);
		
		textInsideLogicFileMemory = new Text(this, SWT.BORDER);
		textInsideLogicFileMemory.setBounds(173, 166, 73, 21);
		
		Label lblInsideLogicFileData = new Label(this, SWT.NONE);
		lblInsideLogicFileData.setText("内部逻辑文件数据类型数");
		lblInsideLogicFileData.setBounds(302, 166, 139, 21);
		
		textlInsideLogicFileData = new Text(this, SWT.BORDER);
		textlInsideLogicFileData.setBounds(447, 166, 73, 21);
		
		Label lblExternalInterfaceFileMemory = new Label(this, SWT.NONE);
		lblExternalInterfaceFileMemory.setText("外部接口文件记录元素数");
		lblExternalInterfaceFileMemory.setBounds(33, 211, 134, 18);
		
		textExternalInterfaceFileMemory = new Text(this, SWT.BORDER);
		textExternalInterfaceFileMemory.setBounds(173, 208, 73, 21);
		
		Label lblExternalInterfaceFileData = new Label(this, SWT.NONE);
		lblExternalInterfaceFileData.setText("外部接口文件数据类型数");
		lblExternalInterfaceFileData.setBounds(302, 208, 139, 21);
		
		textExternalInterfaceFileData = new Text(this, SWT.BORDER);
		textExternalInterfaceFileData.setBounds(447, 208, 73, 21);
		
		Label lblSoftKnowing = new Label(this, SWT.NONE);
		lblSoftKnowing.setBounds(33, 260, 78, 15);
		lblSoftKnowing.setText("软件理解因子");
		
		Label lblProgramUnfamili = new Label(this, SWT.NONE);
		lblProgramUnfamili.setBounds(302, 260, 103, 15);
		lblProgramUnfamili.setText("程序不熟悉性因子");
		
		Combo cbSoftKnowing = new Combo(this, SWT.NONE);
		cbSoftKnowing.setBounds(173, 257, 73, 18);
		cbSoftKnowing.add("很低",0);
		cbSoftKnowing.add("低",1);
		cbSoftKnowing.add("标称",2);
		cbSoftKnowing.add("高",3);
		cbSoftKnowing.add("很高",4);
		
		Combo cbProgramUnfamili = new Combo(this, SWT.NONE);
		cbProgramUnfamili.setBounds(447, 257, 73, 23);
		cbProgramUnfamili.add("完全不熟悉", 0);
		cbProgramUnfamili.add("大部分不熟悉", 1);
		cbProgramUnfamili.add("有点熟悉", 2);
		cbProgramUnfamili.add("部分熟悉", 3);
		cbProgramUnfamili.add("大部分熟悉",4);
		cbProgramUnfamili.add("完全熟悉", 5);
		
		Label lblAdjustScale = new Label(this, SWT.NONE);
		lblAdjustScale.setBounds(33, 314, 61, 15);
		lblAdjustScale.setText("修改规模");
		textAdjustScale = new Text(this, SWT.BORDER);
		textAdjustScale.setBounds(173, 311, 73, 21);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}