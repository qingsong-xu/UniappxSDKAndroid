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
open class GenPagesPersonCenterPwdModify : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesPersonCenterPwdModify) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesPersonCenterPwdModify;
            val _cache = __ins.renderCache;
            fun genModifyPwdFn() {
                console.log("修改密码");
            }
            val modifyPwd = ::genModifyPwdFn;
            return fun(): Any? {
                val _component_ux_edit = resolveEasyComponent("ux-edit", GenComponentsUxEditUxEditClass);
                val _component_fui_button = resolveEasyComponent("fui-button", GenUniModulesFirstuiUnixComponentsFuiButtonFuiButtonClass);
                return createElementVNode("view", utsMapOf("class" to "page-container common-gray-bg"), utsArrayOf(
                    createVNode(_component_ux_edit, utsMapOf("label" to "旧密码", "placeholder" to "请输入旧密码")),
                    createVNode(_component_ux_edit, utsMapOf("label" to "新密码", "placeholder" to "请输入新密码")),
                    createVNode(_component_ux_edit, utsMapOf("label" to "确认新密码", "placeholder" to "请再次输入新密码")),
                    createElementVNode("view", utsMapOf("class" to "btn-box"), utsArrayOf(
                        createVNode(_component_fui_button, utsMapOf("text" to "确定", "radius" to "20rpx", "width" to "80%", "onClick" to modifyPwd))
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
                return utsMapOf("btn-box" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "marginTop" to "40rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
