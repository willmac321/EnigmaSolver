import java.io.File;
import java.io.FileNotFoundException;

public class EnigmaMain {

	
	
	public static void main(String[] args) {
		
		
		File fIn = new File("input.txt");
		
		
		BasicDecrypt theOne=new BasicDecrypt(fIn);
		//DecryptWithCrib theSecond = new DecryptWithCrib(10,"IPUXZGICZWASMJFGLFVIHCAYEGT");
		

	/*	
		Arrays.sort(arr);
		long[] count= new long[26];
		for(char t :arr)
		{
			
			count[Character.getNumericValue(t)-10]++;
			
		}
		
		for(char i=0;i<26;i++) {
			System.out.println("Letter is: " + (char)(i+65)+ " " +count[i] );
		}
		*/
	}

}
