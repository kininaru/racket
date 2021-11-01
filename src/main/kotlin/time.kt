import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

fun nextLoginTime(): String {
    val hour = DateTimeFormatter.ofPattern("HH")
        .withZone(ZoneOffset.UTC)
        .format(Instant.now()).toInt() + 8
    val minute = DateTimeFormatter.ofPattern("mm")
        .withZone(ZoneOffset.UTC)
        .format(Instant.now()).toInt()

    return when (hour) {
        in 8..10 -> "11:30"
        in 14..16 -> "17:30"
        in 19..20 -> "21:00"
        in 0..6 -> "7:30"
        else -> ""
    }
}

fun getStatusFromTime(time: String): String {
    return when (time) {
        "11:30", "17:30", "21:30" -> "读书"
        "7:30" -> "睡觉"
        else -> ""
    }
}