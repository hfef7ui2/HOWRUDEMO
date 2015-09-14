package com.example.howrudemo;

import java.security.PublicKey;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

//public interface defaultobserver(){
//	public Void onchangedtextview();
//}

public class Newact extends Activity implements OnSeekBarChangeListener{
	
private TextView type,date,message,showquota,actname;
private SeekBar quota;
private String loginname;
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.newact);
	type=(TextView) findViewById(R.id.acttype);
	date=(TextView) findViewById(R.id.date);
	actname=(TextView) findViewById(R.id.actname);
	message=(TextView) findViewById(R.id.message);
	showquota= (TextView) findViewById(R.id.showquota);
	quota = (SeekBar) findViewById(R.id.seekBar1);
quota.setOnSeekBarChangeListener(this);
final Globaldata globaldata=(Globaldata) getApplication();
type.setText(globaldata.getActtype());
loginname=globaldata.getLoginname();
}

public void newactback(View view){
	
	Toast toast= Toast.makeText(this, "back", Toast.LENGTH_LONG);
	toast.show();
	this.finish();
	this.onDestroy();
}

public void composedone(View view){
	SQLiteDatabase db = openOrCreateDatabase("user.db", MODE_PRIVATE, null);
	String actdate=date.getText().toString();
	String descrip=message.getText().toString();
	ContentValues values=new ContentValues();
	values.put("acttype",actdate);
	values.put("message", descrip);
	values.put("date",date.getText().toString());
	values.put("quota", showquota.getText().toString());
	values.put("actname", actname.getText().toString());
	values.put("name", loginname);
	db.insert("record", null, values);
	Intent intent = new Intent(this, MainActivity.class);
	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	startActivity(intent);
	Toast toast= Toast.makeText(this, "save and back to main", Toast.LENGTH_LONG);
	toast.show();
}

@Override
public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
	// TODO Auto-generated method stub
	showquota.setText(String.valueOf(progress+2));
}

@Override
public void onStartTrackingTouch(SeekBar seekBar) {
	// TODO Auto-generated method stub
	
}

@Override
public void onStopTrackingTouch(SeekBar seekBar) {
	// TODO Auto-generated method stub
	
}
}
