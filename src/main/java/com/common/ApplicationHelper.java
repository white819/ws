package com.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationHelper implements ApplicationContextAware {

	private static ApplicationContext ctx;

	// Private constructor prevents instantiation from other classes
    private ApplicationHelper() {}

	public static ApplicationContext getApplicationContext() {
		return ctx;
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		// TODO Auto-generated method stub
		ApplicationHelper.ctx = ctx;
	}
	
	public static <T>T getBean(Class<T> clazz){
		return ctx.getBean(clazz);
	}

}

