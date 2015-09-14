package com.example.howrudemo;

import java.io.StringWriter;

import android.R.string;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Contacts.Intents.Insert;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Comer extends Activity{
	private EditText comername,comerpw,comerpw2;
	SQLiteDatabase db;
	Cursor cursor;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.comer);
	
}

public void registback(View view){
	this.finish();
}

public void registbt(View view){
	comername= (EditText) findViewById(R.id.comername);
	comerpw=(EditText) findViewById(R.id.comerpw);
	comerpw2=(EditText) findViewById(R.id.comerpw2);	
	String newname,pw,pw2;
	newname=comername.getText().toString();
	pw=comerpw.getText().toString();
	pw2=comerpw2.getText().toString();
	if (!pw.equals(pw2)) {
		Toast.makeText(this, "two passwords above should not be different.", Toast.LENGTH_LONG).show();
	}
	else {	
	db = openOrCreateDatabase("user.db", MODE_PRIVATE, null);
	cursor = db.rawQuery("SELECT name FROM userdb WHERE _id >= ?", new String[]{"0"});
	String[] columnsStrings=null;
	
	columnsStrings = cursor.getColumnNames();
	
	Boolean different=true;
	
	while(cursor.moveToNext()){
		for(String columnName:columnsStrings){
			String string = cursor.getString(cursor.getColumnIndex(columnName));
			Log.i("info",string);
			if(newname.equals(string)){
				Toast.makeText(this, "this name already exists.", Toast.LENGTH_LONG).show();
				different=false;
				break;
			}}}
			 if (different) {
				
			
				ContentValues user=new ContentValues();
				user.put("name", newname);
				user.put("password", pw);
				db.insert("userdb", null, user);
				final Globaldata globaldata=(Globaldata) getApplication();
				globaldata.setLogin(true);
				globaldata.setLoginname(newname);//global change
				Toast.makeText(this, "sign up successfully.", Toast.LENGTH_LONG).show();
				Intent intent = new Intent(this, MainActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);//返回主界面
			 }
			 cursor.close();
			 Toast.makeText(this, "cursor closes", 12000).show();
				db.close();}
				
}

}
