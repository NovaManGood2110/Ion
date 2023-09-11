package net.horizonsend.ion.server.features.multiblock.starshipweapon.cannon

import net.horizonsend.ion.server.features.multiblock.MultiblockShape
import net.horizonsend.ion.server.features.multiblock.starshipweapon.SignlessStarshipWeaponMultiblock
import net.horizonsend.ion.server.features.starship.active.ActiveStarship
import net.horizonsend.ion.server.features.starship.subsystem.weapon.primary.ChaingunWeaponSubsystem
import net.horizonsend.ion.server.miscellaneous.utils.Vec3i
import org.bukkit.block.BlockFace

object ChaingunStarshipWeaponMultiblock : SignlessStarshipWeaponMultiblock<ChaingunWeaponSubsystem>() {
	override fun createSubsystem(starship: ActiveStarship, pos: Vec3i, face: BlockFace): ChaingunWeaponSubsystem {
		return ChaingunWeaponSubsystem(starship, pos, face)
	}

   override fun MultiblockShape.buildStructure() {
        at(+0, +0, +0).ironBlock()
        at(+0, +0, +1).sponge()
        at(+0, +0, +2).type(Material.GRINDSTONE)
        at(+0, +0, +3).endRod()
        at(+0, +0, +4).endRod()
    }
}
