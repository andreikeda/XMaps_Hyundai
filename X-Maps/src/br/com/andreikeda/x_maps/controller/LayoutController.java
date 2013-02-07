package br.com.andreikeda.x_maps.controller;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import br.com.andreikeda.x_maps.R;
import br.com.andreikeda.x_maps.activity.MainActivity;
import br.com.andreikeda.x_maps.helper.LayoutHelper;
import br.com.andreikeda.x_maps.helper.MenuHelper;
import br.com.andreikeda.x_maps.widget.SpecialMenu;
import br.com.andreikeda.x_maps.widget.model.SpecialMenuModel;

/**
 * Classe criada em: 04/02/2013
 * Classe finalizada em: 06/02/2013
 *
 * Alteração: 05/02/2013
 *
 * @author André Ikeda
 *
 */
public class LayoutController {
	
	public static void configureMenu(RelativeLayout lyMenu) {
		ArrayList<SpecialMenuModel> model = new ArrayList<SpecialMenuModel>();
		for (int i = 1; i < MenuHelper.values().length; i++)
			model.add(getConfiguredButton(MenuHelper.values()[i]));
		SpecialMenu menu = new SpecialMenu(MainActivity.getInstance(), 450, 3, model);
		menu.setSpecialMenuCallBack(MainActivity.getInstance());
    	RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(450, 450);
    	lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
    	lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
    	lyMenu.addView(menu, lp);
	}
	
	public static void inflateContentLayout(LinearLayout lyContent, LayoutHelper type) {
		View view;
		LayoutInflater inflater = (LayoutInflater) MainActivity.getInstance().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(LayoutHelper.getLayoutId(type), null);
		view.setBackgroundResource(LayoutHelper.getBackgroundId(type));
//		view.setOnTouchListener(MainActivity.getInstance());
		lyContent.addView(view);
	}
	
	private static SpecialMenuModel getConfiguredButton(MenuHelper helper) {
		SpecialMenuModel m = new SpecialMenuModel();
		m.tag = helper;
		switch(helper) {
			case Challenges:
				m.name = "Desafios";
				m.Rid = R.drawable.menu_desafio;
				break;
				
			case Checkin:
				m.name = "Check-in";
				m.Rid = R.drawable.menu_checkin;
				break;
				
			case Explorer:
				m.name = "Explorar";
				m.Rid = R.drawable.menu_explorar;
				break;
				
			case Gallery:
				m.name = "Galeria";
				m.Rid = R.drawable.menu_galeria;
				break;
				
			case None:
				break;
			
			case Settings:
				m.name = "Configurações";
				m.Rid = R.drawable.menu_config;
				break;
		}
		return m;
	}

}
