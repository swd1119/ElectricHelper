package com.e_helper.app.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.eWorld.e_helper.R;
import com.e_helper.app.model.Business;
import com.e_helper.app.model.CommonSense;

import android.content.Context;
import android.provider.ContactsContract.CommonDataKinds.Nickname;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AppCommonSenceAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private ArrayList<CommonSense> mCommonSenses;
	
	public AppCommonSenceAdapter(Context context,ArrayList<CommonSense> commonSenses) {
		// TODO Auto-generated constructor stub
		super();
		this.mInflater = LayoutInflater.from(context);
		this.mCommonSenses = commonSenses;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mCommonSenses.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mCommonSenses.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		if (arg1 == null) {
			arg1 = mInflater.inflate(R.layout.app_common_sence_list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.titleTextView = (TextView) arg1.findViewById(R.id.app_common_sence_list_item_title);
			viewHolder.timeTextView = (TextView) arg1.findViewById(R.id.app_common_sence_list_item_time);
			arg1.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) arg1.getTag();
		}
		
		CommonSense tempCommonSense = mCommonSenses.get(arg0);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		viewHolder.timeTextView.setText(format.format(tempCommonSense.getCreatedAt()));
		viewHolder.titleTextView.setText(tempCommonSense.getCommonSenseTitle());
		
		return arg1;
	}
	
	public class ViewHolder {
		TextView titleTextView;
		TextView timeTextView;
	}

}
