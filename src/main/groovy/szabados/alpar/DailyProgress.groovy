package szabados.alpar

import static szabados.alpar.Config.*
import static szabados.alpar.CreateQuestions.collectQuestions
import static szabados.alpar.CurrentDate.TODAY
import static szabados.alpar.SaveToLog.saveLog
import static szabados.alpar.UserInput.userInput

class DailyProgress {
    static void main(String... args) {
        def questions = collectQuestions(QUESTIONS)
        println INSIGNIA
        println STARDATE
        for (question in questions) {
            println "Have you done any ${question.key} today?"
            question.value = userInput()
        }

        def logPreview = "Log preview:\n\n${INSIGNIA}\n${TODAY}\n\nToday's progress:\n"
        def answers = questions.inject('') { s, it ->  "${s}${it.key.capitalize()}: ${it.value}\n" }
        println "${logPreview}${answers}\n"

        def fileExists = LOG.exists()
        if (fileExists) {
            println OVERWRITE
            saveLog(answers, OVERWRITTEN, NOT_OVERWRITTEN)
        } else {
            println SAVE
            saveLog(answers, SAVED, NOT_SAVED)
        }
    }
}