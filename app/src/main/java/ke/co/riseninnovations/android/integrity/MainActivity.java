package ke.co.riseninnovations.android.integrity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import butterknife.ButterKnife;
import ke.co.riseninnovations.android.base.BaseApplication;
import ke.co.riseninnovations.android.fragments.FirstFragment;
import ke.co.riseninnovations.android.ui.BaseActivity;

public class MainActivity
        extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BaseApplication baseApplication = new BaseApplication(getApplicationContext());
        if (baseApplication.LoginStatus()){
            Toast.makeText(getApplicationContext(),"LOGGED IN!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"NOT LOGGED IN!", Toast.LENGTH_LONG).show();
        }

        //Check if user is logged in already if not takes user to login screen
        loadSavedPreferences();

        setContentView(R.layout.activity_main);

    }

    private void loadSavedPreferences() {

        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        boolean loginToken = sharedPreferences.getBoolean("login_value", false);
        String sharedUsername = sharedPreferences.getString("storedName", "YourName");
        if(loginToken == false){
            //Starts LoginActivity
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
        }

    }

}
