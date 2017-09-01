package com.example.android.widget.sample.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;
import java.util.List;

public class WidgetDataProvider implements RemoteViewsService.RemoteViewsFactory {

    List<String> collection = new ArrayList<>();
    Context mContext;
    Intent intent;

    private void initData(){
        collection.clear();
        for (int i = 1; i <= 10; i++) {
            collection.add("listView Item "+ i);
        }
    }

    public WidgetDataProvider(Context mContext, Intent intent) {
        this.mContext = mContext;
        this.intent = intent;
    }

    @Override
    public void onCreate() {
        initData();
    }

    @Override
    public void onDataSetChanged() {
        initData();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return collection.size();
    }

    @Override
    public RemoteViews getViewAt(int i) {
        RemoteViews remoteview = new RemoteViews(mContext.getPackageName(),android.R.layout.simple_list_item_1);
        remoteview.setTextViewText(android.R.id.text1,collection.get(i));
        remoteview.setTextColor(android.R.id.text1, Color.BLACK);
        Intent fillInIntent = new Intent();
        fillInIntent.putExtra("WIDGETVALUE", collection.get(i));
        remoteview.setOnClickFillInIntent(android.R.id.text1, fillInIntent);
        return   remoteview;

    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
