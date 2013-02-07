package br.com.andreikeda.x_maps.fragment;

import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import br.com.andreikeda.x_maps.R;
import br.com.andreikeda.x_maps.application.MyApplication;
import br.com.andreikeda.x_maps.util.Constants;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EFragment;
import com.googlecode.androidannotations.annotations.Touch;

/**
 * Classe criada em: 06/02/2013
 * Classe finalizada em: 06/02/2013
 *
 * Alteração: 06/02/2013
 *
 * @author André Ikeda
 *
 */
@EFragment(R.layout.frag_login)
public class LoginFragment extends Fragment {
	
	@Click(R.id.btn_login)
	void login() {
		MyApplication.getInstance().connectFacebook();
	}
	
	@Touch(R.id.ly_curtain)
	void move(MotionEvent evt) {
		
	}
	
	private int content = Constants.VIEW_LOGIN;

}
