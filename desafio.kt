val nível = Nivel.BASICO

enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    AVANCADO
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Usuario(val nome: String, val email: String)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun listarInscritos(): List<Usuario> {
        return inscritos
    }
}

fun main() {
    val conteudo = ConteudoEducacional("Aprendendo Kotlin", 60, nível)

    val formacao = Formacao("Curso Básico de Kotlin", listOf(conteudo))

    val usuario = Usuario("Leonardo Cardoso", "leonardocardoso@email.com")
    formacao.matricular(usuario)

    println("Inscritos na formação: ${formacao.listarInscritos()}")
}