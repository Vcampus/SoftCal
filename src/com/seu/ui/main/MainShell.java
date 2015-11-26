package com.seu.ui.main;

import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.seu.bean.Proj;
import com.seu.bean.Version;
import com.seu.dao.impl.ProjDaoImpl;
import com.seu.dao.impl.VersionDaoImpl;
import com.seu.exception.VersionExistedException;
import com.seu.ui.adjust.CompArgsAdjust;
import com.seu.ui.cal.CompWorkCal;
import com.seu.ui.res.CompResShow;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class MainShell extends Shell {
	Composite comp_Content;
	Composite compNewProj;

	CompWorkCal compWorkCal;
	CompArgsAdjust compArgsAdjust;
	CompResShow compResShow;
	NewProCp newProCp;

	Menu menu_1;
	MenuItem mntmNewSubmenuFile;
	MenuItem mntmNewItem_open;
	MenuItem mntmNewItem_new;
	MenuItem mntmNewItem_cal;
	MenuItem mntmNewItem_adjust;
	MenuItem mntmNewItem_res;

	Proj proj;
	java.util.List<Proj> listProjs;
	private ProjDaoImpl projDaoImpl;
	Version version;
	private VersionDaoImpl versionDaoImpl;
	java.util.List<Version> versions;
	private Label lable_blank_tip;
	private Button btn_addversion;
	private Button btn_saveversion;
	private Button btn_cancel;
	private Label lblnewversion;
	private Text text_version;
	private Label lblproj;
	private Combo comboproj;
	private Label lblversion;
	private Combo comboversion;
	private Label lblVersionNumber;
	private Button btnCal_exp;
	private Button btnCalAB;
	
	public Proj getProj() {
		return proj;
	}

	public void setProj(Proj proj) {
		this.proj = proj;
	}

	/**
	 * Launch the application.
	 * 
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
		// VersionDaoImpl versionDaoImpl = new VersionDaoImpl();
		// List<Version> versions=new ArrayList<Version>();
		// versions= versionDaoImpl.findByParams("select * from version_info
		// where proj_id =?", 1);
		// for(Version i : versions){
		//
		// }
	}

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public MainShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		// 变量初始化
		versionDaoImpl = new VersionDaoImpl();

		// 初始布局加载
		initLayout();

		// 窗口创建
		createContents();

		// 窗口进行刷新
		refresh();
	}

	/**
	 * Create contents of the shell.
	 */

	private void initLayout() {
		setMinimumSize(new Point(943, 616));
		setLayout(new FormLayout());

		compResShow = new CompResShow(this, SWT.NONE);
		FormData cpReShow_fd = new FormData();
		cpReShow_fd.top = new FormAttachment(0, 10);
		cpReShow_fd.left = new FormAttachment(0, 10);
		cpReShow_fd.bottom = new FormAttachment(100, -10);
		cpReShow_fd.right = new FormAttachment(100, -10);
		compResShow.setLayoutData(cpReShow_fd);

		// 添加版本号
		compNewProj = new Composite(this, SWT.NONE);
		compNewProj.setLayout(new FormLayout());
		FormData cp_Blank_fd = new FormData();
		cp_Blank_fd.top = new FormAttachment(0, 10);
		cp_Blank_fd.left = new FormAttachment(0, 10);
		cp_Blank_fd.bottom = new FormAttachment(100, -10);
		cp_Blank_fd.right = new FormAttachment(100, -10);
		compNewProj.setLayoutData(cp_Blank_fd);

		newProCp = new NewProCp(compNewProj, SWT.NONE);
		FormData newProCp_fd = new FormData();
		newProCp_fd.top = new FormAttachment(20, 10);
		newProCp_fd.left = new FormAttachment(20, 10);
		newProCp_fd.bottom = new FormAttachment(80, -10);
		newProCp_fd.right = new FormAttachment(80, -10);
		newProCp.setLayoutData(newProCp_fd);

		lable_blank_tip = new Label(compNewProj, SWT.NONE);
		lable_blank_tip.setAlignment(SWT.CENTER);
		lable_blank_tip.setText("Empty Project Workspace");
		FormData lable_blank_tip_fd = new FormData();
		lable_blank_tip_fd.top = new FormAttachment(40, 10);
		lable_blank_tip_fd.left = new FormAttachment(40, 10);
		lable_blank_tip_fd.bottom = new FormAttachment(60, -10);
		lable_blank_tip_fd.right = new FormAttachment(60, -10);
		lable_blank_tip.setLayoutData(lable_blank_tip_fd);

		// 主界面布局
		comp_Content = new Composite(this, SWT.NONE);
		comp_Content.setLayout(new FormLayout());
		FormData comp_Content_fd = new FormData();
		comp_Content_fd.top = new FormAttachment(0, 10);
		comp_Content_fd.left = new FormAttachment(0, 10);
		comp_Content_fd.bottom = new FormAttachment(100, -10);
		comp_Content_fd.right = new FormAttachment(100, -10);
		comp_Content.setLayoutData(comp_Content_fd);

		compArgsAdjust = new CompArgsAdjust(comp_Content, SWT.NONE);
		FormData compArgsAdjust_fd = new FormData();
		compArgsAdjust_fd.top = new FormAttachment(8, 10);
		compArgsAdjust_fd.left = new FormAttachment(0, 10);
		compArgsAdjust_fd.bottom = new FormAttachment(100, -10);
		compArgsAdjust_fd.right = new FormAttachment(100, -10);
		compArgsAdjust.setLayoutData(compArgsAdjust_fd);

		compWorkCal = new CompWorkCal(comp_Content, SWT.NONE);
		FormData compWorkCal_fd = new FormData();
		compWorkCal_fd.top = new FormAttachment(8, 10);
		compWorkCal_fd.left = new FormAttachment(0, 10);
		compWorkCal_fd.bottom = new FormAttachment(100, -10);
		compWorkCal_fd.right = new FormAttachment(100, -10);
		compWorkCal.setLayoutData(compWorkCal_fd);

		// 选择项目
		lblproj = new Label(comp_Content, SWT.NONE);
		FormData lblproj_fd = new FormData();
		lblproj_fd.top = new FormAttachment(2, 7);
		lblproj_fd.right = new FormAttachment(8, -1);
		lblproj_fd.left = new FormAttachment(1, 1);
		lblproj_fd.bottom = new FormAttachment(compArgsAdjust, -5);
		lblproj.setLayoutData(lblproj_fd);
		lblproj.setText("Project");

		comboproj = new Combo(comp_Content, SWT.NONE);
		FormData comboproj_fd = new FormData();
		comboproj_fd.top = new FormAttachment(2, 5);
		comboproj_fd.right = new FormAttachment(20, -1);
		comboproj_fd.left = new FormAttachment(lblproj, 3);
		comboproj.setLayoutData(comboproj_fd);
		ProjDaoImpl projDaoImpl = new ProjDaoImpl();
		listProjs = new ArrayList<Proj>();
		listProjs = projDaoImpl.findByParams("select * from proj_info ");
		for (int i = 0; i < listProjs.size(); i++) {
			comboproj.add(listProjs.get(i).getName(), i);
		}
		comboproj.select(0);
		proj = listProjs.get(0);
		comboproj.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				// 这里需要写获取选中函数
				proj = listProjs.get(comboproj.getSelectionIndex());
				refresh();
			}
		});

		// 版本号显示
		lblversion = new Label(comp_Content, SWT.NONE);
		FormData lblversion_fd = new FormData();
		lblversion_fd.top = new FormAttachment(2, 7);
		lblversion_fd.right = new FormAttachment(34, -20);
		lblversion_fd.left = new FormAttachment(25, 1);
		lblversion_fd.bottom = new FormAttachment(compArgsAdjust, -5);
		lblversion.setLayoutData(lblversion_fd);
		lblversion.setText("Version");

		comboversion = new Combo(comp_Content, SWT.NONE);
		FormData comboversion_fd = new FormData();
		comboversion_fd.left = new FormAttachment(lblversion, 15);
		comboversion_fd.top = new FormAttachment(2, 5);
		comboversion.setLayoutData(comboversion_fd);
		versions = new ArrayList<Version>();
		versions = versionDaoImpl.findByParams("select * from version_info where proj_id = ?", proj.getId());
		comboversion.select(0);
		proj = listProjs.get(0);
		for (int i = 0; i < versions.size(); i++) {
			comboversion.add(versions.get(i).getVersion(), i);
		}
		comboversion.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				version = versions.get(comboversion.getSelectionIndex());
				refresh();
				comboversion.setText(version.getVersion());
			}
		});

		// 添加版本
		btn_addversion = new Button(comp_Content, SWT.NONE);
		comboversion_fd.right = new FormAttachment(btn_addversion);
		btn_addversion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				btnCal_exp.setVisible(false);
				lblnewversion.setVisible(true);
				btn_saveversion.setVisible(true);
				btn_cancel.setVisible(true);
				text_version.setVisible(true);
			}
		});
		btn_addversion.setText("+");
		FormData btn_addversion_fd = new FormData();
		btn_addversion_fd.top = new FormAttachment(2, 5);
		btn_addversion_fd.left = new FormAttachment(0, 407);
		btn_addversion.setLayoutData(btn_addversion_fd);
		btn_addversion.setVisible(false);

		lblnewversion = new Label(comp_Content, SWT.NONE);
		lblnewversion.setText("Version");
		FormData lblnewversion_fd = new FormData();
		lblnewversion_fd.top = new FormAttachment(2, 7);
		lblnewversion_fd.left = new FormAttachment(55, 10);
		lblnewversion_fd.bottom = new FormAttachment(compArgsAdjust, -5);
		lblnewversion.setLayoutData(lblnewversion_fd);
		lblnewversion.setVisible(false);

		text_version = new Text(comp_Content, SWT.BORDER);
		text_version.setVisible(false);
		FormData text_version_fd = new FormData();
		text_version_fd.left = new FormAttachment(lblnewversion, 15);
		text_version_fd.top = new FormAttachment(2, 5);
		text_version_fd.bottom = new FormAttachment(compArgsAdjust, -10);
		text_version.setLayoutData(text_version_fd);

		btn_saveversion = new Button(comp_Content, SWT.NONE);
		btn_saveversion.setText("Save");
		btn_saveversion.setVisible(false);
		FormData btn_saveversion_fd = new FormData();
		btn_saveversion_fd.top = new FormAttachment(2, 5);
		btn_saveversion_fd.bottom = new FormAttachment(compArgsAdjust, -10);
		btn_saveversion_fd.left = new FormAttachment(text_version, 20);
		btn_saveversion.setLayoutData(btn_saveversion_fd);
		btn_saveversion.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent arg0) {
				if (text_version.getText() != "") {
					Version version = new Version(proj.getId(), proj.getName(), text_version.getText());
					try {
						versionDaoImpl.Save(version);
						MessageBox messageBox = new MessageBox(getShell());
						messageBox.setMessage("successfully save");
						messageBox.open();
						refresh();
						lblnewversion.setVisible(false);
						btn_saveversion.setVisible(false);
						text_version.setVisible(false);
						btn_cancel.setVisible(false);
						text_version.setText("");
					} catch (VersionExistedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				} else {
					MessageBox messageBox = new MessageBox(getShell());
					messageBox.setMessage("please enter new version");
					messageBox.open();
				}
			}
		});

		btn_cancel = new Button(comp_Content, SWT.NONE);
		btn_cancel.setText("Cancle");
		btn_cancel.setVisible(false);
		FormData btn_cancle_fd = new FormData();
		btn_cancle_fd.top = new FormAttachment(2, 5);
		btn_cancle_fd.bottom = new FormAttachment(compArgsAdjust, -10);
		btn_cancle_fd.left = new FormAttachment(btn_saveversion, 15);
		btn_cancel.setLayoutData(btn_cancle_fd);
		btn_cancel.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent arg0) {
				lblnewversion.setVisible(false);
				btn_saveversion.setVisible(false);
				text_version.setVisible(false);
				btn_cancel.setVisible(false);
				btnCal_exp.setVisible(true);
				text_version.setText("");

			}
		});

		lblVersionNumber = new Label(comp_Content, SWT.NONE);
		lblVersionNumber.setText("This project has " + versions.size() + " versions");
		FormData lblVersionNumber_fd = new FormData();
		lblVersionNumber_fd.top = new FormAttachment(2, 5);
		lblVersionNumber_fd.left = new FormAttachment(55, 1);
		lblVersionNumber_fd.bottom = new FormAttachment(compArgsAdjust, -10);
		lblVersionNumber.setLayoutData(lblVersionNumber_fd);
		lblVersionNumber.setVisible(false);

		// 计算PM经验指
		btnCal_exp = new Button(comp_Content, SWT.NONE);
		FormData btnCal_fd = new FormData();
		btnCal_fd.top = new FormAttachment(2, 5);
		btnCal_fd.bottom = new FormAttachment(compArgsAdjust, -10);
		btnCal_fd.left = new FormAttachment(70, 1);
		btnCal_exp.setLayoutData(btnCal_fd);
		btnCal_exp.setText("Calculate PM");
		btnCal_exp.setVisible(true);

		// 公式校准AB
		btnCalAB = new Button(comp_Content, SWT.NONE);
		FormData btnCalAB_fd = new FormData();
		btnCalAB_fd.top = new FormAttachment(2, 5);
		btnCalAB_fd.bottom = new FormAttachment(compArgsAdjust, -10);
		btnCalAB_fd.left = new FormAttachment(80, 1);
		btnCalAB.setLayoutData(btnCalAB_fd);
		btnCalAB.setText("Adjust A B");
		btnCalAB.setVisible(false);

		// 主菜单栏
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);

		// 文件下拉菜单栏
		mntmNewSubmenuFile = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenuFile.setText("New Project");
		mntmNewSubmenuFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				compNewProj.setVisible(true);
				compResShow.setVisible(false);
				compArgsAdjust.setVisible(false);
				compWorkCal.setVisible(false);
				MainShell.this.setText("添加新项目");
			}
		});

		// 演化成本估算
		mntmNewItem_cal = new MenuItem(menu, SWT.NONE);
		mntmNewItem_cal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				btnCal_exp.setVisible(true);
				btnCalAB.setVisible(false);
				btn_addversion.setVisible(true);
				lblVersionNumber.setVisible(false);
				compNewProj.setVisible(false);
				compResShow.setVisible(false);
				compArgsAdjust.setVisible(false);
				compWorkCal.setVisible(true);
				MainShell.this.setText("演化成本估算");
			}
		});
		mntmNewItem_cal.setText("演化成本估算");

		// 公式校准
		mntmNewItem_adjust = new MenuItem(menu, SWT.NONE);
		mntmNewItem_adjust.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				btnCal_exp.setVisible(false);
				btnCalAB.setVisible(true);
				lblVersionNumber.setVisible(true);
				btn_addversion.setVisible(false);
				lblnewversion.setVisible(false);
				btn_saveversion.setVisible(false);
				text_version.setVisible(false);
				btn_cancel.setVisible(false);
				compNewProj.setVisible(false);
				compResShow.setVisible(false);
				compArgsAdjust.setVisible(true);
				compWorkCal.setVisible(false);
				MainShell.this.setText("公式校准");
				refresh();

			}
		});
		mntmNewItem_adjust.setText("公式校准");

		// 结果展示
		mntmNewItem_res = new MenuItem(menu, SWT.NONE);
		mntmNewItem_res.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				compNewProj.setVisible(false);
				compResShow.setVisible(true);
				compArgsAdjust.setVisible(false);
				compWorkCal.setVisible(false);
				MainShell.this.setText("结果展示");
				refresh();
			}
		});
		mntmNewItem_res.setText("结果展示");

	}

	protected void createContents() {
		setText("软件成本估算");
		setSize(450, 300);
	}

	// 刷新函数需要重新考虑要总体考虑保存
	public void refresh() {
		mntmNewItem_cal.setEnabled(true);
		mntmNewItem_adjust.setEnabled(true);
		versions = versionDaoImpl.findByParams("select * from version_info where proj_id = ?", proj.getId());
		lblVersionNumber.setText("This project has " + versions.size() + " versions");

		if (versions != null) {
			comboversion.removeAll();
			for (int i = 0; i < versions.size(); i++) {
				comboversion.add(versions.get(i).getVersion(), i);
			}
		}
		if (version != null) {
			// compWorkCal里的数据刷新
			compWorkCal.setVersion(version);
			compArgsAdjust.setVersion(version);
			compWorkCal.refresh();
			compArgsAdjust.refresh();
		}

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
