package com.seu.ui.main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;

public class ProportionShell extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			ProportionShell shell = new ProportionShell(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public ProportionShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label PRECLb = new Label(this, SWT.NONE);
		PRECLb.setText("先例性：");
		PRECLb.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		PRECLb.setBounds(33, 21, 80, 25);
		
		Label FLEXLb = new Label(this, SWT.NONE);
		FLEXLb.setText("开发灵活性：");
		FLEXLb.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		FLEXLb.setBounds(33, 75, 80, 25);
		
		Label RESLLb = new Label(this, SWT.NONE);
		RESLLb.setText("体系结构/风险化解性：");
		RESLLb.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		RESLLb.setBounds(33, 137, 167, 24);
		
		Label TEAMLb = new Label(this, SWT.NONE);
		TEAMLb.setText("团队凝聚力：");
		TEAMLb.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		TEAMLb.setBounds(33, 196, 96, 25);
		
		Label PMATLb = new Label(this, SWT.NONE);
		PMATLb.setText("过程成熟度：");
		PMATLb.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		PMATLb.setBounds(33, 254, 123, 24);
		
		Combo PRECCb = new Combo(this, SWT.NONE);
		PRECCb.setBounds(227, 21, 111, 23);
		PRECCb.add("全新的",0);
		PRECCb.add("绝大部分新",1);
		PRECCb.add("有一些新",2);
		PRECCb.add("基本熟悉",3);
		PRECCb.add("绝大部分熟悉",4);
		PRECCb.add("完全熟悉",5);
		
		Combo FLEXCb = new Combo(this, SWT.NONE);
		FLEXCb.setBounds(227, 75, 111, 23);
		FLEXCb.add("严格", 0);
		FLEXCb.add("偶尔放宽", 1);
		FLEXCb.add("放宽", 2);
		FLEXCb.add("基本一致", 3);
		FLEXCb.add("部分一致", 4);
		FLEXCb.add("通用目标", 5);
		
		Combo RESLCb = new Combo(this, SWT.NONE);
		RESLCb.setBounds(227, 137, 111, 23);
		RESLCb.add("很少",0);
		RESLCb.add("一些",1);
		RESLCb.add("常常",2);
		RESLCb.add("通常",3);
		RESLCb.add("绝大多数",4);
		RESLCb.add("安全",5);
		
		Combo TEAMCb = new Combo(this, SWT.NONE);
		TEAMCb.setBounds(227, 198, 111, 23);
		TEAMCb.add("交流非常困难", 0);
		TEAMCb.add("交流有些障碍", 1);
		TEAMCb.add("基本的交流协作", 2);
		TEAMCb.add("广泛地协作", 3);
		TEAMCb.add("高度协作", 4);
		TEAMCb.add("无缝协作", 5);
		
		Combo PMATCb = new Combo(this, SWT.NONE);
		PMATCb.setBounds(227, 254, 111, 23);
		PMATCb.add("SW-CMM1级较低部分", 0);
		PMATCb.add("SW-CMM1级较高部分", 0);
		PMATCb.add("SW-CMM2级", 0);
		PMATCb.add("SW-CMM3级", 0);
		PMATCb.add("SW-CMM4级", 0);
		PMATCb.add("SW-CMM5级", 0);
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("指数E估算");
		setSize(432, 354);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
