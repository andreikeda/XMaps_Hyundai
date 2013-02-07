package br.com.andreikeda.x_maps.activity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.andreikeda.x_maps.R;
import br.com.andreikeda.x_maps.application.*;
import br.com.andreikeda.x_maps.controller.*;
import br.com.andreikeda.x_maps.fragment.*;
import br.com.andreikeda.x_maps.helper.*;
import br.com.andreikeda.x_maps.util.*;
import br.com.andreikeda.x_maps.widget.interfaces.*;

import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.Session;
import com.googlecode.androidannotations.annotations.App;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.NoTitle;
import com.googlecode.androidannotations.annotations.ViewById;

/**
 * Classe criada em: 04/02/2013
 * Classe finalizada em: 06/02/2013
 *
 * Alteração: 05/02/2013
 *
 * @author André Ikeda
 *
 */
@NoTitle
@EActivity(R.layout.screen_main)
public class MainActivity extends FragmentActivity implements SpecialMenuCallBack {
	
	public void application() {
		if (Constants.DEBUG) {
			outDebugKey.setText(key);
		}
		else {
			if (mApp.isFirstTime() || mApp.getUser() == null) {
				frag = FragmentTypeHelper.Login;
				openFragment();
			}
			else {
				lyHeader.setVisibility(View.VISIBLE);
				LayoutController.configureMenu(lyMenu);
				frag = FragmentTypeHelper.Home;
				openFragment();
			}
		}
	}
	
	public static MainActivity getInstance() {
		return instance;
	}
	
	@Override
	public void onBackPressed() {
		if (frag != FragmentTypeHelper.Home && frag != FragmentTypeHelper.Login && frag != FragmentTypeHelper.SelectSkin) {
			frag = FragmentTypeHelper.Home;
			openFragment();
		}
		else
			finish();
	}
	
	public void openFragment() {
		FragmentManager fm      = getSupportFragmentManager();
		FragmentTransaction ft 	= fm.beginTransaction();
		switch(frag) {
			case Login:
				if (fragLogin == null)
					fragLogin = new LoginFragment_();
				ft.replace(lyContent.getId(), fragLogin);
				break;
				
			case Home:
				if (fragHome == null)
					fragHome = new HomeFragment_();
				ft.replace(lyContent.getId(), fragHome);
				break;
				
			case SelectSkin:
				if (fragSelectSkin == null)
					fragSelectSkin = new SelectSkinFragment_();
				ft.replace(lyContent.getId(), fragSelectSkin);
				break;
				
			case Challenge:
				if (fragChallenge == null)
					fragChallenge = new ChallengeFragment_();
				ft.replace(lyContent.getId(), fragChallenge);
				break;
				
			case Checkin:
				if (fragCheckIn == null)
					fragCheckIn = new CheckInFragment_();
				ft.replace(lyContent.getId(), fragCheckIn);
				break;
				
			case Explorer:
				if (fragExplorer == null)
					fragExplorer = new ExplorerFragment_();
				ft.replace(lyContent.getId(), fragExplorer);
				break;
				
			case Settings:
				if (fragSetting == null)
					fragSetting = new SettingsFragment_();
				ft.replace(lyContent.getId(), fragSetting);
				break;
				
			case Gallery:
				if (fragGallery == null)
					fragGallery = new GalleryFragment_();
				ft.replace(lyContent.getId(), fragGallery);
				break;
				
		}
		ft.commit();
	}
	
	public void setFragment(FragmentTypeHelper type) {
		frag = type;
	}

	/* (non-Javadoc)
	 * @see br.com.andreikeda.x_maps.widget.interfaces.SpecialMenuCallBack#subMenuEvent(br.com.andreikeda.x_maps.helper.MenuHelper)
	 */
	@Override
	public void subMenuEvent(MenuHelper tag) {
		Log.i("MainActivity", "subMenu clicked: " + tag.name());
		switch(tag) {
			case Challenges:
				frag = FragmentTypeHelper.Challenge;
				break;
				
			case Checkin:
				frag = FragmentTypeHelper.Checkin;
				break;
				
			case Explorer:
				frag = FragmentTypeHelper.Explorer;
				break;
				
			case Gallery:
				frag = FragmentTypeHelper.Gallery;
				break;
				
			case Settings:
				frag = FragmentTypeHelper.Settings;
				break;
				
			default:
		}
		openFragment();
	}
	
	@App
	MyApplication mApp;

	@ViewById(R.id.ly_content)
	LinearLayout lyContent;
	@ViewById(R.id.ly_header)
	LinearLayout lyHeader;
	@ViewById(R.id.ly_menu)
	RelativeLayout lyMenu;
	@ViewById(R.id.output_debug_key)
	TextView outDebugKey;

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		instance = this;
	    try {
	        PackageInfo info = getPackageManager().getPackageInfo(
	                "br.com.andreikeda.x_maps", 
	                PackageManager.GET_SIGNATURES);
	        for (Signature signature : info.signatures) {
	            MessageDigest md = MessageDigest.getInstance("SHA");
	            md.update(signature.toByteArray());
	            Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
	            key = Base64.encodeToString(md.digest(), Base64.DEFAULT);
	        }
	    } catch (NameNotFoundException e) {
	    	e.printStackTrace();
	    } catch (NoSuchAlgorithmException e) {
	    	e.printStackTrace();
	    }
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		application();
	}
	
	private ChallengeFragment fragChallenge		= null;
	private CheckInFragment fragCheckIn			= null;
	private ExplorerFragment fragExplorer		= null;
	private GalleryFragment fragGallery			= null;
	private HomeFragment fragHome				= null;
	private LoginFragment fragLogin 			= null;
	private SelectSkinFragment fragSelectSkin	= null;
	private SettingsFragment fragSetting		= null;
	
	private FragmentTypeHelper frag;
	
	private String key;
	
	private static MainActivity instance = null;

}
