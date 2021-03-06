package com.example.administrator.internetpassport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText editTextNewId, editTextNewPassword, editTextConfirmPassword;
    private Button buttonCreateAccount;
    private TextView textViewPasswordSame;
    private InfoStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        editTextNewId = (EditText) findViewById(R.id.editTextNewId);
        editTextNewPassword = (EditText) findViewById(R.id.editTextNewPassword);
        editTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);
        buttonCreateAccount = (Button) findViewById(R.id.buttonCreateAccount);
        textViewPasswordSame = (TextView) findViewById(R.id.textViewPasswordSame);
        storage = MainActivity.getStorage();
    }

    public void createAccount(View view) {
        String inputNewId = editTextNewId.getText().toString();
        String inputNewPassword = editTextNewPassword.getText().toString();
        String inputConfirmPassword = editTextConfirmPassword.getText().toString();

        if(inputNewPassword.equals(inputConfirmPassword)){
            storage.setId(inputNewId);
            storage.setPassword(inputNewPassword);
            Toast.makeText(CreateAccountActivity.this,"Created Account",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        }
        else{
            textViewPasswordSame.setText("Your passwords are not the same");
        }
    }
}
