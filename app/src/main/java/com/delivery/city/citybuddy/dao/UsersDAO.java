package com.delivery.city.citybuddy.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.delivery.city.citybuddy.models.Users;

import java.util.List;

@Dao
public interface UsersDAO {

        @Insert
        public void insertUser(Users user);

        @Update
        public void updateUser(Users user);

        @Delete
        public void deleteUser(Users user);

        @Query("SELECT * FROM Users")
        public List<Users> getAllUsers();

        /*@Query("SELECT EXISTS (SELECT * FROM Users WHERE UserName=:username LIMIT 1)")
        public boolean checkUserName(String username);

        @Query("SELECT EXISTS (SELECT * FROM Users WHERE Email=:email LIMIT 1)")
        public boolean checkEmail(String email);*/

        @Query("SELECT * FROM Users WHERE UserName=:username")
        public List<Users> getUsersByUserName(String username);

        @Query("SELECT * FROM Users WHERE Email=:email")
        public List<Users> getUsersByEmail(String email);

        @Query("SELECT * FROM Users WHERE FirstName=:firstname")
        public List<Users> getUsersByFirstName(String firstname);

        @Query("SELECT * FROM Users WHERE LastName=:lastname")
        public List<Users> getUsersByLastName(String lastname);

}
