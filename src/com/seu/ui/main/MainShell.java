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

import com.seu.ui.adjust.CompArgsAdjust;
import com.seu.ui.cal.CompWorkCal;
import com.seu.ui.res.CompResShow;

public class MainShell extends Shell {
	CompWorkCal compWorkCal;
	CompArgsAdjust compArgsAdjust;
	CompResShow compResShow;

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
		
		//
		
		//窗口创建
		createContents();
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
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("File");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmNewItem_4 = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_4.setText("open project");
		
		MenuItem mntmNewItem_5 = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_5.setText("save project");
		
		MenuItem mntmNewItem_6 = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_6.setText("new project");
		
		MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				compResShow.setVisible(false);
				compArgsAdjust.setVisible(false);
				compWorkCal.setVisible(true);
			}
		});
		mntmNewItem.setText("演化成本估算");
		
		MenuItem mntmNewItem_1 = new MenuItem(menu, SWT.NONE);
		mntmNewItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				compResShow.setVisible(false);
				compArgsAdjust.setVisible(true);
				compWorkCal.setVisible(false);
			}
		});
		mntmNewItem_1.setText("公式校准");
		
		MenuItem mntmNewItem_3 = new MenuItem(menu, SWT.NONE);
		mntmNewItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				compResShow.setVisible(true);
				compArgsAdjust.setVisible(false);
				compWorkCal.setVisible(false);
			}
		});
		mntmNewItem_3.setText("结果展示");
		
	}
	
	protected void createContents() {
		setText("软件成本估算");
		setSize(450, 300);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
