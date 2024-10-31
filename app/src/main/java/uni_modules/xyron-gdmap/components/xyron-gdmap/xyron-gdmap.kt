@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER")
package uni.UNI9BA87F9;
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
import uts.sdk.modules.xyronGdmap.GaoDeMap;
open class GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var markers: UTSArray<Any?> by `$props`;
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap;
            val _cache = __ins.renderCache;
            var mapView: GaoDeMap? = null;
            fun genOnviewinitFn(e: UniNativeViewInitEvent) {
                console.log("onviewinit");
                mapView = GaoDeMap(e.detail.element);
            }
            val onviewinit = ::genOnviewinitFn;
            fun genAddMarkersFn(markers1: UTSArray<*>) {
                console.log("mapView", mapView == null);
                mapView?.addMarker(markers1);
            }
            val addMarkers = ::genAddMarkersFn;
            val props = __props;
            watchEffect(fun(){
                console.log("watchEffect", UTSAndroid.`typeof`( props.markers));
                addMarkers(props.markers);
            }
            );
            onLoad(fun(options){
                console.log("xyron-gdmap onLoad");
            }
            );
            return fun(): Any? {
                return createElementVNode("native-view", utsMapOf("onInit" to onviewinit), null, 32);
            }
            ;
        }
        ;
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf());
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("markers" to utsMapOf("type" to "Array", "required" to true)));
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
