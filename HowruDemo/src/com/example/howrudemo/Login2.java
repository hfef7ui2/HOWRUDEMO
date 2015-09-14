package com.example.howrudemo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login2 extends Activity{
	private EditText name,password;
	private CheckBox cb;
	SQLiteDatabase db;
	Cursor cursor;
	Cursor cursorpw;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
setContentView(R.layout.login2);

cb=(CheckBox) findViewById(R.id.savename);

}

public void loginback2(View view){
	this.finish();
}
public void loginconfirm(View view){
	final Globaldata globaldata=(Globaldata) getApplication();
	//比较并登录
	
	name= (EditText) findViewById(R.id.loginname);
	password= (EditText) findViewById(R.id.loginpassword);
	db=openOrCreateDatabase("user.db",MODE_PRIVATE, null);
	String nameString=name.getText().toString();
	String pw=password.getText().toString();
	//cursor = db.query("userdb", new String[]{"name"}, "_id>0", new String[]{"0"}, null, null, "name");
	//cursor = db.rawQuery("SELECT name FROM userdb", null);
	cursor = db.rawQuery("SELECT name FROM userdb WHERE _id >= ?", new String[]{"0"});

	//Toast.makeText(this, "111111", Toast.LENGTH_LONG).show();
	
	//no problem above

	
		String[] columnsStrings = cursor.getColumnNames();
		//Toast.makeText(this, columnsStrings[0], Toast.LENGTH_LONG).show();
		while(cursor.moveToNext()){
			
				String string = cursor.getString(cursor.getColumnIndex(columnsStrings[0]));
				
				//Log.i("info",string);
				//Toast.makeText(this, "22222222", Toast.LENGTH_LONG).show();

				if(nameString.equals(string)){
					String[] aStrings=new String[]{"password"};
				//	Toast.makeText(this, "111111333333333333333", Toast.LENGTH_LONG).show();

					//cursor=db.query("userdb", aStrings, "name==?", new String[]{string}, null, null, null);//ok????????????
					cursorpw =db.rawQuery("SELECT password FROM userdb WHERE name = ?", new String[]{nameString});
					//Toast.makeText(this, "11111144444444444444444444", Toast.LENGTH_LONG).show();
					
while(cursorpw.moveToNext())
					string=cursorpw.getString(cursorpw.getColumnIndex(aStrings[0]));//move to next!!!!!!!!!!!!!!!!!
					
					if (pw.equals(string)) {
						//载入用户记录
				//		Toast.makeText(this, "111111pqpqweqqewqqwqewq", Toast.LENGTH_LONG).show();

						globaldata.setLogin(true);
						globaldata.setLoginname(nameString);//global change
						
						Intent intent = new Intent(this, MainActivity.class);
						intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intent);//返回主界面
						cursorpw.close();
						Toast.makeText(this, "login successfully", Toast.LENGTH_LONG).show();
						//break;
					}
					else {
						Toast.makeText(this, "wrong password", Toast.LENGTH_LONG).show();
						cursorpw.close();				

					}

					}
					
}cursor.close();
		
		db.close();
}
}