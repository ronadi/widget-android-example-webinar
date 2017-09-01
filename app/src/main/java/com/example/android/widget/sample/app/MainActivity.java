package com.example.android.widget.sample.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtItemWidgetView = (TextView) findViewById(R.id.txt_view_widget_item);
        String itemChoice =  getIntent().getStringExtra("WIDGETVALUE");
        if(!TextUtils.isEmpty(itemChoice)){
            txtItemWidgetView.setText(itemChoice);
        }
    }
}
