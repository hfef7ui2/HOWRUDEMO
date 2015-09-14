package com.example.howrudemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class Right extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.right);
}

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public void newact(View view){
	final Globaldata globaldata=(Globaldata) getApplication();

	switch (view.getId()) {
	case R.id.eat:
	{
		globaldata.setActtype("eat");
		Intent intent = new Intent(Right.this,Newact.class);
	startActivity(intent);
	}
		break;
		
	case R.id.travel:
	{
		globaldata.setActtype("travel");
		Intent intent = new Intent(Right.this,Newact.class);
	startActivity(intent);
	}
		break;
		
	case R.id.sports:
	{
		globaldata.setActtype("sports");
		Intent intent = new Intent(Right.this,Newact.class);
	startActivity(intent);
	}
		break;
		
	case R.id.study:
	{
		globaldata.setActtype("study");
		Intent intent = new Intent(Right.this,Newact.class);
	startActivity(intent);
	}
		break;
		
	default:
		break;
	}
	
}
public void rightback(View view){
	this.finish();
}



}