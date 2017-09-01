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
    // TODO 1. Create Project
    // TODO 2. Add Widget => Menu => File => New => Widget => App Widget
    // TODO 3. set updatePeriodMillis = 0 in res/xml/collection_widget_info.xml
    // TODO 4. Create file WidgetService extends RemoteViewService
    // TODO 5. Create file WidgetDataProvider implements RemoteViewsFactory
    // TODO 6. add static data List String collection, Context, Intent in WidgetDataProvider
    // TODO 7. add constructor with params Context and intent in WidgetDataProvider
    // TODO 8. add new WidgetProvider in WidgetService onGetViewFactory
    // TODO 9. create method initData in WidgetDataProvider to populate static data collection
    // TODO 10. add method initData in onCreate and onDataChanged WidgetDataProvider
    // TODO 11. change return of getCount with collection size  in WidgetDataProvider
    // TODO 12. change return of getViewTypeCount with 1  in WidgetDataProvider
    // TODO 13. change return of getItemId with position in WidgetDataProvider
    // TODO 14. change return of hasStableIds with true
    // TODO 15. delete TextViewText in updateAppWidget of CollectionWidget
    // TODO 16. copy views from https://github.com/udacity/android-widget/blob/master/app/src/main/res/layout/collection_widget.xml
    // TODO 17. create method static setRemoteAdapter (or copy from https://github.com/udacity/android-widget/blob/master/app/src/main/java/com/udacity/horatio/widgetexample/CollectionWidget.java)
    //          because min sdk 17 so no need @TargetAPI

    // TODO 18. call setRemoteAdapter in updateWiget of CollectionWidget (reference  from https://github.com/udacity/android-widget/blob/master/app/src/main/java/com/udacity/horatio/widgetexample/CollectionWidget.java  )
    // TODO 19. change return getViewAt with RemoteViews in WidgetDataProvider
    // TODO 20. add WidgetService and permission in AndroidManifest <service android:name=".WidgetService" android:permission="android.permission.BIND_REMOTEVIEWS" />

    // TODO 21. setOnClickFillInIntent in getViewAt of WidgetDataProvider
    // TODO 22. add PendingIntent in updateAppWidget of CollectionWidget
    // TODO 23. add +id/txt_view_widget_item in TextView of activity_main.xml
    // TODO 23. set String intent to txt_view_widget_item and show in MainActivity

}
