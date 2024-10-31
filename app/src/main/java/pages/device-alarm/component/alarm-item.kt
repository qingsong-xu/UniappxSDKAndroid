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
open class GenPagesDeviceAlarmComponentAlarmItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "item-container"), utsArrayOf(
            createElementVNode("text", utsMapOf("class" to "item-title"), "东风"),
            createElementVNode("text", utsMapOf("class" to "item-label"), "信号：2020-09-01 18:55:20"),
            createElementVNode("text", utsMapOf("class" to "item-label"), "报警：2020-09-01 18:55:20"),
            createElementVNode("view", utsMapOf("class" to "common-gray-line")),
            createElementVNode("text", utsMapOf("class" to "item-status"), "车辆已点火")
        ));
    }
    companion object {
        var name = "alarm-cell";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("item-container" to padStyleMapOf(utsMapOf("flexDirection" to "column", "backgroundColor" to "#ffffff", "borderRadius" to "10rpx", "boxShadow" to "3px 3px 3px #ccc", "marginTop" to "12rpx", "marginRight" to "24rpx", "marginBottom" to "12rpx", "marginLeft" to "24rpx")), "item-title" to padStyleMapOf(utsMapOf("color" to "#ffffff", "backgroundColor" to "#52aafa", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to 0, "borderBottomLeftRadius" to 0, "paddingTop" to "8rpx", "paddingRight" to "8rpx", "paddingBottom" to "8rpx", "paddingLeft" to "8rpx")), "item-label" to padStyleMapOf(utsMapOf("paddingTop" to "8rpx", "paddingRight" to "8rpx", "paddingBottom" to "8rpx", "paddingLeft" to "8rpx")), "item-status" to padStyleMapOf(utsMapOf("color" to "#ffffff", "backgroundColor" to "#f55642", "width" to "200rpx", "height" to "40rpx", "lineHeight" to "40rpx", "flexDirection" to "row", "alignItems" to "center", "textAlign" to "center", "borderRadius" to "4rpx", "justifyContent" to "center", "marginTop" to "16rpx", "marginRight" to "8rpx", "marginBottom" to "16rpx", "marginLeft" to "8rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
