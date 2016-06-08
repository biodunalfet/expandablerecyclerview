package com.sjrnr.hamza.expandablerecyclerview;

/**
 * Created by Hamza Fetuga on 5/29/2016.
 */


public class Data extends Entity {
    private String id;

    private String skill;

    private String company_name;



    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getSkill ()
    {
        return skill;
    }

    public void setSkill (String skill)
    {
        this.skill = skill;
    }

    public String getCompany_name ()
    {
        return company_name;
    }

    public void setCompany_name (String company_name)
    {
        this.company_name = company_name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", skill = "+skill+", company_name = "+company_name+"]";
    }


}


