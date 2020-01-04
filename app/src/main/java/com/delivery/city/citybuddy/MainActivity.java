package com.delivery.city.citybuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.delivery.city.citybuddy.dao.UsersDAO;
import com.delivery.city.citybuddy.models.Users;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnSubmit;

    public UsersDatabase database;
    UsersDAO usersDAO;
    Users users;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = Room.databaseBuilder(this, UsersDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();

        usersDAO = database.getUsersDAO();
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
        TextView textViewLoginPage = (TextView) findViewById(R.id.loginTextView);
        LinearLayout linearLayoutLoginPage = (LinearLayout) findViewById(R.id.LinearLayout_main);
        LinearLayout linearLayoutLanguagePage = (LinearLayout) findViewById(R.id.languagePage);

        Animation animation_fade_in =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        Animation animation_fade_out =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.text);
        linearLayoutLanguagePage.startAnimation(animation_fade_out);
        linearLayoutLanguagePage.setVisibility(view.INVISIBLE);

        linearLayoutLoginPage.startAnimation(animation_fade_in);
        linearLayoutLoginPage.setVisibility(view.VISIBLE);
    }

    public void slide1(View view){
        LinearLayout left = (LinearLayout) findViewById(R.id.leftLinearLayout);
        LinearLayout right = (LinearLayout) findViewById(R.id.rightLinearLayout);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right_1);
        left.startAnimation(animation1);
        Animation animation2 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right_2);
        right.startAnimation(animation2);

        Button b = (Button) findViewById(R.id.shopownerButton);
        Animation animation3 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.text);
        b.startAnimation(animation3);
        b.setVisibility(view.INVISIBLE);
        b.setClickable(false);
        Button b1 = (Button) findViewById(R.id.consumerButton);
        b1.setClickable(false);

        TextView t = (TextView) findViewById(R.id.loginTextView);
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
        LinearLayout left = (LinearLayout) findViewById(R.id.leftLinearLayout);
        LinearLayout right = (LinearLayout) findViewById(R.id.rightLinearLayout);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left_1);
        left.startAnimation(animation1);
        Animation animation2 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left_2);
        right.startAnimation(animation2);

        Button b = (Button) findViewById(R.id.consumerButton);
        Animation animation3 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.text);
        b.startAnimation(animation3);
        b.setVisibility(view.INVISIBLE);
        b.setClickable(false);
        Button b1 = (Button) findViewById(R.id.shopownerButton);
        b1.setClickable(false);

        TextView t = (TextView) findViewById(R.id.loginTextView);
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
        EditText usernameEditText = (EditText) findViewById(R.id.usernameLoginEditText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordLoginEditText);

        List<Users> temp_list = usersDAO.getUsersByUserName(usernameEditText.getText().toString());
        Log.i("size","Size of list obtained is "+temp_list.size());
        if(true){
            Log.i("d","wtf broo!!!");
        }
        if(temp_list.isEmpty()){
            Log.i("dvv","Helloiii");
            Toast.makeText(MainActivity.this,
                    "No such user exists", Toast.LENGTH_SHORT).show();
        }
        else{
            Log.i("dv","Entered else");
            if(!temp_list.get(0).Password.equals(passwordEditText.getText().toString())){
                Toast.makeText(MainActivity.this,
                        "Incorrect password", Toast.LENGTH_SHORT).show();
            }
            else{
                Log.i("temp","Here we are");
                Log.i("Username","Username and password are "+usernameEditText.getText().toString()+" " + passwordEditText.getText().toString());
                Toast.makeText(MainActivity.this,
                        "Welcome "+usernameEditText.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ConsumerWindow.class);
                intent.putExtra("firstname",temp_list.get(0).FirstName);
                startActivity(intent);
            }
        }

    }

    public void signUpForm(View view){
        LinearLayout loginPage = (LinearLayout) findViewById(R.id.loginPage);
        LinearLayout signUpPage = (LinearLayout) findViewById(R.id.signUpPage);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        Animation animation2 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.text);
        loginPage.startAnimation(animation2);
        loginPage.setVisibility(view.INVISIBLE);
        signUpPage.startAnimation(animation1);
        signUpPage.setVisibility(view.VISIBLE);
    }

    public void signUp(View view){
        EditText userName = (EditText) findViewById(R.id.usernameSignUpEditText);
        EditText email = (EditText) findViewById(R.id.emailSignUpEditText);
        EditText firstName = (EditText) findViewById(R.id.firstNameSignUpEditText);
        EditText lastName = (EditText) findViewById(R.id.lastNameSignUpEditText);
        EditText password = (EditText) findViewById(R.id.passwordSignUpEditText);

        if(usersDAO.getUsersByEmail(email.getText().toString()).size() > 0 ){
            signUpForm(view); //temporarily added
            Toast.makeText(MainActivity.this,
                    "Email address already taken", Toast.LENGTH_SHORT).show();
        }
        else{
            if(usersDAO.getUsersByEmail(userName.getText().toString()).size() > 0){
                signUpForm(view);//temporarily added
                Toast.makeText(MainActivity.this,
                        "Username already taken", Toast.LENGTH_SHORT).show();
            }
            else{
                users = new Users(userName.getText().toString(),
                        email.getText().toString(),
                        firstName.getText().toString(),
                        lastName.getText().toString(),
                        password.getText().toString());

                usersDAO.insertUser(users);
                Log.i("user",userName.getText().toString()+" "+email.getText().toString());
                Toast.makeText(MainActivity.this,
                        "New User Created", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ConsumerWindow.class);
                intent.putExtra("firstname",firstName.getText().toString());
                startActivity(intent);
            }
        }


    }
}
