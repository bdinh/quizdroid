package edu.washington.bdinh.quizdroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.answer.*

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.answer)

        val topic = intent.getSerializableExtra("topic") as Topic
        var index = intent.getIntExtra("questionIndex", -1)
        if (index == -1) {
            index = 0
        }
        var correct = intent.getIntExtra("correctCount", -1)
        if (correct == -1) {
            correct = 0
        }
        val userAnswer = intent.getStringExtra("userAnswer")
        val prevQuestion = topic.questions.get(index)
        val correctAnswer = prevQuestion.choices.get(prevQuestion.answer)

        textView_answer_user.text = userAnswer
        textView_answer_correct.text = correctAnswer
        if (correctAnswer == userAnswer) {
            correct += 1
        }
        val summary = "You have " + correct + " out of " + (index + 1) + " correct!"
        textView_answer_summary.text = summary

        if (index == topic.questions.size - 1) {
            button_answer_next.setText("Finished")
            button_answer_next.setOnClickListener{
                this.startActivity(Intent(this, MainActivity::class.java))
            }

        } else {
            button_answer_next.setOnClickListener {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("topic", topic)
                intent.putExtra("questionIndex", index + 1)
                intent.putExtra("correctCount", correct)
                this.startActivity(intent)
            }
        }
    }
}