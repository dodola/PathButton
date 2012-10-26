package com.ljp.pathmenu;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;

public class MyAnimations {

	public final static int	R	= 200;	// R最好计算出来

	public static Animation getRotateAnimation(float fromDegrees, float toDegrees, int durationMillis) {
		RotateAnimation rotate = new RotateAnimation(fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		rotate.setDuration(durationMillis);
		rotate.setFillAfter(true);
		return rotate;
	}

	public static void startAnimationsIn(final ViewGroup viewgroup, int durationMillis) {

		List<TouchObject> preTouch = preTouch(viewgroup);
		ComposerLayout layout = (ComposerLayout) viewgroup;
		if (!layout.isInit())
			layout.initTouches(preTouch);
		layout.setShow(true);

		for (int i = 0; i < viewgroup.getChildCount(); i++) {
			final ImageButton inoutimagebutton = (ImageButton) viewgroup.getChildAt(i);

			inoutimagebutton.setVisibility(0);
			double marginTop = Math.sin(36.0 * i * Math.PI / 180) * R;
			double marginRight = Math.cos(36.0 * i * Math.PI / 180) * R;

			Animation animation = new TranslateAnimation(0, -(int) marginRight, 0, -(int) marginTop);
			animation.setFillAfter(true);
			animation.setDuration(durationMillis);
			animation.setStartOffset((i * 100) / (-1 + viewgroup.getChildCount()));
			animation.setInterpolator(new OvershootInterpolator(2F));

			inoutimagebutton.startAnimation(animation);

		}
	}

	private static List<TouchObject> preTouch(ViewGroup viewgroup) {
		List<TouchObject> objects = new ArrayList<TouchObject>();
		for (int i = 0; i < viewgroup.getChildCount(); i++) {
			final ImageButton inoutimagebutton = (ImageButton) viewgroup.getChildAt(i);
			double marginTop = Math.sin(36.0 * i * Math.PI / 180) * MyAnimations.R;
			double marginRight = Math.cos(36.0 * i * Math.PI / 180) * MyAnimations.R;
			Point point = new Point((int) marginRight, (int) marginTop);
			Rect animationRect = MyAnimations.getAnimationRect(inoutimagebutton, point);
			TouchObject obj = new TouchObject();
			obj.setTouchId(inoutimagebutton.getId());
			obj.setTouchArea(animationRect);
			objects.add(obj);

		}
		return objects;
	}

	public static Rect getAnimationRect(ImageButton btn, Point point) {
		Rect r = new Rect();
		r.left = btn.getLeft() - point.x;
		r.top = btn.getTop() - point.y;
		r.right = btn.getRight() - point.x;
		r.bottom = btn.getBottom() - point.y;
		return r;
	}

	public static void startAnimationsOut(final ViewGroup viewgroup, int durationMillis) {
		ComposerLayout layout = (ComposerLayout) viewgroup;
		layout.setShow(false);
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

			inoutimagebutton.startAnimation(animation);
		}

	}
}