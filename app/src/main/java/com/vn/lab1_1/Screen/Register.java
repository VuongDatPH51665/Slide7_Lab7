package com.vn.lab1_1.Screen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import androidx.appcompat.app.AppCompatActivity;


import com.vn.lab1_1.R;

public class Register extends AppCompatActivity {
        private FirebaseAuth mAuth;
        private EditText emailField, passwordField;
        private Button registerButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

            mAuth = FirebaseAuth.getInstance();
            emailField = findViewById(R.id.edtName);
            passwordField = findViewById(R.id.edtpassword);
            registerButton = findViewById(R.id.btnRegister);

            registerButton.setOnClickListener(v -> {
                String email = emailField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                if (!email.isEmpty() && !password.isEmpty()) {
                    createAccount(email, password);
                } else {
                    Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void createAccount(String email, String password) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                            updateUI(user);
                        } else {
                            String errorMessage = task.getException() != null ? task.getException().getMessage() : "Unknown error";
                            Toast.makeText(this, "Đăng ký thất bại: " + errorMessage, Toast.LENGTH_LONG).show();
                            updateUI(null);
                        }
                    });
        }

        private void updateUI(FirebaseUser user) {
            if (user != null) {
                // Chuyển tới màn hình chính
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                finish();
            }
        }
    }

