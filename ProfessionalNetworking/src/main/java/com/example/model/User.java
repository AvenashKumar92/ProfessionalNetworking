package com.example.model;

import java.util.List;

/**
 * Created by Avenash_2 on 5/18/2018.
 */
public class User
{
    private String email;           //Req
    private String fName;           //Req
    private String lName;           //Req
    private String password;        //Req
    private String imgURL;
    private String profession;
    private Contact contact;
    private List<JobExperience> jobExperiences;
    private List<Education> educations;
    private List<Skills> skills;
    private String linkInUrl;
    private String gitHubUrl;


    public User(){

    }
    public User(String email, String password){
        this.email=email;
        this.password=password;
    }

    public String getGitHubUrl()
    {
        return gitHubUrl;
    }

    public void setGitHubUrl(String gitHubUrl)
    {
        this.gitHubUrl = gitHubUrl;
    }

    public String getLinkInUrl()
    {
        return linkInUrl;
    }

    public void setLinkInUrl(String linkInUrl)
    {
        this.linkInUrl = linkInUrl;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getfName()
    {
        return fName;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
    }

    public String getlName()
    {
        return lName;
    }

    public void setlName(String lName)
    {
        this.lName = lName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getImgURL()
    {
        return imgURL;
    }

    public void setImgURL(String imgURL)
    {
        this.imgURL = imgURL;
    }

    public String getProfession()
    {
        return profession;
    }

    public void setProfession(String profession)
    {
        this.profession = profession;
    }

    public Contact getContact()
    {
        return contact;
    }

    public void setContact(Contact contact)
    {
        this.contact = contact;
    }

    public List<JobExperience> getJobExperiences()
    {
        return jobExperiences;
    }

    public void setJobExperiences(List<JobExperience> jobExperiences)
    {
        this.jobExperiences = jobExperiences;
    }

    public List<Education> getEducations()
    {
        return educations;
    }

    public void setEducations(List<Education> educations)
    {
        this.educations = educations;
    }

    public List<Skills> getSkills()
    {
        return skills;
    }

    public void setSkills(List<Skills> skills)
    {
        this.skills = skills;
    }
}
