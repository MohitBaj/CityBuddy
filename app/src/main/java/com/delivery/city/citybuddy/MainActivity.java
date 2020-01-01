package com.delivery.city.citybuddy;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToUserSelector(View view) {
        radioGroup = (RadioGroup) findViewById(R.id.languageRadio);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        // get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);

        Toast.makeText(MainActivity.this,
                radioButton.getText(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, UserSelectorActivity.class);
        startActivity(intent);
    }
}
