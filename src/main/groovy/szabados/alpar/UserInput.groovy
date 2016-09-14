package szabados.alpar

class UserInput {
    static userInput() {
        def input = System.in.newReader().readLine()
        input.trim()
    }
}