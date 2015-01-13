package com.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

public class WtNumberPicker extends LinearLayout {

	private Context context;

	public interface OnValueChangeListener {
		void onValueChange(NumberPicker picker, int oldVal, int newVal);
	}

	/**
	 * 用来监听用户滑动的接口
	 * */
	public interface onScrollListener {
		/**
		 * 表示没有滑动
		 * */
		public static int SCROLL_STATE_IDLE = 0;
		/**
		 * 表示用户在滑动，单手指依然在尚明
		 * */
		public static int SCROLL_STATE_TOUCH_SCROLL = 1;
		public static int SCROLL_STATE_FLING = 2;

		public void onScrollStateChange(NumberPicker view, int scrollState);
	}

	/**
	 * 该接口是吧当前值转化为字符串用来显示
	 * */
	public interface Formatter {
		public String format(int value);
	}

	public WtNumberPicker(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public WtNumberPicker(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public WtNumberPicker(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context = context;

		// 处理类型属性
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		super.onLayout(changed, l, t, r, b);
		TextView textView = new TextView(context);
		textView.setText("one");
		textView.layout(l, t, r, b);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

}
