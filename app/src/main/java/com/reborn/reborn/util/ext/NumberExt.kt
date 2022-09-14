package com.reborn.reborn.util.ext

import android.content.res.Resources

fun Int.dp(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Float.dp(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
