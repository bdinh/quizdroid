package edu.washington.bdinh.quizdroid

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.question.*

class QuestionFragment : Fragment() {
    private var topic: Topic? = null
    private var index: Int? = null
    private var correct: Int? = null
    private var listener: OnQuestionFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            topic= it.getSerializable("topicObj") as Topic
            index= it.getInt("index")
            correct= it.getInt("correct")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        arguments?.let {
            this.topic= it.getSerializable("topicObj") as Topic
            this.index= it.getInt("index")
            this.correct= it.getInt("correct")
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.question, container, false)
    }

    override fun onStart() {
        super.onStart()

        button_question_submit.visibility = View.INVISIBLE
        val question = this.topic?.questions?.get(this.index as Int)
        textView_question_question.text = question?.question
        radioButton_question_answer_1.text = question?.choices?.get(0)
        radioButton_question_answer_2.text = question?.choices?.get(1)
        radioButton_question_answer_3.text = question?.choices?.get(2)
        radioButton_question_answer_4.text = question?.choices?.get(3)
        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            button_question_submit.visibility = View.VISIBLE
        })

        button_question_submit.setOnClickListener {
            val checkedId = radioGroup.checkedRadioButtonId
            submitAnswerWrapper(this.topic, this.index, this.correct, checkedId)
        }
    }

    fun submitAnswerWrapper(topic: Topic?, index: Int?, correct: Int?, userAnswer: Int) {
        listener?.submitAnswer(topic, index, correct, userAnswer)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnQuestionFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnQuestionFragmentInteractionListener {
        fun submitAnswer(topic: Topic?, index: Int?, correct: Int?, userAnswer: Int)
    }

}
