package se.omegapoint.validitychecker;

import java.util.ArrayList;
import java.util.List;


public class ValidityChecker {

    public boolean validityCheck(String input){
        FormatPersonalNumber format = new FormatPersonalNumber();
        input = format.formatPersonalNumber(input); // format input
        format.isNullOrEmpty(input); //check so input is not null after format
        return compareLastNumWithAlgorithm(input);  // format and validates input, calculate algorithm, compare result, return true if a valid number sequence.
    }

    protected static List<Integer> addStringToIntList(String input) {
        List<Integer> arrayList = new ArrayList<Integer>();
        try{
            for (int i = 0; i < input.length(); i++) {
                arrayList.add(Character.digit(input.charAt(i), 10)); // adding input as Integers in List
                if (arrayList.contains(-1)){ // if not a valid number between [0-10], return null.
                    return null;
                }
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return arrayList; // return complete Integer array list.
    }



    protected static int calcAlgorithmPart1(int input){
        input *= 2; // multiply input by 2
        int input1 = input%10; // mod input by 10
        int input2 = input/10; // divide input by 10
        input = input1 + input2; // sum the two int variables
        return input; // return int variable
    }

    protected static int calcAlgorithmPart2(int input){
        input %= 10; // mod input by 10
        int input1 = 10 - input; // 10 - calc of input
        input1 %=10; // 10 mod input1
        return input1;
    }

    private static int calcElementInIntList(List<Integer> input) {
        for (int i = 0; i < input.size() - 1; i += 2) {
            input.set(i, calcAlgorithmPart1(input.get(i))); //perform algorithm1 on every second element
        }
        int sum = 0;
        for (int i = 0; i < input.size() -1; i++) {
            sum += input.get(i); //increments sum with the results from algorithm1 by every element.
        }
        return calcAlgorithmPart2(sum); // returns value after performing algorithm2 method
    }

    private static boolean compareLastNumWithAlgorithm(String input){
        List<Integer> arrayList = addStringToIntList(input); //  String into Int List
        int sum = calcElementInIntList(arrayList); //calculate algorithm sum
        int lastNum = arrayList.get(arrayList.size() - 1); //check last element in List
        return lastNum == sum; // compare and return true or false
    }
}
