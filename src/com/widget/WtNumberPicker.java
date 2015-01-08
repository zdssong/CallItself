package com.widget;

import com.callitself.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

public class WtNumberPicker extends LinearLayout {

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
	}

	public WtNumberPicker(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public WtNumberPicker(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		
		//处理类型属性
		TypedArray attributesArray = context.obtainStyledAttributes(attrs,R.styleable., defStyleAttr, defStyleRes)
	}
}
