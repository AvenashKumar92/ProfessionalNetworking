package com.example.util;


import com.example.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avenash_2 on 5/18/2018.
 */
public class DBConnection
{
    private static DBConnection ourInstance = new DBConnection();
    private final String databaseDir=new File(new File("").getAbsolutePath()).getParent()+"\\database";

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    public static DBConnection getInstance()
    {
        return ourInstance;
    }

    private DBConnection()
    {
    }

    public <T>List<T> getAllData(String tableName, Class<T> type){
        List<T> lstData=new ArrayList<>();

        String location=databaseDir+"\\"+tableName;
        File allDataFiles[]=new File(location).listFiles();

        for(File currFile:allDataFiles){
            String filePath=currFile.getAbsolutePath();
            try
            {
                String json=new String(Files.readAllBytes(Paths.get(filePath)));
                lstData.add(gson.fromJson(json, type));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return lstData;
    }
    public void addData(String tableName, String id, Object inputData){
        String databaseName=databaseDir+"\\"+tableName;
        createDirectory(databaseName);
        String DbFilePath=databaseName+"\\"+id+".json";
        File jsonFile=new File(DbFilePath);

        try
        {
            String json = gson.toJson(inputData);
            Files.write(Paths.get(jsonFile.getAbsolutePath()), json.getBytes());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void createDirectory(String dirName){
        File file = new File(dirName);
        if(!file.exists()){
            file.mkdir();
        }
    }
}
