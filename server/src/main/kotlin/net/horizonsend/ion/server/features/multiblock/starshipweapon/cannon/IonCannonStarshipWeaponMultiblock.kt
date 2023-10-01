package net.horizonsend.ion.server.features.multiblock.starshipweapon.cannon

import net.horizonsend.ion.server.features.multiblock.MultiblockShape
import net.horizonsend.ion.server.features.multiblock.starshipweapon.SignlessStarshipWeaponMultiblock
import net.horizonsend.ion.server.features.starship.active.ActiveStarship
import net.horizonsend.ion.server.features.starship.subsystem.weapon.primary.IonCannonWeaponSubsystem
import net.horizonsend.ion.server.miscellaneous.utils.Vec3i
import org.bukkit.Material
import org.bukkit.block.BlockFace

object IonCannonStarshipWeaponMultiblock : SignlessStarshipWeaponMultiblock<IonCannonWeaponSubsystem>() {
    override fun createSubsystem(starship: ActiveStarship, pos: Vec3i, face: BlockFace): IonCannonWeaponSubsystem {
        return IonCannonWeaponSubsystem(starship, pos, face)
    }

    override fun MultiblockShape.buildStructure() {
        at(+0, +0, +0).redstoneBlock()
        at(+0, +0, +1).sponge()
        at(+0, +0, +2).redstoneBlock()
        at(+0, +0, +3).dispenser()
    }
}
