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

import com.seu.adapter.UiAdapter;
import com.seu.bean.Size;
import com.seu.bean.Version;
import com.seu.dao.impl.SizeDaoImpl;
import com.seu.exception.SizeNotFoundException;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SoftwareSizeEnterCp extends Composite implements UiAdapter{
	private Text textlblExternalInputFile;
	private Text textExternalInputData;
	private Text textExternalOutputFile;
	private Text textExternalOutputData;
	private Text textExternalSearchFile;
	private Text textExternalSearchData;
	private Text textInsideLogicFileMemory;
	private Text textlInsideLogicFileData;
	private Text textExternalInterfaceFileMemory;
	private Text textExternalInterfaceFileData;
	private Text textAdjustScale;
	private Label lblhorizontal;
	private Label lblhorizontal1;
	private Text textSizeM;
	Version version;
	Size size;
	
	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	
	public SoftwareSizeEnterCp(Composite parent, int style) {
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
		cp_2_fd.top = new FormAttachment(10, 10);
		cp_2_fd.left = new FormAttachment(composite_1, 15);
		cp_2_fd.bottom = new FormAttachment(80, -43);
		cp_2_fd.right = new FormAttachment(70, -2);
		composite_2.setLayoutData(cp_2_fd);
		
		Composite composite_3 = new Composite(this, SWT.NONE);
		composite_3.setLayoutData(new FormData());
		GridLayout cp_3gridLayout = new GridLayout();
		cp_3gridLayout.marginHeight = 0;
		cp_3gridLayout.marginWidth = 0;
		composite_3.setLayout(cp_3gridLayout);
		FormData cp_3_fd = new FormData();
		cp_3_fd.right = new FormAttachment(90, -10);
		cp_3_fd.left = new FormAttachment(composite_2);
		cp_3_fd.top = new FormAttachment( 10, 10);
		cp_3_fd.bottom = new FormAttachment(80, -43);
		composite_3.setLayoutData(cp_3_fd);
		
		Label lblExternalInputFile = new Label(composite, SWT.PUSH);
		lblExternalInputFile.setLayoutData(new GridData(GridData.FILL_BOTH));
		lblExternalInputFile.setText("外部输入文件类型数");
		
		textlblExternalInputFile = new Text(composite_1,SWT.BORDER| SWT.PUSH);
		GridData gd_textlblExternalInputFile = new GridData(GridData.FILL_BOTH);
		gd_textlblExternalInputFile.minimumHeight = 15;
		textlblExternalInputFile.setLayoutData(gd_textlblExternalInputFile);
		
		Label lblExternalInputData = new Label(composite, SWT.PUSH);
		lblExternalInputData.setLayoutData(new GridData(GridData.FILL_BOTH));
		lblExternalInputData.setText("外部输入数据类型数");
		
		textExternalInputData = new Text(composite_1,SWT.BORDER| SWT.PUSH);
		textExternalInputData.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblExternalOutputFile = new Label(composite, SWT.PUSH);
		lblExternalOutputFile.setText("外部输出文件类型数");
		
		lblExternalOutputFile.setLayoutData(new GridData(GridData.FILL_BOTH));
		textExternalOutputFile = new Text(composite_1,SWT.BORDER| SWT.PUSH);
		textExternalOutputFile.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblExternalOutputData = new Label(composite, SWT.PUSH);
		lblExternalOutputData.setText("外部输出数据类型数");
		
		lblExternalOutputData.setLayoutData(new GridData(GridData.FILL_BOTH));
		textExternalOutputData = new Text(composite_1, SWT.BORDER|SWT.PUSH);
		textExternalOutputData.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblExternalSearchFile = new Label(composite, SWT.PUSH);
		lblExternalSearchFile.setText("外部查询文件类型数");
		lblExternalSearchFile.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		textExternalSearchFile = new Text(composite_1, SWT.BORDER|SWT.PUSH);
		textExternalSearchFile.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblExternalSearchData = new Label(composite, SWT.PUSH);
		lblExternalSearchData.setText("外部查询数据类型数");
		lblExternalSearchData.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		textExternalSearchData = new Text(composite_1, SWT.BORDER|SWT.PUSH);
		textExternalSearchData.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblInsideLogicFileMemory = new Label(composite_2, SWT.PUSH);
		lblInsideLogicFileMemory.setText("内部逻辑文件记录元素数");
		lblInsideLogicFileMemory.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		
		textInsideLogicFileMemory = new Text(composite_3, SWT.BORDER|SWT.PUSH);
		textInsideLogicFileMemory.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblInsideLogicFileData = new Label(composite_2, SWT.PUSH);
		lblInsideLogicFileData.setText("内部逻辑文件数据类型数");
		lblInsideLogicFileData.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		textlInsideLogicFileData = new Text(composite_3, SWT.BORDER|SWT.PUSH);
		textlInsideLogicFileData.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblExternalInterfaceFileMemory = new Label(composite_2, SWT.PUSH);
		lblExternalInterfaceFileMemory.setText("外部接口文件记录元素数");
		lblExternalInterfaceFileMemory.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		textExternalInterfaceFileMemory = new Text(composite_3,SWT.BORDER| SWT.PUSH);
		textExternalInterfaceFileMemory.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblExternalInterfaceFileData = new Label(composite_2, SWT.PUSH);
		lblExternalInterfaceFileData.setText("外部接口文件数据类型数");
		lblExternalInterfaceFileData.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		textExternalInterfaceFileData = new Text(composite_3, SWT.BORDER|SWT.PUSH);
		textExternalInterfaceFileData.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblSoftKnowing = new Label(composite_2, SWT.PUSH);
		lblSoftKnowing.setLayoutData(new GridData(GridData.FILL_BOTH));
		lblSoftKnowing.setText("软件理解因子");
		
		Label lblProgramUnfamili = new Label(composite_2, SWT.PUSH);
		lblProgramUnfamili.setLayoutData(new GridData(GridData.FILL_BOTH));
		lblProgramUnfamili.setText("程序不熟悉性因子");
		
		Combo cbSoftKnowing = new Combo(composite_3, SWT.BORDER|SWT.PUSH);
		cbSoftKnowing.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbSoftKnowing.add("很低",0);
		cbSoftKnowing.add("低",1);
		cbSoftKnowing.add("标称",2);
		cbSoftKnowing.add("高",3);
		cbSoftKnowing.add("很高",4);
		
		Combo cbProgramUnfamili = new Combo(composite_3, SWT.BORDER|SWT.PUSH);
		cbProgramUnfamili.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbProgramUnfamili.add("完全不熟悉", 0);
		cbProgramUnfamili.add("大部分不熟悉", 1);
		cbProgramUnfamili.add("有点熟悉", 2);
		cbProgramUnfamili.add("部分熟悉", 3);
		cbProgramUnfamili.add("大部分熟悉",4);
		cbProgramUnfamili.add("完全熟悉", 5);
		
		Label lblAdjustScale = new Label(composite, SWT.PUSH);
		lblAdjustScale.setLayoutData(new GridData(GridData.FILL_BOTH));
		lblAdjustScale.setText("修改规模");
		textAdjustScale = new Text(composite_1,SWT.BORDER| SWT.PUSH);
		textAdjustScale.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblEnterSizeM = new Label(this, SWT.NONE);
		FormData fd_lblEnterSizeM = new FormData();
		fd_lblEnterSizeM.top = new FormAttachment(composite, 10);
		fd_lblEnterSizeM.left = new FormAttachment(0,6);
		fd_lblEnterSizeM.bottom = new FormAttachment(92, -6);
		lblEnterSizeM.setLayoutData(fd_lblEnterSizeM);
		lblEnterSizeM.setText("直接输入");
		
		lblhorizontal1 = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormData fd_label = new FormData();
		fd_label.bottom = new FormAttachment(85,-1);
		fd_label.top = new FormAttachment(82,1);
		fd_label.left = new FormAttachment(lblEnterSizeM,1);
		fd_label.right = new FormAttachment(95, -5);
		lblhorizontal1.setLayoutData(fd_label);
		
		
		Label lblSizeM = new Label(this, SWT.NONE);
		FormData fd_lblSizeM = new FormData();
		fd_lblSizeM.left = new FormAttachment(10,10);
		lblSizeM.setLayoutData(fd_lblSizeM);
		lblSizeM.setText("SizeM");
		
		textSizeM = new Text(this, SWT.BORDER);
		fd_lblSizeM.top = new FormAttachment(textSizeM, 3, SWT.TOP);
		FormData fd_textSizeM = new FormData();
		fd_textSizeM.bottom = new FormAttachment(100, -10);
		fd_textSizeM.left =new FormAttachment(lblSizeM,30);
		textSizeM.setLayoutData(fd_textSizeM);
		
		Button btn_save = new Button(this, SWT.NONE);
		btn_save.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if(save()){
					System.out.println("保存成功");
				}
				else {
					System.out.println("保存失败");
				}
			}
		});
		FormData fd_btn_save = new FormData();
		fd_btn_save.right = new FormAttachment(composite_3);
		fd_btn_save.bottom = new FormAttachment(100, -9);
		btn_save.setLayoutData(fd_btn_save);
		btn_save.setText("Save");

		
	}

	@Override
	public void load() {
		// TODO 自动生成的方法存根
		if(version!=null){
			SizeDaoImpl sizeDaoImpl = new SizeDaoImpl();
			try {
				size = sizeDaoImpl.getByProj_idAndVersion_id(version.getProj_id(), version.getId());
				textlblExternalInputFile.setText(size.getExInputFiles()+"");
				textExternalInputData.setText(size.getExInputData()+"");
				textExternalOutputFile.setText(size.getExOutputFiles()+"");
				textExternalOutputData.setText(size.getExOutputData()+"");
				textExternalSearchFile.setText(size.getExInquiryFiles()+"");
				textExternalSearchData.setText(size.getExInquiryData()+"");
				//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
				textlInsideLogicFileData.setText(size.getInLogicalData()+"");
				textInsideLogicFileMemory.setText(size.getInLogicalFiles()+"");
				textExternalInterfaceFileData.setText(size.getExInterfaceData()+"");
				textExternalInterfaceFileMemory.setText(size.getExInterfaceFile()+"");
				//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
			} catch (SizeNotFoundException e) {
				// TODO 自动生成的 catch 块
				System.out.println("暂时无版本，请添加");
			}
		}
	}

	@Override
	public void refresh() {
		// TODO 自动生成的方法存根
		load();
	}

	@Override
	public boolean save() {
		// TODO 自动生成的方法存根
		if(version==null){
			return false;
		}	
		SizeDaoImpl sizeDaoImpl = new SizeDaoImpl();
		try {
			try {
				size = sizeDaoImpl.getByProj_idAndVersion_id(version.getProj_id(), version.getId());
				size.setExInputFiles(Integer.parseInt(textlblExternalInputFile.getText()));
				size.setExInputData(Integer.parseInt(textExternalInputData.getText()));
				size.setExOutputFiles(Integer.parseInt(textExternalOutputFile.getText()));
				size.setExOutputData(Integer.parseInt(textExternalOutputData.getText()));
				size.setExInquiryFiles(Integer.parseInt(textExternalSearchFile.getText()));
				size.setExInquiryData(Integer.parseInt(textExternalSearchData.getText()));
				//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
				size.setInLogicalData(Integer.parseInt(textlInsideLogicFileData.getText()));
				size.setInLogicalFiles(Integer.parseInt(textInsideLogicFileMemory.getText()));
				size.setExInterfaceData(Integer.parseInt(textExternalInterfaceFileData.getText()));
				size.setExInterfaceFile(Integer.parseInt(textExternalInterfaceFileMemory.getText()));
				sizeDaoImpl.Update(size);
				return true;
			} catch (SizeNotFoundException e) {
				// TODO: handle exception
				size = new Size();
				size.setProj_id(version.getProj_id());
				size.setVersion_id(version.getId());
				size.setExInputFiles(Integer.parseInt(textlblExternalInputFile.getText()));
				size.setExInputData(Integer.parseInt(textExternalInputData.getText()));
				size.setExOutputFiles(Integer.parseInt(textExternalOutputFile.getText()));
				size.setExOutputData(Integer.parseInt(textExternalOutputData.getText()));
				size.setExInquiryFiles(Integer.parseInt(textExternalSearchFile.getText()));
				size.setExInquiryData(Integer.parseInt(textExternalSearchData.getText()));
				//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
				size.setInLogicalData(Integer.parseInt(textlInsideLogicFileData.getText()));
				size.setInLogicalFiles(Integer.parseInt(textInsideLogicFileMemory.getText()));
				size.setExInterfaceData(Integer.parseInt(textExternalInterfaceFileData.getText()));
				size.setExInterfaceFile(Integer.parseInt(textExternalInterfaceFileMemory.getText()));
				sizeDaoImpl.Save(size);
				return true;
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
