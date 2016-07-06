package com.example.image_loader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.example.image_loader.fragment.ImagePagerFragment;

public class SimpleImageActivity extends FragmentActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		int frIndex = getIntent().getIntExtra(Constants.Extra.FRAGMENT_INDEX, 0);
		Fragment fr = null;
		String tag = null;
		int titleRes = 0;
		switch (frIndex) {

		case ImagePagerFragment.INDEX:
			tag = ImagePagerFragment.class.getSimpleName();
			fr = getSupportFragmentManager().findFragmentByTag(tag);
			if (fr == null) {
				fr = new ImagePagerFragment();
				fr.setArguments(getIntent().getExtras());
			}
			titleRes = R.string.ac_name_image_pager;
			break;
		}

		
		setTitle(titleRes);
		getSupportFragmentManager().beginTransaction().replace(android.R.id.content, fr, tag).commit();
	}
}