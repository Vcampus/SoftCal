package com.seu.ui.input;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

public class EIndexEnterCP extends Composite {
	
	private Label PRECLb;
	private Label FLEXLb;
	private Label RESLLb;
	private Label TEAMLb;
	private Label PMATLb;
	private Composite combocomposite;
	private Composite composite;
	private Combo PRECCb;
	private Combo FLEXCb;
	private Combo RESLCb;
	private Combo TEAMCb;
	private Combo PMATCb;
	private Label lblhorizontal1;
	private Label lblhorizontal;
	private Text textEIndex;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public EIndexEnterCP(Composite parent, int style) {
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
		
		composite = new Composite(this, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		composite.setLayout(gridLayout);
		
		PRECLb = new Label(composite, SWT.PUSH);
		PRECLb.setLayoutData(new GridData(GridData.FILL_BOTH));
		PRECLb.setText("先例性：");
		
		FLEXLb = new Label(composite, SWT.PUSH);
		FLEXLb.setLayoutData(new GridData(GridData.FILL_BOTH));
		FLEXLb.setText("开发灵活性：");
		
		RESLLb = new Label(composite, SWT.PUSH);
		RESLLb.setLayoutData(new GridData(GridData.FILL_BOTH));
		RESLLb.setText("体系结构/风险化解性：");
		
		TEAMLb = new Label(composite, SWT.PUSH);
		TEAMLb.setLayoutData(new GridData(GridData.FILL_BOTH));
		TEAMLb.setText("团队凝聚力：");
		
		PMATLb = new Label(composite, SWT.PUSH);
		PMATLb.setLayoutData(new GridData(GridData.FILL_BOTH));
		PMATLb.setText("过程成熟度：");
		
		FormData cp_fd = new FormData();
		cp_fd.top = new FormAttachment( 10, 10);
		cp_fd.left = new FormAttachment(10, 10);
		cp_fd.bottom = new FormAttachment(80,-10);
		cp_fd.right = new FormAttachment(50, -2);
		composite.setLayoutData(cp_fd);
		
		combocomposite = new Composite(this, SWT.NONE);
		GridLayout cbgridLayout = new GridLayout();
		cbgridLayout.marginHeight = 0;
		cbgridLayout.marginWidth = 0;
		combocomposite.setLayout(cbgridLayout);
		FormData combocp_fd = new FormData();
		combocp_fd.top = new FormAttachment(10, 10);
		combocp_fd.bottom = new FormAttachment(80, -10);
		combocp_fd.right = new FormAttachment(80, -20);
		combocp_fd.left = new FormAttachment(composite, 5);
		combocomposite.setLayoutData(combocp_fd);
		
		PRECCb = new Combo(combocomposite, SWT.PUSH);
		PRECCb.setLayoutData(new GridData(GridData.FILL_BOTH));
		PRECCb.add("全新的",0);
		PRECCb.add("绝大部分新",1);
		PRECCb.add("有一些新",2);
		PRECCb.add("基本熟悉",3);
		PRECCb.add("绝大部分熟悉",4);
		PRECCb.add("完全熟悉",5);
		
		FLEXCb = new Combo(combocomposite, SWT.PUSH);
		FLEXCb.setLayoutData( new GridData(GridData.FILL_BOTH));
		FLEXCb.add("严格", 0);
		FLEXCb.add("偶尔放宽", 1);
		FLEXCb.add("放宽", 2);
		FLEXCb.add("基本一致", 3);
		FLEXCb.add("部分一致", 4);
		FLEXCb.add("通用目标", 5);
		
		RESLCb = new Combo(combocomposite, SWT.PUSH);
		RESLCb.setLayoutData(new GridData(GridData.FILL_BOTH));
		RESLCb.add("很少",0);
		RESLCb.add("一些",1);
		RESLCb.add("常常",2);
		RESLCb.add("通常",3);
		RESLCb.add("绝大多数",4);
		RESLCb.add("安全",5);
		
		TEAMCb = new Combo(combocomposite, SWT.PUSH);
		TEAMCb.setLayoutData(new GridData(GridData.FILL_BOTH));
		TEAMCb.add("交流非常困难", 0);
		TEAMCb.add("交流有些障碍", 1);
		TEAMCb.add("基本的交流协作", 2);
		TEAMCb.add("广泛地协作", 3);
		TEAMCb.add("高度协作", 4);
		TEAMCb.add("无缝协作", 5);
		
		PMATCb = new Combo(combocomposite, SWT.PUSH);
		PMATCb.setLayoutData(new GridData(GridData.FILL_BOTH));
		PMATCb.add("SW-CMM1级较低部分", 0);
		PMATCb.add("SW-CMM1级较高部分", 0);
		PMATCb.add("SW-CMM2级", 0);
		PMATCb.add("SW-CMM3级", 0);
		PMATCb.add("SW-CMM4级", 0);
		PMATCb.add("SW-CMM5级", 0);
		
		
		Label lblEnterE = new Label(this, SWT.NONE);
		FormData lblEnterE_fd = new FormData();
		lblEnterE_fd.top = new FormAttachment(composite, 10);
//		lblEnterE_fd.right = new FormAttachment(lblhorizontal1, -6);
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
		
		Label lblEIndex = new Label(this, SWT.NONE);
		FormData fd_lblEIndex = new FormData();
		fd_lblEIndex.left = new FormAttachment(10,10);
		lblEIndex.setLayoutData(fd_lblEIndex);
		lblEIndex.setText("指数E");
		
		textEIndex = new Text(this, SWT.BORDER);
		fd_lblEIndex.top = new FormAttachment(textEIndex, 3, SWT.TOP);
		FormData fd_textEIndex = new FormData();
		fd_textEIndex.bottom = new FormAttachment(100, -10);
		fd_textEIndex.left =new FormAttachment(lblEIndex,30);
		textEIndex.setLayoutData(fd_textEIndex);
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
