package com.crm.data;

public class CrmJsonData {
	
	private String uname;
	private String pw;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	@Override
	public String toString(){
		return getUname() + ", "+getPw();
	}

}
