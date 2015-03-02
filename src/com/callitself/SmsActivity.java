package com.callitself;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

import com.callitself.baseactivity.BaseActivity;

public class SmsActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_sms);
	}

	private void sendMessage() {
		PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this,
				SmsActivity.class), 0);
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage("", null, "hahahahhahaa", pi, null);
	}
}
