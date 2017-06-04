package io.github.covercash2.graphiks.gdx

import com.badlogic.gdx.ApplicationListener
import com.github.salomonbrys.kodein.*
import io.github.covercash2.graphiks.Random
import io.github.covercash2.graphiks.Window

/**
 * Created by chreeus on 5/26/17.
 */

fun gdxModule() = Kodein.Module {
    bind<Window>() with singleton {
        GdxWindow()
    }

    bind<ApplicationListener>() with singleton {
        val w: Window = instance()
        GdxGame(w)
    }

    bind<Random>() with multiton { seed: Long ->
        GdxRandom(seed)
    }

}
