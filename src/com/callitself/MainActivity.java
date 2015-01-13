package com.callitself;

import com.widget.WtNumberPicker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

public class MainActivity extends Activity implements OnValueChangeListener {

	private Button call;
	private Button hangUp;
	private EditText phoneNumber;
	private WtNumberPicker timePicker;
	private WtNumberPicker numberPicker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initWidget();
		initListener();

//		timePicker.setMaxValue(60);
//		timePicker.setMinValue(0);
//
//		numberPicker.setMaxValue(10);
//		numberPicker.setMinValue(0);

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

	private void initWidget() {
		call = (Button) findViewById(R.id.call);
		phoneNumber = (EditText) findViewById(R.id.number);
		timePicker = (WtNumberPicker) findViewById(R.id.timePicker);
		numberPicker = (WtNumberPicker) findViewById(R.id.numberpicker);
	}

	private void initListener() {
//		timePicker.setOnValueChangedListener(this);
//		numberPicker.setOnValueChangedListener(this);
	}

	@Override
	public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
		// TODO Auto-generated method stub
//		if (picker == timePicker)
//			System.out.println("timePicker");
//		else if (picker == numberPicker)
//			System.out.println("numberPicker");
//		else
//			System.out.println("nothing");

	}
}
