package com.example.garam.takemissinginfo

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.LocationManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_soup_kitchen.*
import net.daum.mf.map.api.MapCircle
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class SoupKitchenActivity : AppCompatActivity(), MapView.MapViewEventListener, MapView.POIItemEventListener {

    init {
        instance = this
    }

    companion object {
        private var instance: SoupKitchenActivity? = null
        fun context() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onMapViewDoubleTapped(p0: MapView?, p1: MapPoint?) {

    }

    override fun onMapViewInitialized(p0: MapView?) {

    }

    override fun onMapViewDragStarted(p0: MapView?, p1: MapPoint?) {

    }

    override fun onMapViewMoveFinished(p0: MapView?, p1: MapPoint?) {

    }

    override fun onMapViewCenterPointMoved(p0: MapView?, p1: MapPoint?) {

    }

    override fun onMapViewDragEnded(p0: MapView?, p1: MapPoint?) {

    }

    override fun onMapViewSingleTapped(p0: MapView?, p1: MapPoint?) {

    }

    override fun onMapViewZoomLevelChanged(p0: MapView?, p1: Int) {

    }

    override fun onMapViewLongPressed(p0: MapView?, p1: MapPoint?) {

    }

    override fun onCalloutBalloonOfPOIItemTouched(p0: MapView?, p1: MapPOIItem?) {

    }

    override fun onCalloutBalloonOfPOIItemTouched(
        p0: MapView?,
        p1: MapPOIItem?,
        p2: MapPOIItem.CalloutBalloonButtonType?
    ) {
        val url = "https://map.kakao.com/link/to/${p1?.itemName},${p1?.mapPoint?.mapPointGeoCoord?.latitude}, ${p1?.mapPoint?.mapPointGeoCoord?.longitude}"
        val nextIntent = Intent(Intent.ACTION_VIEW,Uri.parse(url))
        nextIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        startActivity(nextIntent)

    }

    override fun onDraggablePOIItemMoved(p0: MapView?, p1: MapPOIItem?, p2: MapPoint?) {

    }

    override fun onPOIItemSelected(p0: MapView?, p1: MapPOIItem?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soup_kitchen)

        val mapView = MapView(this)
        mapView.setMapViewEventListener(this)
        mapView.setPOIItemEventListener(this)

        val locationManager : LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val location = if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION),
                100)
            return
        } else locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

        val latitude = location.latitude
        val longitude = location.longitude

        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(latitude,longitude),2, true)
        mapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeadingWithoutMapMoving

        val circle = MapCircle(MapPoint.mapPointWithGeoCoord(latitude,longitude),500,
        Color.argb(128,255,0,0),
        Color.argb(128,0,255,0))

        mapView.addCircle(circle)

        val marker = MapPOIItem()
        marker.mapPoint = MapPoint.mapPointWithGeoCoord(latitude + 0.3,longitude + 0.3)
        marker.itemName = "테스트"
        mapView.addPOIItem(marker)
        mapViewLayout.addView(mapView)

    }

}