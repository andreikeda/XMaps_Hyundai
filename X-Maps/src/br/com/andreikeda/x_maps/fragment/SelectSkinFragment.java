package br.com.andreikeda.x_maps.fragment;

import br.com.andreikeda.x_maps.R;
import br.com.andreikeda.x_maps.activity.MainActivity;
import br.com.andreikeda.x_maps.application.MyApplication;
import br.com.andreikeda.x_maps.helper.BackgroundHelper;
import br.com.andreikeda.x_maps.helper.FragmentTypeHelper;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EFragment;
import com.googlecode.androidannotations.annotations.Touch;
import com.googlecode.androidannotations.annotations.ViewById;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Classe criada em: 06/02/2013
 * Classe finalizada em: 06/02/2013
 *
 * Alteração: 06/02/2013
 *
 * @author André Ikeda
 *
 */
@EFragment(R.layout.frag_select_skin)
public class SelectSkinFragment extends Fragment {
	
	float x1, x2, y1, y2, dx, dy;

	@ViewById(R.id.img_sport)
	ImageView imgSport;
	@ViewById(R.id.ly_skin)
	LinearLayout lySkin;
	
	@Touch(R.id.ly_skin)
	boolean changeSkin(MotionEvent evt) {
		Log.i("MainActivity", "move");
		switch(evt.getAction()) {
			case(MotionEvent.ACTION_DOWN):
				x1 = evt.getX();
	        	y1 = evt.getY();
	        	break;
	        
			case(MotionEvent.ACTION_UP):
				x2 = evt.getX();
				y2 = evt.getY();
				dx = x2-x1;
				dy = y2-y1;

				if(Math.abs(dx) > Math.abs(dy)) {
					if(dx > 0)
						skin = BackgroundHelper.getOnRight(skin);
					else 
						skin = BackgroundHelper.getOnLeft(skin);
					loadSkin();
				}
		}
		return true;
	}
	
	@AfterViews
	void loadSkin() {
		imgSport.setImageResource(BackgroundHelper.getImageId(skin));
		lySkin.setBackgroundResource(BackgroundHelper.getBackgroundId(skin));
	}
	
	@Click(R.id.btn_select)
	void onBtnSelectClicked() {
		MyApplication.getInstance().setSkin(skin.ordinal());
		MainActivity.getInstance().setFragment(FragmentTypeHelper.Home);
		MainActivity.getInstance().openFragment();
	}
	
	private BackgroundHelper skin = BackgroundHelper.Parachute;

}
