package io.github.covercash2.bbsp

import android.os.Bundle
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import io.github.covercash2.graphiks.gdx.GdxGame
import io.github.covercash2.graphiks.gdx.GdxWindow

class AndroidLauncher : AndroidApplication() {
    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)

        val config = AndroidApplicationConfiguration()
        initialize(GdxGame(GdxWindow()), config)
    }
}
