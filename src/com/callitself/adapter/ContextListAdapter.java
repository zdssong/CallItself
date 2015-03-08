package com.callitself.adapter;

import java.util.List;
import com.callitself.R;
import com.callitself.model.Messages;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ContextListAdapter extends BaseAdapter {
	private List<Messages> messages = null;
	private LayoutInflater inflater = null;

	public ContextListAdapter(List<Messages> messages, Context context) {
		// TODO Auto-generated constructor stub
		this.messages = messages;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return messages == null ? 0 : messages.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return messages == null ? null : messages.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (view == null) {
			view = inflater.inflate(R.layout.message_item, null);
		}
		TextView time = (TextView) view.findViewById(R.id.time);
		TextView message = (TextView) view.findViewById(R.id.message);
		time.setText(messages.get(position).getTime());
		message.setText(messages.get(position).getMessage());
		return view;
	}
}
