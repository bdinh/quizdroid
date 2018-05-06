package edu.washington.bdinh.quizdroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.answer.*

class AnswerFragment : Fragment() {
    private var topic: Topic? = null
    private var index: Int? = null
    private var correct: Int? = null
    private var userAnswer: String? = null
    private var listener: OnAnswerFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            topic= it.getSerializable("topicObj") as Topic
            index= it.getInt("index")
            correct= it.getInt("correct")
            userAnswer=it.getString("userAnswer")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        arguments?.let {
            this.topic= it.getSerializable("topicObj") as Topic
            this.index= it.getInt("index")
            this.correct= it.getInt("correct")
            this.userAnswer=it.getString("userAnswer")
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.answer, container, false)
    }

    override fun onStart() {
        super.onStart()
        val prevQuestion = topic?.questions?.get(this.index as Int) as Quiz
        val correctAnswer = prevQuestion.choices.get(prevQuestion.answer)
        var newCorrect = this.correct as Int

        textView_answer_user.text = this.userAnswer as String
        textView_answer_correct.text = correctAnswer
        if (this.userAnswer == correctAnswer) {
            newCorrect += 1
        }
        val summary = "You have " + newCorrect + " out of " + (this.index as Int + 1) + " correct!"
        textView_answer_summary.text = summary

        if (this.index as Int == this.topic?.questions?.size as Int - 1) {
            button_answer_next.setText("Finished")
            button_answer_next.setOnClickListener{
                this.startActivity(Intent(this.activity, MainActivity::class.java))
            }

        } else {
            button_answer_next.setOnClickListener {
                nextQuestionWrapper(this.topic, this.index as Int + 1, newCorrect)
            }
        }
    }

    fun nextQuestionWrapper(topic: Topic?, index: Int?, correct: Int?) {
        listener?.nextQuestion(topic, index, correct)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnAnswerFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnAnswerFragmentInteractionListener {
        fun nextQuestion(topic: Topic?, index: Int?, correct: Int?)
    }

}
