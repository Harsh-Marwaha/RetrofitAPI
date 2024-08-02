package com.harsh.retrofitapi

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsRecViewAdapter : RecyclerView.Adapter<NewsRecViewAdapter.ViewHolder> {

    private var context : Context? = null
    private var arrArticles : List<ArticlesModel>? = null


    constructor(context: Context,arrArticles: List<ArticlesModel>){
        this.context=context
        this.arrArticles=arrArticles
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsRecViewAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context!!).inflate(R.layout.row_news,parent,false))
    }

    override fun onBindViewHolder(holder: NewsRecViewAdapter.ViewHolder, position: Int) {
        holder.newsTitle.text = arrArticles?.get(position)!!.title
        holder.newsDescription.text = arrArticles?.get(position)!!.description
        Glide.with(context!!).load(arrArticles!![position].urlToImage).into(holder.newsImage)
    }

    override fun getItemCount(): Int {
        return arrArticles!!.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
        var newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDescription = itemView.findViewById<TextView>(R.id.newsDescription)
    }
}
