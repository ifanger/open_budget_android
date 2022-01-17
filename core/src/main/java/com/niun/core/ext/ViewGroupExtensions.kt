package com.niun.core.ext

import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.getLayoutInflater(): LayoutInflater {
    return LayoutInflater.from(this.context)
}