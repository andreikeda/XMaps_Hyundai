package br.com.andreikeda.x_maps.helper;

import br.com.andreikeda.x_maps.R;

/**
 * Classe criada em: 04/02/2013
 * Classe finalizada em: 06/02/2013
 *
 * Alteração: 05/02/2013
 *
 * @author André Ikeda
 *
 */
public enum LayoutHelper {
	TitleButton,
	Home,
	SelectSport,
	Login;
	
	public static int getBackgroundId(LayoutHelper helper) {
		switch(helper) {
			case Home:
			case Login:
			case SelectSport:
				return R.drawable.bg_all;
				
			case TitleButton:
				return R.drawable.bg_tit;
		}
		return -1;
	}
	
	public static int getLayoutId(LayoutHelper helper) {
		switch(helper) {
			case Login:
				return R.layout.frag_login;
				
//			case TitleButton:
//				return R.layout.subscreen_title_button;
				
			case SelectSport:
				return R.layout.frag_select_skin;
				
			case Home:
				
		}
		return -1;
	}

}
