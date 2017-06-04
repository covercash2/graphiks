package io.github.covercash2.bbsp

import com.github.salomonbrys.kodein.Kodein
import io.github.covercash2.graphiks.gdx.gdxModule

/**
 * Created by chreeus on 5/26/17.
 */

fun initGdx(): Kodein {
    return Kodein { import(gdxModule()) }
}
