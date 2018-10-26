package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView fab = (ImageView) findViewById(R.id.rb_loans_filtrate);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), FunnelPopupWindowActivity.class);
                intent.putExtra("width",Integer.toString(view.getWidth()));
                intent.putExtra("bottom",Integer.toString(view.getBottom()));
                intent.putExtra("top",Integer.toString(view.getTop()));
                intent.putExtra("LPHeight",Integer.toString(view.getMeasuredHeight()));
                intent.putExtra("LPWidth",Integer.toString(view.getMeasuredWidth()));

                startActivity(intent);
            }
        });
    }
}
