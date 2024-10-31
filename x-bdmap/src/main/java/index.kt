@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER")
package uts.sdk.modules.xBdmap;
import android.app.Application;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.UniSDKEngine;
import io.dcloud.uniapp.appframe.PageProxy;
import io.dcloud.uniapp.dom.node.DomNode;
import io.dcloud.uniapp.dom.node.PageNode;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.interfaces.INodeData;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.ui.component.IComponentData;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import io.dcloud.uts.component.*;
import io.dcloud.uts.component.UTSComponent;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
open class MyApiOptions (
    @JsonNotNull
    open var paramA: Boolean = false,
    open var success: ((res: MyApiResult) -> Unit)? = null,
    open var fail: ((res: MyApiFail) -> Unit)? = null,
    open var complete: ((res: Any) -> Unit)? = null,
) : UTSObject()
open class MyApiResult (
    @JsonNotNull
    open var fieldA: Number,
    @JsonNotNull
    open var fieldB: Boolean = false,
    @JsonNotNull
    open var fieldC: String,
) : UTSObject()
typealias MyApiErrorCode = Number;
interface MyApiFail : IUniError {
    override var errCode: MyApiErrorCode
}
typealias MyApi = (options: MyApiOptions) -> Unit;
typealias MyApiSync = (paramA: Boolean) -> MyApiResult;
val UniErrorSubject = "x地图集合包";
val MyAPIErrors: Map<MyApiErrorCode, String> = Map(utsArrayOf(
    utsArrayOf(
        9010001,
        "custom error mseeage1"
    ),
    utsArrayOf(
        9010002,
        "custom error mseeage2"
    )
));
open class MyApiFailImpl : UniError, MyApiFail {
    constructor(errCode: MyApiErrorCode) : super() {
        this.errSubject = UniErrorSubject;
        this.errCode = errCode;
        this.errMsg = MyAPIErrors.get(errCode) ?: "";
    }
}
open class BdMapViewComponent : UTSComponent<MapView> {
    constructor(proxy: PageProxy, componentData: IComponentData) : super(proxy, componentData) ;
    override fun NVLoad(): MapView {
        val bdMapView = MapView(this.`$androidContext`);
        val bdMap = bdMapView.getMap() as BaiduMap;
        return bdMapView;
    }
    companion object {
        var name = "bd-map-view";
        init {
            io.dcloud.uniapp.UniSDKEngine.registerUniComponent("bd-map-view", BdMapViewComponent::class.java, BdMapViewElement::class.java);
        }
    }
}
open class BdMapViewElement : DomNode {
    constructor(data: INodeData, pageNode: PageNode) : super(data, pageNode) ;
}
val myApi: MyApi = fun(options: MyApiOptions) {
    if (options.paramA == true) {
        val res = MyApiResult(fieldA = 85, fieldB = true, fieldC = "some message");
        options.success?.invoke(res);
        options.complete?.invoke(res);
    } else {
        val err = MyApiFailImpl(9010001);
        options.fail?.invoke(err);
        options.complete?.invoke(err);
    }
}
;
val myApiSync: MyApiSync = fun(paramA: Boolean): MyApiResult {
    val res = MyApiResult(fieldA = 85, fieldB = paramA, fieldC = "some message");
    return res;
}
;
open class AppHookProxy : UTSAndroidHookProxy {
    override fun onCreate(application: Application) {
        console.log("AppHookProxy--onCreate---" + UTSAndroid.isPrivacyAgree());
        SDKInitializer.initialize(UTSAndroid.getAppContext());
        SDKInitializer.setCoordType(CoordType.BD09LL);
        Log.e("AppHookProxy", "AppHookProxy--onCreate---");
        if (UTSAndroid.isPrivacyAgree()) {
            console.log("AppHookProxy--onCreate---isPrivacyAgree");
            Log.e("AppHookProxy", "AppHookProxy--onCreate---isPrivacyAgree");
        }
    }
}
