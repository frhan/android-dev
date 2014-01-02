package me.farhan.androidpractice;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	ModelB modelB;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<ModelA> list = new ArrayList<ModelA>();
		list.add(new ModelA(10,15));
		list.add(new ModelA(15,20));
		
		modelB = new ModelB();
		modelB.listModels = list;
		modelB.stra = "Hello";
		modelB.strb = "Hello world";
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onclickOk(View view) 
	{
		
		Intent intent = new Intent(MainActivity.this, me.farhan.androidpractice.PracticeActivity.class);
		Bundle b = new Bundle();
		b.putParcelable("v", modelB);
		intent.putExtras(b);
		startActivity(intent);
		
	}
}
