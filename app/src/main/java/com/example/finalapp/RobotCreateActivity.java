package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RobotCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot_create);

        initMakeButton();
        initHeadColorPicker();
        initBodyColorPicker();
        initLegColorPicker();
        initRadioGroupChooseHeadColor();
        initRadioGroupChooseBodyColor();
        initRadioGroupChooseLegColor();
    }

    private void initMakeButton() {
        Button makeButton = findViewById(R.id.makeButton);
        makeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RobotCreateActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                EditText nameChoose = findViewById(R.id.nameChoose);
                intent.putExtra("choosename", nameChoose.getText().toString());
                startActivity(intent);
            }
        });
    }


    private void initHeadColorPicker() {
        SharedPreferences sharedHeadPref = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
        int chooseColor = sharedHeadPref.getInt("chooseheadcolor", 0xFFFF0000);
        RadioButton headColorRed = findViewById(R.id.headColorRed);
        RadioButton headColorBlue = findViewById(R.id.headColorBlue);
        RadioButton headColorYellow = findViewById(R.id.headColorYellow);
        if (chooseColor==0xFFFF0000) {
            headColorRed.setChecked(true);
        } else if (chooseColor==0xFF0000FF) {
            headColorBlue.setChecked(true);
        } else if (chooseColor==0xFFFFFF00) {
            headColorYellow.setChecked(true);
        }

    }

    private void initBodyColorPicker() {
        SharedPreferences sharedBodyPref = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
        int chooseColor = sharedBodyPref.getInt("choosebodycolor", 0xFFFF0000);
        RadioButton bodyColorRed = findViewById(R.id.bodyColorRed);
        RadioButton bodyColorBlue = findViewById(R.id.bodyColorBlue);
        RadioButton bodyColorYellow = findViewById(R.id.bodyColorYellow);
        if (chooseColor==0xFFFF0000) {
            bodyColorRed.setChecked(true);
        } else if (chooseColor==0xFF0000FF) {
            bodyColorBlue.setChecked(true);
        } else if (chooseColor==0xFFFFFF00) {
            bodyColorYellow.setChecked(true);
        }

    }

    private void initLegColorPicker() {
        SharedPreferences sharedLegPref = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
        int chooseColor = sharedLegPref.getInt("chooselegcolor", 0xFFFF0000);
        RadioButton legColorRed = findViewById(R.id.legColorRed);
        RadioButton legColorBlue = findViewById(R.id.legColorBlue);
        RadioButton legColorYellow = findViewById(R.id.legColorYellow);
        if (chooseColor==0xFFFF0000) {
            legColorRed.setChecked(true);
        } else if (chooseColor==0xFF0000FF) {
            legColorBlue.setChecked(true);
        } else if (chooseColor==0xFFFFFF00) {
            legColorYellow.setChecked(true);
        }

    }

    private void initRadioGroupChooseHeadColor() {
        RadioGroup rgHead = findViewById(R.id.rgHead);
        RadioButton rbHRed = findViewById(R.id.headColorRed);
        RadioButton rbHBlue = findViewById(R.id.headColorBlue);
        RadioButton rbHYellow = findViewById(R.id.headColorYellow);
        rgHead.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbHRed.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("chooseheadcolor", 0xFFFF0000);
                    editor.apply();
                } else if (rbHBlue.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("chooseheadcolor", 0xFF0000FF);
                    editor.apply();
                } else if (rbHYellow.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("chooseheadcolor", 0xFFFFFF00);
                    editor.apply();
                }

            }
        });
    }

    private void initRadioGroupChooseBodyColor() {
        RadioGroup rgBody = findViewById(R.id.rgBody);
        RadioButton rbBRed = findViewById(R.id.bodyColorRed);
        RadioButton rbBBlue = findViewById(R.id.bodyColorBlue);
        RadioButton rbBYellow = findViewById(R.id.bodyColorYellow);
        rgBody.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbBRed.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("choosebodycolor", 0xFFFF0000);
                    editor.apply();
                } else if (rbBBlue.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("choosebodycolor", 0xFF0000FF);
                    editor.apply();
                } else if (rbBYellow.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("choosebodycolor", 0xFFFFFF00);
                    editor.apply();
                }

            }
        });
    }

    private void initRadioGroupChooseLegColor() {
        RadioGroup rgLeg = findViewById(R.id.rgLeg);
        RadioButton rbLRed = findViewById(R.id.legColorRed);
        RadioButton rbLBlue = findViewById(R.id.legColorBlue);
        RadioButton rbLYellow = findViewById(R.id.legColorYellow);
        rgLeg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbLRed.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("chooselegcolor", 0xFFFF0000);
                    editor.apply();
                } else if (rbLBlue.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("chooselegcolor", 0xFF0000FF);
                    editor.apply();
                } else if (rbLYellow.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("chooselegcolor", 0xFFFFFF00);
                    editor.apply();
                }

            }
        });
    }
}