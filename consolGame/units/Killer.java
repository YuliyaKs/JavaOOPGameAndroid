package com.waroften.game.consolGame.units;

import com.waroften.game.consolGame.units.abstractclass.Shooter;
import com.waroften.game.consolGame.units.helpers.States;

// Класс Снайпер
public class Killer extends Shooter {
    
    public Killer(int x, int y) {
        super(new int[] {3, 7}, x, y, 10, States.Ready);
    }
}
