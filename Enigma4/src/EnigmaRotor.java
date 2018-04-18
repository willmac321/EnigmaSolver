
public class EnigmaRotor {

	private int name;
	private char[] rotor;
	private int count;
	
	public EnigmaRotor(int j){
		count=0;
		this.name=j;
	}
	public EnigmaRotor(int j, String strRotor){
		this(j);
		    rotor= strRotor.toCharArray();   
	}
	
	public void setCipher(char str) {
		setRotorCount(Character.getNumericValue(str)-10);
	}
	
	public int getName() {
		return name;
	}
	
	public int getRotorCount() {
		return count;
	}
	
	public void setRotorCount(int n) {
		count=n;
	}
	
	public int getCount() {
		return count;
	}
	public void incRotorCount() {
		count++;
		count=count % 26;
	}
	private int isOkNum(int n) {
		
		if (n<0) {
			n=26+n;
		}
		else if (n>=26) {
			n=n-26;
		}
		return n;
	}
	private int incByCount(int n, boolean inOrOut) {
		if (inOrOut){
			n=n+count;	
		}
		else {
			n=n-count;
		}
		
		n=isOkNum(n);
		
		return n;
	}
	
	/*private char findReverse(char in) {
		char out=0;
		in=(char)((25+Character.getNumericValue(in)-10+count-1)%25+1+65);
		for (int i =0;i<rotor.length;i++) {
			if(in==rotor[i]) {
				out=(char) ((25+i-count-1)%25+1+65);
				i=27;
			}
		}
		return out;
	}
	*/
	public char findReturnChar(char in, boolean inOrOut) {
		char out=0;
		//int test =((Character.getNumericValue(in)-10)+count-1)%25+1;
		int num;
		if(inOrOut) {
			num=(Character.getNumericValue(in)-10);
			num=incByCount(num,true);
			num=Character.getNumericValue(rotor[num])-10;
			num=incByCount(num,false);
			
			out=(char)(num+65);
			//System.out.println("Count: "+count+ " Num: "+ num);
		}
		else {
			num=0;
			out=(char)(incByCount(Character.getNumericValue(in)-10,true)+65);
			for (int i =0;i<rotor.length;i++) {
				if(out==rotor[i]) {
					num=i;
					i=27;
				}
			}
			num=incByCount(num,false);
			//System.out.println("Count: "+count+ " Num: "+ num);
			out=(char)(num+65);
		}
		return (out);
	}
		/*
		
		if (inOrOut){

			num = (25+(Character.getNumericValue(in)-10)+count-1)%25+1;

			temp=(25+Character.getNumericValue(rotor[num])-10-count-1)%25+1;
				
			return  (char)(temp+65);
		}
		else
		{
			
			return findReverse(in);
		}
		*/

}
