package com.seu.adapter;

import com.seu.exception.EindexMissingParamException;
import com.seu.exception.InvalidInputException;
import com.seu.exception.VersionNotSelectedException;

public interface UiEindexAdapter {
	public void load();
	public void refresh();
	public void save()throws VersionNotSelectedException,InvalidInputException,EindexMissingParamException;
}
