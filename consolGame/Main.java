package com.waroften.game.consolGame;

import com.waroften.game.consolGame.units.*;
import com.waroften.game.consolGame.units.abstractclass.AbsoluteHero;
import com.waroften.game.consolGame.units.helpers.States;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    ArrayList<AbsoluteHero> armyLightForces = new ArrayList<>();
    ArrayList<AbsoluteHero> armyDarkForces = new ArrayList<>();
    public ArrayList<AbsoluteHero> army = new ArrayList<>();
    public void main() {

        fillArmyLF(armyLightForces);

        fillArmyDF(armyDarkForces);

//        Вызывать персонажей из обеих комманд в порядке инициативы.
        army.addAll(armyLightForces);
        army.addAll(armyDarkForces);

        for (int i = 0; i < army.size() - 1; i++) {
            for (int j = 0; j < army.size() - 1 - i; j++) {
                if (army.get(j).initiative > army.get(j+1).initiative) {
                    AbsoluteHero temp = army.get(j);
                    army.set(j, army.get(j+1));
                    army.set(j+1, temp);
                }

            }
        }

//        Scanner in = new Scanner(System.in);
  }
    boolean light = false;
    boolean dark = false;
    public boolean run() {
        while (true) {
            for (int i = 19; i >= 0; i--) {
                if (armyLightForces.contains(army.get(i))) {
                    army.get(i).step(armyDarkForces, armyLightForces);
                } else {
                    army.get(i).step(armyLightForces, armyDarkForces);
                }

            }
            //            View.view();
            //            in.nextLine();
            for (int i = 0; i < armyLightForces.size(); i++) {
                if (armyLightForces.get(i).state != States.Die) break;
                else {
                    if (i == armyLightForces.size() - 1) dark = true;
                }
            }
            for (int i = 0; i < armyDarkForces.size(); i++) {
                if (armyDarkForces.get(i).state != States.Die) break;
                else {
                    if (i == armyDarkForces.size() - 1) light = true;
                }
            }
            if (dark == true) {
                System.out.println("Dark Forces win");
                return false;
            }
            if (light == true) {
                System.out.println("Light Forces win");
                return false;
            }
        }
    }
    public static void fillArmyLF (ArrayList<AbsoluteHero> ArrList) {
        for (int i = 1; i < 11; i++) {
            int count = new Random().nextInt(4);
            switch (count) {
                case 0: {
                    ArrList.add(new Countryman(1, i));
                    break;                    
                }
                case 1: {
                    ArrList.add(new Arbalester(1, i));
                    break;                    
                }
                case 2: {
                    ArrList.add(new Monastic(1, i));
                    break;
                }
                case 3: {
                    ArrList.add(new Pikeman(1, i));
                    break;
                }

            }               
        }
    }

    public static void fillArmyDF (ArrayList<AbsoluteHero> ArrList) {
        for (int i = 1; i < 11; i++) {
            int count = new Random().nextInt(4);
            switch (count) {
                case 0: {
                    ArrList.add(new Countryman(10, i));
                    break;                    
                }
                case 1: {
                    ArrList.add(new Bandit(10, i));
                    break;                    
                }
                case 2: {
                    ArrList.add(new Killer(10, i));
                    break;
                }
                case 3: {
                    ArrList.add(new Wizard(10, i));
                    break;
                }

            }               
        }
    }
}

