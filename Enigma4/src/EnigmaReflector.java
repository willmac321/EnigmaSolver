
public class EnigmaReflector {

	private int name;
	private String refl;
	public EnigmaReflector(int name){
		this.name=name;
		setRef(name);
	}
		
		private void setRef(int name) {
			String str="";
			switch(name) {
			//B 
			case 1:
				 str= "AY,BR,CU,DH,EQ,FS,GL,IP,JX,KN,MO,TZ,VW,";
				refl=str;
				break;
			case 2:
				str = "AF,BV,CP,DJ,EI,GO,HY,KR,LZ,MX,NW,TQ,SU,";
				refl=str;
				break;
			case 3:
				str="YR,UH,QS,LD,PX,NG,OK,MI,EB,FZ,CW,VJ,AT,";
				refl=str;
				break;
			case 4:
				str="FV,PJ,IA,OY,ED,RZ,XW,GC,TK,UQ,SB,NM,HL,";
				refl=str;
				break;
			case 5:
				str="EN,KQ,AU,YW,JI,CO,PB,LM,DX,ZV,FT,HR,GS,";
				refl=str;
				break;
			case 6:
				str = "RD,OB,JN,TK,VE,HM,LF,CW,ZA,XG,YI,PS,UQ,";
				refl=str;				
			}
		}
			
			public char reflect(char c) {
				char rv;
				
				int n = refl.indexOf(c);
				if (refl.charAt(n+1)==',') {
					n--;
				}
				else {
					n++;
				}
				
				rv=(refl.charAt(n));
				
				return rv;
			}
}
