package io.github.covercash2.graphiks.gdx

import com.badlogic.gdx.math.RandomXS128
import io.github.covercash2.graphiks.MathLib
import io.github.covercash2.graphiks.Random
import java.lang.Math as JMath

/**
 * Created by chreeus on 5/28/17.
 * functions and classes that don't deserve
 * their own file
 */

class GdxRandom(seed: Long): RandomXS128(seed), Random
