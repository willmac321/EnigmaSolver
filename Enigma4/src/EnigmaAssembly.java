
public class EnigmaAssembly {

	private EnigmaRotor rotor1;
	private EnigmaRotor rotor2;	
	private EnigmaRotor rotor3;
	private EnigmaRotor[] rotors;
	private EnigmaReflector refl;
	private EnigmaPlugboard plugboard;
	
	/**
	 * 
	 * @param cipher Encryption key
	 * @param a first rotor
	 * @param b second rotor
	 * @param c third rotor
	 * @param ref reflector B or C
	 * @param noPlugs Number of plug board plugs used (up to 10)
	 * @param plug String of plug combinations delimited by ","
	 */
  public EnigmaAssembly(String cipher, int a, int b, int c, int ref, int noPlugs, String plug){
	  	rotor1= new EnigmaRotor(a);
	  	rotor2=new EnigmaRotor(b);
	  	rotor3 = new EnigmaRotor(c);
	  	this.refl = new EnigmaReflector(ref);
		rotors= new EnigmaRotor[] {rotor1,rotor2,rotor3};
		//plugboard = new EnigmaPlugboard(10,"AV,BS,CG,DL,FU,HZ,IN,KM,OW,RX");
		plugboard = new EnigmaPlugboard(noPlugs,plug);
		int i =0;
	  for ( EnigmaRotor rotor:rotors) {
		  
			switch (rotor.getName()){
				case 1:
					rotor=new EnigmaRotor(1,	"EKMFLGDQVZNTOWYHXUSPAIBRCJ");
					break;
				case 2:
					rotor=new EnigmaRotor(2,	"AJDKSIRUXBLHWTMCQGZNPYFVOE");
					break;
				case 3:
					rotor=new EnigmaRotor(3,	"BDFHJLCPRTXVZNYEIWGAKMUSQO");
					break;
				case 4:
					rotor=new EnigmaRotor(4,	"ESOVPZJAYQUIRHXLNFTGKDCMWB");
					break;
				case 5:
					rotor=new EnigmaRotor(5,	"VZBRGITYUPSDNHLXAWMJQOFECK");
					break;
				case 6: 
					rotor=new EnigmaRotor(6,	"JPGVOUMFYQBENHZRDKASXLICTW");
					break;
				case 7: 
					rotor=new EnigmaRotor(7,	"NZJHGRCXMYSWBOUFAIVLPEKQDT");
					break;
				case 8:
					rotor=new EnigmaRotor(8,	"FKQHTLXOCBJSPDZRAMEWNIUYGV");
					break;
		}
	  	rotor.setCipher(cipher.charAt(i));
	  	rotors[i]=rotor;
	  	i++;
	  }
  }
	public char inputLetter(char letter) {
		char rv=letter;		
		
		if (isNotched(rotors[0])){			
				if(isNotched(rotors[1])) {
					rotors[2].incRotorCount();
				}
				//to make like py enigma comment out
				rotors[1].incRotorCount();

		}
		else if (isNotched(rotors[2])) {
			rotors[1].incRotorCount();
			rotors[2].incRotorCount();
			
		}
		
		
		rotors[0].incRotorCount();
		
		
		rv=plugboard.passThruPlugboard(rv);
		rv=rotors[0].findReturnChar(rv,true);
		rv=rotors[1].findReturnChar(rv,true);
		rv=rotors[2].findReturnChar(rv,true);
			
			
		rv=refl.reflect(rv);
		
		rv=rotors[2].findReturnChar(rv,false);
		rv=rotors[1].findReturnChar(rv,false);
		rv=rotors[0].findReturnChar(rv,false);
		rv=plugboard.passThruPlugboard(rv);
		return rv;
	}
	
	private boolean isNotched( EnigmaRotor name) {
		
		//http://www.cryptomuseum.com/crypto/enigma/wiring.htm
		//use notch not what is 'visible'
		
		
		char letter=(char)(name.getCount()+65);
		boolean test=false;
		switch (name.getName()){
			case 1:
				if (letter=='Y'){
				
					test=true;
				}
				break;
			case 2:
				if (letter=='M'){
					
					test=true;
				}
				break;
			case 3:
				if (letter=='D'){
				
					test=true;
				}
				break;
			case 4:
				if (letter=='R'){
					
					test=true;
				}
				break;
			case 5:
				if (letter=='H'){
				
					test=true;
				}
				break;
			case 6: case 7: case 8:
				if (letter=='H'|| letter=='U'){
			
					test=true;
				}
				
		}
		return test;
	}
	
	
	public void incNextRotor() {
	}
}

