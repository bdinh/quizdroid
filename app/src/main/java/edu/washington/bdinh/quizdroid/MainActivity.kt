package edu.washington.bdinh.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val questionMath1 = Question("What do you call an angle more than 90 degrees and less than 180 degrees?"
                , arrayOf("Obtuse", "Scalene", "Equilateral", "Acute"),
                0)
        val questionMath2 = Question("What's a polygon with four unequal sides called?",
                arrayOf("A quadrapolygon", "A quadrilateral", "Square", "Shape"), 1)

        val questionMath3 = Question("What mathematical symbol did math whiz Ferdinand von Lindemann determine to be a transcendental number in 1882?",
                arrayOf("Tilde", "PI", "Delta", "Euler-Mascheroni constant"), 1)

        val topicMath :Topic = Topic("Math",
                "A comprehensive set of math questions",
                arrayOf(questionMath1, questionMath2, questionMath3))


        val questionPhysics1 = Question("Which of the following is a physical quantity that has a magnitude but no direction?"
                , arrayOf("Scalar", "Vector", "Frame of reference", "Resultant"),
                0)
        val questionPhysics2 = Question("Which of the following is an example of a vector quantity?",
                arrayOf("Temperature", "Velocity", "Volume", "Mass"), 1)

        val questionPhysics3 = Question("Which of the following is an example of projectile motion?",
                arrayOf("An aluminum can dropped straight down into the recycling bin", "A thrown baseball",
                        "A spaece shuttle being launched", "A jet lifting off a runway"), 1)

        val topicPhysics :Topic = Topic("Physics",
                "A comprehensive set of physics questions",
                arrayOf(questionPhysics1, questionPhysics2, questionPhysics3))


        val questionMarvel1 = Question("What does Captain America carry with him into battle?"
                , arrayOf("Spear", "Shield", "Sword", "Axe"),
                1)
        val questionMarvel2 = Question("Nick Fury, Dum Dum Dugan and Maria Hill have all be Directors of which fictional Marvel Agency?",
                arrayOf("HYDRA", "S.H.I.E.L.D", "A.I.M", "H.A.M.M.E.R"), 1)

        val questionMarvel3 = Question("Which Marvel Villain is also known as the Mad Titan?",
                arrayOf("Annihilus", "Galactus",
                        "Terrax", "Thanos"), 3)

        val topicMarvel :Topic = Topic("Marvel",
                "A comprehensive set of Marvel questions",
                arrayOf(questionMarvel1, questionMarvel2, questionMarvel3))


        val quizData = QuizData(arrayOf(topicMath, topicPhysics, topicMarvel))
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = MainAdapter(quizData)
    }
}
