package net.horizonsend.ion.server.features.starship.subsystem.weapon.primary

import net.horizonsend.ion.common.extensions.userError
import net.horizonsend.ion.server.IonServer
import net.horizonsend.ion.server.features.starship.controllers.Controller
import net.horizonsend.ion.server.features.starship.active.ActiveStarship
import net.horizonsend.ion.server.features.starship.subsystem.weapon.CannonWeaponSubsystem
import net.horizonsend.ion.server.features.starship.subsystem.weapon.projectile.IonCannonProjectile
import net.horizonsend.ion.server.miscellaneous.utils.Vec3i
import org.bukkit.Location
import org.bukkit.block.BlockFace
import org.bukkit.util.Vector

class IonCannonWeaponSubsystem(starship: ActiveStarship, pos: Vec3i, face: BlockFace) :
    CannonWeaponSubsystem(starship, pos, face) {
    override val powerUsage: Int = IonServer.balancing.starshipWeapons.IonCannon.powerUsage
    override val length: Int = IonServer.balancing.starshipWeapons.IonCannon.length
    override val angleRadians: Double = Math.toRadians(IonServer.balancing.starshipWeapons.IonCannon.angleRadians)
    override val convergeDist: Double = IonServer.balancing.starshipWeapons.IonCannon.convergeDistance
    override val extraDistance: Int = IonServer.balancing.starshipWeapons.IonCannon.extraDistance

    override fun isAcceptableDirection(face: BlockFace): Boolean {
        return true
    }

    override fun isForwardOnly(): Boolean = IonServer.balancing.starshipWeapons.IonCannon.fowardOnly

    override fun getMaxPerShot(): Int {
        return 1
    }

    override fun fire(
        loc: Location,
        dir: Vector,
        shooter: Controller,
        target: Vector?
    ) {
        if (starship.initialBlockCount > 1000) {
            shooter.userError("You can't fire IonCannons on a ship larger than 1000 blocks!")
            return
        }
        IonCannonProjectile(starship, loc, dir, shooter).fire()
    }
}
