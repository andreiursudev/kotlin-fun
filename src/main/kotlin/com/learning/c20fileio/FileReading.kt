package academy.learnprogramming.iokotlin

import java.io.File


fun main(args: Array<String>) {
    val reader = File("testfile.txt").reader()
    val lines = reader.readLines()
    println(lines)
    reader.close()

    File("testfile.txt").reader().forEachLine { println(it) }

    //new InputStreamReader(new FileInputStreamReader(new File("testfile.txt")), "UTF-8")
}