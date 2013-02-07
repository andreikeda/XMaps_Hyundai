package br.com.andreikeda.x_maps.fragment;

import br.com.andreikeda.x_maps.R;
import br.com.andreikeda.x_maps.application.MyApplication;
import br.com.andreikeda.x_maps.helper.BackgroundHelper;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EFragment;
import com.googlecode.androidannotations.annotations.ViewById;

import android.support.v4.app.Fragment;
import android.widget.RelativeLayout;

/**
 * Classe criada em: 06/02/2013
 * Classe finalizada em: 06/02/2013
 *
 * Alteração: 06/02/2013
 *
 * @author André Ikeda
 *
 */
@EFragment(R.layout.frag_explorer)
public class ExplorerFragment extends Fragment {
	
	@ViewById(R.id.ly_skin)
	RelativeLayout lySkin;
	
	@AfterViews
	void loadSkin() {
		lySkin.setBackgroundResource(BackgroundHelper.getBackgroundId(MyApplication.getInstance().getSkin()));
	}

}
