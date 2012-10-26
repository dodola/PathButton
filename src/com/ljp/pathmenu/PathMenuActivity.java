package com.ljp.pathmenu;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class PathMenuActivity extends Activity {

	private boolean			areButtonsShowing;
	private RelativeLayout	composerButtonsWrapper;
	private ImageView		composerButtonsShowHideButtonIcon;
	private RelativeLayout	composerButtonsShowHideButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		composerButtonsWrapper = (RelativeLayout) findViewById(R.id.composer_buttons_wrapper);
		composerButtonsShowHideButton = (RelativeLayout) findViewById(R.id.composer_buttons_show_hide_button);
		composerButtonsShowHideButtonIcon = (ImageView) findViewById(R.id.composer_buttons_show_hide_button_icon);

		composerButtonsShowHideButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!areButtonsShowing) {
					MyAnimations.startAnimationsIn(composerButtonsWrapper, 300);
					composerButtonsShowHideButtonIcon.startAnimation(MyAnimations.getRotateAnimation(0, -270, 300));
				}
				else {
					MyAnimations.startAnimationsOut(composerButtonsWrapper, 300);
					composerButtonsShowHideButtonIcon.startAnimation(MyAnimations.getRotateAnimation(-270, 0, 300));
				}
				areButtonsShowing = !areButtonsShowing;
			}
		});


		composerButtonsShowHideButton.startAnimation(MyAnimations.getRotateAnimation(0, 360, 200));

	}

}