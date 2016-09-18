package szabados.alpar

class CreateQuestions {
    static Map<String, String> collectQuestions(String text) {
        Map questions = [:]
        text.eachLine { line ->
            questions[line] = ''
        }
        questions
    }
}
