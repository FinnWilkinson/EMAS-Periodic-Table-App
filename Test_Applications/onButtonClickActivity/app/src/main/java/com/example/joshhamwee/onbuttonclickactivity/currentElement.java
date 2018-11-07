package com.example.joshhamwee.onbuttonclickactivity;

public class currentElement{
    String name;
    Integer id;

    public currentElement(Integer id){
        if(id == 1) this.name = "Helium";
        if(id == 2) this.name = "Hydrogen";
    }

    public String getName(){
        return name;
    }
}
