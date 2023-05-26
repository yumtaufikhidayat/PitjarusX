package com.yumtaufikhidayat.pitjarusx.ui.store.storelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yumtaufikhidayat.pitjarusx.databinding.ItemStoreVisitingListBinding
import com.yumtaufikhidayat.pitjarusx.model.login.Store

class StoreListAdapter(
    private val onItemClickListener: () -> Unit
) : ListAdapter<Store, StoreListAdapter.StoreViewHolder>(storeListDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder(
            ItemStoreVisitingListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class StoreViewHolder(private val binding: ItemStoreVisitingListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Store) {
            binding.apply {
                tvStoreName.text = data.storeName
                itemView.setOnClickListener {
                    onItemClickListener()
                }
            }
        }
    }

    companion object {
        private val storeListDiffCallback = object : DiffUtil.ItemCallback<Store>() {
            override fun areItemsTheSame(
                oldItem: Store,
                newItem: Store
            ): Boolean = oldItem.accountId == newItem.accountId

            override fun areContentsTheSame(
                oldItem: Store,
                newItem: Store
            ): Boolean = oldItem == newItem
        }
    }
}