import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import opennlp.tools.tokenize.TokenizerME
import opennlp.tools.tokenize.TokenizerModel
import java.io.FileInputStream

class ReverseAkinator {
    private lateinit var selectedIdol: String

    fun start() {
        val idols = listOf("島村卯月", "渋谷凛", "本田未央", "木村夏樹") // 実際にはもっと多くのアイドルを含める
        selectedIdol = idols.random()
        println("アイドルが選ばれました。質問を始めてください。")
    }

//    fun askQuestion(question: String): String {
//        return if (ai.evaluateQuestion(question)) "はい" else "いいえ"
//    }

    fun guessIdol(guess: String): Boolean {
        val idolName = guess.removeSuffix("ですか？")
        if (idolName.equals(selectedIdol, ignoreCase = true)) {
            println("おめでとうございます！正解です！")
            return true
        } else {
            println("残念！もう一度考えてみてください！")
            println(selectedIdol)
            return false
        }
    }
}

fun main() {
    val game = ReverseAkinator()
    game.start()

    while (true) {
        print("質問または推測を入力してください: ")
        val input = readLine() ?: continue

        if (input.endsWith("ですか？")) {
            val answer = game.guessIdol(input)
            if (answer) {
                println("正解です！")
                breakM
            }
        } else {
//            val correct = game.guessIdol(input)
//            if (correct) {
//                println("正解です！")
//            } else {
//                println("不正解です。正解は${game.selectedIdol}でした。")
//            }
            println("最後は ですか？ で終えてください")
        }
    }
}