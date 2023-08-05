package com.waroften.game.consolGame.units;

import com.waroften.game.consolGame.units.abstractclass.Psychic;
import com.waroften.game.consolGame.units.helpers.States;

// Класс Колдун
public class Wizard extends Psychic {

    private int elixir;
    private int medicament;

    public Wizard(int x, int y) {
        super(new int[]{-5, -5}, x, y, 6, States.Ready);
        this.elixir = Wizard.r.nextInt(100);
    }
}
