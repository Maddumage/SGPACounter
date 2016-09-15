package com.roshan.sgpacounter;

/**
 * Created by Roshan on 8/14/2016.
 */
public class Student{

    // property help us to keep data
    public String student_ID;
    public String name;
    public String email;
    public String batch;
    public String username;
    public String password;

    public Student(String id, String name, String email, String batch)
    {
        this.student_ID = id;
        this.name = name;
        this.email = email;
        this.batch = batch;
    }
    public Student(){}

    public Student(String uname, String pword) {
        this.username = uname;
        this.password = pword;
    }

    public void setId(String id)
    {
        this.student_ID = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setBatch(String batch)
    {
        this.batch = batch;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getStudent_ID()
    {
        return student_ID;
    }
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    public String getBatch()
    {
        return batch;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
}
