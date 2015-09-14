package com.example.howrudemo;

import java.util.List;
import java.util.zip.Inflater;

import android.content.Context;
import android.support.v7.internal.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Myadapter extends BaseAdapter{
	
	private List<Activityitembean> mList;
private LayoutInflater mInflater;
	
	public Myadapter(Context context,List<Activityitembean> list) {
		// TODO Auto-generated constructor stub
		mList= list;
		mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
if(convertView==null){
	viewHolder = new ViewHolder();
	convertView= mInflater.inflate(R.layout.activityitem, null);
	viewHolder.imageView= (ImageView) convertView.findViewById(R.drawable.ic_launcher);//wtf?!
	viewHolder.title= (TextView) convertView.findViewById(R.id.tv_title);
	viewHolder.content= (TextView) convertView.findViewById(R.id.tv_content);
	convertView.setTag(viewHolder);
}
else {
	viewHolder=(ViewHolder) convertView.getTag();
}
		Activityitembean bean = mList.get(position);
		viewHolder.imageView.setImageResource(bean.Itemimageresid);
		viewHolder.content.setText(bean.Itemcontent);
		viewHolder.title.setText(bean.Itemtitle);
		return null;
	}
	class ViewHolder{
		public ImageView imageView;
		public TextView title;
		public TextView content;
	}
}
