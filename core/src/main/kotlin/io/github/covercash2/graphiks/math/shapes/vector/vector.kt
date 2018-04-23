package io.github.covercash2.graphiks.math.shapes.vector

import io.github.covercash2.graphiks.SquareMatrix
import io.github.covercash2.graphiks.Vector

/**
 * Created by chreeus on 5/26/17.
 */
typealias VectorInitializer = (Int) -> Float

/**
 * a 2D vector
 */
//abstract class Vector2D<T: Vector2D<T>>(
//        init: VectorInitializer
//): BaseVector<T>(2, init) {
//    val x: Float
//        inline get() = this[0]
//    val y: Float
//        inline get() = this[1]
//}

/**
 * a 3D vector
 */
//abstract class Vector3D<T: Vector3D<T>>(
//        init: VectorInitializer
//): BaseVector<T>(3, init) {
//    val x: Float
//        inline get() = this[0]
//    val y: Float
//        inline get() = this[1]
//    val z: Float
//        inline get() = this[2]
//}

/**
 * this implementation is a vector
 * whose functions alter their own data
 * and methods that return a vector will
 * return this
 */
