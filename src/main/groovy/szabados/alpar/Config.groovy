package szabados.alpar

import static szabados.alpar.CurrentDate.TODAY

class Config {
    static final QUESTIONS = new File('questions.txt').text
    static final INSIGNIA = new File('insignia.txt').text
    static final LOG = new File("${TODAY}.txt")

    static final STARDATE = "Stardate: ${TODAY}\n\nCaptain's Log:\n\n"
    static final SAVE = "Do you want to save today's progress? (y/n)"
    static final OVERWRITE = "You already saved your progress today, do you want to overwrite?"
    static final SAVED = "Your progress was saved"
    static final NOT_SAVED = "Your progress was not saved"
    static final OVERWRITTEN = "Your progress was overwritten"
    static final NOT_OVERWRITTEN = "Your progress was not overwritten"
}