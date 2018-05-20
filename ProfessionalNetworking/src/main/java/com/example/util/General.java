package com.example.util;

/**
 * Created by Avenash_2 on 5/20/2018.
 */
public class General
{
    public static boolean str2Bool(String str){

        if(str!=null && str.equalsIgnoreCase("on"))
            return true;
        return false;
    }
}
