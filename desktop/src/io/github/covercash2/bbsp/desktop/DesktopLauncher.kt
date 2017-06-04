package io.github.covercash2.bbsp.desktop

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.instance
import io.github.covercash2.graphiks.gdx.gdxModule

object DesktopLauncher {
    @JvmStatic fun main(arg: Array<String>) {

        val di = Kodein { import(gdxModule()) }

        val appListener: ApplicationListener = di.instance()

        val config = LwjglApplicationConfiguration()
        LwjglApplication(appListener, config)
    }
}
