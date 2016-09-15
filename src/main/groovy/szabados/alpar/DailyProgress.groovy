package szabados.alpar

import static szabados.alpar.Config.*
import static szabados.alpar.CreateQuestions.createQuestions
import static szabados.alpar.CurrentDate.TODAY
import static szabados.alpar.SaveToLog.*
import static szabados.alpar.UserInput.userInput

class DailyProgress {
    static void main(String... args) {
        Map<String, String> questions = createQuestions(QUESTIONS)
        println INSIGNIA
        println STARDATE
        for (question in questions) {
            println "Have you done any ${question.getKey()} today?"
            question.value = userInput()
        }

        String logPreview = "Log preview:\n\n${INSIGNIA}\n${TODAY}\n\nToday's progress:\n"
        String answers = questions.inject('') { s, it -> s + "${it.key.capitalize()}: ${it.value}\n" }
        println "${logPreview}${answers}\n"

        boolean fileExists = LOG.exists()
        if (!fileExists) {
            println SAVE
            saveLog(answers, SAVED, NOT_SAVED)
        } else {
            println OVERWRITE
            saveLog(answers, OVERWRITTEN, NOT_OVERWRITTEN)
        }
    }
}