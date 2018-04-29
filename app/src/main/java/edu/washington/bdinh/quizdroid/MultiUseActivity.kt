package edu.washington.bdinh.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton

class MultiUseActivity : AppCompatActivity(), TopicsFragment.OnTopicsFragmentInteractionListener,
        QuestionFragment.OnQuestionFragmentInteractionListener, AnswerFragment.OnAnswerFragmentInteractionListener{

    override fun nextQuestion(topic: Topic?, index: Int?, correct: Int?) {
        val args = Bundle()
        args.putSerializable("topicObj", topic)
        args.putInt("index", index as Int)
        args.putInt("correct", correct as Int)
        val questionFragment = QuestionFragment()
        questionFragment.arguments = args
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.multi_use_activity, questionFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun submitAnswer(topic: Topic?, index: Int?, correct: Int?, userAnswer: Int) {
        val args = Bundle()
        args.putSerializable("topicObj", topic)
        args.putInt("index", index as Int)
        args.putInt("correct", correct as Int)
        val userAnswerString = findViewById<RadioButton>(userAnswer).text
        args.putString("userAnswer", userAnswerString.toString())
        val answerFragment = AnswerFragment()
        answerFragment.arguments = args
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.multi_use_activity, answerFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun beginTopicQuiz(topic: Topic?) {
        val args = Bundle()
        args.putSerializable("topicObj", topic)
        args.putInt("index", 0)
        args.putInt("correct", 0)
        val questionFragment = QuestionFragment()
        questionFragment.arguments = args
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.multi_use_activity, questionFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_use)
        val topicsFragment =TopicsFragment()
        topicsFragment.arguments = intent.extras
        val transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.multi_use_activity, topicsFragment)
        transaction.commit()
    }
}
