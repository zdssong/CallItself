package com.callitself;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.callitself.adapter.ContextListAdapter;
import com.callitself.baseactivity.BaseActivity;
import com.callitself.model.Messages;
import com.callitself.tools.Tools;

public class SmsActivity extends BaseActivity implements OnClickListener {

	private TextView send = null;
	private TextView addContact = null;
	private EditText contact = null;
	private EditText context = null;

	private ListView contextList = null;
	private ContextListAdapter adapter = null;
	private List<Messages> messages = null;

	private String phoneNumber;
	private String message;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_sms);

		initView();
		initListener();
		initListView();
		System.out.println(getCurrentTime());
	}

	private void initView() {
		send = (TextView) findViewById(R.id.send);
		addContact = (TextView) findViewById(R.id.addContact);
		contact = (EditText) findViewById(R.id.contacts);
		context = (EditText) findViewById(R.id.context);
		contextList = (ListView) findViewById(R.id.listView);
	}

	private void initListener() {
		send.setOnClickListener(this);
		addContact.setOnClickListener(this);
	}

	private void initListView() {
		messages = new ArrayList<Messages>();
		adapter = new ContextListAdapter(messages, this);
		contextList.setAdapter(adapter);
	}

	private String getCurrentTime() {
		SimpleDateFormat format = new SimpleDateFormat("MM月dd日  HH:mm:ss");
		Date curData = new Date(System.currentTimeMillis());
		return format.format(curData).toString();
	}

	private void sendMessage(String phoneNumber, String content) {
		PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this,
				SmsActivity.class), 0);
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(phoneNumber, null, content, pi, null);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.send:
			phoneNumber = contact.getText().toString();
			message = context.getText().toString();
			if (phoneNumber == null || phoneNumber.equals("")) {
				Toast.makeText(this, "发送人为空", Toast.LENGTH_SHORT).show();
				break;
			}
			if (!Tools.isMobileNO(phoneNumber)) {
				Toast.makeText(this, "该号码不正确", Toast.LENGTH_SHORT).show();
				break;
			}
			if (message == null || message.equals("")) {
				Toast.makeText(this, "发送内容为空", Toast.LENGTH_SHORT).show();

				break;
			}
			sendMessage(phoneNumber, message);
			Messages temp = new Messages();
			temp.setMessage(message);
			temp.setTime(getCurrentTime());
			messages.add(temp);
			adapter.notifyDataSetChanged();
			contact.setText("");
			context.setText("");
			break;
		case R.id.addContact:

			break;

		default:
			break;
		}
	}

	private class SmsReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub

		}

	}
}
