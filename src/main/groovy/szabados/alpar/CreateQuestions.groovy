package szabados.alpar

class CreateQuestions {
    static Map<String, String> createQuestions(String text) {
        Map questions = [:]
        text.eachLine { line ->
            questions.put(line, '')
        }
        questions
    }
}
