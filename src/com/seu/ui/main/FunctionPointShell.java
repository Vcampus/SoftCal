package com.seu.ui.main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class FunctionPointShell extends Shell {
	public FunctionPointShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label ExternalInputLb = new Label(this, SWT.NONE);
		ExternalInputLb.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		ExternalInputLb.setBounds(39, 20, 80, 25);
		ExternalInputLb.setText("外部输入：");
		
		Button ExternalInputBt = new Button(this, SWT.NONE);
		ExternalInputBt.setBounds(264, 19, 80, 25);
		ExternalInputBt.setText("编辑");
		
		Label ExternalOutputLb = new Label(this, SWT.NONE);
		ExternalOutputLb.setText("外部输出：");
		ExternalOutputLb.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		ExternalOutputLb.setBounds(39, 74, 80, 25);
		
		Button ExternalOutputBt = new Button(this, SWT.NONE);
		ExternalOutputBt.setText("编辑");
		ExternalOutputBt.setBounds(264, 73, 80, 25);
		
		Label InsideLogicalLb = new Label(this, SWT.NONE);
		InsideLogicalLb.setText("内部逻辑文件：");
		InsideLogicalLb.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		InsideLogicalLb.setBounds(39, 136, 123, 24);
		
		Button InsideLogicalBt = new Button(this, SWT.NONE);
		InsideLogicalBt.setText("编辑");
		InsideLogicalBt.setBounds(264, 135, 80, 25);
		
		Label ExternalSearchLb = new Label(this, SWT.NONE);
		ExternalSearchLb.setText("外部查询：");
		ExternalSearchLb.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		ExternalSearchLb.setBounds(39, 195, 80, 25);
		
		Button ExternalsearchBt = new Button(this, SWT.NONE);
		ExternalsearchBt.setText("编辑");
		ExternalsearchBt.setBounds(264, 195, 80, 25);
		
		Label ExternalInterfaceFileLb = new Label(this, SWT.NONE);
		ExternalInterfaceFileLb.setText("外部接口文件：");
		ExternalInterfaceFileLb.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		ExternalInterfaceFileLb.setBounds(39, 253, 123, 24);
		
		Button ExternalInterfaceFileBt = new Button(this, SWT.NONE);
		ExternalInterfaceFileBt.setText("编辑");
		ExternalInterfaceFileBt.setBounds(264, 252, 80, 25);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("功能点输入");
		setSize(406, 349);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
