package com.delivery.city.citybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UserSelectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selector);


    }

    public void slide1(View view){
        LinearLayout left = (LinearLayout) findViewById(R.id.left_part);
        LinearLayout right = (LinearLayout) findViewById(R.id.right_part);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right_1);
        left.startAnimation(animation1);
        Animation animation2 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right_2);
        right.startAnimation(animation2);

        Button b = (Button) findViewById(R.id.shopowner);
        Animation animation3 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.text);
        b.startAnimation(animation3);
        b.setVisibility(view.INVISIBLE);
        b.setClickable(false);
        Button b1 = (Button) findViewById(R.id.consumer);
        b1.setClickable(false);

        TextView t = (TextView) findViewById(R.id.textView);
        Animation animation4 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.text);
        t.startAnimation(animation4);
        t.setVisibility(view.INVISIBLE);

        LinearLayout loginPage = (LinearLayout) findViewById(R.id.loginPage);
        Animation animation5 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        loginPage.startAnimation(animation5);
        loginPage.setVisibility(view.VISIBLE);
    }
    public void slide2(View view){
        LinearLayout left = (LinearLayout) findViewById(R.id.left_part);
        LinearLayout right = (LinearLayout) findViewById(R.id.right_part);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left_1);
        left.startAnimation(animation1);
        Animation animation2 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left_2);
        right.startAnimation(animation2);

        Button b = (Button) findViewById(R.id.consumer);
        Animation animation3 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.text);
        b.startAnimation(animation3);
        b.setVisibility(view.INVISIBLE);
        b.setClickable(false);
        Button b1 = (Button) findViewById(R.id.shopowner);
        b1.setClickable(false);

        TextView t = (TextView) findViewById(R.id.textView);
        Animation animation4 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.text);
        t.startAnimation(animation4);
        t.setVisibility(view.INVISIBLE);

        LinearLayout loginPage = (LinearLayout) findViewById(R.id.loginPage);
        Animation animation5 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        loginPage.startAnimation(animation5);
        loginPage.setVisibility(view.VISIBLE);
    }

    public void loginStart(View view){
        EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        Log.i("Username","Username and password are "+usernameEditText.getText().toString()+" " + passwordEditText.getText().toString());
        Toast.makeText(UserSelectorActivity.this,
                "Welcome "+usernameEditText.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
