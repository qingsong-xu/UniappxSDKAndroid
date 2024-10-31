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
open class GenUniModulesFirstuiUnixComponentsFuiActionsheetFuiActionsheet : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onCreated(fun() {
            val list = JSON.parse<UTSArray<FuiActionSheetItemParam>>(JSON.stringify(this.itemList));
            if (list != null) {
                this.initData(list);
            }
        }
        , __ins);
        onMounted(fun() {
            this.`$nextTick`(fun(){
                setTimeout(fun(){
                    if (!this.visible) {
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
            return this.itemList;
        }
        , fun(newVal: UTSArray<FuiActionSheetItemParam>) {
            this.initData(newVal);
        }
        );
        this.`$watch`(fun(): Any? {
            return this.theme;
        }
        , fun(kVal: String) {
            this.themeStyl = "";
            this.`$nextTick`(fun(){
                this.themeStyl = kVal;
            }
            );
        }
        , WatchOptions(immediate = true));
        this.`$watch`(fun(): Any? {
            return this.locale;
        }
        , fun(kVal: String) {
            val lang = getFuiLocaleLang(kVal);
            val actionsheet = lang["actionsheet"] as UTSJSONObject;
            this.cancelText = actionsheet.getString("cancel") as String;
        }
        , WatchOptions(immediate = true));
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", null, utsArrayOf(
            createElementVNode("view", utsMapOf("ref" to _ctx.refAsMkId, "class" to "fui-actionsheet__mask", "onClick" to _ctx.handleClickMask, "style" to normalizeStyle(utsMapOf("zIndex" to (_ctx.zIndex - 10)))), null, 12, utsArrayOf(
                "onClick"
            )),
            createElementVNode("view", utsMapOf("ref" to _ctx.refAsId, "class" to normalizeClass(utsArrayOf(
                "fui-actionsheet__wrap",
                utsArrayOf(
                    if (_ctx.radius) {
                        "fui-actionsheet__radius";
                    } else {
                        "";
                    }
                    ,
                    "fui-as__bg-" + _ctx.themeStyl
                )
            )), "style" to normalizeStyle(utsMapOf("zIndex" to _ctx.zIndex))), utsArrayOf(
                if (_ctx.tips != "") {
                    createElementVNode("text", utsMapOf("key" to 0, "class" to normalizeClass(utsArrayOf(
                        "fui-actionsheet__tips",
                        utsArrayOf(
                            if (_ctx.color == "") {
                                "fui-actionsheet__tip-color";
                            } else {
                                "";
                            },
                            "fui-as__btn-" + _ctx.themeStyl
                        )
                    )), "style" to normalizeStyle(_ctx.getTipsStyl)), toDisplayString(_ctx.tips), 7);
                } else {
                    createCommentVNode("v-if", true);
                }
                ,
                createElementVNode("view", utsMapOf("class" to normalizeClass(utsMapOf("fui-actionsheet__operate-box" to _ctx.isCancel))), utsArrayOf(
                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.vals, fun(item, index, __index, _cached): Any {
                        return createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                            "fui-as__btn-" + _ctx.themeStyl
                        )), "key" to index, "hover-class" to "fui-actionsheet__btn-active", "hover-stay-time" to 150), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to normalizeClass(utsArrayOf(
                                "fui-actionsheet__btn",
                                utsArrayOf(
                                    if ((item.darkColor == null || item.darkColor == "") && _ctx.themeStyl == "dark") {
                                        "fui-actionsheet__color-" + _ctx.themeStyl;
                                    } else {
                                        "";
                                    }
                                    ,
                                    if ((item.color == null || item.color == "") && _ctx.themeStyl == "light") {
                                        "fui-actionsheet__color-" + _ctx.themeStyl;
                                    } else {
                                        "";
                                    }
                                    ,
                                    if (!_ctx.isCancel && index == _ctx.vals.length - 1 && _ctx.iphoneX && _ctx.safeArea) {
                                        "fui-as__safe-weex";
                                    } else {
                                        "";
                                    }
                                    ,
                                    if (index != 0 || _ctx.tips != "") {
                                        "fui-as__divider-" + _ctx.themeStyl;
                                    } else {
                                        "";
                                    }
                                )
                            )), "style" to normalizeStyle(_ctx.getBtnStyl(item.color, item.darkColor, _ctx.theme, _ctx.itemSize)), "onClick" to fun(){
                                _ctx.handleClickItem(index);
                            }
                            ), toDisplayString(item.text), 15, utsArrayOf(
                                "onClick"
                            ))
                        ), 2);
                    }
                    ), 128)
                ), 2),
                createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                    "fui-as__btn-" + _ctx.themeStyl
                )), "hover-class" to "fui-actionsheet__btn-active", "hover-stay-time" to 150), utsArrayOf(
                    if (isTrue(_ctx.isCancel && _ctx.themeStyl != "")) {
                        createElementVNode("text", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("fontSize" to ("" + _ctx.itemSize + "rpx"))), "class" to normalizeClass(utsArrayOf(
                            "fui-actionsheet__btn",
                            utsMapOf("fui-actionsheet__color-dark" to (_ctx.themeStyl == "dark"), "fui-actionsheet__color-light" to (_ctx.themeStyl == "light"), "fui-as__safe-weex" to (_ctx.iphoneX && _ctx.safeArea))
                        )), "onClick" to _ctx.handleClickCancel), toDisplayString(_ctx.cancelText), 15, utsArrayOf(
                            "onClick"
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                ), 2)
            ), 6)
        ));
    }
    open var visible: Boolean by `$props`;
    open var itemList: UTSArray<FuiActionSheetItemParam> by `$props`;
    open var itemSize: Number by `$props`;
    open var tips: String by `$props`;
    open var color: String by `$props`;
    open var size: Number by `$props`;
    open var radius: Boolean by `$props`;
    open var isCancel: Boolean by `$props`;
    open var theme: String by `$props`;
    open var maskClosable: Boolean by `$props`;
    open var zIndex: Number by `$props`;
    open var safeArea: Boolean by `$props`;
    open var refAsId: Any? by `$data`;
    open var refAsMkId: Any? by `$data`;
    open var isShow: Boolean by `$data`;
    open var iphoneX: Boolean by `$data`;
    open var vals: UTSArray<FuiActionSheetItemParam> by `$data`;
    open var element: UniElement? by `$data`;
    open var mkElement: UniElement? by `$data`;
    open var isActive: Boolean by `$data`;
    open var themeStyl: String by `$data`;
    open var cancelText: String by `$data`;
    open var locale: String by `$data`;
    open var getTipsStyl: Any by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        val refAsId = "fui_as_" + parseInt(Math.ceil(Math.random() * 10e5).toString(), 36);
        val refAsMkId = "fui_asmk_" + parseInt(Math.ceil(Math.random() * 10e5).toString(), 36);
        return utsMapOf("refAsId" to refAsId, "refAsMkId" to refAsMkId, "isShow" to false, "iphoneX" to false, "vals" to utsArrayOf<FuiActionSheetItemParam>(), "element" to null as UniElement?, "mkElement" to null as UniElement?, "isActive" to false, "themeStyl" to "", "cancelText" to "", "locale" to computed<String>(fun(): String {
            return fuiLang.locale;
        }
        ), "getTipsStyl" to computed<Any>(fun(): Any {
            val mp: Map<String, String> = Map();
            mp.set("fontSize", "" + this.size + "rpx");
            if (this.color != "") {
                mp.set("color", this.color);
            }
            return mp;
        }
        ));
    }
    override fun `$initMethods`() {
        this.getBtnStyl = fun(color: String?, darkColor: String?, theme: String, size: Number): Any {
            val mp: Map<String, Any> = Map();
            mp.set("fontSize", "" + size + "rpx");
            if (theme == "dark") {
                if (darkColor != null && darkColor != "") {
                    mp.set("color", darkColor);
                }
            } else {
                if (color != null && color != "") {
                    mp.set("color", color);
                }
            }
            return mp;
        }
        ;
        this.initData = fun(vals: UTSArray<FuiActionSheetItemParam>) {
            this.vals = utsArrayOf<FuiActionSheetItemParam>();
            this.themeStyl = "";
            this.`$nextTick`(fun(){
                this.vals = vals;
                this.themeStyl = this.theme;
            }
            );
        }
        ;
        this.handleClickMask = fun() {
            if (!this.maskClosable) {
                return;
            }
            this.handleClickCancel();
        }
        ;
        this.handleClickItem = fun(index: Number) {
            if (!this.visible) {
                return;
            }
            val item = this.vals[index];
            item.index = index;
            this.`$emit`("onclick", item);
        }
        ;
        this.handleClickCancel = fun() {
            this.`$emit`("cancel");
            this.`$emit`("update:visible", false);
        }
        ;
        this.open = fun() {
            this.`$nextTick`(fun(){
                setTimeout(fun(){
                    this.isShow = true;
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
                this.element = this.`$refs`[this.refAsId] as UniElement;
            }
            if (this.mkElement == null) {
                this.mkElement = this.`$refs`[this.refAsMkId] as UniElement;
            }
            this.mkElement!!.style.setProperty("opacity", if (visible) {
                "1";
            } else {
                "0";
            }
            );
            this.element!!.style.setProperty("transform", "translateY(" + (if (visible) {
                "0";
            } else {
                "100%";
            }
            ) + ")");
            this.element!!.style.setProperty("opacity", if (visible) {
                "1";
            } else {
                "0";
            }
            );
            if (visible) {
                this.mkElement!!.style.setProperty("visibility", "visible");
                this.element!!.style.setProperty("visibility", "visible");
            } else {
                setTimeout(fun(){
                    this.mkElement!!.style.setProperty("visibility", "hidden");
                    this.element!!.style.setProperty("visibility", "hidden");
                }
                , 250);
            }
        }
        ;
    }
    open lateinit var getBtnStyl: (color: String?, darkColor: String?, theme: String, size: Number) -> Any;
    open lateinit var initData: (vals: UTSArray<FuiActionSheetItemParam>) -> Unit;
    open lateinit var handleClickMask: () -> Unit;
    open lateinit var handleClickItem: (index: Number) -> Unit;
    open lateinit var handleClickCancel: () -> Unit;
    open lateinit var open: () -> Unit;
    open lateinit var close: () -> Unit;
    open lateinit var _animation: (visible: Boolean) -> Unit;
    companion object {
        var name = "fui-actionsheet";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("fui-actionsheet__wrap" to padStyleMapOf(utsMapOf("width" to "100%", "visibility" to "hidden", "minHeight" to "100rpx", "position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "transitionDuration" to "0.25s", "transitionProperty" to "transform,opacity,visibility", "transitionTimingFunction" to "ease-in-out", "transform" to "translateY(100%)", "transformOrigin" to "center center")), "fui-as__bg-light" to padStyleMapOf(utsMapOf("backgroundColor" to "#F8F8F8")), "fui-as__bg-dark" to padStyleMapOf(utsMapOf("backgroundColor" to "#111111")), "fui-actionsheet__radius" to padStyleMapOf(utsMapOf("borderTopLeftRadius" to "24rpx", "borderTopRightRadius" to "24rpx", "overflow" to "hidden")), "fui-actionsheet__tips" to padStyleMapOf(utsMapOf("width" to "100%", "boxSizing" to "border-box", "paddingTop" to "40rpx", "paddingRight" to "60rpx", "paddingBottom" to "40rpx", "paddingLeft" to "60rpx", "textAlign" to "center", "fontWeight" to "normal")), "fui-as__btn-light" to padStyleMapOf(utsMapOf("backgroundColor" to "#FFFFFF")), "fui-as__btn-dark" to padStyleMapOf(utsMapOf("backgroundColor" to "#222222")), "fui-actionsheet__color-light" to padStyleMapOf(utsMapOf("!color" to "#181818")), "fui-actionsheet__color-dark" to padStyleMapOf(utsMapOf("!color" to "#D1D1D1")), "fui-actionsheet__tip-color" to padStyleMapOf(utsMapOf("!color" to "#7F7F7F")), "fui-actionsheet__operate-box" to padStyleMapOf(utsMapOf("paddingBottom" to "12rpx")), "fui-actionsheet__btn" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100rpx", "lineHeight" to "100rpx", "textAlign" to "center", "fontWeight" to "normal", "position" to "relative", "boxSizing" to "content-box")), "fui-actionsheet__btn-active" to padStyleMapOf(utsMapOf("!backgroundColor" to "rgba(0,0,0,0.2)")), "fui-as__divider-light" to padStyleMapOf(utsMapOf("borderTopWidth" to 0.5, "borderTopColor" to "#EEEEEE", "borderTopStyle" to "solid")), "fui-as__divider-dark" to padStyleMapOf(utsMapOf("borderTopWidth" to 0.5, "borderTopColor" to "#333333", "borderTopStyle" to "solid")), "fui-as__safe-weex" to padStyleMapOf(utsMapOf("paddingBottom" to 34)), "fui-actionsheet__mask" to padStyleMapOf(utsMapOf("position" to "fixed", "top" to 0, "left" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "rgba(0,0,0,0.6)", "transitionDuration" to "0.25s", "transitionProperty" to "opacity,visibility", "transitionTimingFunction" to "ease-in-out", "opacity" to 0, "visibility" to "hidden")), "@TRANSITION" to utsMapOf("fui-actionsheet__wrap" to utsMapOf("duration" to "0.25s", "property" to "transform,opacity,visibility", "timingFunction" to "ease-in-out"), "fui-actionsheet__mask" to utsMapOf("duration" to "0.25s", "property" to "opacity,visibility", "timingFunction" to "ease-in-out")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("onclick" to null, "cancel" to null, "update:visible" to null);
        var props = normalizePropsOptions(utsMapOf("visible" to utsMapOf("type" to "Boolean", "default" to false), "itemList" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<FuiActionSheetItemParam> {
            return utsArrayOf<FuiActionSheetItemParam>();
        }
        ), "itemSize" to utsMapOf("type" to "Number", "default" to 32), "tips" to utsMapOf("type" to "String", "default" to ""), "color" to utsMapOf("type" to "String", "default" to ""), "size" to utsMapOf("type" to "Number", "default" to 26), "radius" to utsMapOf("type" to "Boolean", "default" to true), "isCancel" to utsMapOf("type" to "Boolean", "default" to true), "theme" to utsMapOf("type" to "String", "default" to "light"), "maskClosable" to utsMapOf("type" to "Boolean", "default" to false), "zIndex" to utsMapOf("type" to "Number", "default" to 996), "safeArea" to utsMapOf("type" to "Boolean", "default" to true)));
        var propsNeedCastKeys = utsArrayOf(
            "visible",
            "itemList",
            "itemSize",
            "tips",
            "color",
            "size",
            "radius",
            "isCancel",
            "theme",
            "maskClosable",
            "zIndex",
            "safeArea"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
