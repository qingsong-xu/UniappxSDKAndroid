@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER")
package uts.sdk.modules.xyronGdmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.rylgps.app.R;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
open class LatLngEntity (
    @JsonNotNull
    open var lat: Double = 0.0,
    @JsonNotNull
    open var lng: Double = 0.0,
) : UTSObject()
open class GaoDeMap {
    open var `$element`: UniNativeViewElement;
    constructor(element: UniNativeViewElement){
        this.`$element` = element;
        this.bindView();
    }
    open var mapView: MapView? = null;
    open var aMap: AMap? = null;
    open fun bindView() {
        this.mapView = MapView(this.`$element`.getAndroidActivity()!!);
        this.mapView?.onCreate(Bundle());
        this.aMap = this.mapView?.getMap();
        val uiSetting = this.aMap?.getUiSettings();
        uiSetting?.setRotateGesturesEnabled(false);
        AMapLocationClient.updatePrivacyShow(this.`$element`.getAndroidActivity()!!, true, true);
        AMapLocationClient.updatePrivacyAgree(this.`$element`.getAndroidActivity()!!, true);
        this.`$element`.bindAndroidView(this.mapView!!);
    }
    open fun addMarker(markers: UTSArray<*>) {
        console.log("自定义marker:", markers);
        var mMakers = JSON.parseArray(JSON.stringify(markers)) as UTSArray<LatLngEntity>;
        mMakers.forEach(fun(element: LatLngEntity, index: Number){
            console.log(element);
            val latLng = LatLng(element.lat, element.lng);
            val markerOption = MarkerOptions();
            markerOption.position(latLng);
            markerOption.title("贵阳");
            markerOption.snippet("家里");
            markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(this.`$element`.getAndroidActivity()!!.getResources(), R.drawable.green_car_gd)));
            val marker = this.aMap?.addMarker(markerOption);
        }
        );
    }
    open fun destroy() {}
}
