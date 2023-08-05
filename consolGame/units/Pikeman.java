package com.waroften.game.consolGame.units;

import com.waroften.game.consolGame.units.abstractclass.AbsoluteHero;
import com.waroften.game.consolGame.units.abstractclass.Soldier;
import com.waroften.game.consolGame.units.helpers.States;

import java.util.ArrayList;

// Класс Копейщик
public class Pikeman extends Soldier {
    
    public Pikeman(int x, int y) {
        super(new int[]{2, 6}, x, y, 7, States.Ready);
    }
}