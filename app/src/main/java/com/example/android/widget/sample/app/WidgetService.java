package com.example.android.widget.sample.app;

import android.content.Intent;
import android.widget.RemoteViewsService;

public class WidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        //return remoteViewfactory
        return new WidgetDataProvider(this, intent);
    }
}
