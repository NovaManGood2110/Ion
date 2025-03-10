package net.horizonsend.ion.server.features.starship.subsystem.weapon

import net.horizonsend.ion.server.features.starship.active.ActiveStarship
import net.horizonsend.ion.server.features.starship.subsystem.StarshipSubsystem
import net.horizonsend.ion.server.miscellaneous.utils.Vec3i
import org.bukkit.util.Vector
import java.util.concurrent.TimeUnit

abstract class WeaponSubsystem(
	starship: ActiveStarship,
	pos: Vec3i
) : StarshipSubsystem(starship, pos) {
	val name = this.javaClass.simpleName.removeSuffix("WeaponSubsystem")
	open var fireCooldownNanos: Long = TimeUnit.MILLISECONDS.toNanos(250L)
	var lastFire: Long = System.nanoTime()
	abstract val powerUsage: Int

	fun isCooledDown(): Boolean {
		return System.nanoTime() - lastFire >= fireCooldownNanos
	}

	open fun getMaxPerShot(): Int? = null

	abstract fun getAdjustedDir(dir: Vector, target: Vector): Vector

	/**
	 * Check if the weapon is obstructed etc.
	 * @return True if it should fire, false if it shouldn't
	 */
	abstract fun canFire(dir: Vector, target: Vector): Boolean

	open fun isForwardOnly(): Boolean = false

	fun postFire() {
		lastFire = System.nanoTime()
	}
}
