package com.pta.joshhamwee.onbuttonclickactivity;

public class currentElement{
    String name;
    Integer id;

    public currentElement(Integer id){
        if(id == R.id.b1) this.name = "Helium";
        if(id == R.id.b2) this.name = "Hydrogen";
        if(id == R.id.b3) this.name = "Lithium";
        if(id == R.id.b4) this.name = "Nitrogen";

    }

    public String getName(){
        return name;
    }
}
