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
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab;
open class GenPagesLoginLogin : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesLoginLogin) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesLoginLogin;
            val _cache = __ins.renderCache;
            var phone = ref("");
            var pwd = ref("");
            fun genLoginFn() {
                uni_showLoading(ShowLoadingOptions(title = "请求中..."));
                uni_switchTab(SwitchTabOptions(url = "/pages/index/index"));
            }
            val login = ::genLoginFn;
            return fun(): Any? {
                val _component_form = resolveComponent("form");
                return createElementVNode("view", utsMapOf("class" to "page-container"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "img-a"), utsArrayOf(
                        createElementVNode("image", utsMapOf("src" to "/static/image/head.png", "class" to "img-bg")),
                        createElementVNode("view", utsMapOf("class" to "t-b"), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "txt"), "您好，"),
                            createElementVNode("text", utsMapOf("class" to "txt magin-top"), "欢迎使用任易联")
                        ))
                    )),
                    createElementVNode("view", utsMapOf("class" to "login-view"), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "t-login"), utsArrayOf(
                            createVNode(_component_form, utsMapOf("class" to "cl"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "t-a"), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "txt"), "账号"),
                                        createElementVNode("input", utsMapOf("class" to "t-login-input", "type" to "number", "name" to "phone", "placeholder" to "请输入您的账号", "maxlength" to "11", "modelValue" to unref(phone), "onInput" to fun(`$event`: InputEvent){
                                            phone = trySetRefValue(phone, `$event`.detail.value);
                                        }
                                        ), null, 40, utsArrayOf(
                                            "modelValue"
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "t-a"), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "txt"), "密码"),
                                        createElementVNode("input", utsMapOf("class" to "t-login-input", "type" to "password", "name" to "code", "maxlength" to "18", "placeholder" to "请输入您的密码", "modelValue" to unref(pwd), "onInput" to fun(`$event`: InputEvent){
                                            pwd = trySetRefValue(pwd, `$event`.detail.value);
                                        }
                                        ), null, 40, utsArrayOf(
                                            "modelValue"
                                        ))
                                    )),
                                    createElementVNode("button", utsMapOf("class" to "t-login-button", "onClick" to fun(){
                                        login();
                                    }
                                    ), "登 录", 8, utsArrayOf(
                                        "onClick"
                                    ))
                                );
                            }
                            ), "_" to 1))
                        ))
                    ))
                ));
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
                return utsMapOf("img-a" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "450rpx", "position" to "relative")), "t-b" to utsMapOf(".img-a " to utsMapOf("position" to "absolute", "left" to "100rpx", "top" to "100rpx")), "txt" to utsMapOf(".img-a .t-b " to utsMapOf("fontSize" to "48rpx", "color" to "#ffffff", "fontWeight" to "bold")), "magin-top" to padStyleMapOf(utsMapOf("marginTop" to "10rpx")), "img-bg" to utsMapOf(".img-a " to utsMapOf("width" to "100%", "height" to "100%", "position" to "absolute", "left" to 0, "top" to 0, "right" to 0, "bottom" to 0)), "login-view" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative", "marginTop" to "-120rpx", "backgroundColor" to "#ffffff", "borderTopLeftRadius" to "24rpx", "borderTopRightRadius" to "24rpx", "borderBottomRightRadius" to 0, "borderBottomLeftRadius" to 0)), "t-login" to padStyleMapOf(utsMapOf("width" to "600rpx", "marginTop" to 0, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto", "fontSize" to "28rpx", "paddingTop" to "80rpx")), "t-login-button" to utsMapOf(".t-login " to utsMapOf("fontSize" to "28rpx", "backgroundImage" to "none", "backgroundColor" to "#2796f2", "color" to "#ffffff", "height" to "90rpx", "lineHeight" to "90rpx", "borderRadius" to "50rpx", "fontWeight" to "bold")), "t-login-input" to utsMapOf(".t-login " to utsMapOf("height" to "90rpx", "lineHeight" to "90rpx", "marginBottom" to "50rpx", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#e9e9e9", "fontSize" to "28rpx")), "t-a" to utsMapOf(".t-login " to utsMapOf("position" to "relative")), "t-c" to utsMapOf(".t-login " to utsMapOf("position" to "absolute", "right" to "22rpx", "top" to "22rpx", "backgroundImage" to "none", "backgroundColor" to "#5677fc", "color" to "#ffffff", "fontSize" to "24rpx", "borderRadius" to "50rpx", "height" to "50rpx", "lineHeight" to "50rpx", "paddingTop" to 0, "paddingRight" to "25rpx", "paddingBottom" to 0, "paddingLeft" to "25rpx")), "t-d" to utsMapOf(".t-login " to utsMapOf("textAlign" to "center", "color" to "#999999", "marginTop" to "80rpx", "marginRight" to 0, "marginBottom" to "80rpx", "marginLeft" to 0)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
