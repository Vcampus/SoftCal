package com.seu.ui.adjust.input;

import java.util.ArrayList;

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

import com.seu.adapter.UiAdapter;
import com.seu.adapter.UiEindexAdapter;
import com.seu.bean.EIndex;
import com.seu.bean.EM;
import com.seu.bean.Version;
import com.seu.dao.impl.EIndexDaoImpl;
import com.seu.dao.impl.EMDaoImpl;
import com.seu.exception.EindexMissingParamException;
import com.seu.exception.EindexNotFoundException;
import com.seu.exception.EmMissingParamException;
import com.seu.exception.EmNotFoundException;
import com.seu.exception.InvalidInputException;
import com.seu.exception.VersionNotSelectedException;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class AdjEIndexEnterCP extends Composite implements UiEindexAdapter{
	
	private Label PRECLb;
	private Version version;
	private EIndex eindex;

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
	private final int PREC=1;
	private final int FLEX=2;
	private final int RESL=3;
	private final int TEAM=4;
	private final int PMAT=5;
	private final float vsPREC[]={6.20f,4.96f,3.72f,2.48f,2.14f,0.00f};
	private final float	vsFLEX[]={5.07f,4.05f,3.04f,2.03f,1.01f,0.00f};
	private final float	vsRESL[]={7.07f,5.65f,4.24f,2.83f,1.41f,0.00f};
	private final float	vsTEAM[]={5.48f,4.38f,3.29f,2.19f,1.10f,0.00f};
	private final float vsPMAT[]={7.80f,6.24f,4.68f,3.12f,1.56f,0.00f};
	ArrayList<float[]>alist = new ArrayList<float[]>();
	private Button btn_save;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AdjEIndexEnterCP(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		alist.add(vsPREC);
		alist.add(vsFLEX);
		alist.add(vsRESL);
		alist.add(vsTEAM);
		alist.add(vsPMAT);
		initLayout();
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	@Override
	public void load() {
		// TODO 自动生成的方法存根
		if(version!=null){
			EIndexDaoImpl eIndexDaoImpl = new EIndexDaoImpl();
			try {
				eindex = eIndexDaoImpl.getByProj_idAndVersion_idAndType(version.getProj_id(), version.getId(),1);
				if(eindex.getInputE()==0.0f)
					textEIndex.setText("");
				else {
					textEIndex.setText(eindex.getInputE()+"");
				}
				if(isCbEnabled())
				{
					PRECCb.select(getEindexIndex(1, eindex.getPREC()));
					FLEXCb.select(getEindexIndex(2, eindex.getFLEX()));
					RESLCb.select(getEindexIndex(3, eindex.getRESL()));
					TEAMCb.select(getEindexIndex(4, eindex.getTEAM()));
					PMATCb.select(getEindexIndex(5, eindex.getPMAT()));
				}
				
				
			} catch (EindexNotFoundException e) {
				// TODO 自动生成的 catch 块
				System.out.println("暂时无eindex版本，请添加");
			}
		}
	}

	@Override
	public void refresh() {
		// TODO 自动生成的方法存根
		load();
	}

	@Override
	public void save()throws VersionNotSelectedException,InvalidInputException,EindexMissingParamException{
		// TODO 自动生成的方法存根
		if(version==null){
			throw new VersionNotSelectedException();
		}	
		EIndexDaoImpl eIndexDaoImpl = new EIndexDaoImpl();
		try {
			try {
				eindex = eIndexDaoImpl.getByProj_idAndVersion_idAndType(version.getProj_id(), version.getId(),1);
				if(isCbEnabled()){
					eindex.setPREC(getEindexValue(1, PRECCb.getSelectionIndex()));
					System.out.println("SS"+PRECCb.getSelectionIndex());
					System.out.println("SS"+getEindexValue(1, PRECCb.getSelectionIndex()));
					eindex.setFLEX(getEindexValue(2, FLEXCb.getSelectionIndex()));
					eindex.setRESL(getEindexValue(3, RESLCb.getSelectionIndex()));
					eindex.setTEAM(getEindexValue(4, TEAMCb.getSelectionIndex()));
					eindex.setPMAT(getEindexValue(5, PMATCb.getSelectionIndex()));
					eindex.setInputE(0);
				}
				else {
					eindex.setPREC(0);
					eindex.setFLEX(0);
					eindex.setRESL(0);
					eindex.setTEAM(0);
					eindex.setPMAT(0);
					eindex.setInputE(Float.parseFloat(textEIndex.getText()));
				}
				eIndexDaoImpl.Update(eindex);
			} catch (EindexNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
				eindex = new EIndex();
				eindex.setProj_id(version.getProj_id());
				eindex.setVersion_id(version.getId());
				eindex.setType(1);
				if(isCbEnabled()){
					eindex.setPREC(getEindexValue(1, PRECCb.getSelectionIndex()));
					eindex.setFLEX(getEindexValue(2, FLEXCb.getSelectionIndex()));
					eindex.setRESL(getEindexValue(3, RESLCb.getSelectionIndex()));
					eindex.setTEAM(getEindexValue(4, TEAMCb.getSelectionIndex()));
					eindex.setPMAT(getEindexValue(5, PMATCb.getSelectionIndex()));
					eindex.setInputE(0);
				}
				else {
					eindex.setPREC(0);
					eindex.setFLEX(0);
					eindex.setRESL(0);
					eindex.setTEAM(0);
					eindex.setPMAT(0);
					eindex.setInputE(Float.parseFloat(textEIndex.getText()));
				}
				eIndexDaoImpl.Save(eindex);
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception	
				System.out.println("存在数据输入格式不正确");
				throw new InvalidInputException();
		} catch (EindexMissingParamException e) {
			// TODO: handle exception
			throw new EindexMissingParamException();
		}
	}
	
	public float getEindexValue (int type,int index)throws EindexMissingParamException{
		try {
			System.out.println("LIST"+alist.get(type-1)[index]);
			return alist.get(type-1)[index];
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			if(isCbEnabled())
			throw new EindexMissingParamException();
			else {
				System.out.println('s');
				return 0.0f;
			}
		}	
		
	}
	
	public int getEindexIndex(int type,float value){
		for(int i=0;i<alist.get(type-1).length;i++)
		{	
			if(value == alist.get(type-1)[i])
				return i;
		}
		return -1;
	}
	
	public boolean isCbEnabled(){
		Boolean enable;
		if(textEIndex.getText().equals(""))
		{	
			enable=true;
		}else {
			enable=false;
		}
		PRECCb.setEnabled(enable);
		FLEXCb.setEnabled(enable);
		RESLCb.setEnabled(enable);
		TEAMCb.setEnabled(enable);
		PMATCb.setEnabled(enable);
        return enable;
	}
	
	public void initLayout(){
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
		textEIndex.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				isCbEnabled();
			}
		});
		fd_lblEIndex.top = new FormAttachment(textEIndex, 3, SWT.TOP);
		FormData fd_textEIndex = new FormData();
		fd_textEIndex.bottom = new FormAttachment(100, -10);
		fd_textEIndex.left =new FormAttachment(lblEIndex,30);
		textEIndex.setLayoutData(fd_textEIndex);
		
		//添加注释
		String sReturn = System.getProperty("line.separator");
		PRECLb.setToolTipText("PREC（Precedentedness）is used to"
				+ sReturn +" describe the similarity between the"
				+sReturn + " product and the previously developed "
				+ sReturn +"projects. If they have high  similarity, "
				+ sReturn +"theprecedentedness is high.");
		FLEXLb.setToolTipText("FLEX（flexibility）is used to "
				+ sReturn +" describe the flexibility of the e"
				+sReturn + "software development, and evaluate  "
				+ sReturn +"the strictness of the requirements  "
				+ sReturn +"and the coherence of the external "
				+ sReturn +"interfaces.");
		RESLLb.setToolTipText("RESL (Risk Resolution)  examines the"
				+ sReturn +" amount of project’s risk items and"
				+sReturn + "the level of the risks. It also  "
				+ sReturn +"identifies the percent of "
				+ sReturn +"development schedule devoted to "
				+ sReturn +"establishing architecture, when the "
				+ sReturn +"general product objectives are  "
				+ sReturn +"given.");
		TEAMLb.setToolTipText("TEAM accounts for the sources of "
				+ sReturn +"project turbulence and entropy "
				+sReturn + "because of difficulties in "
				+ sReturn +"synchronizing the project’s  "
				+ sReturn +"stakeholders.");
		PMATLb.setToolTipText("The procedure for determining PMAT "
				+ sReturn +"(Process Maturity) is organized "
				+sReturn + "around the Software Engineering "
				+ sReturn +"Institute’s Capability Maturity "
				+ sReturn +"Model (CMM)");
		
		btn_save = new Button(this, SWT.NONE);
		btn_save.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				try {
					save();
					System.out.println("保存成功");
				} catch (VersionNotSelectedException e) {
					// TODO 自动生成的 catch 块
					System.out.println("未选择版本");
					System.out.println("保存失败");
					e.printStackTrace();
				} catch (InvalidInputException e) {
					// TODO 自动生成的 catch 块
					System.out.println("错误的输入");
					System.out.println("保存失败");
					e.printStackTrace();
				} catch (EindexMissingParamException e) {
					// TODO 自动生成的 catch 块
					System.out.println("参数缺失");
					System.out.println("保存失败");
					e.printStackTrace();
				}
			}
		});
		FormData fd_btn_save = new FormData();
		fd_btn_save.bottom = new FormAttachment(lblEIndex, 0, SWT.BOTTOM);
		fd_btn_save.right = new FormAttachment(100, -88);
		btn_save.setLayoutData(fd_btn_save);
		btn_save.setText("Save");
	}
}
