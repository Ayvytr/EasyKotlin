package com.ayvytr.easykotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import com.ayvytr.easykotlin.android.context.*
import com.ayvytr.easykotlin.android.ui.fullscreen
import com.ayvytr.easykotlin.android.ui.hideActionBar
import com.ayvytr.easykotlin.android.ui.isFullscreen
import com.ayvytr.easykotlin.android.ui.showActionBar
import com.ayvytr.easykotlin.customview.global.Res
import kotlinx.android.synthetic.main.activity_resources.*

class ResourcesActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resources)
        initView()
    }

    private fun initView()
    {
        btnGetAppName.setOnClickListener {
            btnGetAppName.text = getString(R.string.app_name)
        }

        ib1.setImageDrawable(getDrawable2(R.mipmap.ic_launcher))

        val drawableArray = getDrawableArray(R.array.drawableArray)
//        toast("drawable array size: ${drawableArray.size}")

        val drawableIdArray = getDrawableIdArray(R.array.drawableArray)
        var str = ""
        drawableIdArray.forEach {
            str += it.toString() + " "
        }
        toast(str)

        ib2.setImageDrawable(drawableArray[0])
        ib3.setImageDrawable(drawableArray[1])

        val m = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(m)
        toast("${m.widthPixels}, ${m.heightPixels}")

        val color = Res.getColor(this, R.color.abc_background_cache_hint_selector_material_dark)
        btnGetAppName.setBackgroundColor(color)

//        setLandscape()

        tv.text = "${getScreenWidth()} ${getScreenHeight()}"
        val dm = getDisplayMetrics()
        tv2.text = "${dm.widthPixels} ${dm.heightPixels}"

        btnHideActionBar.setOnClickListener {
            if (supportActionBar!!.isShowing) hideActionBar() else showActionBar()
        }

        btnFullScreen.setOnClickListener {
            if(isFullscreen())
            {
                fullscreen(false)
            }
            else
            {
                fullscreen(true)
            }
        }
    }

    override fun onBackPressed()
    {
        if (isLandscape())
        {
            setPortrait()
            return
        }

        super.onBackPressed()
    }
}
