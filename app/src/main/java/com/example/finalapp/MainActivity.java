package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCreateButton();

        ConstraintLayout headLayout = findViewById(R.id.headLayout);

        SharedPreferences sharedHeadPref = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
        int chooseHeadColor = sharedHeadPref.getInt("chooseheadcolor", 0xFF00FF00);
        headLayout.setBackgroundColor(chooseHeadColor);

        ConstraintLayout bodyLayout = findViewById(R.id.bodyLayout);
        ConstraintLayout armLeftLayout = findViewById(R.id.lArmLayout);
        ConstraintLayout armRightLayout = findViewById(R.id.rArmLayout);

        int chooseBodyColor = sharedHeadPref.getInt("choosebodycolor", 0xFF00FF00);
        bodyLayout.setBackgroundColor(chooseBodyColor);
        armLeftLayout.setBackgroundColor(chooseBodyColor);
        armRightLayout.setBackgroundColor(chooseBodyColor);

        ConstraintLayout legLeftLayout = findViewById(R.id.lLegLayout);
        ConstraintLayout legRightLayout = findViewById(R.id.rLegLayout);

        int chooseLegColor = sharedHeadPref.getInt("chooselegcolor", 0xFF00FF00);
        legLeftLayout.setBackgroundColor(chooseLegColor);
        legRightLayout.setBackgroundColor(chooseLegColor);

    }

    public void onResume() {
        super.onResume();

        TextView nameText = findViewById(R.id.nameText);

        Intent intent = getIntent();
        String textName = intent.getStringExtra("choosename");
        nameText.setText(textName);
    }

    private void initCreateButton() {
        Button createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RobotCreateActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}