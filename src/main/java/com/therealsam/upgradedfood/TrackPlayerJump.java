package com.therealsam.upgradedfood;

public class TrackPlayerJump {
    private static boolean playerJumping = false;

    public static boolean getJump() {
        return playerJumping;
    }

    public static void setJump(boolean b) {
        playerJumping = b;
    }
}
