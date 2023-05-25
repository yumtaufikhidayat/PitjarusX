package com.yumtaufikhidayat.pitjarusx.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yumtaufikhidayat.pitjarusx.databinding.ItemMenuBinding
import com.yumtaufikhidayat.pitjarusx.model.menu.MenuEntity

class MenuAdapter(
    private val onItemClickListener: (Int) -> Unit
): ListAdapter<MenuEntity, MenuAdapter.MenuViewHolder>(menuDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            ItemMenuBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class MenuViewHolder(private val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MenuEntity, position: Int) {
            binding.apply {
                imgMenu.setImageResource(data.menuIcon)
                tvMenuName.text = data.menuName
                itemView.setOnClickListener {
                    onItemClickListener(position)
                }
            }
        }
    }

    companion object {
        private val menuDiffCallback = object : DiffUtil.ItemCallback<MenuEntity>() {
            override fun areItemsTheSame(
                oldItem: MenuEntity,
                newItem: MenuEntity
            ): Boolean = oldItem.menuId == newItem.menuId

            override fun areContentsTheSame(
                oldItem: MenuEntity,
                newItem: MenuEntity
            ): Boolean = oldItem == newItem
        }
    }
}