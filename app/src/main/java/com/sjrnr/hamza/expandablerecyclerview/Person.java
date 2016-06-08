package com.sjrnr.hamza.expandablerecyclerview;

/**
 * Created by Hamza Fetuga on 5/31/2016.
 */
public class Person extends Entity
{
    @Override
    public boolean isParent() {
        return true;
    }

    private String id;

    private Friend[] friends;

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

    public Friend[] getFriends ()
    {
        return friends;
    }

    public void setFriends (Friend[] friends)
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