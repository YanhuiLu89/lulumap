package com.xiaochuang.lulumap;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MapView mMapView = null;
    private BaiduMap mBaiduMap=null;
    private Button mLayerButton=null;
    private Button mTmc=null;
    private Button mHeat=null;
    ArrayList< Parcelable> mlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap=mMapView.getMap();
        mBaiduMap.setMyLocationEnabled(true);
        mLayerButton=(Button) findViewById(R.id.layerButton);
        mLayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MapLayerActivity.class);
                startActivity(intent);
//                mBaiduMap.getMapType();
//                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);

            }
        });

//        mTmc=(Button) findViewById(R.id.tmcButton);
//        mTmc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mBaiduMap.setTrafficEnabled(true);
//
//            }
//        });
//
//        mHeat=(Button) findViewById(R.id.heatButton);
//        mHeat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mBaiduMap.setBaiduHeatMapEnabled(true);
//
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
}
