package io.github.covercash2.graphiks.math.shapes.vector

import io.github.covercash2.graphiks.MutableVector
import io.github.covercash2.graphiks.SquareMatrix
import io.github.covercash2.graphiks.Vector

@Suppress("OVERRIDE_BY_INLINE")
/**
 * Created by chreeus on 6/7/17.
 */

class BaseVector(
        val data: FloatArray
): Vector {

    override inline fun fold(
            initial: Float,
            fn: (accumulator: Float, fl: Float) -> Float
    ): Float {
        return data.fold(initial, fn)
    }
    override inline fun foldIndexed(
            initial: Float,
            fn: (i: Int, accumulator: Float, fl: Float) -> Float
    ): Float {
        return data.foldIndexed(initial, fn)
    }
    override inline fun forEach(
            fn: (Float) -> Unit
    ) { data.forEach(fn) }
    override inline fun forEachIndexed(
            fn: (Int, Float) -> Unit
    ): Float { data.forEachIndexed(fn) }

    override val dimension: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val epsilon: Float
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun get(i: Int): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun scale(a: Float): {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unit(): {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transform(m: SquareMatrix): {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun distance(o: <out >): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun length(): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

//class Mutable2DVector<V>(
//        init: VectorInitializer
//): MutableVector<V, Mutable2DVector<V>>
//where V: Vector<V, Mutable2DVector<V>> {
//
//}
