package com.Goowin.stringapp;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		StringView sv = new StringView(this); // 创建自定义视图StringView
		setContentView(sv); // 调用传入sv参数的setContentView()方法，通过显示程序界面的视图设置StringView
	}
}
