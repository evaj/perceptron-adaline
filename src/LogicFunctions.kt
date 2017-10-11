/**
 * Created by Dell on 2017-10-09.
 */

val AND_VALUES: Array<Array<Double>> = arrayOf(
        arrayOf(1.0, 1.0, 1.0),
        arrayOf(1.0, 0.0, 0.0),
        arrayOf(0.0, 1.0, 0.0),
        arrayOf(0.0, 0.0, 0.0)
)

val AND_VALUES_BIPOLAR: Array<Array<Double>> = arrayOf(
        arrayOf(1.0, 1.0, 1.0),
        arrayOf(1.0, -1.0, -1.0),
        arrayOf(-1.0, 1.0, -1.0),
        arrayOf(-1.0, -1.0, -1.0)
)

val OR_VALUES: Array<Array<Double>> = arrayOf(
        arrayOf(1.0, 1.0, 1.0),
        arrayOf(1.0, 0.0, 1.0),
        arrayOf(0.0, 1.0, 1.0),
        arrayOf(0.0, 0.0, 0.0)
)

val OR_VALUES_BIPOLAR: Array<Array<Double>> = arrayOf(
        arrayOf(1.0, 1.0, 1.0),
        arrayOf(1.0, -1.0, 1.0),
        arrayOf(-1.0, 1.0, 1.0),
        arrayOf(-1.0, -1.0, -1.0)
)

val XOR_VALUES_BIPOLAR: Array<Array<Double>> = arrayOf(
        arrayOf(1.0, 1.0, -1.0),
        arrayOf(1.0, -1.0, 1.0),
        arrayOf(-1.0, 1.0, 1.0),
        arrayOf(-1.0, -1.0, -1.0)
)