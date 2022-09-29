package com.reborn.reborn.ui.view.picker

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PickerItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

  val tvItem: TextView? = itemView?.findViewById(com.reborn.reborn.R.id.tv_item)
  val tvCm: TextView? = itemView?.findViewById(com.reborn.reborn.R.id.tv_cm)
  val tvKg: TextView? = itemView?.findViewById(com.reborn.reborn.R.id.tv_kg)
}