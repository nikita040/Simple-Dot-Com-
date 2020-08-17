package com.company;

import java.util.ArrayList;

public class DotComBust {

    ArrayList<SimpleDotComGame> dotComList = new ArrayList<SimpleDotComGame>();
    UserInput ui = new UserInput();
    int numOfGuesses =0;

    void setUpGame(){
        SimpleDotComGame S1 = new SimpleDotComGame();

        dotComList.add(S1);
        SimpleDotComGame S2 = new SimpleDotComGame();
        dotComList.add(S2);
        SimpleDotComGame S3 = new SimpleDotComGame();
        dotComList.add(S3);

        for(SimpleDotComGame sdcg: dotComList){
            ArrayList<String> arr = ui.placeDotCom(3);
            for(String str: arr){
                System.out.println(str);
            }
            sdcg.setLocationCells(arr);

        }

    }
    String checkUserGuess(String userGuess){
        for(SimpleDotComGame s: dotComList){
            String res = s.checkYourself(userGuess);

            if(res == "Hit"){
                return ("Hit");
            }
            if(res=="Empty"){
                dotComList.remove(s);
                return ("Destroyed.");
            }

        }
        return("Fail");
    }

    void startPlaying(){
        while(!dotComList.isEmpty()){
            String str = ui.getUserInput();
            String str1= checkUserGuess(str);
            System.out.println((str1));
            numOfGuesses++;
        }
        System.out.println(numOfGuesses);
        finishPlaying();
    }

    void finishPlaying(){
        System.out.println("Thanks");
    }






}
