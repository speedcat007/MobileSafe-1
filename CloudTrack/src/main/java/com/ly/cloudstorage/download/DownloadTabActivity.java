package com.ly.cloudstorage.download;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.ly.cloudstorage.R;

public class DownloadTabActivity extends SherlockFragmentActivity implements
		TabListener {

	private ViewPager mViewPager;
	private DownloadPagerAdapter mPagerAdapter;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);

		setContentView(R.layout.download_tab_layout);

		final ActionBar actionBar = getSupportActionBar();
		//隐藏Title  
		actionBar.setDisplayShowTitleEnabled(false);  
        //隐藏Home logo  
		actionBar.setDisplayShowHomeEnabled(false);  
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		mPagerAdapter = new DownloadPagerAdapter(getSupportFragmentManager(),
				this);

		mViewPager = (ViewPager) findViewById(R.id.tab_pager);
		mViewPager.setAdapter(mPagerAdapter);

		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		for (int i = 0; i < mPagerAdapter.getCount(); i++) {
			actionBar.addTab(actionBar.newTab()
					.setText(mPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}
}
