package com.sjrnr.hamza.expandablerecyclerview;

/**
 * Created by Hamza Fetuga on 5/31/2016.
 */
public class Person extends Entities
{
    @Override
    public boolean isParent() {
        return true;
    }

    private String id;

    private Friends[] friends;

    private boolean childrenVisible;

    public boolean isChildrenVisible() {
        return childrenVisible;
    }

    public void setChildrenVisible(boolean childrenVisible) {
        this.childrenVisible = childrenVisible;
    }

    private String name;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Friends[] getFriends ()
    {
        return friends;
    }

    public void setFriends (Friends[] friends)
    {
        this.friends = friends;
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
        return "ClassPojo [id = "+id+", friends = "+friends+", name = "+name+"]";
    }
}