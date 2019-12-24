package com.crm.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.crm.config.BaseConfiguration;
import com.crm.objrep.CrmObjects;
import com.crm.utils.CommonUtil;

public class ContactService extends BaseConfiguration {
	private static Logger log = Logger.getLogger(ContactService.class.getName());
	public CrmObjects crmobj = new CrmObjects();
	public static WebDriver wd = null;
	
	public ContactService navigateToCreatContact() {
		CommonUtil.clickButton("css", crmobj.getObject().getProperty("contact_linnk"), wd);
		CommonUtil.clickButton("css", crmobj.getObject().getProperty("create_contact_link"), wd);
		return this;
		
	}

}
