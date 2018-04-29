package edu.washington.bdinh.quizdroid

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.topic_overview.*

class TopicsFragment : Fragment() {
    private var topic: Topic? = null
    private var listener: OnTopicsFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            topic= it.getSerializable("topicObj") as Topic
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        arguments?.let {
            this.topic= it.getSerializable("topicObj") as Topic
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.topic_overview, container, false)
    }

    override fun onStart() {
        super.onStart()
        textView_topicOverview_question_count.text = this.topic?.questions?.size.toString()
        textView_topicOverview_title.text = this.topic?.title
        textView_topicOverview_description.text = this.topic?.description
        button_topicOverview_begin.setOnClickListener {
            beginTopicQuizWrapper(this.topic)
        }
    }

    fun beginTopicQuizWrapper(topic: Topic?) {
        listener?.beginTopicQuiz(topic)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnTopicsFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnTopicsFragmentInteractionListener {
        fun beginTopicQuiz(topic: Topic?)
    }

}
