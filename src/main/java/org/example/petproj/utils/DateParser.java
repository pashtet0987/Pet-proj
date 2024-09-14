package org.example.petproj.utils;

import java.time.LocalDate;

public class DateParser {

    private static LocalDate date;

    //getting data for pasting into url
    public static String getLocalDate(){
        date = LocalDate.now();
        StringBuilder builder = new StringBuilder();
        String[] s = String.valueOf(date).split("-");
        for(int i = 0; i < s.length; i++){
            if(i < s.length-1){
                builder.append(s[s.length - 1 - i]).append(".");
            }else{
                builder.append(s[s.length - 1 - i]);
            }
        }
        return builder.toString();
    }
}
