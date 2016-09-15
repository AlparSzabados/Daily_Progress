package szabados.alpar

import static szabados.alpar.Config.INSIGNIA
import static szabados.alpar.Config.LOG
import static szabados.alpar.CurrentDate.TODAY
import static szabados.alpar.UserInput.userInput

class SaveToLog {
    static saveLog(answers, String messageYes, String messageNo) {
        boolean userYes = userInput().toLowerCase() == 'y'
        if (userYes) {
            LOG.write("${INSIGNIA}\n${TODAY}\n\nToday's progress:\n${answers.toString()}")
            println messageYes
        } else
            println messageNo
    }
}