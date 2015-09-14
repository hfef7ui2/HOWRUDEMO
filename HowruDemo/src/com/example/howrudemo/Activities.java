package com.example.howrudemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Activities extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activities);
}
public void actback(View view){
	this.finish();
}


}
