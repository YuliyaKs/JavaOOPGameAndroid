package com.waroften.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.waroften.game.consolGame.Main;
import com.waroften.game.consolGame.units.Arbalester;
import com.waroften.game.consolGame.units.Bandit;
import com.waroften.game.consolGame.units.Countryman;
import com.waroften.game.consolGame.units.Killer;
import com.waroften.game.consolGame.units.Monastic;
import com.waroften.game.consolGame.units.Pikeman;
import com.waroften.game.consolGame.units.Wizard;
import com.waroften.game.consolGame.units.abstractclass.AbsoluteHero;

import java.util.Arrays;
import java.util.Random;

public class WarOfTen extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, crossBowMan, mage, monk, peasant, rouge, sniper, spearMan;
	Music music;
	Main game;
	boolean play, clk;
	
	@Override
	public void create () {
//		Main.main(new String[]{});
		clk = play = true;

		game = new Main();
		game.main();

		batch = new SpriteBatch();
		fon = new Texture("fon/"+Fons.values()[new Random().nextInt(Fons.values().length)]+".png");
		music = Gdx.audio.newMusic(Gdx.files.internal("music/paul-romero-rob-king-combat-theme-0"+(new Random().nextInt(4)+1)+".mp3"));
		music.setLooping(true);
		music.setVolume(0.125f);
		music.play();

		crossBowMan = new Texture("pers/CrossBowMan.png");
		mage = new Texture("pers/Mage.png");
		monk = new Texture("pers/Monk.png");
		peasant = new Texture("pers/Peasant.png");
		rouge = new Texture("pers/Rouge.png");
		sniper = new Texture("pers/Sniper.png");
		spearMan = new Texture("pers/SpearMan.png");

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		int kx = Gdx.graphics.getWidth()/12;
		int ky = Gdx.graphics.getHeight()/15;
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		for (AbsoluteHero hero: game.army) {
			if (hero instanceof Killer) batch.draw(sniper, hero.coordinates.toArray()[0]*kx, hero.coordinates.toArray()[1]*ky, - sniper.getWidth(), sniper.getHeight());
			if (hero instanceof Arbalester) batch.draw(crossBowMan, hero.coordinates.toArray()[0]*kx, hero.coordinates.toArray()[1]*ky);
			if (hero instanceof Countryman) batch.draw(peasant, hero.coordinates.toArray()[0]*kx, hero.coordinates.toArray()[1]*ky);
			if (hero instanceof Wizard) batch.draw(mage, hero.coordinates.toArray()[0]*kx, hero.coordinates.toArray()[1]*ky, - mage.getWidth(), mage.getHeight());
			if (hero instanceof Monastic) batch.draw(monk, hero.coordinates.toArray()[0]*kx, hero.coordinates.toArray()[1]*ky);
			if (hero instanceof Bandit) batch.draw(rouge, hero.coordinates.toArray()[0]*kx, hero.coordinates.toArray()[1]*ky, - rouge.getWidth(), rouge.getHeight());
			if (hero instanceof Pikeman) batch.draw(spearMan, hero.coordinates.toArray()[0]*kx, hero.coordinates.toArray()[1]*ky);
		}
		batch.end();

		if (Gdx.input.isTouched() & play & clk){
			if (!game.run()) {
				play = false;
				Gdx.graphics.setTitle("Game over!");
				music.stop();
			}
            clk = false;
		}

        if (!Gdx.input.isTouched()) clk = true;
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
		music.dispose();
		crossBowMan.dispose();
		mage.dispose();
		monk.dispose();
		peasant.dispose();
		rouge.dispose();
		sniper.dispose();
		spearMan.dispose();
	}
}
