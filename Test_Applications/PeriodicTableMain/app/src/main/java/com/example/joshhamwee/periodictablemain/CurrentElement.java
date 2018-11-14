package com.example.joshhamwee.periodictablemain;

public class CurrentElement {
    String name;
    Integer id;

    public CurrentElement(Integer id){
        if (id == R.id.H) this.name = "Hydrogen";
        else if (id == R.id.He) this.name = "Helium";
        else if (id == R.id.Li) this.name = "Lithium";
        else this.name = "Other";
    }

}
