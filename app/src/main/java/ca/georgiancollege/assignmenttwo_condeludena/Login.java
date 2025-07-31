/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 29, 2025
 * 10:00am
 * */
package ca.georgiancollege.assignmenttwo_condeludena;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import ca.georgiancollege.assignmenttwo_condeludena.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {

    //initialize binding for activity_main.xml
    ActivityLoginBinding activityLoginBinding;
    //initialize Firebase
    private FirebaseAuth firebaseAuthentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign binding to layout
        activityLoginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(activityLoginBinding.getRoot());

        //assign firebase to a new instance
        firebaseAuthentication = FirebaseAuth.getInstance();

        //onclick for register button
        activityLoginBinding.buttonGoSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initialize new intent to Register
                Intent intentRegister = new Intent(getApplicationContext(), Register.class);
                startActivity(intentRegister);
            }
        });

        //TODO:Complete method
        //onclick for login button
        activityLoginBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get from edit text email and password and save it in str variables
                String email = activityLoginBinding.inputEmail.getText().toString().trim();
                String password = activityLoginBinding.inputPassword.getText().toString().trim();

                //clear errors
                activityLoginBinding.textError.setVisibility(View.GONE);

                //email not valid
                if (!isValidEmail(email)) {
                    //display error
                    activityLoginBinding.textError.setText("Invalid email address");
                    //set view visible for error
                    activityLoginBinding.textError.setVisibility(View.VISIBLE);
                    //end void function
                    return;
                }

                //password not valid
                if (!isValidPassword(password)) {
                    activityLoginBinding.textError.setText("Password must be at least 6 characters and include a number");
                    activityLoginBinding.textError.setVisibility(View.VISIBLE);
                    return;
                }

                //sign in user
                signUser(email, password);

                //TODO: reuse views from movies recycler view

                //intialize new intent for movie activity
                Intent intentMovieActivity = new Intent(getApplicationContext(), MovieActivity.class);
                startActivity(intentMovieActivity);
                finish();
            }
        });
    }
    //TODO: Complete method
    //void method to sign user
    private void signUser(String email, String password){
        //method from firebase to sign in with email and password
        firebaseAuthentication.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        });
    }
    //email validation using regex
    private boolean isValidEmail(String email) {
        //set regex for email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        //return a boolean in string matches regex
        return email.matches(emailRegex);
    }

    //password validation using regex
    private boolean isValidPassword(String password) {
        // At least 6 characters, at least 1 letter and 1 number
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d).{6,}$";
        return password.matches(passwordRegex);
    }
}