package com.callitself;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Button call;
	private Button hangUp;
	private EditText phoneNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		InitWidget();

		call.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!phoneNumber.getText().toString().equals("")) {
					Intent intent = new Intent(Intent.ACTION_CALL, Uri
							.parse("tel:" + phoneNumber.getText()));
					startActivity(intent);
				}
			}
		});
	}

	private void InitWidget() {
		call = (Button) findViewById(R.id.call);
		phoneNumber = (EditText) findViewById(R.id.number);
	}
}
