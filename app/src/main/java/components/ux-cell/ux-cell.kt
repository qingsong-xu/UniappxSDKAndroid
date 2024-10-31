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
open class GenComponentsUxCellUxCell : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "common-cell-item", "hover-class" to "hover"), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "common-row"), utsArrayOf(
                createElementVNode("image", utsMapOf("src" to _ctx.icon, "class" to "common-icon-size"), null, 8, utsArrayOf(
                    "src"
                )),
                createElementVNode("text", utsMapOf("class" to "margin-left"), toDisplayString(_ctx.title), 1)
            )),
            if (isTrue(_ctx.rightArrow)) {
                createElementVNode("image", utsMapOf("key" to 0, "src" to _ctx.arrowRightIcon, "class" to "common-icon-size"), null, 8, utsArrayOf(
                    "src"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
        ));
    }
    open var title: String by `$props`;
    open var size: Number by `$props`;
    open var color: String by `$props`;
    open var icon: String by `$props`;
    open var rightArrow: Boolean by `$props`;
    open var arrowRightIcon: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("arrowRightIcon" to "/static/icons/arrow-right.png" as String);
    }
    companion object {
        var name = "ux-cell";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("hover" to padStyleMapOf(utsMapOf("backgroundColor" to "#dbdbdb")), "margin-left" to padStyleMapOf(utsMapOf("marginLeft" to "20rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("title" to utsMapOf("type" to "String", "required" to true), "size" to utsMapOf("type" to "Number", "default" to 18), "color" to utsMapOf("type" to "String", "default" to "#000000"), "icon" to utsMapOf("type" to "String", "default" to ""), "rightArrow" to utsMapOf("type" to "Boolean", "default" to true)));
        var propsNeedCastKeys = utsArrayOf(
            "size",
            "color",
            "icon",
            "rightArrow"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
