package com.reborn.reborn.ui.binding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.reborn.reborn.R
import com.reborn.reborn.base.App

@BindingAdapter(value = ["dropdownStrings"])
fun Spinner.setDropdownStrings(items: List<String>) {
    val adapter = SelectDropdownAdapter(this.context)
    adapter.addAll(items)
    adapter.setDropDownViewResource(R.layout.item_search_spinner_dropdown_item)
    this.adapter = adapter
}


class SelectDropdownAdapter(
    context: Context
) : ArrayAdapter<String>(context, R.layout.item_spinner_item) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(App.appContext).inflate(R.layout.item_spinner_item, parent, false)
        val tv = view.findViewById<TextView>(R.id.text)
        tv.text = getItem(position)

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view.findViewById<TextView>(R.id.text)
        tv.text = getItem(position)

        return view
    }

}