package com.reborn.reborn.ui.view.picker

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.Resource
import com.reborn.reborn.R

class PickerAdapterWeight : RecyclerView.Adapter<PickerItemViewHolder>() {

  private val data: ArrayList<String> = ArrayList()
  var callback: Callback? = null
  private val clickListener = View.OnClickListener { v -> v?.let { callback?.onItemClicked(it) } }
  private var selectedItem: Int? = -1
  private var ctx: Context? = null

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): PickerItemViewHolder {

    ctx = parent.context

    val itemView: View = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_horizontal_picker, parent, false)

    itemView.setOnClickListener(clickListener)
    return PickerItemViewHolder(itemView)
  }

  override fun getItemCount(): Int {
    return data.size
  }

  override fun onBindViewHolder(
    holder: PickerItemViewHolder,
    position: Int
  ) {
    holder.tvItem?.text = data[position]

    when (selectedItem) {
      position -> {
        holder.tvItem?.setTextColor(ContextCompat.getColor(ctx!!, R.color.black))
        holder.tvKg?.visibility = View.VISIBLE
        selectedItem = -1
      }
      else -> {
        holder.tvItem?.setTextColor(ContextCompat.getColor(ctx!!, R.color.grey_c4))
        holder.tvKg?.visibility = View.GONE
      }
    }
  }

  fun setSelectedItem(position: Int) {
    selectedItem = position
    notifyDataSetChanged()
  }

  fun setData(data: ArrayList<String>) {
    this.data.clear()
    this.data.addAll(data)
    notifyDataSetChanged()
  }

  interface Callback {
    fun onItemClicked(view: View)
  }
}