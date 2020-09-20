package com.android.infocus.adapters

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.android.infocus.data.ItemUpdates
import com.android.infocus.databinding.ItemRvUpdatesBinding

class UpdatesAdapter (
    private val data: List<ItemUpdates>,
    private val mContext: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var titleColor: Int = Color.BLACK
    var contentColor: Int = Color.parseColor("#808080")
    var iconColor: Int = Color.BLACK

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemUpdatesVH(ItemRvUpdatesBinding.inflate(LayoutInflater.from(mContext), parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position <= data.size) {
            with((holder as ItemUpdatesVH).binding) {
                if (data[position].imageRes != 0) {
                    AppCompatResources.getDrawable(mContext, data[position].imageRes)?.let { drawable ->
                        DrawableCompat.setTint(drawable, iconColor)

                        title.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
                    }
                }

                with(title) {
                    gravity = Gravity.CENTER_VERTICAL
                    compoundDrawablePadding = 16
                    text = data[position].title
                    setTextColor(contentColor)
                }

                with(desc) {
                    text = data[position].desc
                    setTextColor(contentColor)
                }

            }
        }
    }

    class ItemUpdatesVH(val binding: ItemRvUpdatesBinding) : RecyclerView.ViewHolder(binding.root)

}