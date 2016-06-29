package ke.co.riseninnovations.android.base;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import ke.co.riseninnovations.android.integrity.LoginActivity;

/**
 * Created by simon on 6/27/2016.
 */
public class BaseApplication {

    private SharedPreferences settings;
    private String keyLoginToken = "login_value";
    private Context context;

    public BaseApplication(Context context){
        this.context = context;
        settings = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public boolean LoginStatus(){
        return settings.getBoolean(keyLoginToken, false);
    }


}
