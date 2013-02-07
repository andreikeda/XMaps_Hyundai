package br.com.andreikeda.x_maps.interfaces;

import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultInt;
import com.googlecode.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Classe criada em: 04/02/2013
 * Classe finalizada em: 06/02/2013
 *
 * Alteração: 05/02/2013
 *
 * @author André Ikeda
 *
 */
@SharedPref
public interface MyPreferences {
	
	@DefaultBoolean(true)
	boolean firstTime();
	@DefaultInt(0)
	int skin();

}
