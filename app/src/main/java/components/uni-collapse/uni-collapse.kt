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
open class GenComponentsUniCollapseUniCollapse : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", null, utsArrayOf(
            renderSlot(_ctx.`$slots`, "default")
        ));
    }
    open var accordion: Boolean by `$props`;
    open var child_nodes: UTSArray<ComponentPublicInstance> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("child_nodes" to utsArrayOf<ComponentPublicInstance>());
    }
    override fun `$initMethods`() {
        this.init = fun(child: ComponentPublicInstance) {
            this.child_nodes.push(child);
        }
        ;
        this.cloceAll = fun() {
            if (this.accordion && this.child_nodes.length > 0) {
                this.child_nodes.forEach(fun(item){
                    val is_open = item.`$data`["is_open"] as Boolean;
                    if (is_open) {
                        item.`$data`["is_open"] = false;
                        item.`$callMethod`("openOrClose", false);
                    }
                }
                );
            }
        }
        ;
    }
    open lateinit var init: (child: ComponentPublicInstance) -> Unit;
    open lateinit var cloceAll: () -> Unit;
    companion object {
        var name = "UniCollapse";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf());
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("accordion" to utsMapOf("type" to "Boolean", "default" to true)));
        var propsNeedCastKeys = utsArrayOf(
            "accordion"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
