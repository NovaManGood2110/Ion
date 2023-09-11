package net.horizonsend.ion.server.features.starship.subsystem.weapon.primary

import net.horizonsend.ion.server.IonServer
import net.horizonsend.ion.server.features.starship.controllers.Controller
import net.horizonsend.ion.server.features.starship.active.ActiveStarship
import net.horizonsend.ion.server.features.starship.subsystem.weapon.CannonWeaponSubsystem
import net.horizonsend.ion.server.features.starship.subsystem.weapon.projectile.PlasmaLaserProjectile
import net.horizonsend.ion.server.miscellaneous.utils.Vec3i
import org.bukkit.Location
import org.bukkit.block.BlockFace
import org.bukkit.util.Vector

class ChaingunWeaponSubsystem(starship: ActiveStarship, pos: Vec3i, face: BlockFace) :
	CannonWeaponSubsystem(starship, pos, face) {
	override val powerUsage: Int = IonServer.balancing.starshipWeapons.Chaingun.powerUsage
	override val length: Int = IonServer.balancing.starshipWeapons.Chaingun.length
	override val angleRadians: Double = Math.toRadians(IonServer.balancing.starshipWeapons.Chaingun.angleRadians)
	override val convergeDist: Double = IonServer.balancing.starshipWeapons.Chaingun.convergeDistance
	override val extraDistance: Int = IonServer.balancing.starshipWeapons.Chaingun.extraDistance

	override fun isAcceptableDirection(face: BlockFace): Boolean {
		return true
	}

	override fun isForwardOnly(): Boolean = IonServer.balancing.starshipWeapons.Chaingun.fowardOnly

	override fun getMaxPerShot(): Int {
		return 1
	}

	override fun fire(
        loc: Location,
        dir: Vector,
        shooter: Controller,
        target: Vector?
	) {
		PlasmaLaserProjectile(starship, loc, dir, shooter).fire()
	}
}
