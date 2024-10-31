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
open class GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var height: Number by `$props`;
    open var background: String by `$props`;
    open var type: String by `$props`;
    open var showMask: Boolean by `$props`;
    open var maskBg: String by `$props`;
    open var maskOp: Number by `$props`;
    open var show: () -> Unit
        get() {
            return unref(this.`$exposed`["show"]) as () -> Unit;
        }
        set(value) {
            setRefValue(this.`$exposed`, "show", value);
        }
    open var hide: () -> Unit
        get() {
            return unref(this.`$exposed`["hide"]) as () -> Unit;
        }
        set(value) {
            setRefValue(this.`$exposed`, "hide", value);
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose;
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawer;
            val _cache = __ins.renderCache;
            val props = __props;
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread);
            }
            var status = ref(false);
            var is_listen = ref(true);
            var opacity = ref(props.maskOp);
            var before_touch: Number = 0;
            var drawer = ref<UniElement?>(null);
            var position = ref(if (props.type == "top" || props.type == "left") {
                -props.height;
            } else {
                props.height;
            }
            );
            val touchstartFun = fun(e: TouchEvent){
                before_touch = Math.round(e.changedTouches[0].clientY);
                drawer.value?.style?.setProperty("transition-duration", "0ms");
            }
            ;
            val touchmoveFun = fun(e: TouchEvent, force_trigger: Boolean){
                if (!is_listen.value && !force_trigger) {
                    return;
                }
                var now_touch: Number;
                if (props.type == "top" || props.type == "bottom") {
                    debounce(fun(){
                        before_touch = Math.round(e.changedTouches[0].clientY);
                    }, 25);
                    now_touch = e.changedTouches[0].clientY;
                } else {
                    debounce(fun(){
                        before_touch = Math.round(e.changedTouches[0].clientX);
                    }
                    , 25);
                    now_touch = e.changedTouches[0].clientX;
                }
                if (Math.round(now_touch) - before_touch > 3) {
                    if (props.type == "top" || props.type == "left") {
                        if (position.value > 0) {
                            return;
                        }
                        position.value += props.height / 100 * 2.5;
                    } else {
                        if (position.value >= props.height) {
                            return;
                        }
                        position.value += props.height / 100 * 2.5;
                    }
                } else if (Math.round(now_touch) - before_touch < -3) {
                    if (props.type == "top" || props.type == "left") {
                        if (position.value <= -props.height) {
                            return;
                        }
                        position.value -= props.height / 100 * 2.5;
                    } else {
                        if (position.value < 0) {
                            return;
                        }
                        position.value -= props.height / 100 * 2.5;
                    }
                }
            }
            ;
            val touchendFun = fun(){
                drawer.value?.style?.setProperty("transition-duration", "300ms");
                position.value = if (Math.abs(position.value) < props.height / 4.5) {
                    0;
                } else {
                    if (props.type == "top" || props.type == "left") {
                        -props.height;
                    } else {
                        props.height;
                    }
                    ;
                }
                ;
            }
            ;
            val show = fun(){
                position.value = 0;
                drawer.value?.style?.setProperty("transition-duration", "300ms");
            }
            ;
            val hide = fun(){
                position.value = if (props.type == "top" || props.type == "left") {
                    -props.height;
                } else {
                    props.height;
                }
                ;
                drawer.value?.style?.setProperty("transition-duration", "300ms");
            }
            ;
            val scrollUp = fun(e: ScrollEvent){
                if (props.type == "bottom") {
                    if (e.detail.scrollTop <= 1) {
                        is_listen.value = true;
                    } else {
                        is_listen.value = false;
                    };
                } else {
                    is_listen.value = false;
                }
                debounce(fun(){
                    is_listen.value = true;
                }
                , 300);
            }
            ;
            watch(fun(): Number {
                return position.value;
            }
            , fun(afterVl: Number){
                if (props.type == "top" || props.type == "left") {
                    drawer.value?.style?.setProperty("transform", "translateX(" + position.value + "px)");
                    if (afterVl > 0) {
                        position.value = 0;
                    }
                    if (afterVl < -props.height) {
                        position.value = -props.height;
                    }
                } else {
                    drawer.value?.style?.setProperty("transform", "translateY(" + position.value + "px)");
                    if (afterVl < 0) {
                        position.value = 0;
                    }
                    if (afterVl > props.height) {
                        position.value = props.height;
                    }
                }
                opacity.value = 0.4 * (1 - Math.abs(afterVl) / props.height);
                if (afterVl >= props.height || afterVl <= -props.height) {
                    status.value = false;
                } else {
                    status.value = true;
                }
                ;
                if (Math.abs(afterVl) == 0) {
                    emits("change", true);
                }
                if (Math.abs(afterVl) == props.height) {
                    emits("change", false);
                }
            }
            );
            __expose(utsMapOf("show" to show, "hide" to hide));
            return fun(): Any? {
                return createElementVNode(Fragment, null, utsArrayOf(
                    if (isTrue(_ctx.type == "top" || _ctx.type == "bottom" || _ctx.type == "left" || _ctx.type == "right")) {
                        createElementVNode("view", utsMapOf("key" to 0, "ref_key" to "drawer", "ref" to drawer, "onTouchmove" to fun(`$event`: Any){
                            touchmoveFun(`$event` as TouchEvent, false);
                        }, "onTouchstart" to touchstartFun, "onTouchend" to touchendFun, "class" to normalizeClass(utsArrayOf(
                            "lpb-drawer",
                            _ctx.type
                        )), "style" to normalizeStyle(utsMapOf("background" to _ctx.background, "width" to if (_ctx.type == "top" || _ctx.type == "bottom") {
                            "100vw";
                        } else {
                            "" + _ctx.height + "px";
                        }, "height" to if (_ctx.type == "top" || _ctx.type == "bottom") {
                            "" + _ctx.height + "px";
                        } else {
                            "100vh";
                        }, "transform" to if (_ctx.type == "top" || _ctx.type == "bottom") {
                            "translateY(" + unref(position) + "px)";
                        } else {
                            "translateX(" + unref(position) + "px)";
                        }))), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "lpb-topBar", "onTouchstart" to withModifiers(touchstartFun, utsArrayOf(
                                "stop"
                            )), "onTouchend" to withModifiers(touchendFun, utsArrayOf(
                                "stop"
                            )), "onTouchmove" to withModifiers(fun(`$event`: Any){
                                touchmoveFun(`$event` as TouchEvent, true);
                            }, utsArrayOf(
                                "stop"
                            ))), null, 40, utsArrayOf(
                                "onTouchmove"
                            )),
                            renderSlot(_ctx.`$slots`, "bar", UTSJSONObject(), fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    withDirectives(createElementVNode("view", utsMapOf("class" to "bar"), null, 512), utsArrayOf(
                                        utsArrayOf(
                                            vShow,
                                            false
                                        )
                                    ))
                                );
                            }),
                            createElementVNode("scroll-view", utsMapOf("onScroll" to scrollUp, "onScrolltolower" to fun(){}, "show-scrollbar" to false, "direction" to "vertical", "style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
                                renderSlot(_ctx.`$slots`, "default")
                            ), 44, utsArrayOf(
                                "onScrolltolower"
                            ))
                        ), 46, utsArrayOf(
                            "onTouchmove"
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                    ,
                    if (isTrue(_ctx.type == "top" || _ctx.type == "bottom" || _ctx.type == "left" || _ctx.type == "right")) {
                        withDirectives(createElementVNode("view", utsMapOf("key" to 1, "class" to "mask", "style" to normalizeStyle(utsMapOf("opacity" to unref(opacity), "background" to _ctx.maskBg)), "onClick" to fun(){
                            hide();
                        }), null, 12, utsArrayOf(
                            "onClick"
                        )), utsArrayOf(
                            utsArrayOf(
                                vShow,
                                unref(status) && _ctx.showMask
                            )
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                ), 64);
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
                return utsMapOf("lpb-drawer" to utsMapOf("" to utsMapOf("position" to "fixed", "zIndex" to 10001, "transitionProperty" to "transform"), ".top" to utsMapOf("top" to 0, "left" to 0, "right" to 0, "transformOrigin" to "center top"), ".bottom" to utsMapOf("left" to 0, "right" to 0, "bottom" to 0, "transformOrigin" to "center bottom"), ".left" to utsMapOf("top" to 0, "left" to 0, "bottom" to 0, "transformOrigin" to "left center"), ".right" to utsMapOf("top" to 0, "right" to 0, "bottom" to 0, "transformOrigin" to "right center")), "lpb-topBar" to utsMapOf(".lpb-drawer>" to utsMapOf("position" to "absolute", "zIndex" to 10000), ".lpb-drawer.top>" to utsMapOf("left" to 0, "right" to 0, "bottom" to 0, "height" to 20), ".lpb-drawer.bottom>" to utsMapOf("top" to 0, "left" to 0, "right" to 0, "height" to 20), ".lpb-drawer.left>" to utsMapOf("top" to 0, "right" to 0, "bottom" to 0, "width" to 20), ".lpb-drawer.right>" to utsMapOf("top" to 0, "left" to 0, "bottom" to 0, "width" to 20)), "bar" to utsMapOf(".lpb-drawer>" to utsMapOf("width" to 50, "height" to 8, "marginTop" to 0, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto", "borderRadius" to 8, "backgroundColor" to "#ffffff", "left" to 0, "right" to 0, "top" to 6, "position" to "absolute")), "mask" to padStyleMapOf(utsMapOf("top" to 0, "left" to 0, "right" to 0, "bottom" to 0, "zIndex" to 10000, "position" to "fixed", "transitionProperty" to "opacity", "transitionDuration" to "500ms")), "@TRANSITION" to utsMapOf("lpb-drawer" to utsMapOf("property" to "transform"), "mask" to utsMapOf("property" to "opacity", "duration" to "500ms")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("change" to null);
        var props = normalizePropsOptions(utsMapOf("height" to utsMapOf("default" to 300, "type" to "Number"), "background" to utsMapOf("default" to "#cecece", "type" to "String"), "type" to utsMapOf("type" to "String", "required" to true, "default" to "bottom"), "showMask" to utsMapOf("default" to true, "type" to "Boolean"), "maskBg" to utsMapOf("default" to "#000", "type" to "String"), "maskOp" to utsMapOf("default" to 0.4, "type" to "Number")));
        var propsNeedCastKeys = utsArrayOf(
            "height",
            "background",
            "type",
            "showMask",
            "maskBg",
            "maskOp"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
