package io.redspace.ironsspellbooks.util;

import dev.kosmx.playerAnim.api.TransformType;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.modifier.AdjustmentModifier;
import dev.kosmx.playerAnim.api.layered.modifier.MirrorModifier;
import dev.kosmx.playerAnim.core.util.Vec3f;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;

import java.util.Optional;

public class AbstractClientPlayerMixinHelper {

    public static ModifierLayer<IAnimation> playerMixinInit(Player player) {
        var animation = new ModifierLayer<>();

        animation.addModifierLast(new AdjustmentModifier((partName) -> {
            float rotationX = 0;
            float rotationY = 0;
            float rotationZ = 0;
            float offsetX = 0;
            float offsetY = 0;
            float offsetZ = 0;
            switch (partName) {
                case "rightArm", "leftArm" -> {
                    rotationX = (float) Math.toRadians(player.getXRot());
                    rotationY = (float) Math.toRadians(player.yHeadRot - player.yBodyRot);
                }
                default -> {
                    return Optional.empty();
                }
            }
            return Optional.of(new AdjustmentModifier.PartModifier(new Vec3f(rotationX, rotationY, rotationZ), new Vec3f(offsetX, offsetY, offsetZ)));
        }));
        animation.addModifierLast(new MirrorModifier() {
            @Override
            public boolean isEnabled() {
                return player.getUsedItemHand() == InteractionHand.OFF_HAND;
            }
        });

        return animation;
    }
}
