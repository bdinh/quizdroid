package edu.washington.bdinh.quizdroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.topic_overview.*

class TopicOverViewActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.topic_overview)

        val topic = intent.getSerializableExtra("topicObj") as Topic
        supportActionBar?.title = topic.title + " Overview"
        textView_topicOverview_question_count.text = topic.questions.size.toString()
        textView_topicOverview_title.text = topic.title
        textView_topicOverview_description.text = topic.description

        button_topicOverview_begin.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("topic", topic)
            intent.putExtra("questionIndex", 0)
            this.startActivity(intent)
        }


    }
}