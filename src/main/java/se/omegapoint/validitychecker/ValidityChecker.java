package se.omegapoint.validitychecker;

import java.util.*;

public class ValidityChecker {

    public boolean validityCheck(String input){
        isNullOrEmpty(input);
        return compareLastNumWithAlgorithm(formatPersonalNumber(input));
    }


    public String removeDashFromString(String input){
        while(input.contains("-")){
            input = input.replace("-","");
        }
        return input;
    }

    public static String trimPersonalNumber(String input){
            StringBuilder trimmedInput = new StringBuilder(input); // creating StringBuilder variable so .replace function will work.
            trimmedInput.replace(0,2,""); // removing First 2 char in String
            return trimmedInput.toString();
         }

    public String formatPersonalNumber(String input){
        if (input.contains("-")){
            input = removeDashFromString(input);
        }
        if (input.length() == 12){
            input = trimPersonalNumber(input);
        }
        if (input.length() == 10) {
            return input;
        } else {
            return null;
        }

    }
    
    public static List<Integer> addStringToIntList(String input) {
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            arrayList.add(Character.digit(input.charAt(i), 10));
         }
            return arrayList;
        }


    public static boolean isNullOrEmpty(String input) {
        try{
            return input == null || input.trim().isEmpty();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int calcAlgorithmPart1(int input){
        input *= 2; // multiply input by 2
        int input1 = input%10; // mod input by 10
        int input2 = input/10; // divide input by 10
        input = input1 + input2; // sum the two int variables
        return input; // return int variable
    }

    public static int calcAlgorithmPart2(int input){
        input %= 10; // mod input by 10
        int input1 = 10 - input; // 10 - calc of input
        input1 %=10; // 10 mod input1
        return input1;
    }

    public static int calcElementInIntList(List<Integer> input) {
        for (int i = 0; i < input.size() - 1; i += 2) {
            input.set(i, calcAlgorithmPart1(input.get(i))); //perform algorithm1 on every second element
        }
        int sum = 0;
        for (int i = 0; i < input.size() -1; i++) {
            sum += input.get(i);
        }
        return calcAlgorithmPart2(sum);
    }

    public static boolean compareLastNumWithAlgorithm(String input){
        List<Integer> arrayList = addStringToIntList(input); //  String into Int List
        int sum = calcElementInIntList(arrayList); //calculate algorithm sum
        int lastNum = arrayList.get(arrayList.size() - 1); //check last element in List

        return lastNum == sum; // compare and return true or false
    }
}
