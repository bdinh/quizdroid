package edu.washington.bdinh.quizdroid

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.topic_row.view.*

class MainAdapter(val quizData: MutableList<Topic>) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.topic_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return quizData.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val topic :Topic = quizData.get(position)
        holder.view.textView_topic_title.text = topic.title
        holder.view.textView_short_description.text = topic.shortDescription
        holder.topic = topic
    }

}

class CustomViewHolder(val view :View, var topic: Topic? = null): RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener{
            val intent = Intent(view.context, MultiUseActivity::class.java)
            intent.putExtra("topicObj", topic)
            view.context.startActivity(intent)
        }
    }
}