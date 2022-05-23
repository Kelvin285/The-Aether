package com.gildedgames.aether.client.event.listeners;

import com.gildedgames.aether.client.event.hooks.GuiHooks;
import com.gildedgames.aether.client.gui.screen.menu.AetherWorldDisplayHelper;
import com.gildedgames.aether.core.AetherConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.world.entity.player.ChatVisiblity;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.client.event.RenderLevelLastEvent;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class OverlayListener {

    private static void setScreen() {
        Minecraft minecraft = Minecraft.getInstance();
        AetherWorldDisplayHelper.loadingLevel = false;
        AetherWorldDisplayHelper.loadedLevel = Minecraft.getInstance().level;

        var player = minecraft.getSingleplayerServer().getPlayerList().getPlayers().get(0);
        var server = minecraft.getSingleplayerServer();
        var gameRules = server.getGameRules();

        GameType mode = player.gameMode.getGameModeForPlayer();
        player.setGameMode(GameType.SPECTATOR);
        AetherWorldDisplayHelper.loadedPosition = new Vec3(player.position().x, player.position().y, player.position().z);
        AetherWorldDisplayHelper.loadedGameMode = mode;
        AetherWorldDisplayHelper.loadedGameRules = new GameRules();
        AetherWorldDisplayHelper.loadedGameRules.assignFrom(gameRules, server);
        AetherWorldDisplayHelper.loadedChatVisibility = minecraft.options.chatVisibility;
        minecraft.options.chatVisibility = ChatVisiblity.HIDDEN;

        var stack = server.createCommandSourceStack();
        gameRules.getRule(GameRules.RULE_MOBGRIEFING).set(false, server);
        gameRules.getRule(GameRules.RULE_DOMOBSPAWNING).set(false, server);
        gameRules.getRule(GameRules.RULE_RANDOMTICKING).set(0, server);

        AetherWorldDisplayHelper.deleteSessionLock();
        minecraft.forceSetScreen(GuiHooks.aether_menu);
    }

    @SubscribeEvent
    public static void onOverlayRender(RenderLevelLastEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (AetherConfig.CLIENT.enable_world_preview.get()) {
            if (AetherWorldDisplayHelper.loadedSummary != null) {
                if (minecraft.screen == null) {
                    setScreen();
                } else {
                    minecraft.player.setXRot(0);
                    minecraft.player.setYRot(minecraft.player.getYRot() + 0.25f);

                    if (minecraft.screen instanceof PauseScreen) {
                        setScreen();
                    }
                }
            }
        }


    }

}