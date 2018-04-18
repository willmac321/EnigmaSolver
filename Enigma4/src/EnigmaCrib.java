import java.util.Random;

public class EnigmaCrib {
	private int nPlugs;
	private String plug;
	private String crib = "THISSENTENCEWASENCRYPTEDONANMTHREEENIGMAWITHREFLECTORBANDALLTENPLUGSUSED";
	private String testString;
	private int cribCount;
	public EnigmaCrib(int nOfPlugs,String testString) {
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
					plug=testSubString.charAt(cribCount)+ (char)(random+65);
					
				
		}
	}

