package com.example.howrudemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Feedback extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.feedback);
}

public void feedbackcancel(View view){
	this.finish();
}
public void feedbacksubmit(View view){
	//上传 try catch
	Toast toast= Toast.makeText(this,"submitted",Toast.LENGTH_LONG);
	this.finish();//ok?
	toast.show();
	
}
}
