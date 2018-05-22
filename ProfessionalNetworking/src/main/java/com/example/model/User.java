package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avenash_2 on 5/18/2018.
 */
public class User
{
    private String email;               //Req
    private String firstName;           //Req
    private String lastName;            //Req
    private String password;            //Req
    private String profileImgName;
    private String profession;
    private Contact contact;
    private List<JobExperience> jobExperiences;
    private List<Education> educations;
    private List<Skills> skills;
    private String linkInUrl;
    private String gitHubUrl;


    public User()
    {
        profileImgName = "DefaultImg.png";
    }

    public User(String email, String password)
    {
        this();
        this.email = email; this.password = password;
    }

    public void addJobExperience(JobExperience jobExperience){
        if(this.jobExperiences==null)
            jobExperiences=new ArrayList<>();

        jobExperiences.add(jobExperience);
    }

    public void addEducation(Education education){
        if(this.educations==null)
            educations=new ArrayList<>();

        educations.add(education);
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

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getProfileImgName()
    {
        return profileImgName;
    }

    public void setProfileImgName(String profileImgName)
    {
        this.profileImgName = profileImgName;
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

    public JobExperience[] getJobExperienceArray()
    {
        JobExperience experienceArray[]=new JobExperience[jobExperiences.size()];
        return jobExperiences.toArray(experienceArray);
    }

    public Education[] getEducationArray()
    {
        Education educationArray[]=new Education[educations.size()];
        return educations.toArray(educationArray);
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
