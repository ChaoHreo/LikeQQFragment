package com.example.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

public class HomeActivity extends FragmentActivity implements
		View.OnClickListener {

	private FragmentManager manager;
	private MessageFragment messageFragment;
	private ContactsFragment contactsFragment;
	private DynamicFragment dynamicFragment;
	private RadioButton rb_msg,rb_contact,rb_dynamic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initView();
	}

	private void initView() {
		rb_msg = (RadioButton) findViewById(R.id.rb_msg);
		rb_contact = (RadioButton) findViewById(R.id.rb_contact);
		rb_dynamic = (RadioButton) findViewById(R.id.rb_dynamic);
		FrameLayout realtabcontent = (FrameLayout) findViewById(R.id.realtabcontent);
		rb_msg.setOnClickListener(this);
		rb_contact.setOnClickListener(this);
		rb_dynamic.setOnClickListener(this);
		manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		messageFragment = new MessageFragment();
		contactsFragment = new ContactsFragment();
		dynamicFragment = new DynamicFragment();
		rb_msg.setChecked(true);
		transaction.replace(R.id.realtabcontent, messageFragment).commit();

	}

	@Override
	public void onClick(View v) {
		FragmentTransaction transaction = manager.beginTransaction();
		switch (v.getId()) {
		case R.id.rb_msg:
			transaction.replace(R.id.realtabcontent, messageFragment);
			break;
		case R.id.rb_contact:
			transaction.replace(R.id.realtabcontent, contactsFragment);
			break;
		case R.id.rb_dynamic:
			transaction.replace(R.id.realtabcontent, dynamicFragment);
			break;
		}
		transaction.commit();
	}
}
