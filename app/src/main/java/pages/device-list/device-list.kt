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
import io.dcloud.uniapp.extapi.getStorage as uni_getStorage;
open class GenPagesDeviceListDeviceList : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onReady(fun() {
            this.lpbDrawer = this.`$refs`["lpbDrawer"] as LaopobingDrawerComponentPublicInstance;
            uni_getStorage(GetStorageOptions(key = "userInfo", success = fun(res){
                val obj = JSON.parse<UserInfo>(res["data"] as String);
                console.log("success", obj?.userId);
                getUserTree(obj!!!!.userId).then(fun(res){
                    console.log("getUserTree", res);
                }
                ).`catch`(fun(err){
                    console.log("error", err);
                }
                );
            }
            , fail = fun(res){
                console.log("fail", res);
            }
            , complete = fun(res){}));
        }
        , __ins);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_laopobing_drawer = resolveEasyComponent("laopobing-drawer", GenUniModulesLaopobingDrawerComponentsLaopobingDrawerLaopobingDrawerClass);
        val _component_radio = resolveComponent("radio");
        val _component_radio_group = resolveComponent("radio-group");
        val _component_uni_collapse_item = resolveEasyComponent("uni-collapse-item", GenComponentsUniCollapseItemUniCollapseItemClass);
        val _component_uni_collapse = resolveEasyComponent("uni-collapse", GenComponentsUniCollapseUniCollapseClass);
        val _component_form = resolveComponent("form");
        return createElementVNode("view", utsMapOf("class" to "page-container"), utsArrayOf(
            createVNode(_component_laopobing_drawer, utsMapOf("ref" to "lpbDrawer", "type" to "left", "background" to "#fff", "height" to 200, "onChange" to _ctx.changeFun), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("text", null, "客户关系树")
                );
            }
            ), "_" to 1), 8, utsArrayOf(
                "onChange"
            )),
            createElementVNode("view", utsMapOf("class" to "cur-customer"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "uni-row"), utsArrayOf(
                    createElementVNode("image", utsMapOf("src" to _ctx.customerIcon, "class" to "common-icon-size", "onClick" to _ctx.showFun), null, 8, utsArrayOf(
                        "src",
                        "onClick"
                    )),
                    createElementVNode("text", utsMapOf("class" to "margin-left txt-w"), "admin")
                )),
                createElementVNode("view", utsMapOf("class" to "uni-row"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "margin-right txt-w"), "切换客户"),
                    createElementVNode("text", utsMapOf("class" to "margin-left txt-w"), "添加设备")
                ))
            )),
            createVNode(_component_form, utsMapOf("class" to "form-box common-gray-bg"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "search-box"), utsArrayOf(
                        createElementVNode("image", utsMapOf("src" to _ctx.searchIcon, "class" to "common-icon-size"), null, 8, utsArrayOf(
                            "src"
                        )),
                        createElementVNode("input", utsMapOf("type" to "text", "placeholder" to "设备号/车牌号/客户名称"))
                    )),
                    createElementVNode("view", utsMapOf("class" to "ryl-row sort-box"), utsArrayOf(
                        createElementVNode("text", null, "排序"),
                        createVNode(_component_radio_group, utsMapOf("name" to "sort", "class" to "ryl-row", "onChange" to _ctx.changeSort), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_radio, utsMapOf("class" to "uni-list-cell uni-list-cell-padding", "value" to 0, "checked" to _ctx.checked), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        "默认"
                                    );
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "checked"
                                )),
                                createVNode(_component_radio, utsMapOf("class" to "uni-list-cell uni-list-cell-padding", "value" to 1), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        "按名称"
                                    );
                                }
                                ), "_" to 1)),
                                createVNode(_component_radio, utsMapOf("class" to "uni-list-cell uni-list-cell-padding", "value" to 2), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        "按速度"
                                    );
                                }
                                ), "_" to 1))
                            );
                        }
                        ), "_" to 1), 8, utsArrayOf(
                            "onChange"
                        ))
                    )),
                    createElementVNode("scroll-view", utsMapOf("scroll-x" to "true", "class" to "nav-container"), utsArrayOf(
                        createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.navList, fun(item, index, __index, _cached): Any {
                            return createElementVNode("view", utsMapOf("key" to index, "onClick" to fun(){
                                _ctx.switchTab(index);
                            }
                            ), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to normalizeClass(if (index === _ctx.activeIndex) {
                                    "activeNav";
                                } else {
                                    "normalNav";
                                }
                                )), toDisplayString(item.text), 3)
                            ), 8, utsArrayOf(
                                "onClick"
                            ));
                        }
                        ), 128)
                    )),
                    createElementVNode("scroll-view", null, utsArrayOf(
                        createVNode(_component_uni_collapse, utsMapOf("ref" to "collapse"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_uni_collapse_item, utsMapOf("title" to "默认开启"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("padding-left" to "18px")), "class" to "uni-navigate-item", "hover-class" to "is--active"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "uni-navigate-text"), "内容")
                                        ), 4)
                                    );
                                }
                                ), "_" to 1)),
                                createVNode(_component_uni_collapse_item, utsMapOf("title" to "折叠内容"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("padding-left" to "18px")), "class" to "uni-navigate-item", "hover-class" to "is--active"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "uni-navigate-text"), "折叠内容主体，这是一段比较长内容。默认折叠主要内容，只显示当前项标题。点击标题展开，才能看到这段文字。再次点击标题，折叠内容。")
                                        ), 4)
                                    );
                                }
                                ), "_" to 1))
                            );
                        }
                        ), "_" to 1), 512)
                    ))
                );
            }
            ), "_" to 1))
        ));
    }
    open var customerIcon: String by `$data`;
    open var searchIcon: String by `$data`;
    open var arrowRightIcon: String by `$data`;
    open var checked: Boolean by `$data`;
    open var navList: UTSArray<navItem> by `$data`;
    open var activeIndex: Number by `$data`;
    open var value: UTSArray<String> by `$data`;
    open var lpbDrawer: LaopobingDrawerComponentPublicInstance? by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("customerIcon" to "/static/icons/devicelist/ic_customer.png" as String, "searchIcon" to "/static/icons/devicelist/ic_search.png" as String, "arrowRightIcon" to "/static/icons/arrow-right.png" as String, "checked" to true, "navList" to utsArrayOf<navItem>(navItem(id = 0, text = "全部"), navItem(id = 1, text = "在线"), navItem(id = 2, text = "离线"), navItem(id = 3, text = "已过期"), navItem(id = 4, text = "未启用")), "activeIndex" to 0 as Number, "value" to utsArrayOf(
            "0"
        ), "lpbDrawer" to null as LaopobingDrawerComponentPublicInstance?);
    }
    override fun `$initMethods`() {
        this.switchTab = fun(id: Number) {
            this.activeIndex = id;
        }
        ;
        this.changeSort = fun(e: UniRadioGroupChangeEvent) {
            console.log("e", e.detail);
        }
        ;
        this.showFun = fun() {
            this.lpbDrawer?.`$callMethod`("show");
        }
        ;
        this.hideFun = fun() {
            this.lpbDrawer?.`$callMethod`("hide");
        }
        ;
        this.changeFun = fun(show: Boolean) {
            console.log(show);
        }
        ;
    }
    open lateinit var switchTab: (id: Number) -> Unit;
    open lateinit var changeSort: (e: UniRadioGroupChangeEvent) -> Unit;
    open lateinit var showFun: () -> Unit;
    open lateinit var hideFun: () -> Unit;
    open lateinit var changeFun: (show: Boolean) -> Unit;
    companion object {
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
                return utsMapOf("cur-customer" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "backgroundColor" to "#52aafa", "height" to "80rpx", "alignItems" to "center")), "form-box" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%")), "search-box" to padStyleMapOf(utsMapOf("marginTop" to "8rpx", "marginRight" to "16rpx", "marginBottom" to "8rpx", "marginLeft" to "16rpx", "flexDirection" to "row", "alignItems" to "center", "backgroundColor" to "#e6e6e6", "borderRadius" to "10rpx", "paddingTop" to "16rpx", "paddingRight" to "16rpx", "paddingBottom" to "16rpx", "paddingLeft" to "16rpx", "width" to "100%", "height" to "60rpx")), "sort-box" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to "8rpx", "marginRight" to "16rpx", "marginBottom" to "8rpx", "marginLeft" to "16rpx")), "nav-container" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "width" to "100%", "backgroundColor" to "#e6e6e6", "justifyContent" to "space-around")), "activeNav" to padStyleMapOf(utsMapOf("height" to "60rpx", "paddingTop" to 0, "paddingRight" to "12rpx", "paddingBottom" to 0, "paddingLeft" to "12rpx", "color" to "#52aafa", "lineHeight" to "60rpx", "borderBottomWidth" to "4rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#52aafa")), "normalNav" to padStyleMapOf(utsMapOf("height" to "60rpx", "color" to "#333333", "paddingTop" to 0, "paddingRight" to "12rpx", "paddingBottom" to 0, "paddingLeft" to "12rpx", "lineHeight" to "60rpx", "borderBottomWidth" to "4rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "rgba(0,0,0,0)")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
