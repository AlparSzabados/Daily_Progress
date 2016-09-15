package szabados.alpar

import static szabados.alpar.UserInput.userInput

class SaveToLog {
    static saveLog(writeToLog, String messageYes, String messageNo) {
        def userYes = userInput().toLowerCase() == 'y'
        if (userYes) {
            writeToLog
            println messageYes
        } else
            println messageNo
    }
}