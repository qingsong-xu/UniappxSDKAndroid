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
open class GenUniModulesFirstuiUnixComponentsFuiDialogFuiDialog : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.`$nextTick`(fun(){
                setTimeout(fun(){
                    if (!this.isShow) {
                        this.close();
                    }
                }
                , 50);
            }
            );
        }
        , __ins);
        this.`$watch`(fun(): Any? {
            return this.visible;
        }
        , fun(newVal: Boolean) {
            if (newVal) {
                this.open();
            } else {
                if (this.isShow) {
                    this.close();
                }
            }
        }
        , WatchOptions(immediate = true));
        this.`$watch`(fun(): Any? {
            return this.locale;
        }
        , fun(kVal: String) {
            val lang = getFuiLocaleLang(kVal);
            val dialog = lang["dialog"] as UTSJSONObject;
            this.d_title = if (this.title == "fui_def") {
                (dialog.getString("title") as String);
            } else {
                this.title;
            }
            ;
            val btns = JSON.parse<UTSArray<FuiDialogButtonsParam>>(JSON.stringify(this.buttons));
            if (btns == null || btns.length == 0) {
                val param = utsArrayOf<FuiDialogButtonsParam>(FuiDialogButtonsParam(text = dialog.getString("cancel") as String), FuiDialogButtonsParam(text = dialog.getString("confirm") as String, primary = true));
                this.getButtons(param);
            } else {
                this.getButtons(btns);
            }
        }
        , WatchOptions(immediate = true));
        this.`$watch`(fun(): Any? {
            return this.buttons;
        }
        , fun(vals: UTSArray<FuiDialogButtonsParam>) {
            this.getButtons(vals);
        }
        );
        this.`$watch`(fun(): Any? {
            return this.title;
        }
        , fun(kVal: String) {
            if (kVal != "fui_def") {
                this.d_title = this.title;
            }
        }
        );
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("ref" to _ctx.refId, "class" to normalizeClass(utsArrayOf(
            "fui-dialog__wrap",
            utsMapOf("fui-dialog__mask-bg" to (_ctx.maskBackground == ""))
        )), "style" to normalizeStyle(utsMapOf("background" to _ctx.maskBackground, "zIndex" to _ctx.zIndex)), "onClick" to _ctx.maskClose), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                "fui-dialog__inner",
                utsMapOf("fui-dialog__bg" to (_ctx.background == ""))
            )), "style" to normalizeStyle(utsMapOf("background" to _ctx.background, "borderRadius" to ("" + _ctx.radius + "rpx")))), utsArrayOf(
                if (_ctx.title != "") {
                    createElementVNode("text", utsMapOf("key" to 0, "class" to normalizeClass(utsArrayOf(
                        "fui-dialog__title",
                        utsMapOf("fui-dialog__title-color" to (_ctx.color == ""))
                    )), "style" to normalizeStyle(_ctx.getTitleStyl)), toDisplayString(_ctx.d_title), 7);
                } else {
                    createCommentVNode("v-if", true);
                }
                ,
                createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                    "fui-dialog__body",
                    utsMapOf("fui-dialog__mtop" to (_ctx.title == ""))
                ))), utsArrayOf(
                    if (_ctx.content != "") {
                        createElementVNode("text", utsMapOf("key" to 0, "class" to normalizeClass(utsArrayOf(
                            "fui-dialog__descr",
                            utsMapOf("fui-dialog__descr-color" to (_ctx.contentColor == ""))
                        )), "style" to normalizeStyle(_ctx.getContentStyl)), toDisplayString(_ctx.content), 7);
                    } else {
                        createCommentVNode("v-if", true);
                    }
                    ,
                    renderSlot(_ctx.`$slots`, "default")
                ), 2),
                createElementVNode("view", utsMapOf("class" to "fui-dialog__footer"), utsArrayOf(
                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.btns, fun(item, index, __index, _cached): Any {
                        return createElementVNode("text", utsMapOf("key" to index, "style" to normalizeStyle(_ctx.getBtnStyl(item.color)), "class" to normalizeClass(utsArrayOf(
                            "fui-dialog__btn",
                            utsMapOf("fui-dialog__btn-active" to (index == _ctx.current), "fui-dialog__btn-first" to (index == 0), "fui-dialog__btn-color" to ((item.color == null || item.color == "") && (item.primary == null || item.primary == false)), "fui-dialog__color-primary" to ((item.color == null || item.color == "") && item.primary == true))
                        )), "onClick" to fun(){
                            _ctx.handleClick(index);
                        }
                        , "onTouchstart" to fun(){
                            _ctx.onTouchstart(index);
                        }
                        , "onTouchend" to _ctx.onEnd, "onTouchcancel" to _ctx.onEnd), toDisplayString(item.text), 47, utsArrayOf(
                            "onClick",
                            "onTouchstart",
                            "onTouchend",
                            "onTouchcancel"
                        ));
                    }
                    ), 128)
                ))
            ), 6)
        ), 14, utsArrayOf(
            "onClick"
        ));
    }
    open var visible: Boolean by `$props`;
    open var title: String by `$props`;
    open var color: String by `$props`;
    open var content: String by `$props`;
    open var contentColor: String by `$props`;
    open var buttons: UTSArray<FuiDialogButtonsParam> by `$props`;
    open var background: String by `$props`;
    open var radius: Number by `$props`;
    open var maskBackground: String by `$props`;
    open var maskClosable: Boolean by `$props`;
    open var zIndex: Number by `$props`;
    open var refId: Any? by `$data`;
    open var isShow: Boolean by `$data`;
    open var element: UniElement? by `$data`;
    open var current: Number by `$data`;
    open var btns: UTSArray<FuiDialogButtonsParam> by `$data`;
    open var d_title: String by `$data`;
    open var locale: String by `$data`;
    open var getTitleStyl: Any by `$data`;
    open var getContentStyl: Any by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        val refId = "fui_dialog_" + parseInt(Math.ceil(Math.random() * 10e5).toString(), 36);
        return utsMapOf("refId" to refId, "isShow" to false, "element" to null as UniElement?, "current" to -1, "btns" to utsArrayOf<FuiDialogButtonsParam>(), "d_title" to "", "locale" to computed<String>(fun(): String {
            return fuiLang.locale;
        }
        ), "getTitleStyl" to computed<Any>(fun(): Any {
            val mp: Map<String, String> = Map();
            if (this.color != "") {
                mp.set("color", this.color);
            }
            return mp;
        }
        ), "getContentStyl" to computed<Any>(fun(): Any {
            val mp: Map<String, String> = Map();
            if (this.contentColor != "") {
                mp.set("color", this.contentColor);
            }
            return mp;
        }
        ));
    }
    override fun `$initMethods`() {
        this.getBtnStyl = fun(color: String?): Any {
            val mp: Map<String, String> = Map();
            if (color != "" && color != null) {
                mp.set("color", color);
            }
            return mp;
        }
        ;
        this.getButtons = fun(vals: UTSArray<FuiDialogButtonsParam>) {
            this.btns = utsArrayOf<FuiDialogButtonsParam>();
            this.`$nextTick`(fun(){
                this.btns = vals;
            }
            );
        }
        ;
        this.handleClick = fun(index: Number) {
            val item = this.btns[index];
            item.index = index;
            this.`$emit`("onclick", item);
        }
        ;
        this.maskClose = fun() {
            if (!this.maskClosable) {
                return;
            }
            this.`$emit`("close");
            this.`$emit`("update:visible", false);
        }
        ;
        this.open = fun() {
            this.isShow = true;
            this.`$nextTick`(fun(){
                setTimeout(fun(){
                    this._animation(true);
                }
                , 50);
            }
            );
        }
        ;
        this.close = fun() {
            this.isShow = false;
            this._animation(false);
        }
        ;
        this._animation = fun(visible: Boolean) {
            if (this.element == null) {
                this.element = this.`$refs`[this.refId] as UniElement;
            }
            this.element!!.style.setProperty("opacity", if (visible) {
                "1";
            } else {
                "0";
            }
            );
            if (visible) {
                this.element!!.style.setProperty("visibility", "visible");
            } else {
                setTimeout(fun(){
                    this.element!!.style.setProperty("visibility", "hidden");
                }
                , 250);
            }
        }
        ;
        this.onTouchstart = fun(index: Number) {
            this.current = index;
        }
        ;
        this.onEnd = fun() {
            this.current = -1;
        }
        ;
    }
    open lateinit var getBtnStyl: (color: String?) -> Any;
    open lateinit var getButtons: (vals: UTSArray<FuiDialogButtonsParam>) -> Unit;
    open lateinit var handleClick: (index: Number) -> Unit;
    open lateinit var maskClose: () -> Unit;
    open lateinit var open: () -> Unit;
    open lateinit var close: () -> Unit;
    open lateinit var _animation: (visible: Boolean) -> Unit;
    open lateinit var onTouchstart: (index: Number) -> Unit;
    open lateinit var onEnd: () -> Unit;
    companion object {
        var name = "fui-dialog";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("fui-dialog__wrap" to padStyleMapOf(utsMapOf("position" to "fixed", "width" to "100%", "height" to "100%", "top" to 0, "right" to 0, "left" to 0, "bottom" to 0, "transitionTimingFunction" to "ease-in", "transitionProperty" to "visibility,opacity", "transitionDuration" to "0.25s", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "visibility" to "hidden", "opacity" to 0)), "fui-dialog__inner" to padStyleMapOf(utsMapOf("width" to "680rpx", "display" to "flex", "flexDirection" to "column", "overflow" to "hidden")), "fui-dialog__title" to padStyleMapOf(utsMapOf("paddingTop" to "64rpx", "paddingRight" to "48rpx", "paddingBottom" to 0, "paddingLeft" to "48rpx", "fontWeight" to "700", "fontSize" to "34rpx", "textAlign" to "center")), "fui-dialog__body" to padStyleMapOf(utsMapOf("paddingTop" to "32rpx", "paddingRight" to "48rpx", "paddingBottom" to "32rpx", "paddingLeft" to "48rpx", "marginBottom" to "32rpx")), "fui-dialog__descr" to padStyleMapOf(utsMapOf("fontSize" to "30rpx", "fontWeight" to "normal", "textAlign" to "center")), "fui-dialog__mtop" to padStyleMapOf(utsMapOf("marginTop" to "32rpx")), "fui-dialog__footer" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "position" to "relative", "height" to "112rpx", "borderTopWidth" to 0.5, "borderTopStyle" to "solid", "borderTopColor" to "#EEEEEE")), "fui-dialog__btn" to padStyleMapOf(utsMapOf("flex" to 1, "height" to "112rpx", "lineHeight" to "112rpx", "fontWeight" to "700", "position" to "relative", "fontSize" to "34rpx", "borderLeftWidth" to 0.5, "borderLeftStyle" to "solid", "borderLeftColor" to "#EEEEEE", "textAlign" to "center")), "fui-dialog__btn-active" to padStyleMapOf(utsMapOf("backgroundImage" to "none", "backgroundColor" to "rgba(0,0,0,0.2)")), "fui-dialog__btn-first" to padStyleMapOf(utsMapOf("!borderLeftWidth" to 0)), "fui-dialog__mask-bg" to padStyleMapOf(utsMapOf("!backgroundImage" to "none", "!backgroundColor" to "rgba(0,0,0,0.6)")), "fui-dialog__title-color" to padStyleMapOf(utsMapOf("!color" to "#333333")), "fui-dialog__descr-color" to padStyleMapOf(utsMapOf("!color" to "#7F7F7F")), "fui-dialog__bg" to padStyleMapOf(utsMapOf("!backgroundImage" to "none", "!backgroundColor" to "#FFFFFF")), "fui-dialog__btn-color" to padStyleMapOf(utsMapOf("!color" to "#333333")), "fui-dialog__color-primary" to padStyleMapOf(utsMapOf("!color" to "#465CFF")), "@TRANSITION" to utsMapOf("fui-dialog__wrap" to utsMapOf("timingFunction" to "ease-in", "property" to "visibility,opacity", "duration" to "0.25s")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("onclick" to null, "close" to null, "update:visible" to null);
        var props = normalizePropsOptions(utsMapOf("visible" to utsMapOf("type" to "Boolean", "default" to false), "title" to utsMapOf("type" to "String", "default" to "fui_def"), "color" to utsMapOf("type" to "String", "default" to ""), "content" to utsMapOf("type" to "String", "default" to ""), "contentColor" to utsMapOf("type" to "String", "default" to ""), "buttons" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<FuiDialogButtonsParam> {
            return utsArrayOf<FuiDialogButtonsParam>();
        }
        ), "background" to utsMapOf("type" to "String", "default" to ""), "radius" to utsMapOf("type" to "Number", "default" to 24), "maskBackground" to utsMapOf("type" to "String", "default" to ""), "maskClosable" to utsMapOf("type" to "Boolean", "default" to true), "zIndex" to utsMapOf("type" to "Number", "default" to 996)));
        var propsNeedCastKeys = utsArrayOf(
            "visible",
            "title",
            "color",
            "content",
            "contentColor",
            "buttons",
            "background",
            "radius",
            "maskBackground",
            "maskClosable",
            "zIndex"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
