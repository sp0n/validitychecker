package se.omegapoint.validitychecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ValidityChecker {


    public boolean validityCheck(String input){
        String rawInput = input;
        FormatPersonalNumber format = new FormatPersonalNumber();
        try{
            input = format.formatPersonalNumber(input); // format input
            return compareLastNumWithAlgorithm(input); // format and validates input, calculate algorithm, compare result, return true if a valid number sequence.
        } catch (Exception e){
            Map<String, StackTraceElement[]> mapEx = new HashMap<>();
            mapEx.put(rawInput, e.getStackTrace()); // saves invalid input linked together with exception in Map Collection.
            return false; // return false after Exception catches.
        }
    }

    protected static List<Integer> addStringToIntList(String input) throws NullPointerException {
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            arrayList.add(Character.digit(input.charAt(i), 10)); // adding input as Integers in List
        }
        return arrayList; // return complete Integer array list.
    }

    protected static int calcAlgorithmPart1(int input) throws ArithmeticException{
        input *= 2; // multiply input by 2
        int input1 = input%10; // mod input by 10
        int input2 = input/10; // divide input by 10
        input = input1 + input2; // sum the two int variables
        return input; // return int variable
    }

    protected static int calcAlgorithmPart2(int input) throws ArithmeticException{
        int input1;
        input %= 10; // mod input by 10
        input1 = 10 - input;
        input1 %= 10; // 10 mod input1
        return input1;
    }

    protected static int calcElementInIntList(List<Integer> input) throws IndexOutOfBoundsException{
        for (int i = 0; i < input.size() - 1; i += 2) {
            input.set(i, calcAlgorithmPart1(input.get(i))); //perform algorithm1 on every second element
        }
        int sum = 0;
        for (int i = 0; i < input.size() -1; i++) {
            sum += input.get(i); //increments sum with the results from algorithm1 by every element.
        }
        return calcAlgorithmPart2(sum); // returns value after performing algorithm2 method
    }

    protected static boolean compareLastNumWithAlgorithm(String input) throws IndexOutOfBoundsException {
        List<Integer> arrayList = addStringToIntList(input); //  String into Int List
        int sum = calcElementInIntList(arrayList); //calculate algorithm sum
        int lastNum = arrayList.get(arrayList.size() - 1); //check last element in List
        if (lastNum == sum) {
            return true;
        } else throw new IllegalArgumentException();// compare and return true or false
    }
}
