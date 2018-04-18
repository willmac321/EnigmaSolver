
public class EnigmaAssembly {

	private EnigmaRotor rotor1;
	private EnigmaRotor rotor2;	
	private EnigmaRotor rotor3;
	private EnigmaRotor[] rotors;
	private EnigmaReflector refl;

	
	
  public EnigmaAssembly(String cipher, int a, int b, int c, int ref){
	  	rotor1= new EnigmaRotor(a);
	  	rotor2=new EnigmaRotor(b);
	  	rotor3 = new EnigmaRotor(c);
	  	this.refl = new EnigmaReflector(ref);
		rotors= new EnigmaRotor[] {rotor1,rotor2,rotor3};

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
				rotors[1].incRotorCount();
			}
			else if (isNotched(rotors[1])) {
				rotors[1].incRotorCount();
				rotors[2].incRotorCount();
				
			}
			rotors[0].incRotorCount();
			
		rv=rotors[0].findReturnChar(rv,true);
		rv=rotors[1].findReturnChar(rv,true);
		rv=rotors[2].findReturnChar(rv,true);
			
			
		rv=refl.reflect(rv);
		
		rv=rotors[2].findReturnChar(rv,false);
		rv=rotors[1].findReturnChar(rv,false);
		rv=rotors[0].findReturnChar(rv,false);
		
		return rv;
	}
	
	private boolean isNotched( EnigmaRotor name) {
		char letter=(char)(name.getCount()+65);
		boolean test=false;
		switch (name.getName()){
			case 1:
				if (letter=='Q'){
				
					test=true;
				}
				break;
			case 2:
				if (letter=='E'){
					
					test=true;
				}
				break;
			case 3:
				if (letter=='V'){
				
					test=true;
				}
				break;
			case 4:
				if (letter=='J'){
					
					test=true;
				}
				break;
			case 5:
				if (letter=='Z'){
				
					test=true;
				}
				break;
			case 6: case 7: case 8:
				if (letter=='Z'|| letter=='M'){
			
					test=true;
				}
				break;
		}
		return test;
	}
	
	
	public void incNextRotor() {
	}
}

