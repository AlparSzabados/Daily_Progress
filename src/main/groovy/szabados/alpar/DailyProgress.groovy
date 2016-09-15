package szabados.alpar

import static szabados.alpar.Config.*
import static szabados.alpar.CreateQuestions.createQuestions
import static szabados.alpar.CurrentDate.TODAY
import static szabados.alpar.SaveToLog.saveLog
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
        def writeToLog = LOG.write(answers.toString())

        if (!fileExists) {
            println SAVE
            saveLog(writeToLog, SAVED, NOT_SAVED)
        } else {
            println OVERWRITE
            saveLog(writeToLog, OVERWRITTEN, NOT_OVERWRITTEN)
        }
    }
}