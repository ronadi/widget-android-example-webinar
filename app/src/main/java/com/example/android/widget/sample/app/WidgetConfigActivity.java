package com.example.android.widget.sample.app;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RemoteViews;

public class WidgetConfigActivity extends AppCompatActivity {

    private ListView lv;
    private String [] datas;

    private int mAppWidgetId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkIntent();

        setContentView(R.layout.activity_widget_config);
        lv = (ListView) findViewById(R.id.list_item);
        datas = getResources().getStringArray(R.array.the_list);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, datas));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String data = datas[i];
                sendWidget(data);
            }
        });
    }

    private void sendWidget(String data) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        RemoteViews views = new RemoteViews(getPackageName(), R.layout.collection_widget);
        Intent widgetIntent = new Intent(this, WidgetService.class);
        widgetIntent.putExtra("data", data);
        views.setRemoteAdapter(R.id.widget_list,widgetIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(mAppWidgetId, views);

        Intent resultValue = new Intent(this, WidgetService.class);
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
        setResult(RESULT_OK, resultValue);

        finish();
    }

    private void checkIntent() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }
    }



}
