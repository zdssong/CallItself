package com.callitself;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;

import com.callitself.baseactivity.BaseActivity;
import com.callitself.constant.Constants;

public class PhoneActivity extends BaseActivity implements OnClickListener,
		OnValueChangeListener {

	// define the widgets
	private TextView call = null;
	private EditText phoneNumber = null;
	private NumberPicker timePicker = null;
	private NumberPicker numberPicker = null;

	// define the values
	private int dialNumber = 0;
	private int dialNumberNow = 0;
	private int interval = 0;

	//
	private HangUpReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_phone);
		initWidget();
		initListener();
		numberPicker.setMaxValue(20);
		timePicker.setMaxValue(300);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		register();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		unRegister();
		super.onDestroy();
	}

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			if (msg.what == Constants.HANGUP_MESSAGE) {
				if (dialNumberNow < dialNumber) {
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							dial();// call function
						}
					}, interval * 1000);
					dialNumberNow++;
				}
			}
			super.handleMessage(msg);
		}

	};

	// register the phone state Receiver
	private void register() {
		// Filter
		receiver = new HangUpReceiver();
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_NEW_OUTGOING_CALL);
		filter.addAction(Constants.PHONE_ACTION);
		registerReceiver(receiver, filter);
	}

	// unregister the phone state Receiver
	private void unRegister() {
		unregisterReceiver(receiver);
	}

	// initialize the widget
	private void initWidget() {
		call = (TextView) findViewById(R.id.call);
		phoneNumber = (EditText) findViewById(R.id.number);
		timePicker = (NumberPicker) findViewById(R.id.timePicker);
		numberPicker = (NumberPicker) findViewById(R.id.numberpicker);
	}

	// add listener to the widget
	private void initListener() {
		call.setOnClickListener(this);
		timePicker.setOnValueChangedListener(this);
		numberPicker.setOnValueChangedListener(this);
	}

	// dial the phone
	private void dial() {
		if (!phoneNumber.getText().toString().equals("")) {
			Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
					+ phoneNumber.getText()));
			startActivity(intent);
		}
	}

	@Override
	public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
		// TODO Auto-generated method stub
		if (picker == timePicker) {

		} else if (picker == numberPicker)
			System.out.println("numberPicker");
		else
			System.out.println("nothing");

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.call:
			dialNumber = numberPicker.getValue();
			interval = timePicker.getValue();
			dial();
			break;
		}
	}

	private class HangUpReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			if (intent.getAction().equals(Constants.PHONE_ACTION)) {
				TelephonyManager manager = (TelephonyManager) context
						.getSystemService(Service.TELEPHONY_SERVICE);
				switch (manager.getCallState()) {
				case TelephonyManager.CALL_STATE_OFFHOOK:
					System.out.println("TelephonyManager.CALL_STATE_OFFHOOK");
					break;
				case TelephonyManager.CALL_STATE_IDLE:
					handler.sendEmptyMessage(Constants.HANGUP_MESSAGE);
					break;
				case TelephonyManager.CALL_STATE_RINGING:
					System.out.println("CALL_STATE_RINGING");
					break;
				case TelephonyManager.DATA_ACTIVITY_INOUT:
					System.out.println("DATA_ACTIVITY_INOUT");
					break;
				}
			}
		}

	}
}
