package org.example.utils;

public class ValidationUtils {

    public static boolean isNumber(String option){
        try{
            int num = Integer.parseInt(option);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkValidOption(String option, int min, int max){
            if(!isNumber(option)){
                return false;
            }
            int numOption = Integer.parseInt(option);
            return numOption >= min && numOption <= max;
    }








}
