package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UserInput {
    private int comCount;
    private int gridlength =7;
    private int gridSize =49;
    private int[]grid = new int[gridSize];
    private static final String alphabet= "abcdefg";


    String getUserInput(){
        String inputline = null;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your guess");
            inputline = br.readLine();
            if(inputline.length() == 0) return null;


        }
        catch(IOException io)
        {
            System.out.println("Exception" + io);
        }
        return inputline;
    }

    ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] aphacords= new String[comSize];
        String temp= null;
        int [] coords = new int[comSize];
        int attempts =0;
        boolean sucess= false;
        int location = 0;

        comCount++;
        int incr =1;
        if((comCount) % 2 ==1 ){
            incr = gridlength;

        }
        while(!sucess & attempts++<200){
            location =(int)(Math.random()* gridSize);
            int x=0;
            sucess = true;
            while (sucess&&x<comSize){
                if(grid[location]==0){
                    coords[x++] = location;
                    location+=incr;
                    if(location>=gridSize){
                        sucess =false;

                    }
                    if(x>0 && (location%gridlength == 0)){
                        sucess =false;

                    }

                }
                else{
                    sucess =false;
                }
            }
        }
        int x =0;
        int row=0;
        int column=0;

        while(x<comSize){
            grid[coords[x]]=1;
            row= (int)(coords[x]/gridlength);
            column = coords[x]%gridlength;
            temp= String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }
        return alphaCells;
    }
}
