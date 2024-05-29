package com.example.tester;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Subscribe to Firebase topic
        FirebaseMessaging.getInstance().subscribeToTopic("web_app")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Done";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }
                    }
                });
    }

    public void onLoginClick(View view) {
        // Launch Login Activity
        Intent loginIntent = new Intent(this, Login.class);
        startActivity(loginIntent);
    }

    public void onRegisterClick(View view) {
        // Launch Register Activity
        Intent registerIntent = new Intent(this, Register.class);
        startActivity(registerIntent);
    }

    public void logout(View view) {
        // Code to logout the user
        // For example, you can clear user session or navigate to the login screen
        // Here, I'll just close the activity for demonstration purposes
        finish();
    }
}
