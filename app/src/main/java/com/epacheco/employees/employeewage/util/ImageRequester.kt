package com.epacheco.employees.employeewage.util

import android.content.Context
import android.graphics.*
import android.util.LruCache

import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.NetworkImageView
import com.android.volley.toolbox.Volley
import com.epacheco.employees.employeewage.application.EmployeeApplication


/**
 * Created by epacheco on 23,enero,2021
 * Siatigroup, Copyright
 */
object ImageRequester {
    private val requestQueue: RequestQueue
    private val imageLoader: ImageLoader
    private val maxByteSize: Int

    init {
        val context = EmployeeApplication.instance
        this.requestQueue = Volley.newRequestQueue(context)
        this.requestQueue.start()
        this.maxByteSize = calculateMaxByteSize(context)
        this.imageLoader = ImageLoader(
            requestQueue,
            object : ImageLoader.ImageCache {
                private val lruCache = object : LruCache<String, Bitmap>(maxByteSize) {
                    override fun sizeOf(url: String, bitmap: Bitmap): Int {
                        return bitmap.byteCount
                    }
                }

                @Synchronized
                override fun getBitmap(url: String): Bitmap? {
                    var img = lruCache.get(url)
                    if (img != null) {
                        img = getCircularBitmap(lruCache.get(url))
                    }
                    return img
                }

                @Synchronized
                override fun putBitmap(url: String, bitmap: Bitmap) {
                    if (bitmap != null){
                        lruCache.put(url, getCircularBitmap(bitmap))
                    } else {
                        lruCache.put(url, bitmap)
                    }
                }
            })
    }

    /**
     * Sets the image on the given [NetworkImageView] to the image at the given URL
     *
     * @param networkImageView [NetworkImageView] to set image on
     * @param url              URL of the image
     */
    fun setImageFromUrl(networkImageView: NetworkImageView, url: String) {
        networkImageView.setImageUrl(url, imageLoader)
    }

    /**
     * Creates a circular bitmap and uses whichever dimension is smaller to determine the width
     * <br></br>Also constrains the circle to the leftmost part of the image
     *
     * @param bitmap
     * @return bitmap
     */
    private fun getCircularBitmap(bitmap: Bitmap): Bitmap {
        val output = Bitmap.createBitmap(
            bitmap.width,
            bitmap.height, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(output)
        var width = bitmap.width
        if (bitmap.width > bitmap.height)
            width = bitmap.height
        val color = -0xbdbdbe
        val paint = Paint()
        val rect = Rect(0, 0, width, width)
        val rectF = RectF(rect)
        val roundPx = (width / 2).toFloat()

        paint.setAntiAlias(true)
        canvas.drawARGB(0, 0, 0, 0)
        paint.setColor(color)
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint)

        paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_IN))
        canvas.drawBitmap(bitmap, rect, rect, paint)

        return output
    }

    private fun calculateMaxByteSize(context: Context): Int {
        val displayMetrics = context.resources.displayMetrics
        val screenBytes = displayMetrics.widthPixels * displayMetrics.heightPixels * 4
        return screenBytes * 3
    }
}