package com.crm.validators;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.testng.Assert;

import com.crm.data.CrmLoginData;
import com.crm.data.CrmTestData;
import com.crm.data.LoginData;
import com.crm.services.*;

public class CrmValidations {
	
	CrmLoginData crdata = CrmTestData.getTestData();
	CrmLoginData logindata = null;
	List<LoginData> crmlogindata = crdata.getCrmlogindata();
	
	public CrmValidations validateLoginUsername(CrmService crservice) throws InterruptedException {
		String userName = crservice.getLoginUserName();
		//System.out.println(userName);
		String userNameFromData = crmlogindata.get(0).getUsername();
		//System.out.println(userNameFromData);
		Assert.assertTrue(userName.equalsIgnoreCase(userNameFromData));
		return this;
	}
	
	public CrmValidations validateAccountData(CrmService crservice) throws InterruptedException {
		String accountName = crservice.getAccountName();
		String accountNameFromDat = crmlogindata.get(0).getAccountName();
		Assert.assertEquals(accountName, accountNameFromDat);
		return this;
	}
	
	public CrmValidations validateBillingAddress(CrmService crservice) throws InterruptedException {
		List<String> blist = crservice.getBillingAddress();
		ArrayList<String> bdataList = new ArrayList<String>();
		bdataList.add(crmlogindata.get(0).getStreet());
		bdataList.add(crmlogindata.get(0).getCity());
		bdataList.add(crmlogindata.get(0).getState());
		bdataList.add(crmlogindata.get(0).getCountry());
		for(int i=0; i < bdataList.size(); i++) {
			Assert.assertEquals(blist.get(i), bdataList.get(i));
		}
		return this;
	}

}
