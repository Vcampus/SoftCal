package com.seu.ui.input;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class EMEnterCp extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public EMEnterCp(Composite parent, int style) {
		super(parent, style);
		Label lblRELY = new Label(this, SWT.NONE);
		lblRELY.setBounds(47, 30, 61, 15);
		lblRELY.setText("软件可靠性");
		Combo cbRELY = new Combo(this, SWT.NONE);
		cbRELY.setBounds(135, 22, 88, 23);
		cbRELY.add("很低",0 );
		cbRELY.add("低", 1);
		cbRELY.add("标称",2 );
		cbRELY.add("高", 3);
		cbRELY.add("很高",4 );
		
		Label lblDOCU = new Label(this, SWT.NONE);
		lblDOCU.setText("文档编制");
		lblDOCU.setBounds(47, 70, 61, 15);
		Combo cbDOCU = new Combo(this, SWT.NONE);
		cbDOCU.setBounds(135, 67, 88, 23);
		cbDOCU.add("很低",0);
		cbDOCU.add("低",1);
		cbDOCU.add("标称",2);
		cbDOCU.add("高",3);
		cbDOCU.add("很高",4);
		
		Label lblSTOR = new Label(this, SWT.NONE);
		lblSTOR.setText("主存储约束");
		lblSTOR.setBounds(47, 110, 61, 15);
		Combo cbSTOR = new Combo(this, SWT.NONE);
		cbSTOR.setBounds(135, 107, 88, 23);
		cbSTOR.add("标称",0);
		cbSTOR.add("高",1);
		cbSTOR.add("很高",2);
		cbSTOR.add("极高",3);
		
		Label lblACAP = new Label(this, SWT.NONE);
		lblACAP.setText("分析员能力");
		lblACAP.setBounds(47, 150, 61, 15);
		Combo cbACAP = new Combo(this, SWT.NONE);
		cbACAP.setBounds(135, 147, 88, 23);
		cbACAP.add("很低",0 );
		cbACAP.add("低",1 );
		cbACAP.add("标称",2 );
		cbACAP.add("高", 3);
		cbACAP.add("很高",4 );
		
		Label lblPCAP = new Label(this, SWT.NONE);
		lblPCAP.setText("程序员能力");
		lblPCAP.setBounds(47, 190, 61, 15);
		Combo cbPCAP = new Combo(this, SWT.NONE);
		cbPCAP.setBounds(135, 187, 88, 23);
		cbPCAP.add("很低",0);
		cbPCAP.add("低", 1);
		cbPCAP.add("标称",2);
		cbPCAP.add("高", 3);
		cbPCAP.add("很高", 4);
		
		Label lblPLEX = new Label(this, SWT.NONE);
		lblPLEX.setText("平台经验");
		lblPLEX.setBounds(47, 230, 61, 15);
		Combo cbPLEX = new Combo(this, SWT.NONE);
		cbPLEX.setBounds(135, 227, 88, 23);
		cbPLEX.add("很低",0);
		cbPLEX.add("低", 1);
		cbPLEX.add("标称",2);
		cbPLEX.add("高", 3);
		cbPLEX.add("很高", 4);
		
		Label lblTOOL = new Label(this, SWT.NONE);
		lblTOOL.setText("软件工具使用");
		lblTOOL.setBounds(47, 270, 61, 15);
		Combo cbTOOL = new Combo(this, SWT.NONE);
		cbTOOL.setBounds(135, 267, 88, 23);
		cbTOOL.add("很低",0);
		cbTOOL.add("低", 1);
		cbTOOL.add("标称",2);
		cbTOOL.add("高", 3);
		cbTOOL.add("很高", 4);
		
		Label lblCPLX = new Label(this, SWT.NONE);
		lblCPLX.setText("产品复杂性");
		lblCPLX.setBounds(293, 25, 61, 15);
		Combo cbCPLX = new Combo(this, SWT.NONE);
		cbCPLX.setBounds(381, 17, 88, 23);
		cbCPLX.add("很低",0);
		cbCPLX.add("低", 1);
		cbCPLX.add("标称",2);
		cbCPLX.add("高", 3);
		cbCPLX.add("很高", 4);
		
		Label lblTIME = new Label(this, SWT.NONE);
		lblTIME.setText("执行时间约束");
		lblTIME.setBounds(293, 65, 82, 15);
		Combo cbTIME = new Combo(this, SWT.NONE);
		cbTIME.setBounds(381, 62, 88, 23);
		cbTIME.add("标称",0);
		cbTIME.add("高",1);
		cbTIME.add("很高",2);
		cbTIME.add("极高",3);
		
		Label lblPVOL = new Label(this, SWT.NONE);
		lblPVOL.setText("平台易变性");
		lblPVOL.setBounds(293, 105, 82, 15);
		Combo cbPVOL = new Combo(this, SWT.NONE);
		cbPVOL.setBounds(381, 102, 88, 23);
		cbPVOL.add("标称",0);
		cbPVOL.add("高",1);
		cbPVOL.add("很高",2);
		cbPVOL.add("极高",3);
		
		Label lblPCON = new Label(this, SWT.NONE);
		lblPCON.setText("人员连续性");
		lblPCON.setBounds(293, 145, 72, 15);
		Combo cbPCON = new Combo(this, SWT.NONE);
		cbPCON.setBounds(381, 142, 88, 23);
		cbPCON.add("很低",0);
		cbPCON.add("低", 1);
		cbPCON.add("标称",2);
		cbPCON.add("高", 3);
		cbPCON.add("很高", 4);
		
		Label lblAPEX = new Label(this, SWT.NONE);
		lblAPEX.setText("应用经验");
		lblAPEX.setBounds(293, 185, 61, 15);
		Combo cbAPEX = new Combo(this, SWT.NONE);
		cbAPEX.setBounds(381, 182, 88, 23);
		cbAPEX.add("很低",0);
		cbAPEX.add("低", 1);
		cbAPEX.add("标称",2);
		cbAPEX.add("高", 3);
		cbAPEX.add("很高", 4);
		
		Label lblLTEX = new Label(this, SWT.NONE);
		lblLTEX.setText("语言和工具经验");
		lblLTEX.setBounds(293, 225, 88, 15);
		Combo cbLTEX = new Combo(this, SWT.NONE);
		cbLTEX.setBounds(381, 222, 88, 23);
		cbLTEX.add("很低",0);
		cbLTEX.add("低", 1);
		cbLTEX.add("标称",2);
		cbLTEX.add("高", 3);
		cbLTEX.add("很高", 4);
		
		Label lblSITE = new Label(this, SWT.NONE);
		lblSITE.setText("多点开发");
		lblSITE.setBounds(293, 265, 61, 15);
		Combo cbSITE = new Combo(this, SWT.NONE);
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
