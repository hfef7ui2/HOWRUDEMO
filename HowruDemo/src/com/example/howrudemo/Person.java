package com.example.howrudemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Person extends Activity{
	
	private TextView tv;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.person);
	tv=(TextView)findViewById(R.id.persontext);
	final Globaldata globaldata=(Globaldata) getApplication();

	tv.setText(globaldata.getLoginname());
}

public void personback(View view){
	Intent intent = new Intent(this, MainActivity.class);
	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	startActivity(intent);
}
public void editorsave(View view){
	//edit
}
public void logout(View view) {
	final Globaldata globaldata=(Globaldata) getApplication();
	globaldata.setLogin(false);
	globaldata.setLoginname(null);
	this.finish();
}
}
