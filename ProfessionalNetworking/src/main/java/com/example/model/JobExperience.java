package com.example.model;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Avenash_2 on 5/18/2018.
 */
public class JobExperience
{
    String designation;
    Company company;
    Date from;
    Date to;

    public String getDesignation()
    {
        return designation;
    }

    public void setDesignation(String designation)
    {
        this.designation = designation;
    }

    public Company getCompany()
    {
        return company;
    }

    public void setCompany(Company company)
    {
        this.company = company;
    }

    public Date getFrom()
    {
        return from;
    }

    public void setFrom(Date from)
    {
        this.from = from;
    }

    public Date getTo()
    {
        return to;
    }

    public void setTo(Date to)
    {
        this.to = to;
    }
}
