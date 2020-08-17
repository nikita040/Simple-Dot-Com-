package com.company;

import java.util.ArrayList;

public class SimpleDotComGame {

    ArrayList<String> locationCells = new ArrayList<String>();


    String checkYourself(String userGuess){

        boolean value = locationCells.contains(userGuess);
        if (value == true){
            locationCells.remove(userGuess);
            if(locationCells.isEmpty()){
                return("Empty");
            }
            return ("Hit");

        }
        else{

            return("Miss");
        }

    }


    void setLocationCells(ArrayList<String> cellLocation){
        locationCells = cellLocation;
    }



}
