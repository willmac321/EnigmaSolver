import java.util.Random;

public class DecryptWithCrib {
	private int nPlugs;
	private String plug;
	private String crib = "HOWDY";
	private String testString;
	private int cribCount;
	private String cipher;
	
	public DecryptWithCrib(int nOfPlugs,String testString) {
		nPlugs=nOfPlugs;
		this.testString=testString;
		cribCount=0;
		setPlugs(nOfPlugs);
		plug="";
		
	}
	private void setPlugs(int name) {

			
			for(int i=0;i<crib.length();i++) {
					if (testString.charAt(i+cribCount)==crib.charAt(i))
					{
						cribCount++;
						i=-1;
					}
					
						
			}
					System.out.println("Crib Index: "+ cribCount)	;	
					String testSubString = testString.substring(cribCount,crib.length()+cribCount);
				
					
					
					int random=(int) (Math.random()*(25)+1);
					while(random==(Character.valueOf(testSubString.charAt(0))-10)){
						random=(int) (Math.random()*(25)+1);
					}
					plug=testSubString.charAt(cribCount)+ String.valueOf((char)(random+65));
												
							for (int i=65;i<91;i++) {
								for(int r=65;r<91;r++) {
									for(int t=65;t<91;t++) {
										for(int q=1;q<9;q++) {
											for(int w=1;w<9;w++) {
												for(int y=1;y<9;y++) {
													if(q!=w && q!=y && w!=y) {
														EnigmaAssembly assem = new EnigmaAssembly(String.valueOf((char)i)+String.valueOf((char)r)+String.valueOf((char)t),q,w,y,1,name,plug);
															cipher="";
																for (int l=0;l<crib.length();l++) {
																	cipher+=assem.inputLetter(testSubString.charAt(i));
																}
																	
															}
														}
													}
												}
										}
								}
							}
	}
	}

