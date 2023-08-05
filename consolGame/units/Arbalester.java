package com.waroften.game.consolGame.units;

import com.waroften.game.consolGame.units.abstractclass.Shooter;
import com.waroften.game.consolGame.units.helpers.States;

// Класс Арбалетчик
public class Arbalester extends Shooter {
    
    public Arbalester(int x, int y) {
        super(new int[] {3, 7}, x, y, 9, States.Ready);
    }
}

