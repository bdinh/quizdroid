package edu.washington.bdinh.quizdroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.question.*

class QuestionActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question)

        button_question_submit.visibility = View.INVISIBLE
        val topic = intent.getSerializableExtra("topic") as Topic
        val index = intent.getIntExtra("questionIndex", -1)
        val correct = intent.getIntExtra("correctCount", -1)
        val question = topic.questions.get(index)
        textView_question_question.text = question.question
        radioButton_question_answer_1.text = question.choices.get(0)
        radioButton_question_answer_2.text = question.choices.get(1)
        radioButton_question_answer_3.text = question.choices.get(2)
        radioButton_question_answer_4.text = question.choices.get(3)

        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            button_question_submit.visibility = View.VISIBLE
        })

        button_question_submit.setOnClickListener {
            val checkedId = radioGroup.checkedRadioButtonId
            var checkedRadionButton = findViewById<RadioButton>(checkedId)
            val intent = Intent(this, AnswerActivity::class.java)
            intent.putExtra("topic", topic)
            intent.putExtra("questionIndex", index)
            intent.putExtra("correctCount", correct)
            intent.putExtra("userAnswer", checkedRadionButton.text)
            this.startActivity(intent)
        }

    }

}