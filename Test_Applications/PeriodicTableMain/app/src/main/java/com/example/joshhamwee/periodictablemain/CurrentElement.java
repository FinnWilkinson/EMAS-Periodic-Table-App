package com.example.joshhamwee.periodictablemain;

import android.content.Context;

public class CurrentElement {
    String name, atomicSymbol;
    Integer id;


    public CurrentElement(Integer id) {
        if (id == R.id.H) this.name = "Hydrogen";
        else if (id == R.id.He) this.name = "Helium";
        else if (id == R.id.Li) this.name = "Lithium";
        else this.name = "Other";
    }

    public String databaseAcc(DatabaseAccess db){
        if(this.name == "Other") this.name = "Carbon";
        db.open();
        this.atomicSymbol = db.getAtomicSymbol(this.name);
        db.close();


        return this.atomicSymbol;
    }
}
