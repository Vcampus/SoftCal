package com.seu.ui.main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.win32.SYSTEMTIME;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.seu.bean.Proj;
import com.seu.bean.Size;
import com.seu.bean.Version;
import com.seu.dao.impl.SizeDaoImpl;
import com.seu.dao.impl.VersionDaoImpl;
import com.seu.ui.adjust.CompArgsAdjust;
import com.seu.ui.cal.CompWorkCal;
import com.seu.ui.res.CompResShow;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;

public class MainShell extends Shell {
	Composite comp_Content;
	Composite comp_Blank;
	
	CompWorkCal compWorkCal;
	CompArgsAdjust compArgsAdjust;
	CompResShow compResShow;
	
	Menu menu_1;
	MenuItem mntmNewSubmenuFile;	
	MenuItem mntmNewItem_open;
	MenuItem mntmNewItem_save;
	MenuItem mntmNewItem_new;	
	MenuItem mntmNewItem_cal;
	MenuItem mntmNewItem_adjust;
	MenuItem mntmNewItem_res;
	
	Proj proj ;
	Version version;
	private VersionDaoImpl versionDaoImpl;

	private MenuItem mntmClose;
	private Label lable_blank_tip;
	private Button btn_addversion;

	public Proj getProj() {
		return proj;
	}

	public void setProj(Proj proj) {
		this.proj = proj;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			MainShell shell = new MainShell(display);
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
//		Size size = new Size();
//		SizeDaoImpl sizeDaoImpl = new SizeDaoImpl();
//		try {
//			size = sizeDaoImpl.getByProj_idAndVersion_id(1, 9);
//			size.setInLogicalData(1000);
//			sizeDaoImpl.Update(size);
//			size.setProj_id(2);
//			size.setVersion_id(2);
//			sizeDaoImpl.Save(size);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public MainShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		//变量初始化
		versionDaoImpl = new VersionDaoImpl();
		
		//初始布局加载
		initLayout();	
		
		//窗口创建
		createContents();
		
		//窗口进行刷新
		refresh();
	}

	/**
	 * Create contents of the shell.
	 */
	
