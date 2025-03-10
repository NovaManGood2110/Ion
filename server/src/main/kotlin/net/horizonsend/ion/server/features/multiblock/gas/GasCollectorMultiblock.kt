package net.horizonsend.ion.server.features.multiblock.gas

import net.horizonsend.ion.common.extensions.information
import net.horizonsend.ion.server.features.gas.Gasses
import net.horizonsend.ion.server.features.multiblock.FurnaceMultiblock
import net.horizonsend.ion.server.features.multiblock.InteractableMultiblock
import net.horizonsend.ion.server.features.multiblock.Multiblock
import net.horizonsend.ion.server.features.multiblock.MultiblockShape
import org.bukkit.Material
import org.bukkit.block.Furnace
import org.bukkit.block.Sign
import org.bukkit.entity.Player
import org.bukkit.event.inventory.FurnaceBurnEvent
import org.bukkit.event.player.PlayerInteractEvent

object GasCollectorMultiblock : Multiblock(), FurnaceMultiblock, InteractableMultiblock {
	override val name = "gascollector"

	override val signText = createSignText(
		line1 = "&cGas &6Collector",
		line2 = null,
		line3 = null,
		line4 = null
	)

	override fun MultiblockShape.buildStructure() {
		at(0, 0, 0).machineFurnace()
		at(0, 0, 1).hopper()
	}

	override fun onFurnaceTick(
		event: FurnaceBurnEvent,
		furnace: Furnace,
		sign: Sign
	) {
		event.isBurning = false
		event.burnTime = 0
		event.isCancelled = true
		val smelting = furnace.inventory.smelting

		if (smelting == null || smelting.type != Material.PRISMARINE_CRYSTALS) return

		if (!Gasses.isCanister(furnace.inventory.fuel)) return

		event.isBurning = false
		event.burnTime = (500 + Math.random() * 250).toInt()
		furnace.cookTime = (-1000).toShort()
		event.isCancelled = false

		Gasses.tickCollectorAsync(sign)
	}

	override fun onSignInteract(sign: Sign, player: Player, event: PlayerInteractEvent) {
		val available = Gasses.findAvailableGasses(sign.location).joinToString { it.identifier }

		player.information("Available gasses: $available")
	}
}
