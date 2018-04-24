package edu.washington.bdinh.quizdroid

import java.io.Serializable

class QuizData {
    val topicList: MutableList<String> = mutableListOf()
    val data: Array<Topic>

    constructor(topics: Array<Topic>) {
        this.data = topics
        for (topic in topics) {
            this.topicList.add(topic.title)
        }
    }

}

class Topic :Serializable{
    val title: String
    val description: String
    val questions: Array<Question>


    constructor(title: String, description: String, questions: Array<Question>) {
        this.title = title
        this.description = description
        this.questions = questions
    }
}

class Question(val question: String, val choices: Array<String>, val answer: Int) :Serializable


