package com.example.viewpager2tutorial

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewpager2tutorial.databinding.ViewPagerRowLayoutBinding

class ViewPagerRecyclerAdapter(private val  imagesArray:IntArray,private val context: Context):RecyclerView.Adapter<ViewPagerRecyclerAdapter.MyViewHolder> (){

    class  MyViewHolder(var viewPagerRowLayoutBinding: ViewPagerRowLayoutBinding):RecyclerView.ViewHolder(viewPagerRowLayoutBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val viewPagerRowLayoutBinding = ViewPagerRowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(viewPagerRowLayoutBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       Glide.with(context).load(imagesArray[position]).into(holder.viewPagerRowLayoutBinding.imageView)
    }

    override fun getItemCount(): Int {
        return  imagesArray.size
    }
}