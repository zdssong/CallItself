package com.callitself.receiver;

import com.callitself.constant.Constants;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

public class HangUpReceiver extends BroadcastReceiver {

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
				System.out.println("CALL_STATE_IDLE");
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				System.out.println("CALL_STATE_RINGING");
				break;
			}
		}
	}

}
