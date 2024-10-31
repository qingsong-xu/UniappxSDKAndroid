@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER")
package uts.sdk.modules.xyronXxpermissions;
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
fun permission(permission: UTSArray<String>, gotoSetting: Boolean, callback: (ret: Boolean, desc: String, grantedList: UTSArray<String>) -> Unit) {
    console.log("发起权限请求");
    var permissionNeed = permission;
    if (UTSAndroid.getSystemPermissionDenied(UTSAndroid.getUniActivity()!!, permissionNeed).length == 0) {
        callback(false, "\u5DF2\u5177\u5907" + permission + "\u6743\u9650", utsArrayOf());
        return;
    }
    if (!UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, permissionNeed)) {
        UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, permissionNeed, fun(allRight: Boolean, grantedList: UTSArray<String>) {
            console.log("requestSystemPermission 回调");
            if (allRight) {
                console.log("allRight=" + allRight + "  grantedList=" + grantedList);
                if (UTSAndroid.getSystemPermissionDenied(UTSAndroid.getUniActivity()!!, permissionNeed).length > 0) {
                    callback(false, "权限请求完成,getSystemPermissionDenied 失败", grantedList);
                    return;
                }
                if (!UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, permissionNeed)) {
                    callback(false, "权限请求完成,checkSystemPermissionGranted 失败", grantedList);
                    return;
                }
                callback(true, "", grantedList);
            } else {
                console.log("拒绝了部分 allRight=" + allRight + "  grantedList=" + grantedList);
                callback(false, "用户拒绝了部分权限", grantedList);
            }
        }
        , fun(doNotAskAgain: Boolean, grantedList: UTSArray<String>) {
            console.log("doNotAskAgain=" + doNotAskAgain + "  grantedList=" + grantedList);
            if (doNotAskAgain && gotoSetting) {
                UTSAndroid.gotoSystemPermissionActivity(UTSAndroid.getUniActivity()!!, permission);
            } else {
                callback(false, "用户拒绝了部分权限", grantedList);
            }
        }
        );
    }
}
