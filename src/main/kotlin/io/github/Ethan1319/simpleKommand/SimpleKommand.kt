package io.github.Ethan1319.simpleKommand

import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class CommandShortenerPlugin : JavaPlugin() {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("플레이어만 사용할 수 있는 명령어입니다.")
            return true
        }

        when (command.name.lowercase()) {
            "gc" -> {
                sender.gameMode = GameMode.CREATIVE
                sender.sendMessage("게임모드가 크레이티브로 변경되었습니다.")
            }

            "gs" -> {
                sender.gameMode = GameMode.SURVIVAL
                sender.sendMessage("게임모드가 서바이벌로 변경되었습니다.")
            }

            "k" -> {
                sender.health = 0.0
                sender.sendMessage("§c자살 명령어가 실행되었습니다.")
            }

            "keepi" -> {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory true")
                sender.sendMessage("keepinv가 활성화되었습니다.")
            }

            else -> return false
        }

        return true
    }
}