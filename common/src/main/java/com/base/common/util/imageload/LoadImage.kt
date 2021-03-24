package com.base.common.util.imageload

import android.widget.ImageView
import java.io.File

object LoadImage : LoadEngine {
    const val imgUrl =
        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Fc1cb0016ce599fff96fcaacd3e01452cffc3c8c1a066c-3qtAwO_fw236&refer=http%3A%2F%2Fhbimg.b0.upaiyun.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619171623&t=9a878cb48b953a4f36f6382283739fbb"

    private val glideEngine: LoadEngine by lazy { GlideEngine() }
    private val coilEngine: LoadEngine by lazy { CoilEngine() }

    private var defaultEngine = glideEngine

    override fun load(url: String, img: ImageView) {
        defaultEngine.load(url, img)
    }

    override fun load(file: File, img: ImageView) {
        defaultEngine.load(file, img)
    }

    override fun load(id: Int, img: ImageView) {
        defaultEngine.load(id, img)
    }

    override fun loadBlur(url: String, img: ImageView) {
        defaultEngine.loadBlur(url, img)
    }

    override fun loadBlur(file: File, img: ImageView) {
        defaultEngine.loadBlur(file, img)
    }

    override fun loadBlur(id: Int, img: ImageView) {
        defaultEngine.loadBlur(id, img)
    }

    override fun loadCircle(url: String, img: ImageView) {
        defaultEngine.loadCircle(url, img)
    }

    override fun loadCircle(file: File, img: ImageView) {
        defaultEngine.loadCircle(file, img)
    }

    override fun loadCircle(id: Int, img: ImageView) {
        defaultEngine.loadCircle(id, img)
    }

    override fun loadRound(url: String, img: ImageView) {
        defaultEngine.loadRound(url, img)
    }

    override fun loadRound(file: File, img: ImageView) {
        defaultEngine.loadRound(file, img)
    }

    override fun loadRound(id: Int, img: ImageView) {
        defaultEngine.loadRound(id, img)
    }
}
