package br.com.andreikeda.x_maps.helper;

import br.com.andreikeda.x_maps.R;

/**
 * Classe criada em: 05/02/2013
 * Classe finalizada em: 05/02/2013
 *
 * Alteração: 05/02/2013
 *
 * @author André Ikeda
 *
 */
public enum BackgroundHelper {
	Default,
	Skate,
	Slackline,
	Surf,
	Parachute;
	
	public static int getBackgroundId(BackgroundHelper helper) {
		switch(helper) {
			case Default:
				return R.drawable.bg_all;
				
			case Parachute:
				return R.drawable.bg_paraqueads;
				
			case Skate:
				return R.drawable.bg_skate;
				
			case Slackline:
				return R.drawable.bg_slackline;
				
			case Surf:
				return R.drawable.bg_surf;
		}
		return -1;
	}
	
	public static int getImageId(BackgroundHelper helper) {
		switch(helper) {
			case Default:
				break;
				
			case Parachute:
				return R.drawable.selec_paraquedas;
				
			case Skate:
				return R.drawable.selec_skate;
				
			case Slackline:
				return R.drawable.selec_slack;
				
			case Surf:
				return R.drawable.selec_surf;
		}
		return -1;
	}
	
	public static BackgroundHelper getOnLeft(BackgroundHelper helper) {
		switch(helper) {
			case Parachute:
				return Surf;
				
			case Skate:
				return Parachute;
				
			case Slackline:
				return Skate;
				
			case Surf:
				return Slackline;
				
			default:
				return null;
		}
	}
	
	public static BackgroundHelper getOnRight(BackgroundHelper helper) {
		switch(helper) {
			case Parachute:
				return Skate;
				
			case Skate:
				return Slackline;
				
			case Slackline:
				return Surf;
				
			case Surf:
				return Parachute;
				
			default:
				return null;
		}
	}
}
