/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 31, 2025
 * 3:50am
 * */
package ca.georgiancollege.assignmenttwo_condeludena;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ca.georgiancollege.assignmenttwo_condeludena.databinding.ActivityLoginBinding;
import ca.georgiancollege.assignmenttwo_condeludena.databinding.ActivityRegisterBinding;

public class Register extends AppCompatActivity {
    //initialize binding
    ActivityRegisterBinding activityRegisterBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign binding to layout
        activityRegisterBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(activityRegisterBinding.getRoot());

        //onclick for register button
        activityRegisterBinding.buttonReturnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initialize new intent to Register
                Intent intentLogin = new Intent(getApplicationContext(), Login.class);
                startActivity(intentLogin);

            }
        });

    }
}