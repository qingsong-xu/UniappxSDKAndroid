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
open class GenComponentsUxEditUxEdit : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var label: Any? by `$props`;
    open var placeholder: Any? by `$props`;
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsUxEditUxEdit) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenComponentsUxEditUxEdit;
            val _cache = __ins.renderCache;
            val props = __props;
            var mLabel = ref(props.label);
            var mPlaceholder = ref(props.placeholder);
            return fun(): Any? {
                return createElementVNode("view", utsMapOf("class" to "cell-edit"), utsArrayOf(
                    createElementVNode("text", null, toDisplayString(unref(mLabel)), 1),
                    createElementVNode("input", utsMapOf("class" to "cell-input", "placeholder" to unref(mPlaceholder)), null, 8, utsArrayOf(
                        "placeholder"
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
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("cell-edit" to padStyleMapOf(utsMapOf("flexDirection" to "row", "height" to "80rpx", "width" to "100%", "backgroundColor" to "#ffffff", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to "16rpx", "paddingBottom" to 0, "paddingLeft" to "16rpx", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#f0f0f0")), "cell-input" to utsMapOf(".cell-edit " to utsMapOf("flex" to 1, "textAlign" to "right")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("label" to utsMapOf(), "placeholder" to utsMapOf()));
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
