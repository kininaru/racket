import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.utils.BotConfiguration

suspend fun main(args: Array<String>) {
    val bot = BotFactory.newBot(args[0].toLong(), args[1]) {
        fileBasedDeviceInfo()
        protocol = BotConfiguration.MiraiProtocol.ANDROID_PHONE
    }.alsoLogin()

    bot.eventChannel.subscribeAlways<FriendMessageEvent> {
        val time = nextLoginTime()
        val status = getStatusFromTime(time)
        if (status != "") subject.sendMessage("我现正在$status，账号由代码代管。按照统计规律，我下次上线的时间是 $time。您的这段消息已记录，下次上线时我将会看到针对此消息的报告。")
    }
}