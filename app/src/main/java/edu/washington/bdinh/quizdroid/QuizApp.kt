package edu.washington.bdinh.quizdroid

import android.util.Log

class QuizApp  : android.app.Application() {

    companion object {
        val quizData = QuizData()

        init {
            val questionMath1 = Quiz("What do you call an angle more than 90 degrees and less than 180 degrees?"
                    , arrayOf("Obtuse", "Scalene", "Equilateral", "Acute"),
                    0)
            val questionMath2 = Quiz("What's a polygon with four unequal sides called?",
                    arrayOf("A quadrapolygon", "A quadrilateral", "Square", "Shape"), 1)

            val questionMath3 = Quiz("What mathematical symbol did math whiz Ferdinand von Lindemann determine to be a transcendental number in 1882?",
                    arrayOf("Tilde", "PI", "Delta", "Euler-Mascheroni constant"), 1)

            val topicMath: Topic = Topic("Math",
                    "",
                    "A set of math questions",
                    "A comprehensive set of math questions that will exercise your math knowledge",
                    arrayOf(questionMath1, questionMath2, questionMath3))

            this.quizData.add(topicMath)

            val questionPhysics1 = Quiz("Which of the following is a physical quantity that has a magnitude but no direction?"
                    , arrayOf("Scalar", "Vector", "Frame of reference", "Resultant"),
                    0)
            val questionPhysics2 = Quiz("Which of the following is an example of a vector quantity?",
                    arrayOf("Temperature", "Velocity", "Volume", "Mass"), 1)

            val questionPhysics3 = Quiz("Which of the following is an example of projectile motion?",
                    arrayOf("An aluminum can dropped straight down into the recycling bin", "A thrown baseball",
                            "A spaece shuttle being launched", "A jet lifting off a runway"), 1)

            val topicPhysics: Topic = Topic("Physics",
                    "",
                    "A set of physics questions",
                    "A comprehensive set of physics questions that will exercise your physics knowledge",
                    arrayOf(questionPhysics1, questionPhysics2, questionPhysics3))

            this.quizData.add(topicPhysics)

            val questionMarvel1 = Quiz("What does Captain America carry with him into battle?"
                    , arrayOf("Spear", "Shield", "Sword", "Axe"),
                    1)
            val questionMarvel2 = Quiz("Nick Fury, Dum Dum Dugan and Maria Hill have all be Directors of which fictional Marvel Agency?",
                    arrayOf("HYDRA", "S.H.I.E.L.D", "A.I.M", "H.A.M.M.E.R"), 1)

            val questionMarvel3 = Quiz("Which Marvel Villain is also known as the Mad Titan?",
                    arrayOf("Annihilus", "Galactus",
                            "Terrax", "Thanos"), 3)

            val topicMarvel: Topic = Topic("Marvel",
                    "",
                    "A set of Marvel questions",
                    "A comprehensive set of Marvel questions that will exercise your MCU knowledge",
                    arrayOf(questionMarvel1, questionMarvel2, questionMarvel3))

            this.quizData.add(topicMarvel)
        }

        fun getTopicRepository(): MutableList<Topic> {
            return this.quizData.get()
        }
    }


    override fun onCreate() {
        super.onCreate()
        Log.i("QUIZAPP", "onCreate event fired")
    }
}
