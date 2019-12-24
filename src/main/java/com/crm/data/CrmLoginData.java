package com.crm.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CrmLoginData")
@XmlAccessorType(XmlAccessType.FIELD)
public class CrmLoginData {
	
	@XmlElement(name = "logindata")
	private List<LoginData> crmlogindata = null;

	public List<LoginData> getCrmlogindata() {
		return crmlogindata;
	}

	public void setCrmlogindata(List<LoginData> crmlogindata) {
		this.crmlogindata = crmlogindata;
	}

}
