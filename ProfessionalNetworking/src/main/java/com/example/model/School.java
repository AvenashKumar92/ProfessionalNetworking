package com.example.model;

import java.util.Date;

/**
 * Created by Avenash_2 on 5/18/2018.
 */
public class School
{
    String name;

    Contact contact;


    public Contact getContact()
    {
        return contact;
    }

    public void setContact(Contact contact)
    {
        this.contact = contact;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
