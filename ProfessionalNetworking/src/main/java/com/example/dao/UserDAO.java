package com.example.dao;

import com.example.exception.AuthenticationException;
import com.example.model.User;
import com.example.util.DBConnection;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Avenash_2 on 5/18/2018.
 */
public class UserDAO
{
    static Map<String, User> usersDb;
    static DBConnection dbConnection=DBConnection.getInstance();
    private static final String TABLE_NAME="User";

    static {
        getAllUsers();
    }
    public UserDAO(){

    }

    private static void getAllUsers(){
        usersDb=new HashMap<>();

        List<User> users=dbConnection.getAllData(TABLE_NAME, User.class);

        for(User u:users){
            usersDb.put(u.getEmail(), u);
        }
    }

    public void addUser(User user){
        dbConnection.addData(TABLE_NAME, user.getEmail(), user);
        usersDb.put(user.getEmail(), user);
    }

    public void updateUser(User user){
        addUser(user);
    }

    public User authenticateUser(User user) throws AuthenticationException{
        for(Map.Entry<String, User> entry : usersDb.entrySet()){
            if(entry.getValue().getEmail().equalsIgnoreCase(user.getEmail()) && entry.getValue().getPassword().equals(user.getPassword()))
                return entry.getValue();
        }

        throw new AuthenticationException("Invalid login credentials!");
    }

    public boolean isUserAlreadyExist(User user){
        try{
            authenticateUser(user);
            return true;
        }
        catch (AuthenticationException e){
            return false;
        }
    }


}
