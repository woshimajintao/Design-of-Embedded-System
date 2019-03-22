package com.Goowin.stringapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;

public class StringView extends View {
	private final int NUM = 20; // 要显示的字符串的个数
	
	private Point[] point; // 存储各字符串起始位置的数组
	private int cxView; // 宽度
	private int cyView; // 高度
	
	// 构造函数
	public StringView (Context context) {
		super(context);
		point = new Point[NUM]; // 分配创建NUM个数的Point类型数组point
		
		setBackgroundColor(Color.WHITE); // 设置视图背景颜色为白色
	}
	
	
	protected void onDraw (Canvas canvas) {
		Paint paint = new Paint(); // 创建指定绘制对象背景或与全景有关属性的Paint对象
		
		cxView = getWidth(); // 获取view的宽度
		cyView = getHeight(); // 获取view的高度
		
		paint.setAntiAlias(true); // 打开canvas的抗锯齿，处理更光滑效果的轮廓
		DisplayString(canvas, paint); // 显示字符串
		
		super.onDraw(canvas);
	}
	
	private void DisplayString (Canvas canvas, Paint paint) {
		String str = "15281080文静轩";
		
		calcPos(); // 计算各字符串的横纵起始坐标
		
		paint.setTextSize(20); // 设置字符串的字体大小
		for (int i = 0; i != point.length; ++i) {
			paint.setColor(Color.rgb(200 - (i * 10), 0, 50 + (i * 10))); // 设置字符串的颜色
			
			canvas.drawText (str, point[i].x, point[i].y, paint); // 绘制字符串
		}
	}
	
	private void calcPos () {
		for (int i = 0; i != NUM; ++i) {
			point[i] = new Point(); // 初始化
			point[i].x = i * cxView /(NUM * 2); // x在0~cxView/2的范围内变化，使用(i * cxView /(NUM * 2))使其从0到cxView/2均匀增长
			point[i].y = (int) (cyView / 2 - Math.sqrt((int)(point[i].x * cxView - point[i].x * point[i].x)));; // 圆的方程为(x - cxView / 2) * (x - cxView / 2) + (y - cyView / 2) * (y - cyView / 2) = cxView * cxView / 4，因此y = cyView / 2 - Math.sqrt((int)(point[i].x * cxView - point[i].x * point[i].x))
		}
	}
}
