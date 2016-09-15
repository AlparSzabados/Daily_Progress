package szabados.alpar

import static szabados.alpar.CurrentDate.TODAY

class Config {
    static final QUESTIONS = new File('questions.txt').text
    static final INSIGNIA = new File('insignia.txt').text
    static final LOG = new File("${TODAY}.txt")

    static final STARDATE = "Stardate: ${TODAY}\n\nCaptain's Log:\n\n"
    static final SAVE_QUESTION_MESSAGE = "Do you want to save today's progress? (y/n)"
    static final OVERWRITE_QUESTION_MESSAGE = "You already saved your progress today, do you want to overwrite?"
    static final PROGRESS_SAVED_MESSAGE = "Your progress was saved"
    static final PROGRESS_NOT_SAVED_MESSAGE = "Your progress was not saved"
    static final PROGRESS_OVERWRITTEN_MESSAGE = "Your progress was overwritten"
    static final PROGRESS_NOT_OVERWRITTEN_MESSAGE = "Your progress was not overwritten"
}