package com.example.howrudemo;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Left extends Activity{
	
	//private Button back,person,activities, feedback,indroduction;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.left);
}
public void person(View view){
	final Globaldata globaldata=(Globaldata) getApplication();
if (globaldata.getLogin()) {
	Intent intent = new Intent(Left.this,Person.class);
	startActivity(intent);
}
else {
	Intent intent = new Intent(Left.this,Login.class);
	startActivity(intent);
}
	
}

public void activities(View view){
	Intent intent = new Intent(Left.this,Activities.class);
	startActivity(intent);
}

public void feedback(View view){
	Intent intent = new Intent(Left.this,Feedback.class);
	startActivity(intent);
}

public void introduction(View view){
	Intent intent = new Intent(this,Introduction.class);
	startActivity(intent);
}

public void leftback(View view){
	this.finish();
}
}
