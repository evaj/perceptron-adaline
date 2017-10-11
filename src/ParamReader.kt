import java.io.File
import java.util.*

/**
 * Created by Dell on 2017-10-09.
 */

fun getData(filename: String): Map<String, Double> {
    val file = File(filename)
    val result = HashMap<String, Double>()
    file.readLines().forEach { line ->
        val values = line.split(":")
        result.put(values[0], values[1].toDouble())
    }
    return result
}