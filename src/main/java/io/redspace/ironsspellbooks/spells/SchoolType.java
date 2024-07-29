package io.redspace.ironsspellbooks.spells;

import io.redspace.ironsspellbooks.util.ModTags;
import net.minecraft.ChatFormatting;
import io.redspace.ironsspellbooks.util.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;

public enum SchoolType {
    FLAMETIDE(0),
    CHILLWEAVING(1),
    VOLTTEAR(2),
    AETHERLIGHT(3),
    ENDERECLIPSE(4),
    HEMOSPIRE(5),
    INVOKEVEIL(6),
    BLIGHTROT(8);

    private final int value;

    SchoolType(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }

    public net.minecraft.network.chat.Component getDisplayName() {
        return DISPLAYS[getValue()];
    }

    public static SchoolType getSchoolFromItem(ItemStack stack) {
        if (stack.is(ModTags.FLAMETIDE_FOCUS)) {
            return FLAMETIDE;
        } else if (stack.is(ModTags.CHILLWEAVING_FOCUS)) {
            return CHILLWEAVING;
        } else if (stack.is(ModTags.VOLTTEAR_FOCUS)) {
            return VOLTTEAR;
        } else if (stack.is(ModTags.AETHERLIGHT_FOCUS)) {
            return AETHERLIGHT;
        } else if (stack.is(ModTags.ENDERECLIPSE_FOCUS)) {
            return ENDERECLIPSE;
        } else if (stack.is(ModTags.HEMOSPIRE_FOCUS)) {
            return HEMOSPIRE;
        } else if (stack.is(ModTags.INVOKEVEIL_FOCUS)) {
            return INVOKEVEIL;
        }else if (stack.is(ModTags.BLIGHTROT_FOCUS)) {
            return BLIGHTROT;
        } else return null;
    }

    public static final net.minecraft.network.chat.Component DISPLAY_FLAMETIDE = Component.translatable("school.irons_spellbooks.fire").withStyle(ChatFormatting.GOLD);
    public static final net.minecraft.network.chat.Component DISPLAY_CHILLWEAVING = Component.translatable("school.irons_spellbooks.ice").withStyle(Style.EMPTY.withColor(0xd0f9ff));
    public static final net.minecraft.network.chat.Component DISPLAY_VOLTTEAR = Component.translatable("school.irons_spellbooks.lightning").withStyle(ChatFormatting.AQUA);
    public static final net.minecraft.network.chat.Component DISPLAY_AETHERLIGHT = Component.translatable("school.irons_spellbooks.holy").withStyle(Style.EMPTY.withColor(0xfff8d4));
    public static final net.minecraft.network.chat.Component DISPLAY_ENDERECLIPSE = Component.translatable("school.irons_spellbooks.ender").withStyle(ChatFormatting.LIGHT_PURPLE);
    public static final net.minecraft.network.chat.Component DISPLAY_HEMOSPIRE = Component.translatable("school.irons_spellbooks.blood").withStyle(ChatFormatting.DARK_RED);
    public static final net.minecraft.network.chat.Component DISPLAY_INVOKEVEIL = Component.translatable("school.irons_spellbooks.evocation").withStyle(ChatFormatting.WHITE);
    public static final net.minecraft.network.chat.Component DISPLAY_ENDERGLOOM = Component.translatable("school.irons_spellbooks.void").withStyle(Style.EMPTY.withColor(0x490059));
    public static final net.minecraft.network.chat.Component DISPLAY_BLIGHTROT = Component.translatable("school.irons_spellbooks.poison").withStyle(ChatFormatting.GREEN);
    public static final net.minecraft.network.chat.Component[] DISPLAYS = {DISPLAY_FLAMETIDE, DISPLAY_CHILLWEAVING, DISPLAY_VOLTTEAR, DISPLAY_AETHERLIGHT, DISPLAY_ENDERECLIPSE, DISPLAY_HEMOSPIRE, DISPLAY_INVOKEVEIL, DISPLAY_ENDERGLOOM, DISPLAY_BLIGHTROT};


}
