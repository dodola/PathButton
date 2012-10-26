package com.ljp.pathmenu;

import android.graphics.Rect;

public class TouchObject {

	private int		touchId;
	private Rect	touchArea;

	public int getTouchId() {
		return touchId;
	}

	public void setTouchId(int touchId) {
		this.touchId = touchId;
	}

	public Rect getTouchArea() {
		return touchArea;
	}

	public void setTouchArea(Rect touchArea) {
		this.touchArea = touchArea;
	}
}
