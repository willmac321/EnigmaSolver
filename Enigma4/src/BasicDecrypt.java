import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BasicDecrypt {

	private int plugs=10;
	private String test="PASSWORD";
	
	public BasicDecrypt(File fIn) {
		 String[] common = {"the","of","and","to","in","is","you","that","it","HOWDY","was","for","on","are","as","with","his","they","at","be","this","have","from","or","one","had","by","word","but","not","what","all","were","we","when","your","can","said","there","use","an","each","which","she","do","how","their","if","will","up","other","about","out","many","then","them","these","so","some","her","would","make","like","him","into","time","has","look","two","more","write","go","see","number","no","way","could","people","my","than","first","water","been","call","who","oil","its","now","find","long","down","day","did","get","come","made","may","part"};
		 for(int i=0; i<common.length;i++) {
			 common[i]=common[i].toUpperCase();
		 }
	
			Scanner scn;
			try {
				scn = new Scanner(fIn);
				String in=scn.nextLine();
				scn.close();
				
				String cipher="";
						
						
				File file = new File("output4.txt");
				file.delete();
				FileWriter fw = new FileWriter("output4.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw);
				char[] arr = in.replaceAll(" ","").toCharArray();
				//The rotors read backwards, input is on right....
				debug( arr);
				
			int debug=0;
			for(int z =1;z<2;z++) {
				for (int i=65;i<91;i++) {
					for(int r=65;r<91;r++) {
						for(int t=65;t<91;t++) {
							for(int q=1;q<4;q++) {
								for(int w=1;w<4;w++) {
									for(int y=1;y<4;y++) {
										if(q!=w && q!=y && w!=y) {

											EnigmaAssembly assem = new EnigmaAssembly("MYH",3,2,1,1,10,"AV,BS,CG,DL,FU,HZ,IN,KM,OW,RX,"); //String.valueOf((char)i)+String.valueOf((char)r)+String.valueOf((char)t),q,w,y,z,10,"AV,BS,CG,DL,FU,HZ,IN,KM,OW,RX,");//
												cipher="";
													for( char f :arr) {
														if(debug==17) {
															debug=22;
														}
														cipher+=assem.inputLetter(f);
														debug++;
													}
													int g=0;
													int count=0;
/*
													for (int b=0; b<98;b++) {
															if (cipher.indexOf(common[b])>-1) {
															//if (cipher.indexOf(test)>-1) {		
																g=cipher.indexOf(common[b]);
																count++;
															}
															if (cipher.substring(g).indexOf(common[b])>-1){
																g=cipher.substring(g).indexOf(common[b]);
																count++;
															}
															if (cipher.substring(g).indexOf(common[b])>-1){
																count++;
															}
													}	
*/
													
													if(cipher.indexOf(test)>-1) { //count>=25
														out.print(cipher + " Codex: "+String.valueOf((char)i)+String.valueOf((char)r)+String.valueOf((char)t)+" Rotors: " + y+"," +w+","+q+"\r\n");
														out.flush();
														System.out.println(cipher +" Rotors: " + y+"," +w+","+q);
													}
													
													
											}
											}
										}
									}
								}
							}
						}
				}
	
				//EnigmaAssembly assem = new EnigmaAssembly(String.valueOf((char)'U')+String.valueOf((char)'M')+String.valueOf((char)'H'),y,w,q,1);

				//System.out.print(in+"\n");
				//for( char t :arr) {
			
					
				//	System.out.print(assem.inputLetter(t));
				//}
													//System.out.println(cipher );
				
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