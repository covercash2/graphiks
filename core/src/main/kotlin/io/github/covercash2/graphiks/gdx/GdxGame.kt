package io.github.covercash2.graphiks.gdx

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Vector3
import io.github.covercash2.graphiks.Window

class GdxGame(
        val window: Window
) : ApplicationListener {

    override fun create() {
        batch = SpriteBatch()
        img = Texture("badlogic.jpg")
    }

    override fun pause() {
        window.pause()
    }
    override fun resume() {
        window.resume()
    }
    override fun resize(width: Int, height: Int) {
        window.resize(width, height)
    }

    lateinit internal var batch: SpriteBatch
    lateinit internal var img: Texture

    override fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(img, 0f, 0f)
        batch.end()

        val vec: Vector2 = Vector2()
        val vec3: Vector3 = Vector3()

        window.update(Gdx.graphics.deltaTime)
        window.draw()
     }

    override fun dispose() {
        batch.dispose()
        img.dispose()
    }
}
