package com.base.common.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter

private const val TAG = "ARouterUtil"

/**
 * 默认页面跳转code
 */
const val REQUEST_CODE = 1314

/**
 * 创建路由
 */
fun launchARouter(path: String): Postcard = ARouter.getInstance().build(path)

/**
 * 使用路由模式判断登录跳转
 */
fun Postcard.loginNavigation(context: Context, request: Int = REQUEST_CODE, navCallback: NavCallback? = null) {
    val isLogin = SharedPreferencesUtil.getBoolean(SharedPreferencesUtil.LOGIN, false)

    if (isLogin) {
        normalNavigation(context, request, navCallback)
    } else {
        AndroidUtil.showToast(context, "未登录")
    }
}

/**
 * 使用路由模式直接跳转，跳过所有拦截器
 */
fun Postcard.normalNavigation(context: Context, request: Int = REQUEST_CODE, navCallback: NavCallback? = null) {
    if (context is Activity) {
        greenChannel().navigation(context, request, navCallback)
    } else {
        greenChannel().navigation(context, navCallback)
    }
}

/**
 * 使用普通模式判断登录跳转
 */
fun launchActivityForLogin(context: Context, javaClass: Class<out Activity>, request: Int = REQUEST_CODE) {
    val isLogin = SharedPreferencesUtil.getBoolean(SharedPreferencesUtil.LOGIN, false)
    if (isLogin) {
        launchActivity(context, javaClass, request)
    } else {
        AndroidUtil.showToast(context, "未登录")
    }
}

/**
 * 使用普通模式判断登录跳转
 */
fun launchActivityForLogin(context: Context, intent: Intent, request: Int = REQUEST_CODE) {
    val isLogin = SharedPreferencesUtil.getBoolean(SharedPreferencesUtil.LOGIN, false)
    if (isLogin) {
        launchActivity(context, intent, request)
    } else {
        AndroidUtil.showToast(context, "未登录")
    }
}

/**
 * 使用普通模式直接跳转
 */
fun launchActivity(context: Context, javaClass: Class<out Activity>, request: Int = REQUEST_CODE) {
    launchActivity(context, Intent(context, javaClass), request)
}

/**
 * 使用普通模式直接跳转
 */
fun launchActivity(context: Context, intent: Intent, request: Int = REQUEST_CODE) {
    when (context) {
        is Activity -> {
            context.startActivityForResult(intent, request)
        }
        is Fragment -> {
            context.startActivityForResult(intent, request)
        }
        else -> {
            context.startActivity(intent)
        }
    }
}