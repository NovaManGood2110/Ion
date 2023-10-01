package net.horizonsend.ion.server.features.starship.subsystem.weapon.projectile

import net.horizonsend.ion.server.IonServer
import net.horizonsend.ion.server.features.starship.controllers.Controller
import net.horizonsend.ion.server.miscellaneous.utils.gayColors
import net.horizonsend.ion.server.features.starship.active.ActiveStarship
import org.bukkit.Color
import org.bukkit.Location
import org.bukkit.util.Vector

// from left to right red - orange - yellow - green - blue - purple
class IonCannonProjectile(
	starship: ActiveStarship,
	loc: Location,
	dir: Vector,
	shooter: Controller?
) : LaserProjectile(starship, loc, dir, shooter) {
	override val range: Double = IonServer.balancing.starshipWeapons.IonCannon.range
	override val speed: Double = IonServer.balancing.starshipWeapons.IonCannon.speed
	override val shieldDamageMultiplier: Int = IonServer.balancing.starshipWeapons.IonCannon.shieldDamageMultiplier
	override val color: Color
		get() = if (starship!!.rainbowToggle) gayColors.random() else starship.weaponColor
	override val thickness: Double = IonServer.balancing.starshipWeapons.IonCannon.thickness
	override val particleThickness: Double = IonServer.balancing.starshipWeapons.IonCannon.particleThickness
	override val explosionPower: Float = IonServer.balancing.starshipWeapons.IonCannon.explosionPower
	override val volume: Int = IonServer.balancing.starshipWeapons.IonCannon.volume
	override val soundName: String = IonServer.balancing.starshipWeapons.IonCannon.soundName
}
