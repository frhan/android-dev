package me.farhan.androidnavdrawer;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentManager.OnBackStackChangedListener;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	CustomDrawerAdapter adapter;

	List<DrawerItem> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initializing
		dataList = new ArrayList<DrawerItem>();
		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// Add Drawer Item to dataList
		dataList.add(new DrawerItem("Message", R.drawable.ic_action_email));
		dataList.add(new DrawerItem("Likes", R.drawable.ic_action_good));
		dataList.add(new DrawerItem("Games", R.drawable.ic_action_gamepad));
		dataList.add(new DrawerItem("Lables", R.drawable.ic_action_labels));
		dataList.add(new DrawerItem("Search", R.drawable.ic_action_search));
		dataList.add(new DrawerItem("Cloud", R.drawable.ic_action_cloud));
		dataList.add(new DrawerItem("Camara", R.drawable.ic_action_camera));
		dataList.add(new DrawerItem("Video", R.drawable.ic_action_video));
		dataList.add(new DrawerItem("Groups", R.drawable.ic_action_group));
		dataList.add(new DrawerItem("Import & Export",
				R.drawable.ic_action_import_export));
		dataList.add(new DrawerItem("About", R.drawable.ic_action_about));
		dataList.add(new DrawerItem("Settings", R.drawable.ic_action_settings));
		dataList.add(new DrawerItem("Help", R.drawable.ic_action_help));

		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
				dataList);

		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to
				// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to
				// onPrepareOptionsMenu()
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			SelectItem(0);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	public void SelectItem(int possition) {
		final FragmentManager frgManager = getFragmentManager();
		Fragment oldfragment  = frgManager.findFragmentById(R.id.content_frame);
		Fragment fragment = null;
		Bundle args = new Bundle();
		String TAG = "";
		switch (possition) {
		case 0:
			fragment = frgManager.findFragmentByTag("one");
			if( fragment == null)
			{
				fragment = new FragmentOne();
				TAG = "one";
				args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
						.getItemName());
				args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
						.getImgResID());
				fragment.setArguments(args);
				frgManager.beginTransaction().add(R.id.content_frame, fragment, TAG).addToBackStack(TAG).commit();

			}
			break;
		case 1:
			fragment = frgManager.findFragmentByTag("two");
			if( fragment == null)
			{
				fragment = new FragmentTwo();
				TAG = "two";
				args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
						.getItemName());
				args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
						.getImgResID());
				fragment.setArguments(args);
				frgManager.beginTransaction().add(R.id.content_frame, fragment, TAG).addToBackStack(TAG).commit();
			}
			break;
		case 2:
			fragment = frgManager.findFragmentByTag("three");
			if( fragment == null)
			{
				fragment = new FragmentThree();
				TAG = "three";
				args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
						.getItemName());
				args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList.get(possition)
						.getImgResID());
				fragment.setArguments(args);
				frgManager.beginTransaction().add(R.id.content_frame, fragment, TAG).addToBackStack(TAG).commit();
			}
			break;
		case 3:
			fragment = frgManager.findFragmentByTag("four");
			if( fragment == null)
			{
				fragment = new FragmentOne();
				TAG = "four";
				args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
						.getItemName());
				args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
						.getImgResID());
				fragment.setArguments(args);
				frgManager.beginTransaction().add(R.id.content_frame, fragment, TAG).addToBackStack(TAG).commit();
			}
			break;
		case 4:
			fragment = frgManager.findFragmentByTag("five");
			if( fragment == null)
			{
				fragment = new FragmentTwo();
				TAG = "five";
				args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
						.getItemName());
				args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
						.getImgResID());
				frgManager.beginTransaction().add(R.id.content_frame, fragment, TAG).addToBackStack(TAG).commit();
			}
			break;

		case 5:
			fragment = frgManager.findFragmentByTag("six");
			if( fragment == null)
			{
				fragment = new FragmentThree();
				TAG = "six";
				args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
						.getItemName());
				args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList.get(possition)
						.getImgResID());
				fragment.setArguments(args);
				frgManager.beginTransaction().add(R.id.content_frame, fragment, TAG).addToBackStack(TAG).commit();
			}
			break;
		case 6:
			fragment = frgManager.findFragmentByTag("seven");
			if( fragment == null)
			{
				fragment = new FragmentOne();
				TAG = "seven";
				args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
						.getItemName());
				args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
						.getImgResID());
				fragment.setArguments(args);
				frgManager.beginTransaction().add(R.id.content_frame, fragment, TAG).addToBackStack(TAG).commit();
			}
			break;
		case 7:
			fragment = frgManager.findFragmentByTag("eight");
			if( fragment == null)
			{
				fragment = new FragmentTwo();
				TAG = "eight";
				args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
						.getItemName());
				args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
						.getImgResID());
				fragment.setArguments(args);
				frgManager.beginTransaction().add(R.id.content_frame, fragment, TAG).addToBackStack(TAG).commit();
			}
			break;
		case 8:
			fragment = frgManager.findFragmentByTag("nine");
			if( fragment == null)
			{
				fragment = new FragmentThree();
				TAG = "nine";
				args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
						.getItemName());
				args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList.get(possition)
						.getImgResID());
				fragment.setArguments(args);
				frgManager.beginTransaction().add(R.id.content_frame, fragment, TAG).addToBackStack(TAG).commit();
			}
			break;
		case 9:
			fragment = frgManager.findFragmentByTag("ten");
			if( fragment == null)
			{
				fragment = new FragmentOne();
				TAG = "ten";
				args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
						.getItemName());
				args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
						.getImgResID());
				frgManager.beginTransaction().add(R.id.content_frame, fragment, TAG).addToBackStack(TAG).commit();
			}
			break;
		case 10:
			fragment = frgManager.findFragmentByTag("elvn");
			if( fragment == null)
			{
				fragment = new FragmentTwo();
				TAG = "elvn";
				args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
						.getItemName());
				args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
						.getImgResID());
				fragment.setArguments(args);
				frgManager.beginTransaction().add(R.id.content_frame, fragment, TAG).addToBackStack(TAG).commit();
			}
			break;
		case 11:
			fragment = frgManager.findFragmentByTag("twelve");
			if( fragment == null)
			{
				fragment = new FragmentThree();
				TAG = "twelve";
				args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
						.getItemName());
				args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList.get(possition)
						.getImgResID());
				fragment.setArguments(args);
				frgManager.beginTransaction().add(R.id.content_frame, fragment, TAG).addToBackStack(TAG).commit();
			}
			break;
		case 12:
			fragment = frgManager.findFragmentByTag("thirteen");
			if( fragment == null)
			{
				fragment = new FragmentOne();
				TAG = "thirteen";
				args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
						.getItemName());
				args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
						.getImgResID());
				fragment.setArguments(args);
				frgManager.beginTransaction().add(R.id.content_frame, fragment, TAG).addToBackStack(TAG).commit();
			}
			break;
		default:
			break;
		}

		if(oldfragment != null)
			frgManager.beginTransaction().hide(oldfragment).commit();
		frgManager.beginTransaction().show(fragment).commit();

		mDrawerList.setItemChecked(possition, true);
		setTitle(dataList.get(possition).getItemName());
		mDrawerLayout.closeDrawer(mDrawerList);

		frgManager.addOnBackStackChangedListener(onBackStackChangedListener);

	}
	private OnBackStackChangedListener onBackStackChangedListener = new OnBackStackChangedListener() {

		@Override
		public void onBackStackChanged() {
			Toast.makeText(getBaseContext(), "AD", Toast.LENGTH_SHORT).show();

		}
	};
	public void onBackPressed() 
	{
		final FragmentManager frgManager = getFragmentManager();
		frgManager.popBackStack();
		
	}
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return false;
	}

	private class DrawerItemClickListener implements
	ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			SelectItem(position);

		}
	}

}