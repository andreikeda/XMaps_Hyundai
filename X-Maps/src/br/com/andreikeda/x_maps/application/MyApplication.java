package br.com.andreikeda.x_maps.application;

import br.com.andreikeda.x_maps.activity.MainActivity;
import br.com.andreikeda.x_maps.helper.BackgroundHelper;
import br.com.andreikeda.x_maps.helper.FragmentTypeHelper;
import br.com.andreikeda.x_maps.interfaces.MyPreferences_;

import com.googlecode.androidannotations.annotations.EApplication;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.facebook.*;
import com.facebook.model.*;

import android.app.Application;
import android.widget.Toast;

/**
 * Classe criada em: 04/02/2013
 * Classe finalizada em: 06/02/2013
 *
 * Alteração: 05/02/2013
 *
 * @author André Ikeda
 *
 */
@EApplication
public class MyApplication extends Application {
	
	public void connectFacebook() {
		// start Facebook Login
		Session.openActiveSession(MainActivity.getInstance(), true, new Session.StatusCallback() {
			// callback when session changes state
			@Override
			public void call(Session session, SessionState state, Exception exception) {
				if (session.isOpened()) {
					// make request to the /me API
					Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {
						// callback after Graph API response with user object
						@Override
						public void onCompleted(GraphUser u, Response response) {
							if (u != null) {
								user = u;
								if (isFirstTime()) {
									MainActivity.getInstance().setFragment(FragmentTypeHelper.SelectSkin);
									setFirstTime(false);
								}
								else
									MainActivity.getInstance().setFragment(FragmentTypeHelper.Home);
								Toast.makeText(MainActivity.getInstance(), user.getName(), Toast.LENGTH_SHORT).show();
								MainActivity.getInstance().application();
							}
						}
					});
				}
			}
		});
	}
	
	public static MyApplication getInstance() {
		return instance;
	}
	
	public BackgroundHelper getSkin() {
		return BackgroundHelper.values()[mPref.skin().get()];
	}
	
	public GraphUser getUser() {
		return user;
	}
	
	public boolean isFirstTime() {
		return mPref.firstTime().get();
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		instance = this;
	}
	
	public void setSkin(int value) {
		mPref.edit().skin().put(value).apply();
	}
	
	public void setFirstTime(boolean value) {
		mPref.edit().firstTime().put(value).apply();
	}
	
	GraphUser user;
	
	@Pref
	MyPreferences_ mPref;
	
	private static MyApplication instance;

}
