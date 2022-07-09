package kr.kro.minestar.nms.utility.api

import net.minecraft.network.protocol.game.PacketPlayOutAnimation
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerAnimationEvent
import org.bukkit.event.player.PlayerInteractEvent

object PlayerAnimation {
    enum class AnimationType {
        MAIN_HAND,
        OFF_HAND,
    }

    /**
     * 해당 기능 사용시 [PlayerInteractEvent]와 [PlayerAnimationEvent]가 발생합니다.
     */
    fun armAnimation(player : Player, type: AnimationType) {
        val entityPlayer = (player as CraftPlayer).handle
        when (type) {
            AnimationType.MAIN_HAND -> entityPlayer.b.a(PacketPlayOutAnimation(entityPlayer, 0))
            AnimationType.OFF_HAND -> entityPlayer.b.a(PacketPlayOutAnimation(entityPlayer, 3))
        }
    }
}