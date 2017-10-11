import java.io.BufferedWriter
import java.io.File

/**
 * Created by Dell on 2017-10-08.
 */

fun generateData(number: Int, precision: Double, values: Array<Array<Double>>): Array<String?>{
    val result = arrayOfNulls<String>(number)
    for(item: Int in 0..number-1){
        result[item] = buildString(values[(Math.random()*values.size).toInt()], precision)
    }
    return result
}

fun generateDataArray(number: Int, precision: Double, values: Array<Array<Double>>): Array<Array<Double>> {
    var result = emptyArray<Array<Double>>()
    for(item: Int in 0..number-1){
        result = result.plus(getRandomlyModifiedRow(values[(Math.random()*values.size).toInt()].copyOf(), precision))
    }
    return result
}

fun getRandomlyModifiedRow(values: Array<Double>, precision: Double): Array<Double> {
    if(values.size != 3)
        throw IllegalArgumentException("Incorrect data length!")
    for(index: Int in 0..1){
        values[index] = getRandomlyModifiedValue(values[index], precision)
    }
    return values
}

fun buildString(values: Array<Double>, precision: Double): String{
    if(values.size != 3)
        throw IllegalArgumentException("Incorrect data length!")
    return "" + getRandomlyModifiedValue(values[0], precision).toString() +
            "," + getRandomlyModifiedValue(values[1], precision).toString() + ":" + values[2]
}

fun getRandomlyModifiedValue(number: Double, precision: Double): Double{
    return if (Math.random() > 0.5) (number + Math.random()*precision) else (number - Math.random()*precision)
}

fun writeData(filename: String, values: Array<String>) {
    File(filename).bufferedWriter().use { out ->
        values.forEach {
            out.writeLn(it)
        }
    }
}

fun BufferedWriter.writeLn(line: String) {
    this.write(line)
    this.newLine()
}
