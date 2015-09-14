package com.example.howrudemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Introduction extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.introduction);
}

public void ok(View view){
	this.finish();
}
}
