package szabados.alpar

import java.time.MonthDay
import java.time.Year
import java.time.format.DateTimeFormatter

import static szabados.alpar.Config.*
import static szabados.alpar.UserInput.userInput

class Daily_Progress {
    static void main(String... args) {
        def monthDay = MonthDay.now().format(DateTimeFormatter.ofPattern("MMM-dd"))
        def year = Year.now()
        def today = "${monthDay}-${year}"
        def QUESTIONS = createQuestions(QUESTIONS)

        def insignia = new File('insignia.txt').text
        println (insignia)
        println "Stardate: ${today}\n\nCaptains Log:\n\n"

        for (activities in QUESTIONS) {
            println "Have you done any ${activities.getKey()} today?"
            activities.value = userInput()
        }

        def text = "${insignia}\n${today}\n\nToday's progress:\n\n"
        def output = new File("${today}.txt")

        QUESTIONS.each { text += "${it.key.capitalize()}: ${it.value}\n" }

        println "Summary of: ${text}\n"

        boolean fileExists = output.exists()
        if (fileExists) {
            println "You already saved your progress today, do you want to overwrite?"
            userInput().toLowerCase() == 'y' ? output.write(text) : println("your progress was not overwritten")
        } else {
            println "Do you want to save today's progress? (y/n)"
            userInput().toLowerCase() == 'y' ? output.write(text) : println("your progress was not saved")
        }
    }

    static Map<String, String> createQuestions(String text) {
        Map questions = [:]
        text.eachLine { line ->
            questions.put(line, '')
        }
        questions
    }
}