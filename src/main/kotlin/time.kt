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

    if (hour in 8..11) return "11:30"
    if (hour in 14..17) return "17:30"
    if (hour in 19..21) return "21:00"
    if (hour in 0..7) return "7:30"
    return ""
}

fun getStatusFromTime(time: String): String {
    return when (time) {
        "11:30" -> "读书"
        "17:30" -> "读书"
        "21:30" -> "读书"
        "7:30" -> "睡觉"
        else -> ""
    }
}