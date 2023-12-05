class Usuario(val name: String,val age: Int)
enum class Nivel {
    FACIL, INTERMEDIARIO, DIFICIL
}
data class ConteudoEducacional(var nome: String, val duracao: Int = 60)
data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>){
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario){
        inscritos.add(usuario)
    }
}
fun main(){
    val conteudo01 = ConteudoEducacional("Aprendendo a linguagem do Kotlin na raça e na coragem", duracao = 120)
    val conteudo02 = ConteudoEducacional("Vamos aprender Kotlin por que disseram que era mais fácil que Java", duracao = 120)

    val formacao = Formacao("Formação em linguagem de programação Kotlin, aprendendo do absoluto zero", Nivel.INTERMEDIARIO, mutableListOf(conteudo01, conteudo02))
    val usuario01 = Usuario("Ismael Roberto L Gonçalves", 25)
    val usuario02 = Usuario("Ismael Roberto Teixeira Silva", 27)

    formacao.matricular(usuario01);
    formacao.matricular(usuario02);

    println("Formação : ${formacao.nome}")
    println("Nivel ${formacao.nivel}")
    println("-------------------------")
    println("Conteudos ")
    for(forma in formacao.conteudos){
        println(forma.nome)
    }
    println("Inscritos ${formacao.inscritos.size}")
    for(inscrito in formacao.inscritos){
        println("${inscrito.name}")
    }
}