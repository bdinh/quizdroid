package edu.washington.bdinh.quizdroid

import android.media.Image
import java.io.Serializable

class QuizData: TopicRepository {
    val data: MutableList<Topic> = mutableListOf()

    constructor()

    override fun add(topic: Topic) {
        data.add(topic)
    }

    override fun update(topic: Topic) {
        // No need to update since this doesn't actually serves as a DB
    }

    override fun get(): MutableList<Topic> {
        return this.data
    }

    override fun remove(topic: Topic) {
        data.remove(topic)
    }

}

class Topic :Serializable{
    val title: String
    val icon: String
    val shortDescription: String
    val longDescription: String
    val questions: Array<Quiz>

    constructor(title: String, image: String, shortDescription: String, longDescription: String, questions: Array<Quiz>) {
        this.title = title
        this.icon = image
        this.shortDescription = shortDescription
        this.longDescription = longDescription
        this.questions = questions
    }
}

class Quiz(val question: String, val choices: Array<String>, val answer: Int) :Serializable


interface TopicRepository {
    fun add(topic: Topic)
    fun update(topic: Topic)
    fun remove(topic: Topic)
    fun get() :MutableList<Topic>
}