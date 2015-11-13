package com.seu.ui.input;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class EIndexEnterCP extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public EIndexEnterCP(Composite parent, int style) {
		super(parent, style);
		Label lblPREC = new Label(this, SWT.NONE);
		lblPREC.setText("先例性：");
		lblPREC.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblPREC.setBounds(51, 29, 80, 25);
		
		Label lblFLEX = new Label(this, SWT.NONE);
		lblFLEX.setText("开发灵活性：");
		lblFLEX.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblFLEX.setBounds(51, 83, 80, 25);
		
		Label lblRESL = new Label(this, SWT.NONE);
		lblRESL.setText("体系结构/风险化解性：");
		lblRESL.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblRESL.setBounds(51, 145, 167, 24);
		
		Label lblTEAM = new Label(this, SWT.NONE);
		lblTEAM.setText("团队凝聚力：");
		lblTEAM.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblTEAM.setBounds(51, 204, 96, 25);
		
		Label lblPMAT = new Label(this, SWT.NONE);
		lblPMAT.setText("过程成熟度：");
		lblPMAT.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblPMAT.setBounds(51, 262, 123, 24);
		
		Combo cbPREC = new Combo(this, SWT.NONE);
		cbPREC.setBounds(245, 29, 111, 23);
		cbPREC.add("全新的",0);
		cbPREC.add("绝大部分新",1);
		cbPREC.add("有一些新",2);
		cbPREC.add("基本熟悉",3);
		cbPREC.add("绝大部分熟悉",4);
		cbPREC.add("完全熟悉",5);
		
		Combo cbFLEX = new Combo(this, SWT.NONE);
		cbFLEX.setBounds(245, 83, 111, 23);
		cbFLEX.add("严格", 0);
		cbFLEX.add("偶尔放宽", 1);
		cbFLEX.add("放宽", 2);
		cbFLEX.add("基本一致", 3);
		cbFLEX.add("部分一致", 4);
		cbFLEX.add("通用目标", 5);
		
		Combo cbRESL = new Combo(this, SWT.NONE);
		cbRESL.setBounds(245, 145, 111, 23);
		cbRESL.add("很少",0);
		cbRESL.add("一些",1);
		cbRESL.add("常常",2);
		cbRESL.add("通常",3);
		cbRESL.add("绝大多数",4);
		cbRESL.add("安全",5);
		
		Combo cbTEAM = new Combo(this, SWT.NONE);
		cbTEAM.setBounds(245, 206, 111, 23);
		cbTEAM.add("交流非常困难", 0);
		cbTEAM.add("交流有些障碍", 1);
		cbTEAM.add("基本的交流协作", 2);
		cbTEAM.add("广泛地协作", 3);
		cbTEAM.add("高度协作", 4);
		cbTEAM.add("无缝协作", 5);
		
		Combo cbPMAT = new Combo(this, SWT.NONE);
		cbPMAT.setBounds(245, 262, 111, 23);
		cbPMAT.add("SW-CMM1级较低部分", 0);
		cbPMAT.add("SW-CMM1级较高部分", 0);
		cbPMAT.add("SW-CMM2级", 0);
		cbPMAT.add("SW-CMM3级", 0);
		cbPMAT.add("SW-CMM4级", 0);
		cbPMAT.add("SW-CMM5级", 0);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
