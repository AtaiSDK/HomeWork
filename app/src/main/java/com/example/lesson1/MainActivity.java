
package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.send);
        editText = findViewById(R.id.edit_text);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String input = s.toString().replaceAll("[^\\d]", "");
                if(input.length() ==11){
                    String formatedText = "(" + input.substring(0, 4) + ")" + input.substring(4, 7) + "-" + input.substring(7);
                    editText.setText(formatedText);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        button.setOnClickListener(view -> {
            String text = editText.getText().toString();
            if(TextUtils.isEmpty(text)){
                Toast.makeText(this, "Введите номер", Toast.LENGTH_SHORT).show();

            }else{

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("PhoneNumber", editText.getText().toString());
                startActivity(intent);
            }
        });

    }
}