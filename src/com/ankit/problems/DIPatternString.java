package com.ankit.problems;
//TODO not working
public class DIPatternString {

	private void process(char []pattern) {
		String number="";
		int initial = 1;
		for(char c : pattern) {
			if(c=='d') {
				initial-=1;
			}
			if(c=='i') {
				initial+=1;
			}
		}
		if(initial < 0) {
			initial = 1 - (initial)+1;
		}else
			initial = (initial+1);
		int start = initial;
		number = number+initial;
		for(char c : pattern) {
			if(c=='d') {
				initial-=1;
				number = number+initial;
			}
			if(c=='i') {
				start+=1;
				number = number+start;
			}
			/*System.out.print(initial+" "+start);
			System.out.println();*/
		}
		//System.out.println();
		System.out.println(number);
	}
	public static void main(String[] args) {
		DIPatternString di = new DIPatternString();
		//di.process(new char[]{'d','i','i','i','d','d','i','i'});//435672189
		//di.process(new char[]{'d','i'});//213
		di.process(new char[]{'i','d','i','d'});//23140 else 13254
		di.process(new char[]{'d','d'});//23140 else 321
		di.process("DDIDDIID".toLowerCase().toCharArray());
	}
}
