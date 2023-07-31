package com.example.personallibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText title_input, author_input;
    Button update_button;
    String id, title, author;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title_input = findViewById(R.id.titleEditText2);
        author_input = findViewById(R.id.authorEditText2);
        update_button = findViewById(R.id.update_book);
        getAndSetIntentData();
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(UpdateActivity.this);
                title = title_input.getText().toString().trim();
                author = author_input.getText().toString().trim();
                db.updateData(id,title,author);
                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("author")){
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            author = getIntent().getStringExtra("author");

            title_input.setText(title);
            author_input.setText(author);
        }else{
            Toast.makeText(this, "No Data",Toast.LENGTH_SHORT);
        }
    }
}