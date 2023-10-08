package mining_cooldown_tweaker.mixin;

import mining_cooldown_tweaker.config.MiningCooldownTweakerConfig;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MultiPlayerGameMode.class)
public abstract class MultiPlayerGameModeMixin {
    @Shadow
    private GameType localPlayerMode;

    @ModifyConstant(method = "continueDestroyBlock", constant = @Constant(intValue = 5))
    private int continueDestroyBlockMixin(int value) {
        if (localPlayerMode.isSurvival()) {
            return MiningCooldownTweakerConfig.mining_cooldown.get();
        } else {
            return 5;
        }
    }
}
