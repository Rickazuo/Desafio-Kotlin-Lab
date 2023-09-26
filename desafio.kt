enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun listarInscritos(): List<Usuario> {
        return inscritos.toList()
    }

    fun estaInscrito(usuario: Usuario): Boolean {
        return inscritos.contains(usuario)
    }
}

fun main() {
    val formacaoNome = "Curso de Malabarismo Avançado"
    val conteudoNome = "Lançamento de Facas em Chamas"
    val duracao = 120
    val usuarioNome = "Palhaço Bobinho"

    val usuario = Usuario(usuarioNome)
    val conteudo = ConteudoEducacional(conteudoNome, duracao)
    val formacao = Formacao(formacaoNome, listOf(conteudo))

    formacao.matricular(usuario)

    println("\nInformações da formação:")
    println("Nome: ${formacao.nome}")
    println("Conteúdos: ${formacao.conteudos.joinToString { it.nome }}")

    val inscritos = formacao.listarInscritos()
    println("\nInscritos na formação:")
    inscritos.forEachIndexed { index, inscrito ->
        println("${index + 1}. ${inscrito.nome}")
    }
}
