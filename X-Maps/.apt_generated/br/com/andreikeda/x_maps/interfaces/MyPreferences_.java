//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package br.com.andreikeda.x_maps.interfaces;

import android.content.Context;
import android.content.SharedPreferences;
import com.googlecode.androidannotations.api.sharedpreferences.BooleanPrefEditorField;
import com.googlecode.androidannotations.api.sharedpreferences.BooleanPrefField;
import com.googlecode.androidannotations.api.sharedpreferences.EditorHelper;
import com.googlecode.androidannotations.api.sharedpreferences.IntPrefEditorField;
import com.googlecode.androidannotations.api.sharedpreferences.IntPrefField;
import com.googlecode.androidannotations.api.sharedpreferences.SharedPreferencesHelper;

public final class MyPreferences_
    extends SharedPreferencesHelper
{


    public MyPreferences_(Context context) {
        super(context.getSharedPreferences((getLocalClassName(context)+"_MyPreferences"), 0));
    }

    private static String getLocalClassName(Context context) {
        String packageName = context.getPackageName();
        String className = context.getClass().getName();
        int packageLen = packageName.length();
        if (((!className.startsWith(packageName))||(className.length()<= packageLen))||(className.charAt(packageLen)!= '.')) {
            return className;
        }
        return className.substring((packageLen + 1));
    }

    public MyPreferences_.MyPreferencesEditor_ edit() {
        return new MyPreferences_.MyPreferencesEditor_(getSharedPreferences());
    }

    public BooleanPrefField firstTime() {
        return booleanField("firstTime", true);
    }

    public IntPrefField skin() {
        return intField("skin", 0);
    }

    public final static class MyPreferencesEditor_
        extends EditorHelper<MyPreferences_.MyPreferencesEditor_>
    {


        MyPreferencesEditor_(SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }

        public BooleanPrefEditorField<MyPreferences_.MyPreferencesEditor_> firstTime() {
            return booleanField("firstTime");
        }

        public IntPrefEditorField<MyPreferences_.MyPreferencesEditor_> skin() {
            return intField("skin");
        }

    }

}
