package io.github.covercash2.graphiks

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
 */
interface Vector<V: Vector<V>> {
    val dimension: Int

    fun add(o: V): V
    fun scale(f: Float): V
    fun normalize(): V
    fun transform(m: SquareMatrix): V

    fun distance(o: V): Float
    fun length(): Float
    fun distanceSquared(o: V): Float
    fun lengthSquared(): Float
    fun dot(o: V): Float

    fun approximately(o: V): Boolean
    fun isUnit(): Boolean
    fun isZero(): Boolean
    fun isOnLine(o: V): Boolean
    fun isCollinear(o: V): Boolean
    fun isCollinearOpposite(o: V): Boolean
    fun isPerpendicular(o: V): Boolean
    fun hasSameDirection(o: V): Boolean
    fun hasOppositeDirection(o: V): Boolean
}

interface MathLib {
}

interface Random {
    fun nextFloat(): Float
}
