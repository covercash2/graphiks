package io.github.covercash2.graphiks

import io.github.covercash2.graphiks.math.abs
import io.github.covercash2.graphiks.math.square

/**
 * interfaces to minimize dependencies
 */

interface Window {
    fun update(dt: Float)
    fun draw()
    fun pause()
    fun resume()
    fun resize(width: Int, height: Int)
    fun dispose()
}

interface Graphics {
    fun clear(
            r: Float,
            g: Float,
            b: Float,
            a: Float = 1f)
}

interface Spacial<T> {
    val data: T
    val dimension: Int
}

interface SquareMatrix: Spacial<Array<Array<Float>>>

/**
 * a vector which has functions that can
 * only be applied to other vectors.
 *
 * V is the type of vector implementors will
 * be compared to.
 *
 * R is the return type of functions that return
 * a vector
 */
interface Vector<out R: Vector<R>> {
    val dimension: Int

    /**
     * error margin
     */
    val epsilon: Float

    operator fun get(i: Int): Float

    fun fold(
            initial: Float,
            fn: (accumulator: Float, fl: Float) -> Float
    ): Float
    fun foldIndexed(
            initial: Float,
            fn: (i: Int, accumulator: Float, fl: Float) -> Float
    ): Float
    fun forEach(fn: (Float) -> Unit)
    fun forEachIndexed(fn: (Int, Float) -> Unit)

    fun add(o: ): R
    fun scale(a: Float): R
    fun unit(): R
    fun transform(m: SquareMatrix): R

    fun distance(o: Vector<*>): Float
    fun length(): Float

    fun distanceSquared(o: R): Float =
            foldIndexed(0f) { i, acc, _ ->
                acc + (o[i] - this[i]).square()
            }

    fun lengthSquared(): Float =
            fold(0f) { acc, f ->
                acc + f.square()
            }

    fun dot(o: V): Float =
            foldIndexed(0f) { i, acc, _ ->
                acc + o[i] * this[i]
            }

    fun approximately(o: V): Boolean {
        forEachIndexed { i, _ ->
            // if each value
            if ((this[i] - o[i]).abs() >= epsilon)
                return false
        }
        return true
    }
    fun isUnit(): Boolean = (lengthSquared() - 1f).abs() <= epsilon
    fun isZero(): Boolean = lengthSquared() <= epsilon
    fun isCollinear(o: V): Boolean =
            dot(o).square() - lengthSquared() *
                    o.lengthSquared() <= epsilon
    fun isPerpendicular(o: V): Boolean =
            dot(o).abs() <= epsilon
    fun hasSameDirection(o: V): Boolean =
            dot(o) > 0f
    fun hasOppositeDirection(o: V): Boolean =
            dot(o) < 0f
}

interface MutableVector<out R: MutableVector<R>>:
    Vector<R> {

    override fun add(o: Vector<*>): R {
        setAll {
            data[it] + o[it]
        }
        return this as R
    }
    override fun scale(a: Float): R {
        setAll {
            data[it] * a
        }
        return this as R
    }
    override fun unit(): R {
        val len2 = lengthSquared()
        if (len2.abs() <= epsilon ||
                len2 - 1f <= epsilon) {
        } else {
            val len = length()
            setAll {
                data[it] / len
            }
        }
        return this as R

    }
    operator fun set(i: Int, fl: Float) {
        data[i] = fl
    }
    fun setAll(fn: (Int) -> Float) {
        data.forEachIndexed { i, _ ->
            data[i] = fn(i)
        }
    }
    fun set(o: V) =
            setAll { o[it] }
    fun setAll(fl: Float) =
            setAll { fl }
    fun zero() =
            setAll { 0f }
}

interface Random {
    fun nextFloat(): Float
}
