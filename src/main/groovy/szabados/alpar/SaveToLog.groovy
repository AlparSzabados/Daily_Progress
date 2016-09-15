package szabados.alpar

import static szabados.alpar.Config.LOG
import static szabados.alpar.UserInput.userInput

class SaveToLog {
    static saveLog(answers, String messageYes, String messageNo) {
        boolean userYes = userInput().toLowerCase() == 'y'
        if (userYes) {
            LOG.write(answers.toString())
            println messageYes
        } else
            println messageNo
    }
}