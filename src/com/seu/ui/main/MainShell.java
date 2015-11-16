package com.seu.ui.main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.seu.bean.Proj;
import com.seu.bean.Version;
import com.seu.dao.impl.VersionDaoImpl;
import com.seu.ui.adjust.CompArgsAdjust;
import com.seu.ui.cal.CompWorkCal;
import com.seu.ui.res.CompResShow;
import org.eclipse.swt.widgets.Label;

public class MainShell extends Shell {
	Composite comp_Content;
	Composite comp_Blank;
	
	CompWorkCal compWorkCal;
	CompArgsAdjust compArgsAdjust;
	CompResShow compResShow;
	
	Menu menu_1;
	MenuItem mntmNewSubmenuFile;	
	MenuItem mntmNewItem_open;
	MenuItem mntmNewItem_new;	
	MenuItem mntmNewItem_cal;
	MenuItem mntmNewItem_adjust;
	MenuItem mntmNewItem_res;
	
	Proj proj ;
	Version version;
	private VersionDaoImpl versionDaoImpl;
	private Label lable_blank_tip;
	private Button btn_version;
	private Button btn_project;

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
		FormData cpReShow_fd = new FormData();
		cpReShow_fd.top = new FormAttachment( 0, 10);
		cpReShow_fd.left = new FormAttachment(0, 10);
		cpReShow_fd.bottom = new FormAttachment(100,-10);
		cpReShow_fd.right = new FormAttachment(100, -10);
		compResShow.setLayoutData(cpReShow_fd);
		
		
		//添加版本号
		comp_Blank = new Composite(this, SWT.NONE);
		comp_Blank.setLayout(new FormLayout());
		FormData cp_Blank_fd = new FormData();
		cp_Blank_fd.top = new FormAttachment( 0, 10);
		cp_Blank_fd.left = new FormAttachment(0, 10);
		cp_Blank_fd.bottom = new FormAttachment(100,-10);
		cp_Blank_fd.right = new FormAttachment(100, -10);
		comp_Blank.setLayoutData(cp_Blank_fd);
		
		lable_blank_tip = new Label(comp_Blank, SWT.NONE);
		lable_blank_tip.setAlignment(SWT.CENTER);
		lable_blank_tip.setText("Empty Project Workspace");
		FormData lable_blank_tip_fd = new FormData();
		lable_blank_tip_fd.top = new FormAttachment( 40, 10);
		lable_blank_tip_fd.left = new FormAttachment(40, 10);
		lable_blank_tip_fd.bottom = new FormAttachment(60,-10);
		lable_blank_tip_fd.right = new FormAttachment(60, -10);
		lable_blank_tip.setLayoutData(lable_blank_tip_fd);
			
		//主界面布局
		comp_Content = new Composite(this, SWT.NONE);
		comp_Content.setLayout(new FormLayout());
		FormData comp_Content_fd = new FormData();
		comp_Content_fd.top = new FormAttachment( 0, 10);
		comp_Content_fd.left = new FormAttachment(0, 10);
		comp_Content_fd.bottom = new FormAttachment(100,-10);
		comp_Content_fd.right = new FormAttachment(100, -10);
		comp_Content.setLayoutData(comp_Content_fd);
		
		
		compArgsAdjust = new CompArgsAdjust(comp_Content, SWT.NONE);
		FormData compArgsAdjust_fd = new FormData();
		compArgsAdjust_fd.top = new FormAttachment( 8, 10);
		compArgsAdjust_fd.left = new FormAttachment(0, 10);
		compArgsAdjust_fd.bottom = new FormAttachment(100,-10);
		compArgsAdjust_fd.right = new FormAttachment(100, -10);
		compArgsAdjust.setLayoutData(compArgsAdjust_fd);
		
		
		compWorkCal = new CompWorkCal(comp_Content, SWT.NONE);
		FormData compWorkCal_fd = new FormData();
		compWorkCal_fd.top = new FormAttachment(8, 10);
		compWorkCal_fd.left = new FormAttachment(0, 10);
		compWorkCal_fd.bottom = new FormAttachment(100,-10);
		compWorkCal_fd.right = new FormAttachment(100, -10);
		compWorkCal.setLayoutData(compWorkCal_fd);
		
		
		//添加版本号
		btn_version = new Button(comp_Content, SWT.NONE);
		btn_version.setText("Version");
		btn_version.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				AddVersionShell addVersionShell = new AddVersionShell(getDisplay(), proj,MainShell.this);
				addVersionShell.open();
				addVersionShell.layout();
			}
		});
		FormData fd_btn_version = new FormData();
		fd_btn_version.top = new FormAttachment( 2, 5);
		fd_btn_version.left = new FormAttachment(70, 10);
		fd_btn_version.bottom = new FormAttachment(compArgsAdjust,-5);
		fd_btn_version.right = new FormAttachment(85, -5);
		btn_version.setLayoutData(fd_btn_version);
		
		
		btn_project = new Button(comp_Content, SWT.NONE);
		FormData fd_btn_project = new FormData();
		fd_btn_project.top = new FormAttachment(2, 5);
		fd_btn_project.right = new FormAttachment(30);
		fd_btn_project.left = new FormAttachment(15, 10);
		btn_project.setLayoutData(fd_btn_project);
		btn_project.setText("Project");
		btn_project.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				OpenProjShell openProjShell = new OpenProjShell(getDisplay(), MainShell.this);
				openProjShell.open();
				openProjShell.layout();
			}
		});
		
		
		//主菜单栏
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		//文件下拉菜单栏
		mntmNewSubmenuFile = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenuFile.setText("Project");
		
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
		mntmNewItem_new.setText("New Project");
		
		
		//打开已有工程
		mntmNewItem_open = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_open.setText("Open Project");
		mntmNewItem_open.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				OpenProjShell openProjShell = new OpenProjShell(getDisplay(),MainShell.this);
				openProjShell.open();
				openProjShell.layout();
			}
		});
		
		
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
				btn_version.setText(version.getVersion());
			}else {
				btn_version.setText("select version");
			}
		}
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
				btn_version.setText(version.getVersion());
				//compWorkCal里的数据刷新
				compWorkCal.setVersion(version);
				compWorkCal.refresh();
			}else {
				btn_version.setText("select version");
			}
		}
	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
