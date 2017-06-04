package io.github.covercash2.graphiks.math

/**
 * Created by chreeus on 5/30/17.
 * basic math functions
 */

/**
 * TODO SLOW!
 * find the square root of a number
 */
fun Float.squareRoot(): Float {
    if (this < 0f) { return Float.NaN }
    else if (this == 0f || this == 1f|| this == Float.POSITIVE_INFINITY) {
        return this
    }

    var result = this / 2f
    var t1: Float
    do {
        t1 = result
        result = (t1 + (this / t1)) / 2
    } while ((t1 - result) != 0f)

    return result
}

fun Float.abs() = if (this <= 0f) 0f - this else this

fun Float.square() = this * this