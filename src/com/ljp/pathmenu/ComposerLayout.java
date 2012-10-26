package com.ljp.pathmenu;

import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class ComposerLayout extends RelativeLayout {

	public ComposerLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ComposerLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ComposerLayout(Context context) {
		super(context);
	}

	private List<TouchObject>	objs;

	public void initTouches(List<TouchObject> objects) {
		objs = objects;
	}

	private boolean	isShow;

	private TouchObject getClick(float x, float y) {
		TouchObject obj = null;
		for (TouchObject o : objs) {
			if (o.getTouchArea().contains((int) x, (int) y)) {
				obj = o;
			}
		}
		return obj;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();

		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				if (objs != null) {
					TouchObject click = getClick(x, y);
					onClick(click);
				}
				break;
		}
		return super.onTouchEvent(event);
	}

	private void onClick(TouchObject obj) {
		if (obj != null && isShow) {
			switch (obj.getTouchId()) {
				case R.id.composer_button_music:
					Log.d("touch", "music click");
					break;
				case R.id.composer_button_people:
					Log.d("touch", "people click");
					break;
				case R.id.composer_button_photo:
					Log.d("touch", "photo click");
					break;
				case R.id.composer_button_place:
					Log.d("touch", "place click");
					break;
				case R.id.composer_button_sleep:
					Log.d("touch", "sleep click");
					break;
				case R.id.composer_button_thought:
					Log.d("touch", "thought click");
					break;

			}
		}

	}

	public boolean isInit() {
		return objs != null;
	}

	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
}
