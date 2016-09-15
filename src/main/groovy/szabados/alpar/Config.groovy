package szabados.alpar

import static szabados.alpar.CurrentDate.TODAY

class Config {
    static final QUESTIONS = new File('questions.txt').text
    static final INSIGNIA = new File('insignia.txt').text
    static final LOG = new File("${TODAY}.txt")

    static final SAVE_MESSAGE = "Do you want to save today's progress? (y/n)"
    static final OVERWRITE_MESSAGE = "You already saved your progress today, do you want to overwrite?"
    static final STARDATE = "Stardate: ${TODAY}\n\nCaptain's Log:\n\n"
}