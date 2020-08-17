package com.ankit.problems;

public class RomanNumber {

    int states[] = {1000,500,100,50,10,5,1};
    String figure[] = {"M","D","C","L","X","V","I"}; //{"I","V","X","L","C","D","M"};

    private String changeToRoman(int number){
        String roman="";
        for(int index = 0;index < states.length;index++){
            int i = states[index];
            if(number == i){
                roman = roman + figure[index];
                return roman;
            }
            else if(number >= i){
                int count = number/i;
                while(count > 0){
                    roman = roman + figure[index];
                    count --;
                }
                number = number % i;
                //System.out.println(number);
            } else if(index < states.length-1 && (states[index] - states[index+1]) == number){
                //int tempNum = number + states[index+1];
                roman = roman + figure[index+1] + figure[index];
                return roman;
            }
//            if( index > 0 && number > i && (states[index-1] - states[index])==number) {
//                int tempNum = number + states[index];
//                roman = roman + figure[index] + figure[index - 1];
//                return roman;
//            } else if( index > 1 && number > i && (states[index-2] - states[index])==number) {
//                    int tempNum = number + states[index];
//                    roman = roman + figure[index] + figure[index-2];
//                    return roman;
//            }
        }
        return roman;
    }
    public static void main(String[] args) {
        RomanNumber rom = new RomanNumber();
        String output =rom.changeToRoman(500);
        System.out.println(output);
    }
}
