package com.fitpeo.assignment.screen.loaddata

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fitpeo.assignment.BaseActivity
import com.fitpeo.assignment.interfaces.OnItemClickListener
import com.fitpeo.assignment.other.Status
import com.fitpeo.assignment.screen.loaddata.models.LoadDataItem
import com.fitpeo.assignment.screen.loaddata.viewmodels.LoadDataViewModel
import com.fitpeo.assignment.screen.showdetail.ShowDetailActivity
import com.fitpeo.databinding.ActivityLoadDataBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LoadDataActivity : BaseActivity() {
    lateinit var binding: ActivityLoadDataBinding
    private val viewModel: LoadDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
        //Setup observer for api response
        setApiObserver()
    }

    private fun setUpView() {
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerViewLoadData.layoutManager = layoutManager
    }

    private fun setAdapter(list: ArrayList<LoadDataItem>) {
        val adapter = LoadDataAdapter(list, object : OnItemClickListener {
            override fun onAdapterRowItemClick(pos: Int) {
                var item = viewModel.getClickedItem(pos)
                item?.let {
                    Timber.i("clicked : pos :$pos title ${item.title}")
                    startShowDetail(item)
                }
            }
        })
        binding.recyclerViewLoadData.adapter = adapter
    }

     fun startShowDetail(item: LoadDataItem) {
        val intent = Intent(this@LoadDataActivity, ShowDetailActivity::class.java)
        intent.putExtra("title", item.title)
        intent.putExtra("url", item.url)
        startActivity(intent)
    }

    private fun setApiObserver() {
        viewModel.res.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    dismissAppDialog()
                    it.data.let { res ->
                        res?.let {
                            //Get the data
                            setAdapter(res)
                        } ?: {
                            //Error
                        }
                    }
                }

                Status.LOADING -> {
                    showAppDialog()
                }

                Status.ERROR -> {
                    dismissAppDialog()
                    Snackbar.make(
                        binding.mainContainer,
                        "Something went wrong",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }
}
