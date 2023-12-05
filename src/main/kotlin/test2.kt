class test2 {
}
fun main() {
    val urls = mutableListOf("https://chat.openai.com/", "https://www.invertexto.com/", "https://web.dio.me/", "")

    println("Iniciando downloads...")

    // Cria uma lista de Pair (índice, tamanho)
    val results = mutableListOf<Pair<Int, Int>>()

    // Inicia cada Thread para começar o processo de 'download' paralelamente
    val threads = urls.mapIndexed { index, url ->
        Thread {
            val length = openLink(url)
            synchronized(results) {
                results.add(Pair(index, length))
            }
        }
    }

    // Aguarde até que todas as Threads terminem suas respectivas execuções
    threads.forEach { it.join() }

    // Ordena os resultados por índice para imprimir na ordem correta
    results.sortedBy { it.first }.forEachIndexed { idx, result ->
        println("Arq${idx + 1}: ${result.second}")
    }
    println("Tempo total: ${urls.size}")
}

// Simula a abertura de uma URL, retornando seu tamanho.
fun openLink(url: String): Int {
    // Simula um download esperando 1 segundo
    Thread.sleep(1000)
    return url.length
}
