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
import com.seu.ui.adjust.CompArgsAdjust;
import com.seu.ui.cal.CompWorkCal;
import com.seu.ui.res.CompResShow;

public class MainShell extends Shell {
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
		setLayout(null);
			
		//主界面布局
		Composite comp_Content = new Composite(this, SWT.NONE);
		comp_Content.setBounds(0, 0, 917, 557);
		
		
		compWorkCal = new CompWorkCal(comp_Content, SWT.NONE);
		compWorkCal.setBounds(0, 0, 645, 557);
		
		compArgsAdjust = new CompArgsAdjust(comp_Content, SWT.NONE);
		compArgsAdjust.setBounds(0, 0, 645, 557);
		
		compResShow = new CompResShow(comp_Content, SWT.NONE);
		compResShow.setBounds(0, 0, 645, 557);
		
		//主菜单栏
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		//文件下拉菜单栏
		mntmNewSubmenuFile = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenuFile.setText("File");
		
		menu_1 = new Menu(mntmNewSubmenuFile);
		mntmNewSubmenuFile.setMenu(menu_1);
		
		mntmNewItem_open = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_open.setText("open project");
		
		mntmNewItem_save = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_save.setText("save project");
		
		mntmNewItem_new = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_new.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				OpenProjShell openProjShell = new OpenProjShell(getDisplay(),MainShell.this);
				openProjShell.open();
				openProjShell.layout();
			}
		});
		mntmNewItem_new.setText("new project");
		
		
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
		}
		if(proj != null){
			setText(proj.getName());
			mntmNewItem_cal.setEnabled(true);
			mntmNewItem_adjust.setEnabled(true);
		}
	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
