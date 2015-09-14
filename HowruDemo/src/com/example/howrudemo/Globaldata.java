package com.example.howrudemo;

import android.app.Application;

public class Globaldata extends Application{
private Boolean login=false;
private String loginname=null;
private String acttype=null;

public void setActtype(String acttype) {
	this.acttype = acttype;
}
public String getActtype() {
	return acttype;
}

//public String eat(){
//	acttype="eat";
//	return acttype;
//}
//
//public String study(){
//	acttype="study";
//	return acttype;
//}
//
//public String travel(){
//	acttype="travel";
//	return acttype;
//}
//
//public String sports(){
//	acttype="sports";
//	return acttype;
//}

public void setLoginname(String loginname) {
	this.loginname = loginname;
}

public String getLoginname() {
	return loginname;
}

public Boolean getLogin() {
	return login;
}

public void setLogin(Boolean login) {
	this.login = login;
}

@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
}