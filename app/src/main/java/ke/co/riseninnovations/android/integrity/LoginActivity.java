package ke.co.riseninnovations.android.integrity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by simon on 6/20/2016.
 */
public class LoginActivity
        extends AppCompatActivity
{
    private static EditText username;
    private static EditText password;
    private static Button login_button;
    int attempt_counter = 5;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginButton();

    }


    public void LoginButton(){
        username = (EditText)findViewById(R.id.input_username);
        password = (EditText)findViewById(R.id.input_password);
        login_button = (Button)findViewById(R.id.btn_login);

        login_button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        if(username.getText().toString().equals("user") && password.getText().toString().equals("pass")){
                            Toast.makeText(LoginActivity.this,"Username and password is correct",
                                    Toast.LENGTH_SHORT).show();

                            savePreferences("login_value",  true);

                            finish();
                    }else {
                            Toast.makeText(LoginActivity.this,"Username and password is NOT correct",
                                    Toast.LENGTH_SHORT).show();
                            attempt_counter--;
                            if(attempt_counter==0)
                                login_button.setEnabled(false);

                            savePreferences("login_value",  true);

                    }
                }

    });
    }

    private void savePreferences(String storedName, boolean login_value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(storedName, login_value);
        editor.commit();
    }


}
