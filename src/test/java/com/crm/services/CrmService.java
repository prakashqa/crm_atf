package com.crm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;

import com.crm.config.BaseConfiguration;
import com.crm.objrep.CrmObjects;
import com.crm.utils.*;

public class CrmService extends BaseConfiguration {
	
	//private static Logger log = Logger.getLogger(CrmService.class.getName());
	private static Logger log = Logger.getLogger(CrmService.class.getName());
	public CrmObjects crmobj = new CrmObjects();
	
	public CrmService openCrmLoginPage() {
		invokeBrowser();
		return this;
	}
	
	public CrmService loginToCrm(String uname, String pw) {
		CommonUtil.insertText("id", crmobj.getObject().getProperty("login_user_name_id"), uname, wd);
		CommonUtil.insertText("id", crmobj.getObject().getProperty("login_user_pword_id"), pw, wd);
		CommonUtil.waitForElement("id", crmobj.getObject().getProperty("login_button_id"), wd);
		CommonUtil.clickButton("id", crmobj.getObject().getProperty("login_button_id"), wd);
		log.info("login successful");
		return this;
	}
	
	public CrmService clickOnAccountsLink() {
		CommonUtil.clickButton("css", crmobj.getObject().getProperty("accounts_link_css"), wd);
		return this;
	}
	
	public CrmService clickOnCreateAccount() throws Exception {
		CommonUtil.clickButton("css", crmobj.getObject().getProperty("create_account_css"), wd);
		return this;
	}
	
	public CrmService insertNameforAccount(String name, String email) {
		CommonUtil.insertText("css", crmobj.getObject().getProperty("create_account_name"), name, wd);
		CommonUtil.insertText("css", crmobj.getObject().getProperty("create_account_email"), email, wd);
		return this;
	}
	
	public CrmService insertBillingAddress(String street, String city, String state, String country) {
		CommonUtil.insertText("css", crmobj.getObject().getProperty("create_account_street"), street, wd);
		CommonUtil.insertText("css", crmobj.getObject().getProperty("create_account_city"), city, wd);
		CommonUtil.insertText("css", crmobj.getObject().getProperty("create-account_state"), state, wd);
		CommonUtil.insertText("css", crmobj.getObject().getProperty("create_account_country"), country, wd);
		return this;
	}
	
	public CrmService saveAccount() throws InterruptedException {
		CommonUtil.clickButton("css", crmobj.getObject().getProperty("save_new_account"), wd);
		CommonUtil.wait(3);
		return this;
	}
	
	public String getLoginUserName() throws InterruptedException {
		CommonUtil.wait(3);
		CommonUtil.clickButton("xpath", crmobj.getObject().getProperty("home_logout_menu_xpath"), wd);
		CommonUtil.wait(3);
		/** gets the usesrname data after login to the application */
		String getUsername = CommonUtil.getText("xpath", crmobj.getObject().getProperty("home_getuser_xpath"), wd);
		return getUsername;
	}
	
	public String getAccountName() throws InterruptedException {
		CommonUtil.wait(3);
		String accountName = CommonUtil.getText("css", crmobj.getObject().getProperty("get_save_accountname"), wd);
		return accountName;
	}
	
	public List<String> getBillingAddress() throws InterruptedException {
		CommonUtil.wait(2);;
		String sr = null;
		String billingAddress = CommonUtil.getText("css", crmobj.getObject().getProperty("get_billing_address"), wd);
		//System.out.println(billingAddress);
		List<String> list = new ArrayList<String>();
		String billAddress[] = billingAddress.split(" ");
		//System.out.println(billAddress.length);
		for(int i = 0; i<billAddress.length; i ++) {
			Scanner scanner = new Scanner(billAddress[i]);
			while(scanner.hasNextLine()) {
			  String line = scanner.nextLine();
			  if(line.contains(",")) { 
				  sr = org.apache.commons.lang3.StringUtils.substring(line, 0, line.length() - 1);
			  	  list.add(sr);
			  } else {
				  list.add(line);
			  }
			}
		}
		return list;
	}
	
	public CrmService clickOnCreateContactLink() {
		CommonUtil.clickButton("css", crmobj.getObject().getProperty("create_contact"), wd);
		return this;
	}

}
