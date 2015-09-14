package com.example.howrudemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends Activity{
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.login);
}
public void loginback(View view){
	Intent intent = new Intent(Login.this, Left.class);
	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	startActivity(intent);
}
public void loginbt(View view){
	Intent intent = new Intent(Login.this, Login2.class);
	startActivity(intent);
}
public void comer(View view){
	Intent intent = new Intent(Login.this, Comer.class);
	startActivity(intent);
}
}
