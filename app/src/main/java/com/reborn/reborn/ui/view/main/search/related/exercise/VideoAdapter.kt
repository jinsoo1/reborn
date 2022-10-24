package com.reborn.reborn.ui.view.main.search.related.exercise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.reborn.reborn.R
import com.reborn.reborn.base.App.Companion.getString


class VideoAdapter : RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    var youtubeVideoList: List<YouTubeVideos>? = null

    constructor() {}
    constructor(youtubeVideoList: List<YouTubeVideos>?) {
        this.youtubeVideoList = youtubeVideoList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_video_view, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {

        if(position%2 == 0){
            holder.title.text = getString(R.string.video_copy)
        }else{
            holder.title.text = getString(R.string.exercise_explanation)
        }

        holder.videoWeb.loadData(youtubeVideoList!![position].videoUrl!!, "text/html", "utf-8")

    }

    override fun getItemCount(): Int {
        return youtubeVideoList!!.size
    }

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var videoWeb: WebView
        var title : AppCompatTextView

        init {
            videoWeb = itemView.findViewById(R.id.videoWebView)
            videoWeb.settings.javaScriptEnabled = true
            videoWeb.webChromeClient = object : WebChromeClient() {}

            title = itemView.findViewById(R.id.tv_title)
        }
    }
}