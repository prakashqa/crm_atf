package com.crm.tests;

import com.crm.data.CrmLoginData;
import com.crm.data.CrmTestData;
import com.crm.data.LoginData;
import com.crm.services.ContactService;
import com.crm.services.CrmService;
import com.crm.validators.CrmValidations;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminTest {
	
	CrmLoginData crdata = null;
	CrmService crmservice = null;
	ContactService conservice = null;
	List<LoginData> crmlogindata = null;
	CrmValidations crmvalidator = null;
	
	@BeforeClass
	public void init() {
		crmservice = new CrmService();
		conservice = new ContactService();
		crdata = CrmTestData.getTestData();
		crmlogindata = crdata.getCrmlogindata();
		crmvalidator = new CrmValidations();

		
	}
	
	@Test(description = "user creates account and validate the account", priority = 0)
	public void createAccount() throws Exception {
		crmservice.openCrmLoginPage().loginToCrm(crmlogindata.get(0).getUsername(), crmlogindata.get(0).getPword());
		crmvalidator.validateLoginUsername(crmservice);
		crmservice.clickOnAccountsLink().clickOnCreateAccount().insertNameforAccount(crmlogindata.get(0).getAccountName(), crmlogindata.get(0).getAccountEmail());
		crmservice.insertBillingAddress(crmlogindata.get(0).getStreet(), crmlogindata.get(0).getCity(), crmlogindata.get(0).getState(), crmlogindata.get(0).getCountry());
		//crmservice.saveAccount();
		//crmvalidator.validateAccountData(crmservice).validateBillingAddress(crmservice);
	}
	
	@Test 
	public void createContact() {
		conservice.navigateToCreatContact();
	}

}
