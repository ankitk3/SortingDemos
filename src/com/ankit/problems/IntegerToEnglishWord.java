package com.ankit.problems;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWord {
    Map<String,String> words = new HashMap<>();
    Map<Integer, String> wordsAdd = new HashMap<>();
    private void fillMap(){
        words.put("1","One");
        words.put("2","Two");
        words.put("3","Three");
        words.put("4","Four");
        words.put("5","Five");
        words.put("6","Six");
        words.put("7","Seven");
        words.put("8","Eight");
        words.put("9","Nine");
        words.put("0","");
        words.put("11","One");
        words.put("12","Two");
        words.put("13","Three");
        words.put("14","Four");
        words.put("15","Five");
        words.put("16","Six");
        words.put("17","Seven");
        words.put("18","Eight");
        words.put("19","Nine");

        wordsAdd.put(3,"Hundred");
        wordsAdd.put(3,"Thousand");
        wordsAdd.put(4,"Thousand");
        wordsAdd.put(4,"Lakhs");
    }
    public String numberToWords(int num) {
        String output = "";
        String numStr = Integer.toString(num);
        for(int index=numStr.length()-1;index>=0;index--){
            int invertedIndex = numStr.length()-index;
            char charValue = numStr.charAt(index);
            output = words.get(charValue) + output;
        }
        System.out.println(output);
        return output;
    }

    public static void main(String[] args) {
        IntegerToEnglishWord obj = new IntegerToEnglishWord();
        obj.fillMap();
        obj.numberToWords(11);
    }
}
