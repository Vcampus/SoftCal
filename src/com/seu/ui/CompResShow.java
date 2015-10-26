package com.seu.ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

public class CompResShow extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CompResShow(Composite parent, int style) {
		super(parent, style);
		
		Button btnExit = new Button(this, SWT.NONE);
		btnExit.setBounds(556, 438, 80, 27);
		btnExit.setText("退出");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
