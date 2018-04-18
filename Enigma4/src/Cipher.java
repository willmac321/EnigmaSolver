import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cipher {

	
	public Cipher(File fIn) {
		 String[] common = {"the","of","and","a","to","in","is","you","that","it","he","was","for","on","are","as","with","his","they","I","at","be","this","have","from","or","one","had","by","word","but","not","what","all","were","we","when","your","can","said","there","use","an","each","which","she","do","how","their","if","will","up","other","about","out","many","then","them","these","so","some","her","would","make","like","him","into","time","has","look","two","more","write","go","see","number","no","way","could","people","my","than","first","water","been","call","who","oil","its","now","find","long","down","day","did","get","come","made","may","part"};

	
			Scanner scn;
			try {
				scn = new Scanner(fIn);
				String in=scn.nextLine();
				scn.close();
				
				
						
						
				File file = new File("output2.txt");
				file.delete();
				FileWriter fw = new FileWriter("output2.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw);
				char[] arr = in.replaceAll(" ","").toCharArray();
				//The rotors read backwards, input is on right....
				debug( arr);
				String test = "THISSENTENCEWASENCRYPTEDONANMTHREEENIGMAWITHREFLECTORBANDALLTENPLUGSUSED";
				String cipher="";
				
				EnigmaCrib crib= new EnigmaCrib(10, in);
				
				for (int i=65;i<91;i++) {
					for(int r=65;r<91;r++) {
						for(int t=65;t<91;t++) {
							for(int q=1;q<9;q++) {
								for(int w=1;w<9;w++) {
									for(int y=1;y<9;y++) {
										if(q!=w && q!=y && w!=y) {
											EnigmaAssembly assem = new EnigmaAssembly(String.valueOf((char)i)+String.valueOf((char)r)+String.valueOf((char)t),q,w,y,1);
												cipher="";
													for( char f :arr) {
												
														cipher+=assem.inputLetter(f);
														
													}
													
													int count=0;
													for (int b=0; b<100;b++) {
															//if (cipher.indexOf(common[b])>-1) {
															if (cipher.indexOf(test)>-1) {		
														
																count++;
															}
													}	
													if(count>=1) {
														out.print(cipher + " Codex: "+String.valueOf((char)i)+String.valueOf((char)r)+String.valueOf((char)t)+" Rotors: " + y+"," +w+","+q+"\r\n");
														out.flush();
													}
													
												}
											}
										}
									}
								}
							}
						}
					
			
				EnigmaAssembly assem = new EnigmaAssembly(String.valueOf((char)'U')+String.valueOf((char)'M')+String.valueOf((char)'H'),2,3,5,1);

				System.out.print(in+"\n");
				for( char t :arr) {
			
					
					System.out.print(assem.inputLetter(t));
				}
				System.out.println(cipher );
				
				out.flush();
			
	
				fw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}




		}
	
	public void debug(char[] arr) {
		//EnigmaAssembly assem = new EnigmaAssembly("TDB",1,5,3,1);
		//System.out.print(in+"\n");
		//for( char t :arr) {
	
			
		//	System.out.print(assem.inputLetter(t));
		//}
	}
	}