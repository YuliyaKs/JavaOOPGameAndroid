package com.waroften.game.consolGame.units.helpers;

import com.waroften.game.consolGame.units.abstractclass.AbsoluteHero;

import java.util.ArrayList;

public interface AppInterface {

    void step(ArrayList<AbsoluteHero> enemyArmy, ArrayList<AbsoluteHero> ownArmy);
    
    String getInfo();

}
