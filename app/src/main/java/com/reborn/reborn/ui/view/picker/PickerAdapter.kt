package com.reborn.reborn.ui.view.picker

import android.app.Activity
import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.Resource
import com.reborn.reborn.R

class PickerAdapter(activity: LifecycleOwner) : RecyclerView.Adapter<PickerItemViewHolder>() {

      private val data: ArrayList<String> = ArrayList()
      var callback: Callback? = null
        var activitys = activity
      private var selectedItem: MutableLiveData<Int>? = MutableLiveData()
      private var ctx: Context? = null

      override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
      ): PickerItemViewHolder {

          ctx = parent.context

          val itemView: View = LayoutInflater.from(parent.context)
              .inflate(R.layout.item_horizontal_picker, parent, false)

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

//          holder.tvItem?.setOnClickListener {
//              callback?.getPosition(position)
//          }
          selectedItem!!.observe(activitys, Observer {
              when (it) {
                  position -> {
                      holder.tvItem?.setTextColor(ContextCompat.getColor(ctx!!, R.color.black))
                      holder.tvCm?.visibility = View.VISIBLE
                  }
                  else -> {
                      holder.tvItem?.setTextColor(ContextCompat.getColor(ctx!!, R.color.grey_c4))
                      holder.tvCm?.visibility = View.GONE
                  }
              }
          })

      }

      fun setSelectedItem(position: Int) {
          selectedItem?.value = position
      }

      fun setData(data: ArrayList<String>) {
          this.data.clear()
          this.data.addAll(data)
          notifyDataSetChanged()
      }

      interface Callback {
          fun getPosition(position : Int)
      }
}