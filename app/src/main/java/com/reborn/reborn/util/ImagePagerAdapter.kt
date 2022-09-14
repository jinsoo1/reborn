package com.reborn.reborn.util

import android.util.Log
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.databinding.ItemImageListBinding
import kotlinx.android.synthetic.main.item_image_list.view.*
import org.jetbrains.anko.intentFor

class ImagePagerAdapter(item : List<String>?) : BaseRecyclerAdapter<String, ItemImageListBinding>(
    R.layout.item_image_list
){
    var photoItem = item

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        Log.d("FeedImageList-A", photoItem.toString())
        holder.binding.root.ivImages.setOnClickListener {
            it.context.apply {
//                startActivity(
//                    intentFor<FeedImageListActivity>(
//                        "photoItem" to photoItem,
//                        "position" to position
//                    )
//                )
            }

        }

    }
}