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
open class GenComponentsUniCollapseItemUniCollapseItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onCreated(fun() {
            `$dispatch`(this, "UniCollapse", "init", this);
        }
        , __ins);
        onMounted(fun() {
            this.boxNode = this.`$refs`["boxRef"] as UniElement;
            this.contentNode = this.`$refs`["contentRef"] as UniElement;
        }
        , __ins);
        this.`$watch`(fun(): Any? {
            return this.open;
        }
        , fun(value: Boolean) {
            if (this.boxNode != null) {
                this.openCollapse(value);
            }
        }
        );
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "uni-collapse-item"), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "uni-collapse-item__title", "onClick" to fun(){
                _ctx.openCollapse(!_ctx.is_open);
            }
            ), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to normalizeClass(utsArrayOf(
                    "uni-collapse-item__title-text",
                    utsMapOf("is-disabled" to _ctx.disabled, "open--active" to _ctx.is_open)
                ))), toDisplayString(_ctx.title), 3),
                createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                    "down_arrow",
                    utsMapOf("down_arrow--active" to _ctx.is_open)
                ))), null, 2)
            ), 8, utsArrayOf(
                "onClick"
            )),
            createElementVNode("view", utsMapOf("ref" to "boxRef", "class" to "uni-collapse-item__content"), utsArrayOf(
                createElementVNode("view", utsMapOf("ref" to "contentRef", "class" to "uni-collapse-item__content-box"), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "default")
                ), 512)
            ), 512)
        ));
    }
    open var title: String by `$props`;
    open var open: Boolean by `$props`;
    open var disabled: Boolean by `$props`;
    open var height: Number by `$data`;
    open var is_open: Boolean by `$data`;
    open var boxNode: UniElement? by `$data`;
    open var contentNode: UniElement? by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("height" to 0, "is_open" to this.`$props`["open"] as Boolean, "boxNode" to null as UniElement?, "contentNode" to null as UniElement?);
    }
    override fun `$initMethods`() {
        this.openCollapse = fun(open: Boolean) {
            if (this.disabled) {
                return;
            }
            `$dispatch`(this, "UniCollapse", "cloceAll");
            this.is_open = open;
            this.openOrClose(open);
        }
        ;
        this.openOrClose = fun(open: Boolean) {
            val boxNode = this.boxNode?.style!!;
            val contentNode = this.contentNode?.style!!;
            var hide = if (open) {
                "flex";
            } else {
                "none";
            }
            ;
            val opacity = if (open) {
                "1";
            } else {
                "0";
            }
            ;
            var ani_transform = if (open) {
                "translateY(0)";
            } else {
                "translateY(-100%)";
            }
            ;
            boxNode.setProperty("display", hide);
            this.`$nextTick`(fun(){
                contentNode.setProperty("transform", ani_transform);
                contentNode.setProperty("opacity", opacity);
            }
            );
        }
        ;
    }
    open lateinit var openCollapse: (open: Boolean) -> Unit;
    open lateinit var openOrClose: (open: Boolean) -> Unit;
    companion object {
        var name = "UniCollapseItem";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("uni-collapse-item" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#dddddd")), "uni-collapse-item__title" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "paddingTop" to 12, "paddingRight" to 12, "paddingBottom" to 12, "paddingLeft" to 12, "backgroundColor" to "#ffffff")), "down_arrow" to padStyleMapOf(utsMapOf("width" to 8, "height" to 8, "transform" to "rotate(-45deg)", "borderRightWidth" to 1, "borderRightStyle" to "solid", "borderRightColor" to "#999999", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#999999", "marginTop" to -3, "transitionProperty" to "transform", "transitionDuration" to "0.2s")), "down_arrow--active" to padStyleMapOf(utsMapOf("transform" to "rotate(45deg)", "marginTop" to 0)), "uni-collapse-item__title-text" to padStyleMapOf(utsMapOf("flex" to 1, "color" to "#000000", "fontSize" to 14, "fontWeight" to "400")), "open--active" to padStyleMapOf(utsMapOf("color" to "#bbbbbb")), "is-disabled" to padStyleMapOf(utsMapOf("color" to "#999999")), "uni-collapse-item__content" to padStyleMapOf(utsMapOf("display" to "none", "position" to "relative")), "uni-collapse-item__content-box" to padStyleMapOf(utsMapOf("width" to "100%", "transitionProperty" to "transform,opacity", "transitionDuration" to "0.2s", "transform" to "translateY(-100%)", "opacity" to 0)), "@TRANSITION" to utsMapOf("down_arrow" to utsMapOf("property" to "transform", "duration" to "0.2s"), "uni-collapse-item__content-box" to utsMapOf("property" to "transform,opacity", "duration" to "0.2s")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("title" to utsMapOf("type" to "String", "default" to ""), "open" to utsMapOf("type" to "Boolean", "default" to false), "disabled" to utsMapOf("type" to "Boolean", "default" to false)));
        var propsNeedCastKeys = utsArrayOf(
            "title",
            "open",
            "disabled"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
