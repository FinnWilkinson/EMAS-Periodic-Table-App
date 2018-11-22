package com.example.joshhamwee.periodictablemain;

import android.content.Context;

public class CurrentElement {
    String atomicNumber, name, atomicSymbol, atomicMass, crystalStructure;
    String shellOccK, shellOccL, shellOccM, shellOccN, shellOccO, shellOccP, shellOccQ;
    String valencyCommon, valencies, meltingPoint, boilingPoint, density, ionicRadius;
    String kBeta, kAlpha, lGamma23, lGamma1, lBeta4, lBeta3, lBeta2, lBeta1, lAlpha;
    String mGamma, mBeta, mAlpha;
    Integer id;


    public CurrentElement(Integer id, DatabaseAccess db) {
        if (id == R.id.H) this.name = "Hydrogen";
        else if (id == R.id.He) this.name = "Helium";
        else if (id == R.id.Li) this.name = "Lithium";
        else this.name = "Other";
        dataSetting(db);
        //Plan to expand this, is to fetch all fields from db and store in a list.
        //Then each list entry will be a specific element variable.
        //We will then have to manually set the variables in this class with the elements
        //from the list.
        //Each variable is a string so that displaying the data is simplified.
    }

    private void dataSetting(DatabaseAccess db){
        if(this.name == "Other") this.name = "Carbon";
        db.open();
        this.atomicSymbol = db.getAtomicSymbol(this.name);
        db.close();
    }
}
