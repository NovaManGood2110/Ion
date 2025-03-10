package net.horizonsend.ion.server.features.starship

import net.horizonsend.ion.server.features.progression.Levels
import net.horizonsend.ion.server.miscellaneous.utils.setDisplayNameAndGet
import net.horizonsend.ion.server.miscellaneous.utils.setLoreAndGet
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

enum class StarshipType(
	val displayName: String,
	val minSize: Int,
	val maxSize: Int,
	val minLevel: Int,
	val containerPercent: Double,
	val concretePercent: Double = 0.3,
	val crateLimitMultiplier: Double,
	val sneakFlyAccelDistance: Int,
	val maxSneakFlyAccel: Int,
	val interdictionRange: Int,
	val hyperspaceRangeMultiplier: Double,
	menuItemMaterial: Material,
	val isWarship: Boolean,
	val color: String,
	val overridePermission: String,
	val eventship: Boolean = false,
	val poweroverrider: Double = 1.0,
	val maxMiningLasers: Int = 0,
	val miningLaserTier: Int = 0
) {
	SPEEDER(
		displayName = "Speeder",
		minSize = 25,
		maxSize = 100,
		minLevel = 1,
		containerPercent = 0.25,
		concretePercent = 0.0,
		crateLimitMultiplier = 0.125,
		sneakFlyAccelDistance = 3,
		maxSneakFlyAccel = 3,
		interdictionRange = 10,
		hyperspaceRangeMultiplier = 3.0,
		menuItemMaterial = Material.DEAD_BUSH,
		isWarship = false,
		color = "#ffff32",
		overridePermission = "ion.ships.override.1",
		poweroverrider = 0.0
	),
	STARFIGHTER(
		displayName = "Starfighter",
		minSize = 250,
		maxSize = 500,
		minLevel = 1,
		containerPercent = 0.025,
		concretePercent = 0.1,
		crateLimitMultiplier = 0.5,
		sneakFlyAccelDistance = 4,
		maxSneakFlyAccel = 4,
		interdictionRange = 600,
		hyperspaceRangeMultiplier = 1.5,
		menuItemMaterial = Material.IRON_NUGGET,
		isWarship = true,
		color = "#ff8000",
		overridePermission = "ion.ships.override.1"
	),
	STARBOMBER(
		displayName = "Starbomber",
		minSize = 500,
		maxSize = 1000,
		minLevel = 1,
		containerPercent = 0.025,
		concretePercent = 0.15,
		crateLimitMultiplier = 0.5,
		sneakFlyAccelDistance = 4,
		maxSneakFlyAccel = 4,
		interdictionRange = 800,
		hyperspaceRangeMultiplier = 1.5,
		menuItemMaterial = Material.COPPER_INGOT,
		isWarship = true,
		color = "#ff5400",
		overridePermission = "ion.ships.override.1"
	),
	GUNSHIP(
		displayName = "Gunship",
		minSize = 1000,
		maxSize = 2000,
		minLevel = 10,
		containerPercent = 0.025,
		crateLimitMultiplier = 0.5,
		sneakFlyAccelDistance = 5,
		maxSneakFlyAccel = 2,
		interdictionRange = 1200,
		hyperspaceRangeMultiplier = 1.6,
		menuItemMaterial = Material.IRON_INGOT,
		isWarship = true,
		color = "#ff4000",
		overridePermission = "ion.ships.override.10"
	),
	CORVETTE(
		displayName = "Corvette",
		minSize = 2000,
		maxSize = 4000,
		minLevel = 20,
		containerPercent = 0.025,
		crateLimitMultiplier = 0.5,
		sneakFlyAccelDistance = 6,
		maxSneakFlyAccel = 2,
		interdictionRange = 1800,
		hyperspaceRangeMultiplier = 1.7,
		menuItemMaterial = Material.IRON_BLOCK,
		isWarship = true,
		color = "#ff0000",
		overridePermission = "ion.ships.override.20"
	),
	FRIGATE(
		displayName = "Frigate",
		minSize = 4000,
		maxSize = 8000,
		minLevel = 40,
		containerPercent = 0.025,
		crateLimitMultiplier = 0.5,
		sneakFlyAccelDistance = 6,
		maxSneakFlyAccel = 2,
		interdictionRange = 2400,
		hyperspaceRangeMultiplier = 1.8,
		menuItemMaterial = Material.LAPIS_BLOCK,
		isWarship = true,
		color = "#c00000",
		overridePermission = "ion.ships.override.40"
	),
	DESTROYER(
		displayName = "Destroyer",
		minSize = 8000,
		maxSize = 12000,
		minLevel = 60,
		containerPercent = 0.025,
		crateLimitMultiplier = 0.5,
		sneakFlyAccelDistance = 5,
		maxSneakFlyAccel = 3,
		interdictionRange = 3000,
		hyperspaceRangeMultiplier = 1.9,
		menuItemMaterial = Material.GOLD_BLOCK,
		isWarship = true,
		color = "#800000",
		overridePermission = "ion.ships.override.60"
	),
	BATTLECRUISER(
		displayName = "Battlecruiser",
		minSize = 12000,
		maxSize = 20000,
		minLevel = 1000,
		containerPercent = 0.025,
		crateLimitMultiplier = 0.5,
		sneakFlyAccelDistance = 5,
		maxSneakFlyAccel = 5,
		interdictionRange = 2400,
		hyperspaceRangeMultiplier = 2.5,
		menuItemMaterial = Material.DIAMOND_BLOCK,
		isWarship = true,
		color = "#0c5ce8",
		overridePermission = "ion.ships.override.battlecruiser"

	),
	BATTLESHIP(
		displayName = "Battleship",
		minSize = 20000,
		maxSize = 32000,
		minLevel = 1000,
		containerPercent = 0.025,
		crateLimitMultiplier = 0.5,
		sneakFlyAccelDistance = 5,
		maxSneakFlyAccel = 3,
		interdictionRange = 2800,
		hyperspaceRangeMultiplier = 2.6,
		menuItemMaterial = Material.MAGMA_BLOCK,
		isWarship = true,
		color = "#0c5ce8",
		overridePermission = "ion.ships.override.battleship"

	),
	DREADNOUGHT(
		displayName = "Dreadnought",
		minSize = 32000,
		maxSize = 48000,
		minLevel = 1000,
		containerPercent = 0.025,
		crateLimitMultiplier = 0.5,
		sneakFlyAccelDistance = 10,
		maxSneakFlyAccel = 2,
		interdictionRange = 3200,
		hyperspaceRangeMultiplier = 2.7,
		menuItemMaterial = Material.EMERALD_BLOCK,
		isWarship = true,
		color = "#320385",
		overridePermission = "ion.ships.override.dreadnought"
	),
	SHUTTLE(
		displayName = "Shuttle",
		minSize = 100,
		maxSize = 1000,
		minLevel = 1,
		containerPercent = 0.045,
		crateLimitMultiplier = 1.0,
		sneakFlyAccelDistance = 5,
		maxSneakFlyAccel = 2,
		interdictionRange = 300,
		hyperspaceRangeMultiplier = 1.2,
		menuItemMaterial = Material.PRISMARINE_SHARD,
		isWarship = false,
		color = "#008033",
		overridePermission = "ion.ships.override.1",
		poweroverrider = 0.7,
		maxMiningLasers = 1,
		miningLaserTier = 1
	),
	TRANSPORT(
		displayName = "Transport",
		minSize = 1000,
		maxSize = 2000,
		minLevel = 10,
		containerPercent = 0.045,
		crateLimitMultiplier = 1.0,
		sneakFlyAccelDistance = 10,
		maxSneakFlyAccel = 3,
		interdictionRange = 600,
		hyperspaceRangeMultiplier = 1.25,
		menuItemMaterial = Material.PRISMARINE_CRYSTALS,
		isWarship = false,
		color = "#008066",
		overridePermission = "ion.ships.override.10",
		poweroverrider = 0.7,
		maxMiningLasers = 1,
		miningLaserTier = 2
	),
	LIGHT_FREIGHTER(
		displayName = "Light Freighter",
		minSize = 2000,
		maxSize = 4000,
		minLevel = 20,
		containerPercent = 0.045,
		crateLimitMultiplier = 1.0,
		sneakFlyAccelDistance = 10,
		maxSneakFlyAccel = 3,
		interdictionRange = 900,
		hyperspaceRangeMultiplier = 1.3,
		menuItemMaterial = Material.PRISMARINE_SLAB,
		isWarship = false,
		color = "#008099",
		overridePermission = "ion.ships.override.20",
		poweroverrider = 0.7,
		maxMiningLasers = 2,
		miningLaserTier = 2
	),
	MEDIUM_FREIGHTER(
		displayName = "Medium Freighter",
		minSize = 4000,
		maxSize = 8000,
		minLevel = 40,
		containerPercent = 0.045,
		crateLimitMultiplier = 1.0,
		sneakFlyAccelDistance = 10,
		maxSneakFlyAccel = 3,
		interdictionRange = 1200,
		hyperspaceRangeMultiplier = 1.35,
		menuItemMaterial = Material.PRISMARINE_STAIRS,
		isWarship = false,
		color = "#0080cc",
		overridePermission = "ion.ships.override.40",
		poweroverrider = 0.7,
		maxMiningLasers = 4,
		miningLaserTier = 3
	),
	HEAVY_FREIGHTER(
		displayName = "Heavy Freighter",
		minSize = 8000,
		maxSize = 12000,
		minLevel = 60,
		containerPercent = 0.045,
		crateLimitMultiplier = 1.0,
		sneakFlyAccelDistance = 10,
		maxSneakFlyAccel = 3,
		interdictionRange = 1500,
		hyperspaceRangeMultiplier = 1.4,
		menuItemMaterial = Material.PRISMARINE,
		isWarship = false,
		color = "#0080ff",
		overridePermission = "ion.ships.override.60",
		poweroverrider = 0.7,
		maxMiningLasers = 6,
		miningLaserTier = 3
	),
	PLATFORM(
		displayName = "Platform",
		minSize = 25,
		maxSize = 500000,
		minLevel = 1,
		containerPercent = 100.0,
		crateLimitMultiplier = 100.0,
		concretePercent = 0.0,
		sneakFlyAccelDistance = 0,
		maxSneakFlyAccel = 0,
		interdictionRange = 0,
		hyperspaceRangeMultiplier = 0.0,
		menuItemMaterial = Material.BEDROCK,
		isWarship = false,
		color = "#ffffff",
		overridePermission = "ion.ships.override.1",
		poweroverrider = 0.0
	),
	UNIDENTIFIEDSHIP(
		displayName = "UnidentifiedShip",
		minSize = 25,
		maxSize = 200000,
		minLevel = 69420,
		containerPercent = 100.0,
		concretePercent = 0.0,
		crateLimitMultiplier = 100.0,
		sneakFlyAccelDistance = 10,
		maxSneakFlyAccel = 3,
		interdictionRange = 2000,
		hyperspaceRangeMultiplier = 10.0,
		menuItemMaterial = Material.MUD_BRICKS,
		isWarship = true,
		color = "#d0e39d",
		overridePermission = "ion.ships.eventship",
		eventship = true,
		poweroverrider = 2.0
	);

	val formatted: String get() = "<$color>$displayName</$color>"
	val component: Component get() = Component.text(displayName).color(TextColor.fromHexString(color))

	val menuItem: ItemStack = ItemStack(menuItemMaterial)
		.setDisplayNameAndGet(displayName)
		.setLoreAndGet(
			listOf(
				"Min Block Count: $minSize",
				"Max Block Count: $maxSize",
				"Min Level: $minLevel",
				"Max Container:Total Blocks Ratio: $containerPercent",
				"Crate Limit Multiplier: $crateLimitMultiplier",
				"Sneak Fly Accel Distance: $sneakFlyAccelDistance",
				"Max Sneak Fly Accel: $maxSneakFlyAccel",
				"Interdiction Range: $interdictionRange",
				"Hyperspace Range Multiplier: $hyperspaceRangeMultiplier",
				"Warship: $isWarship"
			)
		)

	fun canUse(player: Player): Boolean =
		player.hasPermission("starships.anyship") || player.hasPermission(overridePermission) || Levels[player] >= minLevel

	companion object {
		fun getUnlockedTypes(player: Player): List<StarshipType> = values()
			.filter { it.canUse(player) }
			.filter { !it.eventship.and(!player.hasPermission("ion.ships.eventship")) }
			.sortedBy { it.minLevel }
	}
}
