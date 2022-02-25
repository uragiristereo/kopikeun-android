package app.kopikeun.common

import java.text.NumberFormat
import java.util.*

object NumberHelper {
    fun formatThousand(value: Int): String {
        val formatter = NumberFormat.getNumberInstance(Locale.US)

        return formatter.format(value)
    }
}