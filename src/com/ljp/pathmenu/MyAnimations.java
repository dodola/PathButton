package com.ljp.pathmenu;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;

public class MyAnimations {

	private final static int	R		= 200;
	private static int			xOffset	= 15;
	private static int			yOffset	= -13;

	public static void initOffset(Context context) {// 由布局文件
		xOffset = (int) (10.667 * context.getResources().getDisplayMetrics().density);
		yOffset = -(int) (8.667 * context.getResources().getDisplayMetrics().density);
	}

	public static Animation getRotateAnimation(float fromDegrees, float toDegrees, int durationMillis) {
		RotateAnimation rotate = new RotateAnimation(fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		rotate.setDuration(durationMillis);
		rotate.setFillAfter(true);
		return rotate;
	}

	public static void startAnimationsIn(ViewGroup viewgroup, int durationMillis) {

		for (int i = 0; i < viewgroup.getChildCount(); i++) {
			ImageButton inoutimagebutton = (ImageButton) viewgroup.getChildAt(i);
			inoutimagebutton.setVisibility(0);
			double marginTop = Math.sin(36.0 * i * Math.PI / 180) * R;
			double marginRight = Math.cos(36.0 * i * Math.PI / 180) * R;
			Log.d("animation", marginTop + "," + marginRight);
			Animation animation = new TranslateAnimation(0, -(int) marginRight, 0, -(int) marginTop);

			animation.setFillAfter(true);
			animation.setDuration(durationMillis);
			animation.setStartOffset((i * 100) / (-1 + viewgroup.getChildCount()));
			animation.setInterpolator(new OvershootInterpolator(2F));
			inoutimagebutton.startAnimation(animation);

		}
	}

	public static void startAnimationsOut(ViewGroup viewgroup, int durationMillis) {
		for (int i = 0; i < viewgroup.getChildCount(); i++) {
			final ImageButton inoutimagebutton = (ImageButton) viewgroup.getChildAt(i);
			double marginTop = Math.sin(36.0 * i * Math.PI / 180) * R;
			double marginRight = Math.cos(36.0 * i * Math.PI / 180) * R;
			Log.d("animation", marginTop + "," + marginRight);
			Animation animation = new TranslateAnimation(-(int) marginRight, 0, -(int) marginTop, 0);
			animation.setFillAfter(true);
			animation.setDuration(durationMillis);
			animation.setStartOffset(((viewgroup.getChildCount() - i) * 100) / (-1 + viewgroup.getChildCount()));// 顺序倒一下比较舒服
			animation.setInterpolator(new AnticipateInterpolator(2F));
			animation.setAnimationListener(new Animation.AnimationListener() {
				@Override
				public void onAnimationStart(Animation arg0) {
				}

				@Override
				public void onAnimationRepeat(Animation arg0) {
				}

				@Override
				public void onAnimationEnd(Animation arg0) {
					// TODO Auto-generated method stub
					inoutimagebutton.setVisibility(8);
				}
			});
			inoutimagebutton.startAnimation(animation);
		}

	}
}