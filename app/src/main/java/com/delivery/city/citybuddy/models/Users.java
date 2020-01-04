package com.delivery.city.citybuddy.models;

import android.app.LauncherActivity;
import android.hardware.usb.UsbRequest;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys = {"UserName","Email"})
public class Users {
    @NonNull
    public String UserName;
    @NonNull
    public String FirstName;
    public String LastName;
    @NonNull
    public String Email;
    @NonNull
    public String Password;

    public Users(@NonNull String UserName,@NonNull String Email, @NonNull String FirstName, String LastName,@NonNull String Password){
        this.UserName = UserName;
        this.Email = Email;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Password = Password;
    }
}
