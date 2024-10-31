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
import io.dcloud.uniapp.extapi.getStorage as uni_getStorage;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.setStorageSync as uni_setStorageSync;
open class GenPagesPersonCenterPersonCenter : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesPersonCenterPersonCenter) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesPersonCenterPersonCenter;
            val _cache = __ins.renderCache;
            var msgIcon = ref("/static/icons/mine/ic_mine_message.png");
            var serverIcon = ref("/static/icons/mine/ic_mine_server.png");
            var refreshIcon = ref("/static/icons/mine/ic_mine_clock.png");
            var editIcon = ref("/static/icons/mine/ic_mine_edit.png");
            var mapIcon = ref("/static/icons/mine/ic_mine_map.png");
            var usIcon = ref("/static/icons/mine/ic_mine_us.png");
            var outIcon = ref("/static/icons/mine/ic_mine_out.png");
            onLoad(fun(options: OnLoadOptions){
                uni_getStorage(GetStorageOptions(key = "userInfo", success = fun(res){}, fail = fun(res){
                    console.log("fail", res);
                }
                , complete = fun(res){}));
            }
            );
            fun genGoMsgNotificationFn() {
                uni_navigateTo(NavigateToOptions(url = "/pages/person-center/msg-notification"));
            }
            val goMsgNotification = ::genGoMsgNotificationFn;
            fun genGoServiceProviderFn() {
                uni_navigateTo(NavigateToOptions(url = "/pages/person-center/service-provider"));
            }
            val goServiceProvider = ::genGoServiceProviderFn;
            fun genGoPwdModifyFn() {
                uni_navigateTo(NavigateToOptions(url = "/pages/person-center/pwd-modify"));
            }
            val goPwdModify = ::genGoPwdModifyFn;
            var content = ref("是否确定退出登录？");
            var showExitAppDialog = ref(false);
            fun genShowExitDialogFn() {
                showExitAppDialog.value = true;
            }
            val showExitDialog = ::genShowExitDialogFn;
            fun genOnCloseFn() {
                showExitAppDialog.value = false;
            }
            val onClose = ::genOnCloseFn;
            fun genOnclickFn(e: FuiDialogButtonsParam) {
                console.log(e);
                onClose();
                uni_exit(ExitOptions(success = fun(res: ExitSuccess){
                    console.log("exit success", res);
                }
                , fail = fun(res: IExitError){
                    console.log("exit fail", res);
                }
                , complete = fun(res: Any){
                    console.log("exit success", res);
                }
                ));
            }
            val onclick = ::genOnclickFn;
            fun genGoAboutUsFn() {
                uni_navigateTo(NavigateToOptions(url = "/pages/person-center/about-us"));
            }
            val goAboutUs = ::genGoAboutUsFn;
            var showMapSelector = ref(false);
            var tips = ref("请选择地图类型");
            var itemList = ref(utsArrayOf<FuiActionSheetItemParam>(FuiActionSheetItemParam(text = "高德地图"), FuiActionSheetItemParam(text = "百度地图")));
            fun genGoSelectMapSourceFn() {
                showMapSelector.value = true;
            }
            val goSelectMapSource = ::genGoSelectMapSourceFn;
            fun genItemClickFn(e: FuiActionSheetItemParam) {
                console.log(JSON.stringify(e));
                showMapSelector.value = false;
                uni_setStorageSync(MAP_SOURCE, e.text);
            }
            val itemClick = ::genItemClickFn;
            return fun(): Any? {
                val _component_ux_cell = resolveEasyComponent("ux-cell", GenComponentsUxCellUxCellClass);
                val _component_fui_dialog = resolveEasyComponent("fui-dialog", GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialogClass);
                val _component_fui_actionsheet = resolveEasyComponent("fui-actionsheet", GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheetClass);
                return createElementVNode(Fragment, null, utsArrayOf(
                    createElementVNode("scroll-view", utsMapOf("class" to "page-container common-gray-bg"), utsArrayOf(
                        createVNode(_component_ux_cell, utsMapOf("title" to "消息通知", "icon" to unref(msgIcon), "onClick" to goMsgNotification), null, 8, utsArrayOf(
                            "icon"
                        )),
                        createVNode(_component_ux_cell, utsMapOf("title" to "服务商信息", "icon" to unref(serverIcon), "onClick" to goServiceProvider), null, 8, utsArrayOf(
                            "icon"
                        )),
                        createVNode(_component_ux_cell, utsMapOf("title" to "刷新设置", "icon" to unref(refreshIcon)), null, 8, utsArrayOf(
                            "icon"
                        )),
                        createVNode(_component_ux_cell, utsMapOf("title" to "修改密码", "icon" to unref(editIcon), "onClick" to goPwdModify), null, 8, utsArrayOf(
                            "icon"
                        )),
                        createVNode(_component_ux_cell, utsMapOf("title" to "地图来源", "icon" to unref(mapIcon), "onClick" to goSelectMapSource), null, 8, utsArrayOf(
                            "icon"
                        )),
                        createVNode(_component_ux_cell, utsMapOf("title" to "关于我们", "icon" to unref(usIcon), "onClick" to goAboutUs), null, 8, utsArrayOf(
                            "icon"
                        )),
                        createVNode(_component_ux_cell, utsMapOf("title" to "退出", "icon" to unref(outIcon), "class" to "margin-top", "onClick" to showExitDialog), null, 8, utsArrayOf(
                            "icon"
                        ))
                    )),
                    createVNode(_component_fui_dialog, utsMapOf("visible" to unref(showExitAppDialog), "onUpdate:visible" to fun(`$event`: Boolean){
                        showExitAppDialog = trySetRefValue(showExitAppDialog, `$event`);
                    }
                    , "content" to unref(content), "maskClosable" to true, "onOnclick" to onclick, "onClose" to onClose), null, 8, utsArrayOf(
                        "visible",
                        "content"
                    )),
                    createVNode(_component_fui_actionsheet, utsMapOf("visible" to unref(showMapSelector), "onUpdate:visible" to fun(`$event`: Boolean){
                        showMapSelector = trySetRefValue(showMapSelector, `$event`);
                    }
                    , "tips" to unref(tips), "itemList" to unref(itemList), "onOnclick" to itemClick), null, 8, utsArrayOf(
                        "visible",
                        "tips",
                        "itemList"
                    ))
                ), 64);
            }
            ;
        }
        ;
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
                return utsMapOf("margin-top" to padStyleMapOf(utsMapOf("marginTop" to "40rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
