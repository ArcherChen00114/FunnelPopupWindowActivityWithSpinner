package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2018/9/10.
 */

public class funnelView extends View {

    private int measuredHeight;
    private int measuredWidth;
    private DrawFilter mDrawFilter;
    private int radius;

    public funnelView(Context context) {
        super(context);
        measure(measuredWidth,measuredHeight);
    }

    public funnelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        measure(measuredWidth,measuredHeight);
    }

    public funnelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        measure(measuredWidth,measuredHeight);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.measuredHeight = getMeasuredHeight();
        this.measuredWidth = getMeasuredWidth();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onDraw(Canvas canvas){

        super.onDraw(canvas);
        canvas.setDrawFilter(mDrawFilter);
        Paint paint=new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        Path path = new Path();
        path.addRoundRect(new RectF(0,0,measuredWidth,measuredHeight-2*radius),30,30, Path.Direction.CW);//绘制圆角框
        Path arc=new Path();
        arc.arcTo(measuredWidth/2-2*radius,measuredHeight-2*radius,measuredWidth/2-radius,measuredHeight,270,90,false);//绘制连接的三个圆弧构成凹槽
        arc.arcTo(measuredWidth/2-radius,measuredHeight-2*radius,measuredWidth/2+radius,measuredHeight,0,180,false);
        arc.arcTo(measuredWidth/2+radius,measuredHeight-2*radius,measuredWidth/2+2*radius,measuredHeight,180,90,false);

        path.addPath(arc,0,0);
        canvas.drawPath(path,paint);

    }

    public void setRadius(int radius) {
        this.radius = radius+5;
    }

    public int getRadius() {
        return 10;
    }//give a padding value to make button stay in center
}
