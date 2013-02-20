package com.example.dojo.test.acceptance;


import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.example.dojo1.ConverterActivity;
import com.example.dojo1.R;
import com.jayway.android.robotium.solo.Solo;

public class RobotiumTest extends ActivityInstrumentationTestCase2{
	private static final String TARGET_PACKAGE_ID="com.example.dojo1";
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME="com.example.dojo1.ConverterActivity";
	private static Class launcherActivityClass;
	static{
		try
		{
			launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}

	public RobotiumTest() throws ClassNotFoundException{
		super(launcherActivityClass);
	}



	Solo solo;
	
	@Override
	protected void setUp() throws Exception
	{
		solo = new Solo(getInstrumentation(),getActivity());
	}

	public void testDisplayBlackBox() {
	
		solo.enterText((EditText) solo.getView(R.id.editText1), "10");
	
		solo.enterText((EditText) solo.getView(R.id.editText2), "1");

		
		solo.clickOnEditText(0);
	
		assertTrue(solo.searchText("3"));
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	public void TestrightActivity(){
		solo = new Solo(getInstrumentation(),getActivity());
		
		solo.assertCurrentActivity("wrong activiy", ConverterActivity.class);
	}
	
	
}