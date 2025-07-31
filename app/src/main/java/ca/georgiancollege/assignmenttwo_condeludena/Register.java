/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 31, 2025
 * 3:50am
 * */
package ca.georgiancollege.assignmenttwo_condeludena;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import ca.georgiancollege.assignmenttwo_condeludena.databinding.ActivityRegisterBinding;

public class Register extends AppCompatActivity {
    //initialize binding
    ActivityRegisterBinding activityRegisterBinding;
    //initialize Firebase
    private FirebaseAuth firebaseAuthentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign binding to layout
        activityRegisterBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(activityRegisterBinding.getRoot());

        //assign firebase to a new instance
        firebaseAuthentication = FirebaseAuth.getInstance();

        //onclick for return button
        activityRegisterBinding.buttonReturnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initialize new intent to Login
                Intent intentLogin = new Intent(getApplicationContext(), Login.class);
                startActivity(intentLogin);
            }
        });

        //on click to register user
        activityRegisterBinding.buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                //get from edit text email and password and save it in str variables
                String email = activityRegisterBinding.inputEmail.getText().toString().trim();
                String password = activityRegisterBinding.inputPassword.getText().toString().trim();

                //clear errors
                activityRegisterBinding.textError.setVisibility(View.GONE);

                //email not valid
                if (!isValidEmail(email)) {
                    //display error
                    activityRegisterBinding.textError.setText("Invalid email address");
                    //set view visible for error
                    activityRegisterBinding.textError.setVisibility(View.VISIBLE);
                    //end void function
                    return;
                }

                //password not valid
                if (!isValidPassword(password)) {
                    activityRegisterBinding.textError.setText("Password must be at least 6 characters and include a number");
                    activityRegisterBinding.textError.setVisibility(View.VISIBLE);
                    return;
                }

                //register user
                registerUser(email, password);
            }
        });
    }

    //method to register user takes two param str for email and password
    private void registerUser(String email, String password){
        //firebase method to create new user
        firebaseAuthentication.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    //intent to return to login
                    Intent intentLogin = new Intent(getApplicationContext(), Login.class);
                    startActivity(intentLogin);
                    //finish
                    finish();
                }else{
                    //show firebase error
                    String errorMsg = task.getException() != null
                            ? task.getException().getMessage()
                            : "Registration failed. Try again.";
                    activityRegisterBinding.textError.setText(errorMsg);
                    activityRegisterBinding.textError.setVisibility(View.VISIBLE);
                }
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