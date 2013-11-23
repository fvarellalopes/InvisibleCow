package br.com.fernandolopes.invisiblecow;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class VacaView extends View {
	private Paint paint;
	private int posX;
	private int posY;
	private int touchCont;
	private boolean venceu;
	private Drawable  mCustomImage;

	public VacaView(Context context, int width, int height) {
		super(context);

		paint = new Paint();
	
		
		

		Random random = new Random();

		posX = random.nextInt(width - 50) + 20;
		posY = random.nextInt(height -50) + 20;
		 mCustomImage = context.getResources().getDrawable(R.drawable.cow_sprite);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		
		if (touchCont++ > 3) {
			venceu = true;
		}
		invalidate();

		return super.onTouchEvent(event);

	}
//	@Override
//	public void getHitRect(Rect outRect) {
//		// TODO Auto-generated method stub
//		outRect.set(getLeft(), getTop(), getRight(), getBottom()+20);
//	}

	@Override
	public void onDraw(Canvas canvas) {
		if (!venceu) {
			paint.setColor(Color.GRAY);
			paint.setStrokeWidth(3);
			canvas.drawRect(posX, posY, posX + 50, posY + 50, paint);
		} else {
			 Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it

		        mCustomImage.setBounds(canvas.getClipBounds());
		        mCustomImage.draw(canvas);
		        Toast.makeText(this.getContext(), "asdasd", Toast.LENGTH_LONG).show();
		}

	}

	public int getPosX() {
		return posX + 25;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY + 25;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
