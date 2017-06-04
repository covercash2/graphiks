package io.github.covercash2.graphiks.math.shapes

import io.github.covercash2.graphiks.math.square
import io.github.covercash2.graphiks.Vector
import io.github.covercash2.graphiks.math.abs

/**
 * Created by chreeus on 5/26/17.
 */
typealias VectorInitializer = (Int) -> Float

/**
 * a vector class that implements platform independent
 * operations and functions that don't return a Vector
 */
abstract class BaseVector<V: BaseVector<V>>: Vector<V> {
    /**
     * allowed error
     *
     * TODO make configurable
     */
    val epsilon = 0.01f

    abstract internal val data: FloatArray

    override val dimension: Int
        get() = data.size

    override fun distanceSquared(o: V) =
            data.foldIndexed(0f) { i, acc, _ ->
                acc + (o[i] - data[i]).square()
            }

    override fun lengthSquared() =
            data.fold(0f) { f, acc ->
                acc + f.square()
            }

    override fun isCollinear(o: V) =
            isOnLine(o) && dot(o) > 0f
    override fun isCollinearOpposite(o: V) =
            isOnLine(o) && dot(o) < 0f
    override fun isPerpendicular(o: V) =
            dot(o).abs() < epsilon
    override fun isUnit() = (lengthSquared() - 1f).abs() < epsilon
    override fun isZero() = lengthSquared() < epsilon
    override fun hasSameDirection(o: V) =
            dot(o) > 0
    override fun hasOppositeDirection(o: V) =
            dot(o) < 0

    override fun approximately(o: V): Boolean {
        data.forEachIndexed { i, _ ->
            val zero = (this[i] - o[i]).abs()
            if (zero >= epsilon) return false
        }
        return true
    }

    operator fun get(i: Int) = data[i]
}
