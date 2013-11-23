package br.com.fernandolopes.invisiblecow;

import br.com.fernandolopes.invisiblecow.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class MainCow extends Activity {

	private VacaView v;
	private int larguraTela;
	private int alturaTela;
	private double diagonalPerc;
	private MediaPlayer grito;
	private MediaPlayer cow11;
	private MediaPlayer cow10;
	private MediaPlayer cow9;
	private MediaPlayer cow8;
	private MediaPlayer cow7;
	private MediaPlayer cow6;
	private MediaPlayer cow5;
	private MediaPlayer cow4;
	private MediaPlayer cow3;
	private MediaPlayer cow2;
	private MediaPlayer cow1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		 setContentView(R.layout.activity_main_cow);
//		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//		inflater.inflate(R.id.cowMain, null);
//		setContentView(R.id.cowMain);
//
		RelativeLayout rl = (RelativeLayout) findViewById(R.id.cowMain);
		DisplayMetrics metrics = this.getResources().getDisplayMetrics();
		larguraTela = metrics.widthPixels;
		alturaTela = metrics.heightPixels;
		v = new VacaView(this, larguraTela, alturaTela);
	
		
	
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(50, 50);
		params.leftMargin = v.getPosX();
		params.topMargin = v.getPosY();
		
//		rl.addView(v, params);
//		v.setLayoutParams(params);
		rl.addView(v, params);
		
		
		diagonalPerc = Math.sqrt(Math.pow((larguraTela - 0.0f), 2) + Math.pow((alturaTela - 0.0f), 2)) / 10.0;

		criarMediaPlayers();
	}

	private void criarMediaPlayers() {
		cow11 = MediaPlayer.create(this, R.raw.cow11);
		cow10 = MediaPlayer.create(this, R.raw.cow10);
		cow9 = MediaPlayer.create(this, R.raw.cow9);
		cow8 = MediaPlayer.create(this, R.raw.cow8);
		cow7 = MediaPlayer.create(this, R.raw.cow7);
		cow6 = MediaPlayer.create(this, R.raw.cow6);
		cow5 = MediaPlayer.create(this, R.raw.cow5);
		cow4 = MediaPlayer.create(this, R.raw.cow4);
		cow3 = MediaPlayer.create(this, R.raw.cow3);
		cow2 = MediaPlayer.create(this, R.raw.cow2);
		cow1 = MediaPlayer.create(this, R.raw.cow1);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		
		

		double distPontoVaca = Math.sqrt(Math.pow((x - v.getPosX()), 2) + Math.pow((y - v.getPosY()), 2));

		double d = distPontoVaca;
		if (d > diagonalPerc * 10) {
			gritar(cow1);
		} else if (d > diagonalPerc * 9) {
			gritar(cow2);
		} else if (d > diagonalPerc * 8) {
			gritar(cow3);
		} else if (d > diagonalPerc * 7) {
			gritar(cow4);
		} else if (d > diagonalPerc * 6) {
			gritar(cow5);
		} else if (d > diagonalPerc * 5) {
			gritar(cow6);
		} else if (d > diagonalPerc * 4) {
			gritar(cow7);
		} else if (d > diagonalPerc * 3) {
			gritar(cow8);
		} else if (d > diagonalPerc * 2) {
			gritar(cow9);
		} else if (d > diagonalPerc * 1) {
			gritar(cow10);
		} else if (d > diagonalPerc * 0) {
			gritar(cow11);

		}

		return super.onTouchEvent(event);

	}

	private void gritar(MediaPlayer sound) {

		sound.start();

	}

}
