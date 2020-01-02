package com.xiaochuang.lulumap;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;
import com.baidu.mapapi.map.BaiduMap;

import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.UiSettings;

public class MapLayerActivity extends AppCompatActivity {
private ListView mListView;
private String[] mapTypes = {"2D平面图","卫星图","3D俯视图"};
private MapView mMapView = null;
private BaiduMap mBaiduMap=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_map_layer);
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap=mMapView.getMap();
        mListView=(ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MapLayerActivity.this, R.layout.support_simple_spinner_dropdown_item, mapTypes);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position==0){
                         mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL) ;
                    }else if(position==1){
                         UiSettings mUiSettings = mBaiduMap.getUiSettings();
                         mUiSettings.setOverlookingGesturesEnabled(true);

                    }else if(position==2) {
                         mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE ) ;
                    }
                    mListView.setSelection(position);
            }
        });
    }

}
