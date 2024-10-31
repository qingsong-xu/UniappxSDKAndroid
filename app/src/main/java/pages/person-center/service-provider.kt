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
open class GenPagesPersonCenterServiceProvider : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesPersonCenterServiceProvider) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesPersonCenterServiceProvider;
            val _cache = __ins.renderCache;
            var serviceName = ref("系统管理员");
            var contact = ref("xxx");
            var phone = ref("xxx");
            var address = ref("xxx");
            return fun(): Any? {
                return createElementVNode("view", utsMapOf("class" to "page-container"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "logo-container"), utsArrayOf(
                        createElementVNode("image"),
                        createElementVNode("text", null, "任易联")
                    )),
                    createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
                        createElementVNode("text", null, "服务商名称：" + toDisplayString(unref(serviceName)), 1),
                        createElementVNode("text", null, "联系人：" + toDisplayString(unref(contact)), 1),
                        createElementVNode("text", null, "电话：" + toDisplayString(unref(phone)), 1),
                        createElementVNode("text", null, "地址：" + toDisplayString(unref(address)), 1)
                    ), 4)
                ));
            }
            ;
        }
        ;
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(), utsArrayOf(
                    GenApp.styles
                ));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
