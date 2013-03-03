package geniuz.pathbuttons;

import geniuz.myPathbutton.composerLayout;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 引用控件
		composerLayout clayout = (composerLayout) findViewById(R.id.test);
		clayout.init(new int[] { R.drawable.composer_camera,
				R.drawable.composer_music, R.drawable.composer_place,
				R.drawable.composer_sleep, R.drawable.composer_thought,
				R.drawable.composer_with }, R.drawable.composer_button,
				R.drawable.composer_icn_plus, composerLayout.RIGHTCENTER, 180,
				300);
		// 加個點擊監聽，100+0對應composer_camera，100+1對應composer_music……如此類推你有幾多個按鈕就加幾多個。
		OnClickListener clickit = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v.getId() == 100 + 0) {
					System.out.println("composer_camera");
				} else if (v.getId() == 100 + 1) {
					System.out.println("composer_music");
				} else if (v.getId() == 100 + 2) {
					System.out.println("composer_place");
				} else if (v.getId() == 100 + 3) {
					System.out.println("composer_sleep");
				} else if (v.getId() == 100 + 4) {
					System.out.println("composer_thought");
				} else if (v.getId() == 100 + 5) {
					System.out.println("composer_with");
				}
			}
		};
		clayout.setButtonsOnClickListener(clickit);

		// 下面呢幾句純粹攞嚟測試下父控件點唔點倒，實際用嘅時候可以去掉。
		RelativeLayout rl = (RelativeLayout) findViewById(R.id.rlparent);
		rl.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("父控件可以點擊就即系冇吡截咗。");
			}
		});

	}

}
