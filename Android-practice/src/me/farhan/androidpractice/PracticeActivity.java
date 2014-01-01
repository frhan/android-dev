package me.farhan.androidpractice;

import android.app.Activity;
import android.os.Bundle;

public class PracticeActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle b = getIntent().getExtras();
		if(b != null)
		{
			ModelB modelB = (ModelB) b.getParcelable("v");
			System.out.print(modelB.listModels.size());
		}
	}
}
