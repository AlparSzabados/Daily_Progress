package szabados.alpar

import static szabados.alpar.Config.*
import static szabados.alpar.CreateQuestions.createQuestions
import static szabados.alpar.CurrentDate.TODAY
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

        println "Log preview:\n\n${INSIGNIA}\n${TODAY}\n\nToday's progress:\n"
        String answers = questions.inject('') { s, it -> s + "${it.key.capitalize()}: ${it.value}\n" }
        println "${answers}\n"

        File output = LOG
        boolean fileExists = output.exists()
        if (fileExists) {
            println OVERWRITE_MESSAGE
            userInput().toLowerCase() == 'y' ? output.write(answers.toString()) : println("Your progress was not overwritten")
        } else {
            println SAVE_MESSAGE
            userInput().toLowerCase() == 'y' ? output.write(answers.toString()) : println("Your progress was not saved")
        }
    }
}