package com.cabalabs.iucaa_x;
import android.content.Context;
import android.content.SharedPreferences;


/**
 * All functions To check if the app is first time launch or not are defined
 *
 */
public class PrefManager {

    /**
     * Shared Preference is used to store the status of the app
     * If Firstime launch show the intro slider
     */
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "ASTROSAT APP - welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Sets the status of App after first Launch
     * @param isFirstTime
     */

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    /**
     * Checks the Status of App Launch
     * @return True if its a First Time
     */

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}