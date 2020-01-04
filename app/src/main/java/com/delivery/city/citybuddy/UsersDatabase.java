package com.delivery.city.citybuddy;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.delivery.city.citybuddy.models.Users;
import com.delivery.city.citybuddy.dao.UsersDAO;

@Database(entities = {Users.class}, version = 1, exportSchema = false)
public abstract class UsersDatabase extends RoomDatabase {

    public abstract UsersDAO getUsersDAO();
}
