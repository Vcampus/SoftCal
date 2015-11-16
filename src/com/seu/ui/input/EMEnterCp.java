package com.seu.ui.input;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class EMEnterCp extends Composite {
	private Label lblhorizontal;
	private Label lblhorizontal1;
	private Text textEM;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public EMEnterCp(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		
		Label lblCalByPiont = new Label(this, SWT.NONE);
		FormData lblCalByPiont_fd = new FormData();
		lblCalByPiont_fd.top = new FormAttachment(2, 1);
		lblCalByPiont_fd.left = new FormAttachment(0,6);
		lblCalByPiont_fd.bottom = new FormAttachment(10, -1);
		lblCalByPiont.setLayoutData(lblCalByPiont_fd);
		lblCalByPiont.setText("参数估算");
		
		lblhorizontal = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormData lblhorizontal_fd = new FormData();
		lblhorizontal_fd.bottom = new FormAttachment(10,-1);
		lblhorizontal_fd.top = new FormAttachment(2,1);
		lblhorizontal_fd.left = new FormAttachment(lblCalByPiont,1);
		lblhorizontal_fd.right = new FormAttachment(95, -5);
		lblhorizontal.setLayoutData(lblhorizontal_fd);
		
		Composite composite = new Composite(this, SWT.NONE);
		GridLayout cpgridLayout = new GridLayout();
		cpgridLayout.marginHeight = 0;
		cpgridLayout.marginWidth = 0;
		composite.setLayout(cpgridLayout);
		FormData cp_fd = new FormData();
		cp_fd.top = new FormAttachment( 10, 10);
		cp_fd.left = new FormAttachment(10, 10);
		cp_fd.bottom = new FormAttachment(80,-5);
		cp_fd.right = new FormAttachment(30, -2);
		composite.setLayoutData(cp_fd);
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setLayoutData(new FormData());
		GridLayout cp_1gridLayout = new GridLayout();
		cp_1gridLayout.marginHeight = 0;
		cp_1gridLayout.marginWidth = 0;
		composite_1.setLayout(cp_1gridLayout);
		FormData cp_1_fd = new FormData();
		cp_1_fd.top = new FormAttachment( 10, 10);
		cp_1_fd.left = new FormAttachment(composite,0);
		cp_1_fd.bottom = new FormAttachment(80,-5);
		cp_1_fd.right = new FormAttachment(50, -2);
		composite_1.setLayoutData(cp_1_fd);
		
		Composite composite_2 = new Composite(this, SWT.NONE);
		composite_2.setLayoutData(new FormData());
		GridLayout cp_2gridLayout = new GridLayout();
		cp_2gridLayout.marginHeight = 0;
		cp_2gridLayout.marginWidth = 0;
		composite_2.setLayout(cp_2gridLayout);
		FormData cp_2_fd = new FormData();
		cp_2_fd.top = new FormAttachment( 10, 5);
		cp_2_fd.left = new FormAttachment(composite_1, 15);
		cp_2_fd.bottom = new FormAttachment(80,-5);
		cp_2_fd.right = new FormAttachment(70, -2);
		composite_2.setLayoutData(cp_2_fd);
		
		Composite composite_3 = new Composite(this, SWT.NONE);
		composite_3.setLayoutData(new FormData());
		GridLayout cp_3gridLayout = new GridLayout();
		cp_3gridLayout.marginHeight = 0;
		cp_3gridLayout.marginWidth = 0;
		composite_3.setLayout(cp_3gridLayout);
		FormData cp_3_fd = new FormData();
		cp_3_fd.left = new FormAttachment(composite_2, 0);
		cp_3_fd.right = new FormAttachment(90, -10);
		cp_3_fd.top = new FormAttachment(10, 10);
		cp_3_fd.bottom = new FormAttachment(80,-5);
		composite_3.setLayoutData(cp_3_fd);
		
		
		Label lblRELY = new Label(composite, SWT.PUSH);
		lblRELY.setText("软件可靠性");
		lblRELY.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbRELY = new Combo(composite_1, SWT.PUSH);
		cbRELY.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbRELY.add("很低",0 );
		cbRELY.add("低", 1);
		cbRELY.add("标称",2 );
		cbRELY.add("高", 3);
		cbRELY.add("很高",4 );
		
		Label lblDOCU = new Label(composite, SWT.PUSH);
		lblDOCU.setText("文档编制");
		lblDOCU.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbDOCU = new Combo(composite_1, SWT.PUSH);
		cbDOCU.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbDOCU.add("很低",0);
		cbDOCU.add("低",1);
		cbDOCU.add("标称",2);
		cbDOCU.add("高",3);
		cbDOCU.add("很高",4);
		
		Label lblSTOR = new Label(composite, SWT.PUSH);
		lblSTOR.setText("主存储约束");
		lblSTOR.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbSTOR = new Combo(composite_1, SWT.PUSH);
		cbSTOR.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbSTOR.add("标称",0);
		cbSTOR.add("高",1);
		cbSTOR.add("很高",2);
		cbSTOR.add("极高",3);
		
		Label lblACAP = new Label(composite, SWT.PUSH);
		lblACAP.setText("分析员能力");
		lblACAP.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbACAP = new Combo(composite_1, SWT.PUSH);
		cbACAP.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbACAP.add("很低",0 );
		cbACAP.add("低",1 );
		cbACAP.add("标称",2 );
		cbACAP.add("高", 3);
		cbACAP.add("很高",4 );
		
		Label lblPCAP = new Label(composite, SWT.PUSH);
		lblPCAP.setText("程序员能力");
		lblPCAP.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbPCAP = new Combo(composite_1, SWT.PUSH);
		cbPCAP.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbPCAP.add("很低",0);
		cbPCAP.add("低", 1);
		cbPCAP.add("标称",2);
		cbPCAP.add("高", 3);
		cbPCAP.add("很高", 4);
		
		Label lblPLEX = new Label(composite, SWT.PUSH);
		lblPLEX.setText("平台经验");
		lblPLEX.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbPLEX = new Combo(composite_1, SWT.PUSH);
		cbPLEX.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbPLEX.add("很低",0);
		cbPLEX.add("低", 1);
		cbPLEX.add("标称",2);
		cbPLEX.add("高", 3);
		cbPLEX.add("很高", 4);
		
		Label lblTOOL = new Label(composite, SWT.PUSH);
		lblTOOL.setText("软件工具使用");
		lblTOOL.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbTOOL = new Combo(composite_1, SWT.PUSH);
		cbTOOL.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbTOOL.add("很低",0);
		cbTOOL.add("低", 1);
		cbTOOL.add("标称",2);
		cbTOOL.add("高", 3);
		cbTOOL.add("很高", 4);
		
		Label lblCPLX = new Label(composite_2, SWT.PUSH);
		lblCPLX.setText("产品复杂性");
		lblCPLX.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbCPLX = new Combo(composite_3, SWT.PUSH);
		cbCPLX.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbCPLX.add("很低",0);
		cbCPLX.add("低", 1);
		cbCPLX.add("标称",2);
		cbCPLX.add("高", 3);
		cbCPLX.add("很高", 4);
		
		Label lblTIME = new Label(composite_2, SWT.PUSH);
		lblTIME.setText("执行时间约束");
		lblTIME.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbTIME = new Combo(composite_3, SWT.PUSH);
		cbTIME.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbTIME.add("标称",0);
		cbTIME.add("高",1);
		cbTIME.add("很高",2);
		cbTIME.add("极高",3);
		
		Label lblPVOL = new Label(composite_2, SWT.PUSH);
		lblPVOL.setText("平台易变性");
		lblPVOL.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbPVOL = new Combo(composite_3, SWT.PUSH);
		cbPVOL.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbPVOL.add("标称",0);
		cbPVOL.add("高",1);
		cbPVOL.add("很高",2);
		cbPVOL.add("极高",3);
		
		Label lblPCON = new Label(composite_2, SWT.PUSH);
		lblPCON.setText("人员连续性");
		lblPCON.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbPCON = new Combo(composite_3, SWT.PUSH);
		cbPCON.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbPCON.add("很低",0);
		cbPCON.add("低", 1);
		cbPCON.add("标称",2);
		cbPCON.add("高", 3);
		cbPCON.add("很高", 4);
		
		Label lblAPEX = new Label(composite_2, SWT.PUSH);
		lblAPEX.setText("应用经验");
		lblAPEX.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbAPEX = new Combo(composite_3, SWT.PUSH);
		cbAPEX.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbAPEX.add("很低",0);
		cbAPEX.add("低", 1);
		cbAPEX.add("标称",2);
		cbAPEX.add("高", 3);
		cbAPEX.add("很高", 4);
		
		Label lblLTEX = new Label(composite_2, SWT.PUSH);
		lblLTEX.setText("语言和工具经验");
		lblLTEX.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbLTEX = new Combo(composite_3, SWT.PUSH);
		cbLTEX.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbLTEX.add("很低",0);
		cbLTEX.add("低", 1);
		cbLTEX.add("标称",2);
		cbLTEX.add("高", 3);
		cbLTEX.add("很高", 4);
		
		Label lblSITE = new Label(composite_2, SWT.PUSH);
		lblSITE.setText("多点开发");
		lblSITE.setLayoutData(new GridData(GridData.FILL_BOTH));
		Combo cbSITE = new Combo(composite_3, SWT.PUSH);
		cbSITE.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbSITE.add("很低",0);
		cbSITE.add("低", 1);
		cbSITE.add("标称",2);
		cbSITE.add("高", 3);
		cbSITE.add("很高", 4);
		cbSITE.add("极高", 5);
		
		Label lblEnterE = new Label(this, SWT.NONE);
		FormData lblEnterE_fd = new FormData();
		lblEnterE_fd.top = new FormAttachment(composite, 10);
		lblEnterE_fd.left = new FormAttachment(0,6);
		lblEnterE_fd.bottom = new FormAttachment(92, -6);
		lblEnterE.setLayoutData(lblEnterE_fd);
		lblEnterE.setText("直接输入");
		
		lblhorizontal1 = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormData fd_label = new FormData();
		fd_label.bottom = new FormAttachment(85,-1);
		fd_label.top = new FormAttachment(82,1);
		fd_label.left = new FormAttachment(lblEnterE,1);
		fd_label.right = new FormAttachment(95, -5);
		lblhorizontal1.setLayoutData(fd_label);
		
		
		Label lblEM = new Label(this, SWT.NONE);
		FormData fd_lblEM = new FormData();
		fd_lblEM.left = new FormAttachment(10,10);
		lblEM.setLayoutData(fd_lblEM);
		lblEM.setText("EM");
		
		textEM = new Text(this, SWT.BORDER);
		fd_lblEM.top = new FormAttachment(textEM, 3, SWT.TOP);
		FormData fd_textEM = new FormData();
		fd_textEM.bottom = new FormAttachment(100, -10);
		fd_textEM.left =new FormAttachment(lblEM,30);
		textEM.setLayoutData(fd_textEM);
		
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
