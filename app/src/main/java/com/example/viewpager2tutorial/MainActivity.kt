package com.example.viewpager2tutorial

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.example.viewpager2tutorial.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {

    private val imagesArray = intArrayOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.d,
        R.drawable.e
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        val viewPagerRecyclerAdapter = ViewPagerRecyclerAdapter(imagesArray,this)
        activityMainBinding.viewPager.adapter = viewPagerRecyclerAdapter
        //Tab layout mediator
        TabLayoutMediator(
            activityMainBinding.tablayout,
            activityMainBinding.viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.customView = createTabItemView(
                imagesArray[position]
            )
        }.attach()

    }


    // create method that return circle imageview

    private fun createTabItemView(resourceId: Int): CircleImageView {
        val imageView = CircleImageView(this)
        imageView.borderColor = Color.WHITE
        imageView.borderWidth = 5
        Glide.with(applicationContext).load(resourceId).into(imageView)
        val params = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        imageView.layoutParams = params
        return imageView
    }
}