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
import io.dcloud.uniapp.extapi.exit as uni_exit;
import io.dcloud.uniapp.extapi.getStorageSync as uni_getStorageSync;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
import uts.sdk.modules.kuxRequest.useInterceptor;
import uts.sdk.modules.kuxRequest.RequestConfig;
import uts.sdk.modules.kuxRequest.useRequest;
import uts.sdk.modules.kuxRequest.UseOptions;
var firstBackTime: Number = 0;
open class GenApp : BaseApp {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLaunch(fun(_: OnLaunchOptions) {
            console.log("App Launch");
        }
        , __ins);
        onAppShow(fun(_: OnShowOptions) {
            console.log("App Show");
        }
        , __ins);
        onHide(fun() {
            console.log("App Hide");
        }
        , __ins);
        onLastPageBackPress(fun() {
            console.log("App LastPageBackPress");
            if (firstBackTime == 0) {
                uni_showToast(ShowToastOptions(title = "再按一次退出应用", position = "bottom"));
                firstBackTime = Date.now();
                setTimeout(fun(){
                    firstBackTime = 0;
                }, 2000);
            } else if (Date.now() - firstBackTime < 2000) {
                firstBackTime = Date.now();
                uni_exit(null);
            }
        }
        , __ins);
        onExit(fun() {
            console.log("App Exit");
        }
        , __ins);
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("common-cell-item" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "backgroundColor" to "#FFFFFF", "borderTopStyle" to "solid", "borderTopColor" to "#f0f0f0", "borderTopWidth" to 1, "paddingTop" to 12, "paddingRight" to 12, "paddingBottom" to 12, "paddingLeft" to 12, "justifyContent" to "space-between")), "common-icon-size" to padStyleMapOf(utsMapOf("width" to 18, "height" to 18)), "common-row" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center")), "common-column" to padStyleMapOf(utsMapOf("flexDirection" to "column", "alignItems" to "center")), "common-gray-bg" to padStyleMapOf(utsMapOf("backgroundColor" to "#f1f1f1")), "common-gray-line" to padStyleMapOf(utsMapOf("backgroundColor" to "#cccccc", "height" to "1rpx", "width" to "100%")), "uni-padding-wrap" to padStyleMapOf(utsMapOf("paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "uni-title" to padStyleMapOf(utsMapOf("paddingTop" to 10, "paddingRight" to 0, "paddingBottom" to 10, "paddingLeft" to 0)), "uni-title-text" to padStyleMapOf(utsMapOf("fontSize" to 15, "fontWeight" to "bold")), "uni-subtitle-text" to padStyleMapOf(utsMapOf("color" to "#888888", "fontSize" to 12, "fontWeight" to "bold", "marginTop" to 5)), "uni-common-mb" to padStyleMapOf(utsMapOf("marginBottom" to 15)), "uni-common-pb" to padStyleMapOf(utsMapOf("paddingBottom" to 15)), "uni-common-pl" to padStyleMapOf(utsMapOf("paddingLeft" to 15)), "uni-common-mt" to padStyleMapOf(utsMapOf("marginTop" to 15)), "uni-hello-text" to padStyleMapOf(utsMapOf("color" to "#7A7E83", "lineHeight" to "22px")), "uni-list" to padStyleMapOf(utsMapOf("backgroundColor" to "#FFFFFF", "position" to "relative", "display" to "flex", "flexDirection" to "column", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#c8c7cc")), "uni-list-cell" to padStyleMapOf(utsMapOf("position" to "relative", "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "uni-list-cell-padding" to padStyleMapOf(utsMapOf("paddingTop" to 16, "paddingRight" to 16, "paddingBottom" to 16, "paddingLeft" to 16)), "uni-list-cell-line" to padStyleMapOf(utsMapOf("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#c8c7cc")), "uni-list-cell-hover" to padStyleMapOf(utsMapOf("backgroundColor" to "#eeeeee")), "uni-list-cell-pd" to padStyleMapOf(utsMapOf("paddingTop" to 11, "paddingRight" to 15, "paddingBottom" to 11, "paddingLeft" to 0)), "uni-list-cell-left" to padStyleMapOf(utsMapOf("paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 10)), "uni-list-cell-db" to padStyleMapOf(utsMapOf("flex" to 1)), "uni-list-cell-right" to padStyleMapOf(utsMapOf("flex" to 1)), "uni-label" to padStyleMapOf(utsMapOf("width" to 105)), "uni-input" to padStyleMapOf(utsMapOf("height" to 25, "paddingTop" to 8, "paddingRight" to 13, "paddingBottom" to 8, "paddingLeft" to 13, "fontSize" to 14, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "flex" to 1, "boxSizing" to "content-box")), "uni-flex" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "uni-flex-item" to padStyleMapOf(utsMapOf("flex" to 1)), "uni-row" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "uni-column" to padStyleMapOf(utsMapOf("flexDirection" to "column")), "uni-bg-red" to padStyleMapOf(utsMapOf("backgroundImage" to "none", "backgroundColor" to "#F76260")), "uni-bg-green" to padStyleMapOf(utsMapOf("backgroundImage" to "none", "backgroundColor" to "#09BB07")), "uni-bg-blue" to padStyleMapOf(utsMapOf("backgroundImage" to "none", "backgroundColor" to "#007AFF")), "uni-btn-v" to padStyleMapOf(utsMapOf("paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0)), "uni-btn" to padStyleMapOf(utsMapOf("marginTop" to 10)), "uni-link" to padStyleMapOf(utsMapOf("color" to "#576B95", "fontSize" to 13)), "uni-center" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "center")), "uni-textarea" to padStyleMapOf(utsMapOf("paddingTop" to 9, "paddingRight" to 9, "paddingBottom" to 9, "paddingLeft" to 9, "lineHeight" to 1.6, "fontSize" to 14)), "uni-icon-size" to padStyleMapOf(utsMapOf("width" to 18, "height" to 18)), "uni-container" to padStyleMapOf(utsMapOf("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "backgroundColor" to "#f8f8f8")), "uni-header-logo" to padStyleMapOf(utsMapOf("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center", "marginTop" to 5)), "uni-header-image" to padStyleMapOf(utsMapOf("width" to 80, "height" to 80)), "uni-text-box" to padStyleMapOf(utsMapOf("marginBottom" to 20)), "hello-text" to padStyleMapOf(utsMapOf("color" to "#7A7E83", "fontSize" to 14, "lineHeight" to "20px")), "uni-panel" to padStyleMapOf(utsMapOf("marginBottom" to 12)), "text-disabled" to padStyleMapOf(utsMapOf("!color" to "#a0a0a0")), "uni-panel-h" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "!flexDirection" to "row", "!justifyContent" to "space-between", "!alignItems" to "center", "paddingTop" to 12, "paddingRight" to 12, "paddingBottom" to 12, "paddingLeft" to 12)), "uni-panel-h-on" to padStyleMapOf(utsMapOf("backgroundColor" to "#f0f0f0")), "uni-panel-text" to padStyleMapOf(utsMapOf("color" to "#000000", "fontSize" to 14, "fontWeight" to "normal")), "uni-navigate-item" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "backgroundColor" to "#FFFFFF", "borderTopStyle" to "solid", "borderTopColor" to "#f0f0f0", "borderTopWidth" to 1, "paddingTop" to 12, "paddingRight" to 12, "paddingBottom" to 12, "paddingLeft" to 12, "justifyContent" to "space-between", "backgroundColor:active" to "#f8f8f8")), "is--active" to padStyleMapOf(utsMapOf("backgroundColor" to "#f8f8f8")), "uni-navigate-text" to padStyleMapOf(utsMapOf("color" to "#000000", "fontSize" to 14, "fontWeight" to "normal")), "left-win-active" to padStyleMapOf(utsMapOf("!color" to "#007AFF")), "page-scroll-view" to padStyleMapOf(utsMapOf("flex" to 1)), "ryl-row" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center")), "ryl-column" to padStyleMapOf(utsMapOf("flexDirection" to "column")), "page-container" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%")), "margin-left" to padStyleMapOf(utsMapOf("marginLeft" to "15rpx")), "txt-w" to padStyleMapOf(utsMapOf("color" to "#FFFFFF")), "cell-item" to padStyleMapOf(utsMapOf("backgroundColor" to "#FFFFFF", "borderTopStyle" to "solid", "borderTopColor" to "#f0f0f0", "borderTopWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f0f0f0", "borderBottomWidth" to 1)));
            }
    }
}
val GenAppClass = CreateVueAppComponent(GenApp::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "app", name = "", inheritAttrs = true, inject = Map(), props = Map(), propsNeedCastKeys = utsArrayOf(), emits = Map(), components = Map(), styles = GenApp.styles);
}
, fun(instance): GenApp {
    return GenApp(instance);
}
);
val httpRequest = useRequest(UseOptions(baseURL = "http://123.249.81.141/"));
val runBlock1 = run {
    httpRequest.onFail(fun(fail: RequestFail){
        console.log("请求失败拦截", fail);
        console.log(fail.cause?.message);
        httpRequest.overrideConfig(RequestConfig(baseURL = "https://test.api.fdproxy.cn"));
    }
    );
}
val interceptors = useInterceptor();
val runBlock2 = run {
    interceptors.useRequestSync(fun(options): UTSPromise<RequestConfig> {
        suspend fun async(): Any? {
            console.log("同步请求拦截", options.url);
            if (options.url == "/user/create") {
                console.log("中断请求", JSON.stringify(httpRequest));
                httpRequest.abort();
            }
            return options;
        }
        return UTSPromise(fun(resolve, reject) {
            kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                try {
                    val result = async();
                    resolve(if (result is UTSPromise<*>) {
                        @Suppress("UNCHECKED_CAST")
                        `await`(result as UTSPromise<RequestConfig>);
                    } else {
                        result as RequestConfig;
                    }
                    );
                }
                 catch (e: Throwable) {
                    reject(e);
                }
            }
            ;
        }
        );
    }
    ).useRequest(fun(options): RequestConfig {
        val tokenType = uni_getStorageSync("tokenType");
        val token = uni_getStorageSync("accessToken");
        options.header = Object.assign(options.header ?: UTSJSONObject(), object : UTSJSONObject() {
            var authorization = "Basic cnlsZ3BzOnJ5bGdwc19zZWNyZXQ="
            var `blade-auth` = "" + tokenType + " " + token
        });
        console.log("请求拦截", options);
        return options;
    }
    ).useResponse(fun(res): Any {
        return res;
    }
    );
}
open class UserInfo (
    @JsonNotNull
    open var accessToken: String,
    @JsonNotNull
    open var userId: String,
    @JsonNotNull
    open var tenantId: String,
    @JsonNotNull
    open var oauthId: String,
    @JsonNotNull
    open var avatar: String,
    @JsonNotNull
    open var authority: String,
    @JsonNotNull
    open var userName: String,
    @JsonNotNull
    open var account: String,
    @JsonNotNull
    open var expiresIn: Number,
    @JsonNotNull
    open var license: String,
    @JsonNotNull
    open var roles: UTSArray<*>,
) : UTSObject()
val GenPagesLoginLoginClass = CreateVueComponent(GenPagesLoginLogin::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesLoginLogin.inheritAttrs, inject = GenPagesLoginLogin.inject, props = GenPagesLoginLogin.props, propsNeedCastKeys = GenPagesLoginLogin.propsNeedCastKeys, emits = GenPagesLoginLogin.emits, components = GenPagesLoginLogin.components, styles = GenPagesLoginLogin.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesLoginLogin.setup(props as GenPagesLoginLogin);
    }
    );
}
, fun(instance): GenPagesLoginLogin {
    return GenPagesLoginLogin(instance);
}
);
val MAP_SOURCE: String = "mapSource";
val GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmapClass = CreateVueComponent(GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap.inheritAttrs, inject = GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap.inject, props = GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap.props, propsNeedCastKeys = GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap.propsNeedCastKeys, emits = GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap.emits, components = GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap.components, styles = GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap.setup(props as GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap);
    }
    );
}
, fun(instance): GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap {
    return GenUniModulesXyronGdmapComponentsXyronGdmapXyronGdmap(instance);
}
);
val GenUniModulesFirstuiUnixComponentsFuiButtonFuiButtonClass = CreateVueComponent(GenUniModulesFirstuiUnixComponentsFuiButtonFuiButton::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesFirstuiUnixComponentsFuiButtonFuiButton.name, inheritAttrs = GenUniModulesFirstuiUnixComponentsFuiButtonFuiButton.inheritAttrs, inject = GenUniModulesFirstuiUnixComponentsFuiButtonFuiButton.inject, props = GenUniModulesFirstuiUnixComponentsFuiButtonFuiButton.props, propsNeedCastKeys = GenUniModulesFirstuiUnixComponentsFuiButtonFuiButton.propsNeedCastKeys, emits = GenUniModulesFirstuiUnixComponentsFuiButtonFuiButton.emits, components = GenUniModulesFirstuiUnixComponentsFuiButtonFuiButton.components, styles = GenUniModulesFirstuiUnixComponentsFuiButtonFuiButton.styles);
}
, fun(instance): GenUniModulesFirstuiUnixComponentsFuiButtonFuiButton {
    return GenUniModulesFirstuiUnixComponentsFuiButtonFuiButton(instance);
}
);
val GenPagesIndexIndexClass = CreateVueComponent(GenPagesIndexIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesIndexIndex.inheritAttrs, inject = GenPagesIndexIndex.inject, props = GenPagesIndexIndex.props, propsNeedCastKeys = GenPagesIndexIndex.propsNeedCastKeys, emits = GenPagesIndexIndex.emits, components = GenPagesIndexIndex.components, styles = GenPagesIndexIndex.styles);
}
, fun(instance): GenPagesIndexIndex {
    return GenPagesIndexIndex(instance);
}
);
val getUserTree = fun(userId: String): UTSPromise<Any> {
    return httpRequest.get("/api/consumer/userTree?userId=" + userId);
}
;
var timeout: Number = 0;
val debounce = fun(func: () -> Unit, wait: Number){
    if (timeout != 0) {
        clearTimeout(timeout);
    }
    timeout = setTimeout(fun(){
        func();
    }
    , wait);
}
;
val GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawerClass = CreateVueComponent(GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer.inheritAttrs, inject = GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer.inject, props = GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer.props, propsNeedCastKeys = GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer.propsNeedCastKeys, emits = GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer.emits, components = GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer.components, styles = GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer.setup(props as GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer, ctx);
    }
    );
}
, fun(instance): GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer {
    return GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer(instance);
}
);
typealias LaopobingDrawerComponentPublicInstance = GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer;
fun `$dispatch`(context: ComponentPublicInstance, componentName: String, eventName: String, vararg spreadParams: Any) {
    var params = UTSArray(*spreadParams);
    var parent = context.`$parent`;
    var name = parent?.`$options`?.name;
    while(parent != null && (name == null || componentName != name)){
        parent = parent.`$parent`;
        if (parent != null) {
            name = parent.`$options`.name;
        }
    }
    if (parent != null) {
        parent.`$callMethod`(eventName, *params.toTypedArray());
    }
}
val GenComponentsUniCollapseItemUniCollapseItemClass = CreateVueComponent(GenComponentsUniCollapseItemUniCollapseItem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsUniCollapseItemUniCollapseItem.name, inheritAttrs = GenComponentsUniCollapseItemUniCollapseItem.inheritAttrs, inject = GenComponentsUniCollapseItemUniCollapseItem.inject, props = GenComponentsUniCollapseItemUniCollapseItem.props, propsNeedCastKeys = GenComponentsUniCollapseItemUniCollapseItem.propsNeedCastKeys, emits = GenComponentsUniCollapseItemUniCollapseItem.emits, components = GenComponentsUniCollapseItemUniCollapseItem.components, styles = GenComponentsUniCollapseItemUniCollapseItem.styles);
}
, fun(instance): GenComponentsUniCollapseItemUniCollapseItem {
    return GenComponentsUniCollapseItemUniCollapseItem(instance);
}
);
val GenComponentsUniCollapseUniCollapseClass = CreateVueComponent(GenComponentsUniCollapseUniCollapse::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsUniCollapseUniCollapse.name, inheritAttrs = GenComponentsUniCollapseUniCollapse.inheritAttrs, inject = GenComponentsUniCollapseUniCollapse.inject, props = GenComponentsUniCollapseUniCollapse.props, propsNeedCastKeys = GenComponentsUniCollapseUniCollapse.propsNeedCastKeys, emits = GenComponentsUniCollapseUniCollapse.emits, components = GenComponentsUniCollapseUniCollapse.components, styles = GenComponentsUniCollapseUniCollapse.styles);
}
, fun(instance): GenComponentsUniCollapseUniCollapse {
    return GenComponentsUniCollapseUniCollapse(instance);
}
);
open class navItem (
    @JsonNotNull
    open var id: Number,
    open var text: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return navItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class navItemReactiveObject : navItem, IUTSReactive<navItem> {
    override var __v_raw: navItem;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: navItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, text = __v_raw.text) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): navItemReactiveObject {
        return navItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var text: String?
        get() {
            return trackReactiveGet(__v_raw, "text", __v_raw.text, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("text")) {
                return;
            }
            val oldValue = __v_raw.text;
            __v_raw.text = value;
            triggerReactiveSet(__v_raw, "text", oldValue, value);
        }
}
val GenPagesDeviceListDeviceListClass = CreateVueComponent(GenPagesDeviceListDeviceList::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesDeviceListDeviceList.inheritAttrs, inject = GenPagesDeviceListDeviceList.inject, props = GenPagesDeviceListDeviceList.props, propsNeedCastKeys = GenPagesDeviceListDeviceList.propsNeedCastKeys, emits = GenPagesDeviceListDeviceList.emits, components = GenPagesDeviceListDeviceList.components, styles = GenPagesDeviceListDeviceList.styles);
}
, fun(instance): GenPagesDeviceListDeviceList {
    return GenPagesDeviceListDeviceList(instance);
}
);
val GenPagesDeviceAlarmComponentAlarmItemClass = CreateVueComponent(GenPagesDeviceAlarmComponentAlarmItem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenPagesDeviceAlarmComponentAlarmItem.name, inheritAttrs = GenPagesDeviceAlarmComponentAlarmItem.inheritAttrs, inject = GenPagesDeviceAlarmComponentAlarmItem.inject, props = GenPagesDeviceAlarmComponentAlarmItem.props, propsNeedCastKeys = GenPagesDeviceAlarmComponentAlarmItem.propsNeedCastKeys, emits = GenPagesDeviceAlarmComponentAlarmItem.emits, components = GenPagesDeviceAlarmComponentAlarmItem.components, styles = GenPagesDeviceAlarmComponentAlarmItem.styles);
}
, fun(instance): GenPagesDeviceAlarmComponentAlarmItem {
    return GenPagesDeviceAlarmComponentAlarmItem(instance);
}
);
val GenPagesDeviceAlarmDeviceAlarmClass = CreateVueComponent(GenPagesDeviceAlarmDeviceAlarm::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesDeviceAlarmDeviceAlarm.inheritAttrs, inject = GenPagesDeviceAlarmDeviceAlarm.inject, props = GenPagesDeviceAlarmDeviceAlarm.props, propsNeedCastKeys = GenPagesDeviceAlarmDeviceAlarm.propsNeedCastKeys, emits = GenPagesDeviceAlarmDeviceAlarm.emits, components = GenPagesDeviceAlarmDeviceAlarm.components, styles = GenPagesDeviceAlarmDeviceAlarm.styles);
}
, fun(instance): GenPagesDeviceAlarmDeviceAlarm {
    return GenPagesDeviceAlarmDeviceAlarm(instance);
}
);
val GenComponentsUxCellUxCellClass = CreateVueComponent(GenComponentsUxCellUxCell::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsUxCellUxCell.name, inheritAttrs = GenComponentsUxCellUxCell.inheritAttrs, inject = GenComponentsUxCellUxCell.inject, props = GenComponentsUxCellUxCell.props, propsNeedCastKeys = GenComponentsUxCellUxCell.propsNeedCastKeys, emits = GenComponentsUxCellUxCell.emits, components = GenComponentsUxCellUxCell.components, styles = GenComponentsUxCellUxCell.styles);
}
, fun(instance): GenComponentsUxCellUxCell {
    return GenComponentsUxCellUxCell(instance);
}
);
open class FuiActionSheetItemParam (
    @JsonNotNull
    open var text: String,
    open var color: String? = null,
    open var darkColor: String? = null,
    open var param: String? = null,
    open var index: Number? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return FuiActionSheetItemParamReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class FuiActionSheetItemParamReactiveObject : FuiActionSheetItemParam, IUTSReactive<FuiActionSheetItemParam> {
    override var __v_raw: FuiActionSheetItemParam;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: FuiActionSheetItemParam, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(text = __v_raw.text, color = __v_raw.color, darkColor = __v_raw.darkColor, param = __v_raw.param, index = __v_raw.index) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): FuiActionSheetItemParamReactiveObject {
        return FuiActionSheetItemParamReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var text: String
        get() {
            return trackReactiveGet(__v_raw, "text", __v_raw.text, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("text")) {
                return;
            }
            val oldValue = __v_raw.text;
            __v_raw.text = value;
            triggerReactiveSet(__v_raw, "text", oldValue, value);
        }
    override var color: String?
        get() {
            return trackReactiveGet(__v_raw, "color", __v_raw.color, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("color")) {
                return;
            }
            val oldValue = __v_raw.color;
            __v_raw.color = value;
            triggerReactiveSet(__v_raw, "color", oldValue, value);
        }
    override var darkColor: String?
        get() {
            return trackReactiveGet(__v_raw, "darkColor", __v_raw.darkColor, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("darkColor")) {
                return;
            }
            val oldValue = __v_raw.darkColor;
            __v_raw.darkColor = value;
            triggerReactiveSet(__v_raw, "darkColor", oldValue, value);
        }
    override var param: String?
        get() {
            return trackReactiveGet(__v_raw, "param", __v_raw.param, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("param")) {
                return;
            }
            val oldValue = __v_raw.param;
            __v_raw.param = value;
            triggerReactiveSet(__v_raw, "param", oldValue, value);
        }
    override var index: Number?
        get() {
            return trackReactiveGet(__v_raw, "index", __v_raw.index, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("index")) {
                return;
            }
            val oldValue = __v_raw.index;
            __v_raw.index = value;
            triggerReactiveSet(__v_raw, "index", oldValue, value);
        }
}
open class FuiDialogButtonsParam (
    @JsonNotNull
    open var text: String,
    open var color: String? = null,
    open var primary: Boolean? = null,
    open var param: String? = null,
    open var index: Number? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return FuiDialogButtonsParamReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class FuiDialogButtonsParamReactiveObject : FuiDialogButtonsParam, IUTSReactive<FuiDialogButtonsParam> {
    override var __v_raw: FuiDialogButtonsParam;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: FuiDialogButtonsParam, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(text = __v_raw.text, color = __v_raw.color, primary = __v_raw.primary, param = __v_raw.param, index = __v_raw.index) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): FuiDialogButtonsParamReactiveObject {
        return FuiDialogButtonsParamReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var text: String
        get() {
            return trackReactiveGet(__v_raw, "text", __v_raw.text, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("text")) {
                return;
            }
            val oldValue = __v_raw.text;
            __v_raw.text = value;
            triggerReactiveSet(__v_raw, "text", oldValue, value);
        }
    override var color: String?
        get() {
            return trackReactiveGet(__v_raw, "color", __v_raw.color, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("color")) {
                return;
            }
            val oldValue = __v_raw.color;
            __v_raw.color = value;
            triggerReactiveSet(__v_raw, "color", oldValue, value);
        }
    override var primary: Boolean?
        get() {
            return trackReactiveGet(__v_raw, "primary", __v_raw.primary, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("primary")) {
                return;
            }
            val oldValue = __v_raw.primary;
            __v_raw.primary = value;
            triggerReactiveSet(__v_raw, "primary", oldValue, value);
        }
    override var param: String?
        get() {
            return trackReactiveGet(__v_raw, "param", __v_raw.param, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("param")) {
                return;
            }
            val oldValue = __v_raw.param;
            __v_raw.param = value;
            triggerReactiveSet(__v_raw, "param", oldValue, value);
        }
    override var index: Number?
        get() {
            return trackReactiveGet(__v_raw, "index", __v_raw.index, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("index")) {
                return;
            }
            val oldValue = __v_raw.index;
            __v_raw.index = value;
            triggerReactiveSet(__v_raw, "index", oldValue, value);
        }
}
val `default`: UTSJSONObject = object : UTSJSONObject() {
    var actionsheet = object : UTSJSONObject() {
        var cancel = "取消"
    }
    var dialog = object : UTSJSONObject() {
        var title = "提示"
        var cancel = "取消"
        var confirm = "确定"
    }
    var swipeaction = object : UTSJSONObject() {
        var `delete` = "删除"
    }
    var loading = object : UTSJSONObject() {
        var text = "加载中"
    }
    var pagination = object : UTSJSONObject() {
        var prevText = "上一页"
        var nextText = "下一页"
    }
    var loadmore = object : UTSJSONObject() {
        var initText = "上拉加载"
        var text = "正在加载..."
        var noneText = "没有更多了"
    }
};
val default1: UTSJSONObject = object : UTSJSONObject() {
    var actionsheet = object : UTSJSONObject() {
        var cancel = "取消"
    }
    var dialog = object : UTSJSONObject() {
        var title = "提示"
        var cancel = "取消"
        var confirm = "確定"
    }
    var swipeaction = object : UTSJSONObject() {
        var `delete` = "刪除"
    }
    var loading = object : UTSJSONObject() {
        var text = "載入中"
    }
    var pagination = object : UTSJSONObject() {
        var prevText = "上一頁"
        var nextText = "下一頁"
    }
    var loadmore = object : UTSJSONObject() {
        var initText = "上拉加載"
        var text = "正在加載..."
        var noneText = "沒有更多了"
    }
};
val default2: UTSJSONObject = object : UTSJSONObject() {
    var actionsheet = object : UTSJSONObject() {
        var cancel = "Cancel"
    }
    var dialog = object : UTSJSONObject() {
        var title = "Message"
        var cancel = "Cancel"
        var confirm = "OK"
    }
    var swipeaction = object : UTSJSONObject() {
        var `delete` = "Delete"
    }
    var loading = object : UTSJSONObject() {
        var text = "Loading"
    }
    var pagination = object : UTSJSONObject() {
        var prevText = "Prev page"
        var nextText = "Next page"
    }
    var loadmore = object : UTSJSONObject() {
        var initText = "Pull-up loading"
        var text = "Loading"
        var noneText = "No more"
    }
};
val default3: UTSJSONObject = object : UTSJSONObject() {
    var actionsheet = object : UTSJSONObject() {
        var cancel = "ยกเลิก"
    }
    var dialog = object : UTSJSONObject() {
        var title = "ข้อความ"
        var cancel = "ยกเลิก"
        var confirm = "ตกลง"
    }
    var swipeaction = object : UTSJSONObject() {
        var `delete` = "ลบ"
    }
    var loading = object : UTSJSONObject() {
        var text = "กำลังโหลด"
    }
    var pagination = object : UTSJSONObject() {
        var prevText = "Prev page"
        var nextText = "Next page"
    }
    var loadmore = object : UTSJSONObject() {
        var initText = "Pull-up loading"
        var text = "กำลังโหลด"
        var noneText = "ไม่มีอีกแล้ว"
    }
};
val default4: UTSJSONObject = object : UTSJSONObject() {
    var actionsheet = object : UTSJSONObject() {
        var cancel = "Отмена"
    }
    var dialog = object : UTSJSONObject() {
        var title = "Сообщение"
        var cancel = "Отмена"
        var confirm = "OK"
    }
    var swipeaction = object : UTSJSONObject() {
        var `delete` = "Удалить"
    }
    var loading = object : UTSJSONObject() {
        var text = "Загрузка"
    }
    var pagination = object : UTSJSONObject() {
        var prevText = "Prev page"
        var nextText = "Next page"
    }
    var loadmore = object : UTSJSONObject() {
        var initText = "Pull-up loading"
        var text = "Загрузка"
        var noneText = "больше не надо"
    }
};
val default5: UTSJSONObject = object : UTSJSONObject() {
    var actionsheet = object : UTSJSONObject() {
        var cancel = "إلغاء"
    }
    var dialog = object : UTSJSONObject() {
        var title = "العنوان"
        var cancel = "إلغاء"
        var confirm = "موافق"
    }
    var swipeaction = object : UTSJSONObject() {
        var `delete` = "حذف"
    }
    var loading = object : UTSJSONObject() {
        var text = "جار التحميل"
    }
    var pagination = object : UTSJSONObject() {
        var prevText = "Prev page"
        var nextText = "Next page"
    }
    var loadmore = object : UTSJSONObject() {
        var initText = "Pull-up loading"
        var text = "جار التحميل"
        var noneText = "لا أكثر"
    }
};
open class FuiLocaleLangParam (
    @JsonNotNull
    open var locale: String,
    @JsonNotNull
    open var messages: UTSJSONObject,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return FuiLocaleLangParamReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class FuiLocaleLangParamReactiveObject : FuiLocaleLangParam, IUTSReactive<FuiLocaleLangParam> {
    override var __v_raw: FuiLocaleLangParam;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: FuiLocaleLangParam, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(locale = __v_raw.locale, messages = __v_raw.messages) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): FuiLocaleLangParamReactiveObject {
        return FuiLocaleLangParamReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var locale: String
        get() {
            return trackReactiveGet(__v_raw, "locale", __v_raw.locale, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("locale")) {
                return;
            }
            val oldValue = __v_raw.locale;
            __v_raw.locale = value;
            triggerReactiveSet(__v_raw, "locale", oldValue, value);
        }
    override var messages: UTSJSONObject
        get() {
            return trackReactiveGet(__v_raw, "messages", __v_raw.messages, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("messages")) {
                return;
            }
            val oldValue = __v_raw.messages;
            __v_raw.messages = value;
            triggerReactiveSet(__v_raw, "messages", oldValue, value);
        }
}
val fuiLang = reactive(FuiLocaleLangParam(locale = "", messages = object : UTSJSONObject() {
    var cn = `default`
    var tc = default1
    var en = default2
    var th = default3
    var ru = default4
    var ar = default5
}));
val getFuiLocaleLang = fun(locale: String?): UTSJSONObject {
    var initLangData: UTSJSONObject;
    if (locale != null && locale != "") {
        initLangData = fuiLang.messages[locale] as UTSJSONObject;
    } else {
        var key = uni_getStorageSync("fui_locale_lang");
        if (key == null || key == "") {
            key = if (fuiLang.locale == "") {
                "cn";
            } else {
                fuiLang.locale;
            }
            ;
        }
        initLangData = fuiLang.messages[key] as UTSJSONObject;
    }
    return initLangData;
}
;
val GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialogClass = CreateVueComponent(GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialog::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialog.name, inheritAttrs = GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialog.inheritAttrs, inject = GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialog.inject, props = GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialog.props, propsNeedCastKeys = GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialog.propsNeedCastKeys, emits = GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialog.emits, components = GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialog.components, styles = GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialog.styles);
}
, fun(instance): GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialog {
    return GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialog(instance);
}
);
val GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheetClass = CreateVueComponent(GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheet::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheet.name, inheritAttrs = GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheet.inheritAttrs, inject = GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheet.inject, props = GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheet.props, propsNeedCastKeys = GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheet.propsNeedCastKeys, emits = GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheet.emits, components = GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheet.components, styles = GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheet.styles);
}
, fun(instance): GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheet {
    return GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheet(instance);
}
);
val GenPagesPersonCenterPersonCenterClass = CreateVueComponent(GenPagesPersonCenterPersonCenter::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesPersonCenterPersonCenter.inheritAttrs, inject = GenPagesPersonCenterPersonCenter.inject, props = GenPagesPersonCenterPersonCenter.props, propsNeedCastKeys = GenPagesPersonCenterPersonCenter.propsNeedCastKeys, emits = GenPagesPersonCenterPersonCenter.emits, components = GenPagesPersonCenterPersonCenter.components, styles = GenPagesPersonCenterPersonCenter.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesPersonCenterPersonCenter.setup(props as GenPagesPersonCenterPersonCenter);
    }
    );
}
, fun(instance): GenPagesPersonCenterPersonCenter {
    return GenPagesPersonCenterPersonCenter(instance);
}
);
val GenPagesStatisticsStatisticsClass = CreateVueComponent(GenPagesStatisticsStatistics::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesStatisticsStatistics.inheritAttrs, inject = GenPagesStatisticsStatistics.inject, props = GenPagesStatisticsStatistics.props, propsNeedCastKeys = GenPagesStatisticsStatistics.propsNeedCastKeys, emits = GenPagesStatisticsStatistics.emits, components = GenPagesStatisticsStatistics.components, styles = GenPagesStatisticsStatistics.styles);
}
, fun(instance): GenPagesStatisticsStatistics {
    return GenPagesStatisticsStatistics(instance);
}
);
val GenPagesPersonCenterMsgNotificationClass = CreateVueComponent(GenPagesPersonCenterMsgNotification::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesPersonCenterMsgNotification.inheritAttrs, inject = GenPagesPersonCenterMsgNotification.inject, props = GenPagesPersonCenterMsgNotification.props, propsNeedCastKeys = GenPagesPersonCenterMsgNotification.propsNeedCastKeys, emits = GenPagesPersonCenterMsgNotification.emits, components = GenPagesPersonCenterMsgNotification.components, styles = GenPagesPersonCenterMsgNotification.styles);
}
, fun(instance): GenPagesPersonCenterMsgNotification {
    return GenPagesPersonCenterMsgNotification(instance);
}
);
val GenPagesPersonCenterServiceProviderClass = CreateVueComponent(GenPagesPersonCenterServiceProvider::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesPersonCenterServiceProvider.inheritAttrs, inject = GenPagesPersonCenterServiceProvider.inject, props = GenPagesPersonCenterServiceProvider.props, propsNeedCastKeys = GenPagesPersonCenterServiceProvider.propsNeedCastKeys, emits = GenPagesPersonCenterServiceProvider.emits, components = GenPagesPersonCenterServiceProvider.components, styles = GenPagesPersonCenterServiceProvider.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesPersonCenterServiceProvider.setup(props as GenPagesPersonCenterServiceProvider);
    }
    );
}
, fun(instance): GenPagesPersonCenterServiceProvider {
    return GenPagesPersonCenterServiceProvider(instance);
}
);
val GenComponentsUxEditUxEditClass = CreateVueComponent(GenComponentsUxEditUxEdit::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsUxEditUxEdit.inheritAttrs, inject = GenComponentsUxEditUxEdit.inject, props = GenComponentsUxEditUxEdit.props, propsNeedCastKeys = GenComponentsUxEditUxEdit.propsNeedCastKeys, emits = GenComponentsUxEditUxEdit.emits, components = GenComponentsUxEditUxEdit.components, styles = GenComponentsUxEditUxEdit.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsUxEditUxEdit.setup(props as GenComponentsUxEditUxEdit);
    }
    );
}
, fun(instance): GenComponentsUxEditUxEdit {
    return GenComponentsUxEditUxEdit(instance);
}
);
val GenPagesPersonCenterPwdModifyClass = CreateVueComponent(GenPagesPersonCenterPwdModify::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesPersonCenterPwdModify.inheritAttrs, inject = GenPagesPersonCenterPwdModify.inject, props = GenPagesPersonCenterPwdModify.props, propsNeedCastKeys = GenPagesPersonCenterPwdModify.propsNeedCastKeys, emits = GenPagesPersonCenterPwdModify.emits, components = GenPagesPersonCenterPwdModify.components, styles = GenPagesPersonCenterPwdModify.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesPersonCenterPwdModify.setup(props as GenPagesPersonCenterPwdModify);
    }
    );
}
, fun(instance): GenPagesPersonCenterPwdModify {
    return GenPagesPersonCenterPwdModify(instance);
}
);
val GenPagesPersonCenterAboutUsClass = CreateVueComponent(GenPagesPersonCenterAboutUs::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesPersonCenterAboutUs.inheritAttrs, inject = GenPagesPersonCenterAboutUs.inject, props = GenPagesPersonCenterAboutUs.props, propsNeedCastKeys = GenPagesPersonCenterAboutUs.propsNeedCastKeys, emits = GenPagesPersonCenterAboutUs.emits, components = GenPagesPersonCenterAboutUs.components, styles = GenPagesPersonCenterAboutUs.styles);
}
, fun(instance): GenPagesPersonCenterAboutUs {
    return GenPagesPersonCenterAboutUs(instance);
}
);
fun createApp(): UTSJSONObject {
    val app = createSSRApp(GenAppClass);
    return UTSJSONObject(Map<String, Any?>(utsArrayOf(
        utsArrayOf(
            "app",
            app
        )
    )));
}
fun main(app: IApp) {
    definePageRoutes();
    defineAppConfig();
    (createApp()["app"] as VueApp).mount(app, GenUniApp());
}
open class UniAppConfig : io.dcloud.uniapp.appframe.AppConfig {
    override var name: String = "任易联";
    override var appid: String = "__UNI__9BA87F9";
    override var versionName: String = "1.0.0";
    override var versionCode: String = "100";
    override var uniCompilerVersion: String = "4.31";
    constructor() : super() {}
}
fun definePageRoutes() {
    __uniRoutes.push(UniPageRoute(path = "pages/login/login", component = GenPagesLoginLoginClass, meta = UniPageMeta(isQuit = true), style = utsMapOf("navigationStyle" to "custom")));
    __uniRoutes.push(UniPageRoute(path = "pages/index/index", component = GenPagesIndexIndexClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "设备名称")));
    __uniRoutes.push(UniPageRoute(path = "pages/device-list/device-list", component = GenPagesDeviceListDeviceListClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "设备列表")));
    __uniRoutes.push(UniPageRoute(path = "pages/device-alarm/device-alarm", component = GenPagesDeviceAlarmDeviceAlarmClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "报警")));
    __uniRoutes.push(UniPageRoute(path = "pages/person-center/person-center", component = GenPagesPersonCenterPersonCenterClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "个人中心")));
    __uniRoutes.push(UniPageRoute(path = "pages/statistics/statistics", component = GenPagesStatisticsStatisticsClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "统计")));
    __uniRoutes.push(UniPageRoute(path = "pages/person-center/msg-notification", component = GenPagesPersonCenterMsgNotificationClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "消息通知")));
    __uniRoutes.push(UniPageRoute(path = "pages/person-center/service-provider", component = GenPagesPersonCenterServiceProviderClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "服务商信息")));
    __uniRoutes.push(UniPageRoute(path = "pages/person-center/pwd-modify", component = GenPagesPersonCenterPwdModifyClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "修改密码")));
    __uniRoutes.push(UniPageRoute(path = "pages/person-center/about-us", component = GenPagesPersonCenterAboutUsClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "关于我们")));
}
val __uniTabBar: Map<String, Any?>? = utsMapOf("color" to "#7A7E83", "selectedColor" to "#465CFF", "borderStyle" to "black", "backgroundColor" to "#ffffff", "height" to "50px", "fontSize" to "10px", "iconWidth" to "24px", "spacing" to "3px", "iconfontSrc" to "static/iconfont.ttf", "list" to utsArrayOf(
    utsMapOf("pagePath" to "pages/index/index", "iconPath" to "static/icons/tabbar/ic_home_bottom_bar_home_normal.png", "selectedIconPath" to "static/icons/tabbar/ic_home_bottom_bar_home_selected.png", "text" to "首页"),
    utsMapOf("pagePath" to "pages/device-list/device-list", "iconPath" to "static/icons/tabbar/ic_home_bottom_bar_device_list_normal.png", "selectedIconPath" to "static/icons/tabbar/ic_home_bottom_bar_device_list_selected.png", "text" to "列表"),
    utsMapOf("pagePath" to "pages/device-alarm/device-alarm", "iconPath" to "static/icons/tabbar/ic_home_bottom_bar_warning_normal.png", "selectedIconPath" to "static/icons/tabbar/ic_home_bottom_bar_warning_selected.png", "text" to "报警"),
    utsMapOf("pagePath" to "pages/statistics/statistics", "iconPath" to "static/icons/tabbar/ic_home_bottom_bar_statistics_normal.png", "selectedIconPath" to "static/icons/tabbar/ic_home_bottom_bar_statistics_selected.png", "text" to "统计"),
    utsMapOf("pagePath" to "pages/person-center/person-center", "iconPath" to "static/icons/tabbar/ic_home_bottom_bar_mine_normal.png", "selectedIconPath" to "static/icons/tabbar/ic_home_bottom_bar_mine_selected.png", "text" to "个人中心")
));
val __uniLaunchPage: Map<String, Any?> = utsMapOf("url" to "pages/login/login", "style" to utsMapOf("navigationStyle" to "custom"));
fun defineAppConfig() {
    __uniConfig.entryPagePath = "/pages/login/login";
    __uniConfig.globalStyle = utsMapOf("navigationBarTextStyle" to "white", "navigationBarTitleText" to "uni-app x", "backgroundColor" to "#f1f1f1", "navigationBarBackgroundColor" to "#465CFF");
    __uniConfig.tabBar = __uniTabBar as Map<String, Any>?;
    __uniConfig.conditionUrl = "";
    __uniConfig.uniIdRouter = utsMapOf();
    __uniConfig.themeConfig = utsMapOf("light" to utsMapOf("navigationBarTextStyle" to "white", "navigationBarBackgroundColor" to "#007AFF", "backgroundColorContent" to "#efeff4", "backgroundColor" to "#efeff4", "tabBarColor" to "#7A7E83", "tabBarSelectedColor" to "#007AFF", "tabBarBorderStyle" to "black", "tabBarBackgroundColor" to "#F8F8F8", "tabBarHomeIconPath" to "static/icons/tabbar/ic_home_bottom_bar_home_normal.png", "tabBarHomeSelectedIconPath" to "static/icons/tabbar/ic_home_bottom_bar_home_selected.png"), "dark" to utsMapOf("navigationBarTextStyle" to "white", "navigationBarBackgroundColor" to "#1F1F1F", "backgroundColor" to "#1F1F1F", "backgroundColorContent" to "#646464", "tabBarColor" to "#cacaca", "tabBarSelectedColor" to "#007AFF", "tabBarBorderStyle" to "white", "tabBarBackgroundColor" to "#1F1F1F", "tabBarHomeIconPath" to "static/icons/tabbar/ic_home_bottom_bar_home_normal.png", "tabBarHomeSelectedIconPath" to "static/icons/tabbar/ic_home_bottom_bar_home_selected.png"));
    __uniConfig.ready = true;
}
open class GenUniApp : UniAppImpl() {
    open val vm: GenApp?
        get() {
            return getAppVm() as GenApp?;
        }
    open val `$vm`: GenApp?
        get() {
            return getAppVm() as GenApp?;
        }
}
fun getApp(): GenUniApp {
    return getUniApp() as GenUniApp;
}
