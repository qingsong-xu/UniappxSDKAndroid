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
import uts.sdk.modules.xBdmap.BdMapViewComponent;
import io.dcloud.uniapp.extapi.getSystemInfo as uni_getSystemInfo;
import uts.sdk.modules.xyronXxpermissions.permission;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesIndexIndex : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLoad(fun(event: OnLoadOptions) {
            requestPermissionLocation();
            uni_getSystemInfo(GetSystemInfoOptions(success = fun(systemInfo){
                var screenHeight = systemInfo.windowHeight;
                console.log("screenHeight", screenHeight);
                var tabBarHeight: Number = 70;
                this.contentHeight = screenHeight - tabBarHeight;
                console.log("contentHeight", this.contentHeight);
            }
            ));
        }
        , __ins);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_xyron_gdmap = resolveEasyComponent("xyron-gdmap", GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmapClass);
        val _component_fui_button = resolveEasyComponent("fui-button", GenUniModulesFirstuiUnixComponentsFuiButtonFuiButtonClass);
        return createElementVNode("view", utsMapOf("class" to "page-container"), utsArrayOf(
            if (_ctx.mapType == 0) {
                createVNode(_component_xyron_gdmap, utsMapOf("key" to 0, "class" to "map-box", "markers" to _ctx.latlngMarkers), null, 8, utsArrayOf(
                    "markers"
                ));
            } else {
                if (_ctx.mapType == 1) {
                    createElementVNode(BdMapViewComponent.name, utsMapOf("key" to 1, "style" to normalizeStyle(utsMapOf("height" to (_ctx.contentHeight + "px")))), null, 4);
                } else {
                    createCommentVNode("v-if", true);
                }
                ;
            }
            ,
            createElementVNode("view", utsMapOf("class" to "operate-box"), utsArrayOf(
                createVNode(_component_fui_button, utsMapOf("text" to "调用测试", "onClick" to _ctx.handleTest), null, 8, utsArrayOf(
                    "onClick"
                ))
            ))
        ));
    }
    open var contentHeight: Number by `$data`;
    open var mapType: Number by `$data`;
    open var latlngMarkers: UTSArray<UTSJSONObject> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("contentHeight" to 0, "mapType" to 0, "latlngMarkers" to utsArrayOf(
            object : UTSJSONObject() {
                var lat: Number = 26.6700
                var lng: Number = 106.6700
            }
        ));
    }
    override fun `$initMethods`() {
        this.requestPermissionLocation = fun() {
            permission(utsArrayOf(
                "android.permission.ACCESS_COARSE_LOCATION"
            ), true, fun(ret, desc, grantedList) {
                console.log("permission ret=" + ret + " desc=" + desc);
                if (ret) {
                    uni_showToast(ShowToastOptions(icon = "none", title = "测试通过"));
                } else {
                    uni_showToast(ShowToastOptions(icon = "none", title = "失败：" + desc));
                }
            }
            );
        }
        ;
        this.handleTest = fun() {
            this.latlngMarkers = utsArrayOf(
                object : UTSJSONObject() {
                    var lat: Number = 26.6476
                    var lng: Number = 106.6302
                },
                object : UTSJSONObject() {
                    var lat: Number = 26.6700
                    var lng: Number = 106.6700
                },
                object : UTSJSONObject() {
                    var lat: Number = 25.0443
                    var lng: Number = 102.7060
                }
            );
        }
        ;
    }
    open lateinit var requestPermissionLocation: () -> Unit;
    open lateinit var handleTest: () -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ), utsArrayOf(
                    GenApp.styles
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("page-container" to padStyleMapOf(utsMapOf("height" to "100%", "position" to "relative")), "operate-box" to utsMapOf(".page-container " to utsMapOf("position" to "absolute", "bottom" to "100rpx")), "map-box" to utsMapOf(".page-container " to utsMapOf("width" to "100%", "height" to "100%")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
