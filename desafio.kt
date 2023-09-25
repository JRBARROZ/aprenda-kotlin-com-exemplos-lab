

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val matricula: Number, val name: String){
    init {
        println("Novo Candidato: $name - $matricula")
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val courseLevel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    fun alunosMatriculados() : MutableList<Usuario>{
        return inscritos
    }

    fun removerMatricula(matricula: Number){
        for(inscrito in inscritos){
            if(inscrito.matricula == matricula){
                inscritos.remove(inscrito)
                return
            }
        }
    }
}

fun main() {

    val conteudos: List<ConteudoEducacional> = listOf<ConteudoEducacional>(
        ConteudoEducacional("Javascript", 30, Nivel.INTERMEDIARIO),
        ConteudoEducacional("CSS", 25, Nivel.BASICO),
        ConteudoEducacional("HTML", 10, Nivel.BASICO),
    )

    val students: List<Usuario> = listOf<Usuario>(
        Usuario(1, "Jhonatas"),
        Usuario(2, "Fábio"),
        Usuario(3, "Arthur")
    )

    val formacaoFrontEnd = Formacao("Front-End", conteudos)

    for (student in students){
        formacaoFrontEnd.matricular(student)
    }

    println(formacaoFrontEnd.alunosMatriculados())

    println(formacaoFrontEnd.removerMatricula(1))

    println(formacaoFrontEnd.alunosMatriculados())

}
