
public class EnigmaPlugboard {

private int nPlugs;
private String plug;

private String testString;
private int cribCount;

	public EnigmaPlugboard(int nOfPlugs, String plugs) {
			nPlugs=nOfPlugs;
			cribCount=0;
			plug=plugs;
			
			
	
	}
	public char passThruPlugboard(char c) {
		char rv;
		rv=c;
		if (plug.contains(String.valueOf(c))) {
			int n = plug.indexOf(c);
			if (plug.charAt(n+1)==',') {
				n--;
			}
			else {
				n++;
			}
			
			rv=(plug.charAt(n));
			}
		return rv;
	}
	
	public void addPlug(String str) {
		if (str.length()==2 && plug.length()<31) {
			plug+=str+",";
			
		}
		
	}
	
	public String getPlug() {
		return plug;
	}
	
	public String clearPlug() {
		String rv="";
		rv=plug;
		plug="";
		return rv;
	}
}