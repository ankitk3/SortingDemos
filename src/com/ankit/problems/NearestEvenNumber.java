package com.ankit.problems;

public class NearestEvenNumber {

    private static void findNumber(String number){
        char arr[] = number.toCharArray();
        for(int index = arr.length-1;index >= 0;index--){
            int value = arr[index];
            System.out.println(value);
            if(value %2 == 0 ){
                continue;
            } else{
                //System.out.println(Character.forDigit((arr[index]++)%10,10));
                value = value++;
                value = value % 10;
                arr[index] = (char)value;
            }
            System.out.println(value);
        }
        System.out.println(new String(arr));
    }
    public static void main(String[] args) {
        findNumber("157");
    }
}
