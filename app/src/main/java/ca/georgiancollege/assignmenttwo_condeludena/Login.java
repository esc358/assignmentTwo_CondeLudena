/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 29, 2025
 * 10:00am
 * */
package ca.georgiancollege.assignmenttwo_condeludena;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import ca.georgiancollege.assignmenttwo_condeludena.databinding.LoginBinding;

public class Login extends AppCompatActivity {

    //initialize binding for activity_main.xml
    LoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign binding to layout
        loginBinding = LoginBinding.inflate(getLayoutInflater());
        setContentView(loginBinding.getRoot());
    }
}