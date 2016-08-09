package com.cschaefbauer.magic_counter;

/**
 * Created by Chris Schaefbauer on 8/4/16.
 */
public class Player {

    public static final Integer MAX_LIFE = 9999;
    public static final Integer MIN_LIFE = -9999;

    private Integer life;
    private Integer commanderDamage;
    private String name;

    public Player() {

        resetPlayer();
        this.name = "Player";
    }

    public Player(String name) {

        resetPlayer();
        this.name = name;
    }

    public void resetPlayer() {
        this.life = 20;
        this.commanderDamage = 0;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Integer getCommanderDamage() {
        return commanderDamage;
    }

    public void setCommanderDamage(Integer commanderDamage) {
        this.commanderDamage = commanderDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
