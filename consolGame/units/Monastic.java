package com.waroften.game.consolGame.units;

import com.waroften.game.consolGame.units.abstractclass.Psychic;
import com.waroften.game.consolGame.units.helpers.States;

// Класс Монах
public class Monastic extends Psychic {

    private int miro;

    public Monastic(int x, int y) {
        super(new int[]{-5, -5}, x, y, 5, States.Ready);
        this.miro = Monastic.r.nextInt(100);
    }
}
