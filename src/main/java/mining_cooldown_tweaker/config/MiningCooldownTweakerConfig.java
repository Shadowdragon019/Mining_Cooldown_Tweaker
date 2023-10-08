package mining_cooldown_tweaker.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MiningCooldownTweakerConfig {
    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec spec;

    public static final ForgeConfigSpec.IntValue mining_cooldown;

    static {
        builder.push("Mining Cooldown Tweaker common config");
        builder.pop();

        mining_cooldown = builder.comment("Minimum delay between mining blocks in ticks").defineInRange("mining_cooldown", 0, 0, Integer.MAX_VALUE);
        spec = builder.build();
    }
}
