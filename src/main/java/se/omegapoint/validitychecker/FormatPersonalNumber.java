package se.omegapoint.validitychecker;


public class FormatPersonalNumber {

    public String formatPersonalNumber(String input){
        try {
            if (isNullOrEmpty(input)) return null; // check if input is null or empty
            if (input.contains("-")) input = removeDashFromString(input); // removes dash if dash exists in string
            if (input.length() == 12) input = trimPersonalNumber(input); // remove first two digits if length == 12
            if (input.length() == 10) return input;
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return null; // if input is not valid return null
    }

    protected String removeDashFromString(String input){
        while(input.contains("-")){
            input = input.replace("-",""); // removes all dashes in String
        }
        return input; // returns string without dash
    }

    protected String trimPersonalNumber(String input){
        StringBuilder trimmedInput = new StringBuilder(input); // creating StringBuilder variable so .replace function will work properly.
        trimmedInput.replace(0,2,""); // removing first 2 char in String
        return trimmedInput.toString(); // returning input as String
    }

    public boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty(); // returns true if null or empty

    }


}
