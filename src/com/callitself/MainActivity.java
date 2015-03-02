package com.callitself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener {

	private LinearLayout phoneLayout = null;
	private LinearLayout smsLayout = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initWidget();
		initListener();
	}

	private void initWidget() {
		phoneLayout = (LinearLayout) findViewById(R.id.phoneLayout);
		smsLayout = (LinearLayout) findViewById(R.id.smsLayout);
	}

	private void initListener() {
		phoneLayout.setOnClickListener(this);
		smsLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.phoneLayout:
			intent.setClass(MainActivity.this, PhoneActivity.class);
			startActivity(intent);
			break;
		case R.id.smsLayout:
			intent.setClass(MainActivity.this, SmsActivity.class);
			startActivity(intent);
			break;
		}
	}
}
