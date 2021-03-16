package net.zerobone.rmibp.server;

import net.zerobone.rmibp.shared.IBoss;

public class Boss implements IBoss {

    private int lvl;

    public Boss(int lvl) {
        this.lvl = lvl;
    }

    @Override
    public int getLvl() {
        System.out.println("Returning the current level " + lvl + " of the boss.");
        return lvl;
    }

    @Override
    public void setLvl(int lvl) {
        this.lvl = lvl;
        System.out.println("Lvl set to " + lvl);
    }

    @Override
    public synchronized void increaseLvl(int diff) {
        System.out.println("Increased level from " + lvl + " to " + (lvl + diff));
        lvl += diff;
    }

    @Override
    public synchronized void decreaseLvl(int diff) {
        System.out.println("Decreased level from " + lvl + " to " + (lvl - diff));
        lvl -= diff;
    }

}