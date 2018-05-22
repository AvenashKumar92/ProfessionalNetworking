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

    private static String getNumberInMonth(int month){
        switch (month){
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        return "";
    }

    public static String convertDateInSpecificFormat(String date){
        String[] arr=date.split("-");

        if(arr.length<2)
            return "";

        return getNumberInMonth(Integer.valueOf(arr[1]))+" "+arr[0];
    }
}
