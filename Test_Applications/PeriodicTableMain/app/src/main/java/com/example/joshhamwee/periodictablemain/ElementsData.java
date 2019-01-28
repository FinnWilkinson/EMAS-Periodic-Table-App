package com.example.joshhamwee.periodictablemain;
import java.util.ArrayList;
import java.util.List;

public class ElementsData {
    private static List<String> elements ;
    static {
        elements =  new ArrayList<String>();
        elements.add("Hydrogen - H - 1");
        elements.add("Helium - He - 2");
        elements.add("Lithium - Li - 3");
        elements.add("Beryllium - Be - 4");
        elements.add("Boron - B - 5");
        elements.add("Carbon - C - 6");
        elements.add("Nitrogen - N -7");
        elements.add("Oxygen - O - 8");
        elements.add("Fluorine - F - 9");
        elements.add("Neon - Ne - 10");
        elements.add("Sodium - Na - 11");
        elements.add("Magnesium - Mg - 12");
        elements.add("Aluminium - Al - 13");
        elements.add("Silicon - Si - 14");
        elements.add("Phosphorus - P - 15");
        elements.add("Sulphur - S - 16");
        elements.add("Chlorine - Cl - 17");
        elements.add("Argon - Ar - 18");
        elements.add("Potassium - K - 19");
        elements.add("Calcium - Ca - 20");
        elements.add("Scandium - Sc - 21");
        elements.add("Titanium - Ti - 22");
        elements.add("Vanadium - V - 23");
        elements.add("Chromium - Cr - 24");
        elements.add("Manganese - Mn - 25");
        elements.add("Iron - Fe - 26");
        elements.add("Cobalt - Co - 27");
        elements.add("Nickel - Ni - 28");
        elements.add("Copper - Cu - 29");
        elements.add("Zinc - Zn - 30");
        elements.add("Gallium - Ga - 31");
        elements.add("Germanium - Ge - 32");
        elements.add("Arsenic - As - 33");
        elements.add("Selenium - Se - 34");
        elements.add("Bromine - Br - 35");
        elements.add("Krypton - Kr - 36");

    }

    public static List<String> getElements(){
        return elements;
    }

    public static List<String> filterData(String searchString){
        List<String> searchResults =  new ArrayList<String>();
        if(searchString != null){
            searchString = searchString.toLowerCase();

            for(String rec :  elements){
                if(rec.toLowerCase().contains(searchString)){
                    searchResults.add(rec);
                }
            }
        }
        return searchResults;
    }
}
