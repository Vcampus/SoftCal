package com.seu.ui.adjust.input;

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
import com.seu.adapter.UiSizeAdapter;
import com.seu.bean.PM;
import com.seu.bean.Size;
import com.seu.bean.Version;
import com.seu.dao.PMDao;
import com.seu.dao.impl.PMDaoImpl;
import com.seu.dao.impl.SizeDaoImpl;
import com.seu.exception.InvalidInputException;
import com.seu.exception.PmNotFoundException;
import com.seu.exception.SizeNotFoundException;
import com.seu.exception.VersionNotSelectedException;
import com.sun.corba.se.impl.logging.OMGSystemException;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class AdjSizeAndPMCp extends Composite implements UiSizeAdapter{
	private Label lblhorizontal;
	private Label lblhorizontal1;
	private Text textSizeM;
	private Text textPersonAmount;
	Version version;
	Size size;
	PM pm;
	private Text textStartTIme;
	private Text textEndTime;
	
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
	
	public AdjSizeAndPMCp(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		initLayout();
	}
	
	public void load() {
		// TODO 自动生成的方法存根
		
		if(version!=null){
			SizeDaoImpl sizeDaoImpl = new SizeDaoImpl();
			PMDaoImpl pmDaoImpl =new PMDaoImpl();
			try {
				size = sizeDaoImpl.getByProj_idAndVersion_idAndType(version.getProj_id(), version.getId(),1);
				pm =pmDaoImpl.getByProj_idAndVersion_id(version.getProj_id(), version.getId());
				if(size.getInputSize()==0)
					textSizeM.setText("");
				else {
					textSizeM.setText(size.getInputSize()+"");
				}
				if(pm.getPM_real()==0)
					textPersonAmount.setText("");
				else {
					textPersonAmount.setText(pm.getPM_real()+"");
				}
				
				
			} catch (SizeNotFoundException e) {
				// TODO 自动生成的 catch 块
				System.out.println("暂时无size版本，请添加");
			}catch (PmNotFoundException e) {
				// TODO: handle exception
				System.out.println("暂时无pm版本，请添加");
			}
		}
	}

	@Override
	public void refresh() {
		// TODO 自动生成的方法存根
		load();
	}

	@Override
	public void save() throws VersionNotSelectedException,InvalidInputException, PmNotFoundException{
		// TODO 自动生成的方法存根
		if(version==null){
			throw new VersionNotSelectedException();
		}	
		SizeDaoImpl sizeDaoImpl = new SizeDaoImpl();
		PMDaoImpl pmDaoImpl =new PMDaoImpl();
		try {
			try {
				size = sizeDaoImpl.getByProj_idAndVersion_idAndType(version.getProj_id(), version.getId(),1);
				size.setInputSize(Integer.parseInt(textSizeM.getText()));
				sizeDaoImpl.Update(size);
			} catch (SizeNotFoundException e) {
				// TODO: handle exception
				size = new Size();
				size.setProj_id(version.getProj_id());
				size.setVersion_id(version.getId());
				size.setType(1);
				sizeDaoImpl.Save(size);
			} 
			//计算pm的公式
			float realpm=0;
			
			try {
				pm = pmDaoImpl.getByProj_idAndVersion_id(version.getProj_id(), version.getId());
				pm.setPM_real(realpm);
				pmDaoImpl.updateReal(pm);
			} catch (PmNotFoundException e) {
				// TODO: handle exception
				pm = new PM();
				pm.setProj_id(version.getProj_id());
				pm.setVersion_id(version.getId());
				pm.setPM_real(realpm);
				pmDaoImpl.Save(pm);
				pm.setPM_real(realpm);
				pmDaoImpl.updateReal(pm);
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("存在数据输入格式不正确");
			throw new InvalidInputException();
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public void initLayout(){
		Label lblCalByPiont = new Label(this, SWT.NONE);
		FormData lblCalByPiont_fd = new FormData();
		lblCalByPiont_fd.top = new FormAttachment(2, 1);
		lblCalByPiont_fd.left = new FormAttachment(0,6);
		lblCalByPiont_fd.bottom = new FormAttachment(10, -1);
		lblCalByPiont.setLayoutData(lblCalByPiont_fd);
		lblCalByPiont.setText("PM实际值输入");
		
		lblhorizontal = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormData lblhorizontal_fd = new FormData();
		lblhorizontal_fd.bottom = new FormAttachment(10,-1);
		lblhorizontal_fd.top = new FormAttachment(2,1);
		lblhorizontal_fd.left = new FormAttachment(lblCalByPiont,1);
		lblhorizontal_fd.right = new FormAttachment(95, -5);
		lblhorizontal.setLayoutData(lblhorizontal_fd);
		
		Label lblStartTime = new Label(this, SWT.NONE);
		FormData lblStartTime1_fd = new FormData();
		lblStartTime1_fd.top = new FormAttachment(15, 1);
		lblStartTime1_fd.bottom =new FormAttachment(22,-1);
		lblStartTime1_fd.left = new FormAttachment(10,1);
		lblStartTime.setLayoutData(lblStartTime1_fd);
		lblStartTime.setText("开始时间");
		
		textStartTIme = new Text(this, SWT.BORDER);
		FormData textStartTIme_fd = new FormData();
		textStartTIme_fd.top = new FormAttachment(15, 1);
		textStartTIme_fd.bottom  =new FormAttachment(22,-1);
		textStartTIme_fd.left = new FormAttachment(lblStartTime, 30);
		textStartTIme.setLayoutData(textStartTIme_fd);
		
		Label lblEndTime = new Label(this, SWT.NONE);
		FormData fd_lblEndTime = new FormData();
		fd_lblEndTime.top =new FormAttachment(15,1);
		fd_lblEndTime.bottom = new FormAttachment(22, -1);
		fd_lblEndTime.left = new FormAttachment(50, 1);
		lblEndTime.setLayoutData(fd_lblEndTime);
		lblEndTime.setText("结束时间");
		
		textEndTime = new Text(this, SWT.BORDER);
		FormData fd_textEndTime = new FormData();
		fd_lblEndTime.top =new FormAttachment(15,1);
		fd_textEndTime.bottom = new FormAttachment(22,-1);
		fd_textEndTime.left = new FormAttachment(lblEndTime, 30);
		textEndTime.setLayoutData(fd_textEndTime);
	
		Label lblPersonAmount = new Label(this, SWT.NONE);
		FormData fd_lblPersonAmount = new FormData();
		fd_lblPersonAmount.left = new FormAttachment(10,1);
		fd_lblPersonAmount.top =new FormAttachment(36,1);
		fd_lblPersonAmount.bottom =new FormAttachment(42,-1);
		fd_lblPersonAmount.right =new FormAttachment(20, -8);
		lblPersonAmount.setLayoutData(fd_lblPersonAmount);
		lblPersonAmount.setText("开发人数");
		
		textPersonAmount = new Text(this, SWT.BORDER);
		textPersonAmount .addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {		
				Boolean editable=true;
			}
		});

		FormData fd_textPersonAmount = new FormData();
		fd_textPersonAmount.right = new FormAttachment(textStartTIme, 73);
		fd_textPersonAmount.left = new FormAttachment(textStartTIme, 0, SWT.LEFT);
		fd_textPersonAmount.top =new FormAttachment(36,1);
		fd_textPersonAmount.bottom =new FormAttachment(42,1);
		textPersonAmount.setLayoutData(fd_textPersonAmount);
		
		
		Label lblEnterSizeM = new Label(this, SWT.NONE);
		FormData fd_lblEnterSizeM = new FormData();
		fd_lblEnterSizeM.top = new FormAttachment(50, 1);
		fd_lblEnterSizeM.left = new FormAttachment(0,6);
		fd_lblEnterSizeM.bottom = new FormAttachment(56, -1);
		lblEnterSizeM.setLayoutData(fd_lblEnterSizeM);
		lblEnterSizeM.setText("SizeM输入");
		
		lblhorizontal1 = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormData fd_lblStartTime = new FormData();
		fd_lblStartTime.bottom = new FormAttachment(54,-1);
		fd_lblStartTime.top = new FormAttachment(51,1);
		fd_lblStartTime.left = new FormAttachment(lblEnterSizeM,1);
		fd_lblStartTime.right = new FormAttachment(95, -5);
		lblhorizontal1.setLayoutData(fd_lblStartTime);
		
		Label lblSizeM = new Label(this, SWT.NONE);
		FormData fd_lblSizeM = new FormData();
		fd_lblSizeM.left = new FormAttachment(0, 58);
		fd_lblSizeM.top = new FormAttachment(lblEnterSizeM, 30);
		lblSizeM.setLayoutData(fd_lblSizeM);
		lblSizeM.setText("SizeM");
		
		textSizeM = new Text(this, SWT.BORDER);
		textSizeM.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {		
				Boolean editable=true;
			}
		});
		FormData fd_textSizeM = new FormData();
		fd_textSizeM.left = new FormAttachment(lblSizeM, 50);
		fd_textSizeM.bottom = new FormAttachment(lblSizeM, 0, SWT.BOTTOM);
		textSizeM.setLayoutData(fd_textSizeM);
		
		Button btn_save = new Button(this, SWT.NONE);
		btn_save.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				try {
					save();
					System.out.println("保存成功");
				} catch (VersionNotSelectedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
					System.out.println("未选择版本");
					System.out.println("保存失败");
				} catch (InvalidInputException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
					System.out.println("输入不正确");
					System.out.println("保存失败");
				} catch (PmNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
					System.out.println("Pm找不到");
					System.out.println("保存失败");
				}
			}
		});
		FormData fd_btn_save = new FormData();
		fd_btn_save.left = new FormAttachment(100, -156);
		fd_btn_save.bottom = new FormAttachment(95, -10);
		fd_btn_save.right = new FormAttachment(100, -91);
		btn_save.setLayoutData(fd_btn_save);
		btn_save.setText("Save");	
		
		Button btnLoad = new Button(this, SWT.NONE);
		FormData fd_btnLoad = new FormData();
		fd_btnLoad.bottom = new FormAttachment(100, -30);
		fd_btnLoad.right = new FormAttachment(0, 131);
		fd_btnLoad.left = new FormAttachment(0, 66);
		btnLoad.setLayoutData(fd_btnLoad);
		btnLoad.setText("load");
		
		

	}
}
