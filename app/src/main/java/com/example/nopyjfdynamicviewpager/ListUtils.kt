package com.example.nopyjfdynamicviewpager

fun <T> List<T>.createFakeList(): List<T> {
    return listOf(this[this.size - 2]) +
            listOf(this.last()) +
            this +
            listOf(this.first()) +
            listOf(this[1])
}