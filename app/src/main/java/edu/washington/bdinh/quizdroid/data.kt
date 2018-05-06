package edu.washington.bdinh.quizdroid

import java.io.Serializable

class QuizData: TopicRepository {
    val topicList: MutableList<String> = mutableListOf()
    val data: MutableList<Topic> = mutableListOf()

    constructor()

    override fun add(topic: Topic) {
        data.add(topic)
        topicList.add(topic.title)
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
    val description: String
    val questions: Array<Quiz>

    constructor(title: String, description: String, questions: Array<Quiz>) {
        this.title = title
        this.description = description
        this.questions = questions
    }
}

class Quiz(val question: String, val choices: Array<String>, val answer: Int) :Serializable


