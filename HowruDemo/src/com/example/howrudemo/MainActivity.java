package com.example.howrudemo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.R.integer;
import android.R.string;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.SyncStateContract.Columns;
import android.provider.SyncStateContract.Helpers;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {



	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<Activityitembean> itembeanlist = new ArrayList<Activityitembean>();
		for(int i=0; i<30;i++)
		{
			itembeanlist.add(new Activityitembean(R.drawable.ic_launcher, "titleeee"+i, "content"+i));
			
		}
		ListView listView;
		listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(new Myadapter(this, itembeanlist));
		//problem exists.
		
		
		SQLiteDatabase db = openOrCreateDatabase("user.db", MODE_PRIVATE, null);
		db.execSQL("create table if not exists userdb (_id integer primary key autoincrement, name VARCHAR, password VARCHAR)");
		
		db.execSQL("create table if not exists record (_recordid integer primary key autoincrement, name VARCHAR, actname text, acttype text, date date, quota text, message text)");
		
		
//		SQLiteDatabase db = openOrCreateDatabase("user.db", MODE_PRIVATE, null);
//		db.execSQL("create table if not exists userdb (_id integer primary key autoincrement, name text not null, age integer not null, sex text not null)");
//		db.execSQL("insert into userdb(name,sex,age) values('aaa','fe','229')");
//		Cursor c = db.rawQuery("select * from userdb", null);
//		if(c!=null)
//		{
//			while(c.moveToNext()){
//				Log.i("info","_id:"+c.getInt(c.getColumnIndex("_id")));
//				Log.i("info","age:"+c.getInt(c.getColumnIndex("age")));
//				Log.i("info","name:"+c.getString(c.getColumnIndex("name")));
//				Log.i("info","sex:"+c.getString(c.getColumnIndex("sex")));
//				
//			}
//			c.close();
//		}
//		db.close();
//		
//		SQLiteDatabase db = openOrCreateDatabase("user.db", MODE_PRIVATE, null);
//		db.execSQL("create table if not exists userdb (_id integer primary key autoincrement, name text not null, age integer not null, sex text not null)");
//		ContentValues values = new ContentValues();
//		values.put("name", "aaaa");
//		values.put("name", "aaaab");
//		db.insert("userdb", null, values);
//		db.update("userdb", values, "_id>?", new String[]{"3"});
//		db.delete("userdb", "name like ?", new String[]{"%b%"});
//Cursor c=db.query("userdb", null, "_id>0", new String[]{"0"}, null, null, "name");
//if(c!=null){
//	String[] columnsStrings = c.getColumnNames();
//	while(c.moveToNext()){
//		for(String columnName:columnsStrings){
//			Log.i("info",c.getString(c.getColumnIndex(columnName)));
//		}
//		c.close();
//	}
//	db.close();
//}
//
//DBopenhelper dBopenhelper =new DBopenhelper(MainActivity.this,"user2.db", null, 1);
//SQLiteDatabase db2= dBopenhelper.getWritableDatabase();
//Cursor cursor=db.rawQuery("select * from userdb", null);
//if(cursor!=null){
//	String[] colsStrings=cursor.getColumnNames();
//	while(cursor.moveToNext()){
//		for(String cString : colsStrings){
//			Log.i("info",  cString +":"+cursor.getColumnIndex(cString));
//		}
//	}
//	cursor.close();
//}
//db2.close();

//File file= new File("/mnt/sdcard/howrutest");
//if(!file.exists()){
//	try {
//		file.createNewFile();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}}
//	else {
//		Toast.makeText(MainActivity.this, "file already exists", Toast.LENGTH_LONG).show();
//	}


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void leftbtclick(View view){
		Intent intent= new Intent(MainActivity.this, Left.class);
		startActivity(intent);
	}
	public void rightbtclick(View view){
		Intent intent= new Intent(MainActivity.this,Right.class);
		startActivity(intent);
	}
}