	private void initLayout(){
		setMinimumSize(new Point(943, 616));
		setLayout(new FormLayout());
		
		compResShow = new CompResShow(this, SWT.NONE);
		FormLayout fl_compResShow = new FormLayout();
		fl_compResShow.marginRight = 10;
		fl_compResShow.marginLeft = 110;
		compResShow.setLayout(fl_compResShow);
		FormData fd_compResShow = new FormData();
		fd_compResShow.bottom = new FormAttachment(0, 503);
		fd_compResShow.right = new FormAttachment(90);
		fd_compResShow.top = new FormAttachment(0);
		fd_compResShow.left = new FormAttachment(10);
		compResShow.setLayoutData(fd_compResShow);
		
		
		//添加版本号
		comp_Blank = new Composite(this, SWT.NONE);
		FormData fd_comp_Blank = new FormData();
		fd_comp_Blank.bottom = new FormAttachment(0, 517);
		fd_comp_Blank.right = new FormAttachment(0, 917);
		fd_comp_Blank.top = new FormAttachment(0);
		fd_comp_Blank.left = new FormAttachment(0);
		comp_Blank.setLayoutData(fd_comp_Blank);
		
		lable_blank_tip = new Label(comp_Blank, SWT.NONE);
		lable_blank_tip.setLocation(267, 250);
		lable_blank_tip.setSize(416, 41);
		lable_blank_tip.setAlignment(SWT.CENTER);
		lable_blank_tip.setText("Empty Project Workspace");
			
		//主界面布局
		comp_Content = new Composite(this, SWT.NONE);
		comp_Content.setLayout(new FormLayout());
		FormData fd_comp_Content = new FormData();
		fd_comp_Content.bottom = new FormAttachment(0, 557);
		fd_comp_Content.right = new FormAttachment(0, 917);
		fd_comp_Content.top = new FormAttachment(0);
		fd_comp_Content.left = new FormAttachment(0);
		comp_Content.setLayoutData(fd_comp_Content);
		
		compArgsAdjust = new CompArgsAdjust(comp_Content, SWT.NONE);
		FormData fd_compArgsAdjust = new FormData();
		fd_compArgsAdjust.bottom = new FormAttachment(0, 617);
		fd_compArgsAdjust.right = new FormAttachment(0, 753);
		fd_compArgsAdjust.top = new FormAttachment(0, 100);
		fd_compArgsAdjust.left = new FormAttachment(0);
		compArgsAdjust.setLayoutData(fd_compArgsAdjust);
		
		
		compWorkCal = new CompWorkCal(comp_Content, SWT.NONE);
		FormData fd_compWorkCal = new FormData();
		fd_compWorkCal.bottom = new FormAttachment(0, 586);
		fd_compWorkCal.right = new FormAttachment(0, 572);
		fd_compWorkCal.top = new FormAttachment(0, 100);
		fd_compWorkCal.left = new FormAttachment(0);
		compWorkCal.setLayoutData(fd_compWorkCal);
		
		
		//添加版本号
		btn_addversion = new Button(comp_Content, SWT.NONE);
		FormData fd_btn_addversion = new FormData();
		fd_btn_addversion.right = new FormAttachment(0, 480);
		fd_btn_addversion.top = new FormAttachment(0, 10);
		fd_btn_addversion.left = new FormAttachment(0, 400);
		btn_addversion.setLayoutData(fd_btn_addversion);
		btn_addversion.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				AddVersionShell addVersionShell = new AddVersionShell(getDisplay(), proj,MainShell.this);
				addVersionShell.open();
				addVersionShell.layout();
			}
		});
		
		
		//主菜单栏
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		//文件下拉菜单栏
		mntmNewSubmenuFile = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenuFile.setText("File");
		
		menu_1 = new Menu(mntmNewSubmenuFile);
		mntmNewSubmenuFile.setMenu(menu_1);
		
		//建立新工程
		mntmNewItem_new = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_new.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				NewProjShell newProjShell = new NewProjShell(getDisplay(),MainShell.this);
				newProjShell.open();
				newProjShell.layout();
			}
		});
		mntmNewItem_new.setText("new project");
		
		
		//打开已有工程
		mntmNewItem_open = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_open.setText("open project");
		mntmNewItem_open.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				OpenProjShell openProjShell = new OpenProjShell(getDisplay(),MainShell.this);
				openProjShell.open();
				openProjShell.layout();
			}
		});
		
		
		//保存工程
		mntmNewItem_save = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_save.setText("save project");
		
		
		//关闭工程
		mntmClose = new MenuItem(menu_1, SWT.NONE);
		mntmClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				proj = null;
				refresh();
			}
		});
		mntmClose.setText("close");
		
		
		//演化成本估算
		mntmNewItem_cal = new MenuItem(menu, SWT.NONE);
		mntmNewItem_cal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				compResShow.setVisible(false);
				compArgsAdjust.setVisible(false);
				compWorkCal.setVisible(true);
			}
		});
		mntmNewItem_cal.setText("演化成本估算");
		
		//公式校准
		mntmNewItem_adjust = new MenuItem(menu, SWT.NONE);
		mntmNewItem_adjust.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				compResShow.setVisible(false);
				compArgsAdjust.setVisible(true);
				compWorkCal.setVisible(false);
			}
		});
		mntmNewItem_adjust.setText("公式校准");
		
		
		//结果展示
		mntmNewItem_res = new MenuItem(menu, SWT.NONE);
		mntmNewItem_res.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				compResShow.setVisible(true);
				compArgsAdjust.setVisible(false);
				compWorkCal.setVisible(false);
			}
		});
		mntmNewItem_res.setText("结果展示");
		
	}
	
	
	protected void createContents() {
		setText("软件成本估算");
		setSize(450, 300);
	}
	
	public void refresh(){
		if(proj == null){
			//如果没有任何工程被打开
			setText("软件成本估算");
			mntmNewItem_cal.setEnabled(false);
			mntmNewItem_adjust.setEnabled(false);
			
			comp_Blank.setVisible(true);
			comp_Content.setVisible(false);
			compResShow.setVisible(false);
			compArgsAdjust.setVisible(false);
			compWorkCal.setVisible(false);
			
		}
		if(proj != null){
			setText(proj.getName());
			mntmNewItem_cal.setEnabled(true);
			mntmNewItem_adjust.setEnabled(true);
			comp_Blank.setVisible(false);
			comp_Content.setVisible(true);
			compResShow.setVisible(false);
			compArgsAdjust.setVisible(false);
			compWorkCal.setVisible(true);
			if(version != null){
				btn_addversion.setText(version.getVersion());
				//compWorkCal里的数据刷新
				compWorkCal.setVersion(version);
				compWorkCal.refresh();
			}else {
				btn_addversion.setText("select version");
			}
		}
	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
