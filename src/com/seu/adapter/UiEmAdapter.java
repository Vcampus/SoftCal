package com.seu.adapter;

import com.seu.exception.EmMissingParamException;
import com.seu.exception.InvalidInputException;
import com.seu.exception.VersionNotSelectedException;

public interface UiEmAdapter {
	public void load();
	public void refresh();
	public void save()throws EmMissingParamException,VersionNotSelectedException,InvalidInputException;
}
