package com.fitpeo.assignment.screen.showdetail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.fitpeo.R
import com.fitpeo.assignment.BaseActivity
import com.fitpeo.databinding.ActivityShowDetailBinding
import com.squareup.picasso.Picasso

class ShowDetailActivity:BaseActivity() {

    lateinit var binding: ActivityShowDetailBinding
    private val viewModel: ShowDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_show_detail)
        binding.showDetailViewModel=viewModel
        binding.lifecycleOwner=this
        findIntentData()
    }

    private fun findIntentData(){
        var title=intent.getStringExtra("title")
        var url=intent.getStringExtra("url")
        title?.let {
            viewModel.updateTitle(title)
            viewModel.updateImage(url?:"")
            Picasso.get().load(viewModel.imageUrl.value).
            error(R.drawable.fitpeo_logo).into(binding.ivPhoto)
        }
    }
}