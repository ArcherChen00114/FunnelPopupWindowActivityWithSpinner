package com.example.administrator.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/10/15.
 */

public class FunnelPopupWindowActivity extends AppCompatActivity{
    Context mContext;
    View ParentView;
    TextView anchor;
    Intent intent;
    String radius;
    String LPWidth;
    String LPHeight;
    String bottom;
    String top;
    ArrayList<String> data = new ArrayList<String>();
    @BindView(R.id.dropView)
    funnelView dropView;
    @BindView(R.id.limit_area)
    TextView limitArea;
    @BindView(R.id.lowest_limit)
    NiceSpinner lowestLimit;
    @BindView(R.id.ALine)
    TextView ALine;
    @BindView(R.id.highest_limit)
    NiceSpinner highestLimit;
    @BindView(R.id.firstLine)
    LinearLayout firstLine;
    @BindView(R.id.limit_deadline)
    LinearLayout limitDeadline;
    @BindView(R.id.loan_deadline)
    NiceSpinner loanDeadline;
    @BindView(R.id.drop_button)
    ImageView dropButton;
    @BindView(R.id.finish_area)
    RelativeLayout finishArea;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.funnel_view);
        ButterKnife.bind(this);
        mContext = this;
        intent = getIntent();
        Bundle bundle = intent.getExtras();
        radius = bundle.getString("width");//获取被点击按钮宽度
        LPWidth = bundle.getString("LPWidth");
        LPHeight = bundle.getString("LPHeight");
        bottom = bundle.getString("bottom");
        top = bundle.getString("top");
        List<String> dataset2 = new LinkedList<>(Arrays.asList("10", "11", "12", "13", "14", "15", "16", "17", "18", "19"));
        loanDeadline.attachDataSource(dataset2);
        highestLimit.attachDataSource(dataset2);
        lowestLimit.attachDataSource(dataset2);
        for (int i = 0; i < 7; i++) {
            data.add(i + "");
        }
        anchor = (TextView) findViewById(R.id.anchor);
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                showFirstPopUp();
            }
        });
    }

    private void showFirstPopUp() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);//测量控件的大小1
        ViewGroup.LayoutParams viewLP = (ViewGroup.LayoutParams) dropButton.getLayoutParams();
        int width = Integer.parseInt(radius);
        viewLP.height = Integer.parseInt(LPHeight);
        viewLP.width = Integer.parseInt(LPWidth);
        dropButton.setPadding(0,0,0,dropView.getRadius());
        dropButton.setLayoutParams(viewLP);//获取原按钮的长宽赋予新界面中的按钮
        //让显示的window上的按钮与按钮位置一致
        dropView.setRadius(width / 2);//使window获得原按钮的半径，做出相适应的凹洞
        dropButton.setOnClickListener(new View.OnClickListener() {
            //设置按钮点击关闭窗体
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


}
