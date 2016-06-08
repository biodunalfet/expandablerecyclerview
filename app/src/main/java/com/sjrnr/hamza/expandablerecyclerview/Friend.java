package com.sjrnr.hamza.expandablerecyclerview;

/**
 * Created by Hamza Fetuga on 5/31/2016.
 */
public class Friend extends Entity
{

    @Override
    public boolean isParent() {
        return false;
    }

    private String id;

    private String name;

    private String parentID;

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", name = "+name+"]";
    }
}
