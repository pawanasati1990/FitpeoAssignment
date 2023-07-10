package com.fitpeo.assignment.screen.loaddata

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fitpeo.assignment.interfaces.OnItemClickListener
import com.fitpeo.assignment.screen.loaddata.models.LoadDataItem
import com.fitpeo.databinding.AdapterLoadDataRowBinding
import com.squareup.picasso.Picasso
import timber.log.Timber

class LoadDataAdapter(
    list: ArrayList<LoadDataItem>,
    clickListener: OnItemClickListener
) : RecyclerView.Adapter<LoadDataAdapter.LoadDataViewHolder>() {

    private var onItemClickListener: OnItemClickListener
    private var listItem: List<LoadDataItem>
    lateinit var binding: AdapterLoadDataRowBinding

    init {
        onItemClickListener = clickListener
        listItem = list
    }

    inner class LoadDataViewHolder(binding: AdapterLoadDataRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(position: Int)=with(binding){
            var item = listItem[position]

             tvTitle.text=item.title
            Picasso.get().load(item.thumbnailUrl).into(ivThumbnail)

           binding.llRowContainer.setOnClickListener {
                onItemClickListener.onAdapterRowItemClick(position)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoadDataViewHolder {
        binding =
            AdapterLoadDataRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoadDataViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }


    override fun onBindViewHolder(holder: LoadDataViewHolder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemViewType(position: Int): Int = position

}