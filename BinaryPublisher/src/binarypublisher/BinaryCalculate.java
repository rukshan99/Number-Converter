package binarypublisher;

import java.util.HashMap;

public class BinaryCalculate implements  BinaryService {
	

	@Override
	public String DecimalToBinary(int decimal) {
		
		
        int[] binaryNum = new int[1000];
        String result="";
   
       
        int i = 0;
        while (decimal > 0) 
        {
            
            binaryNum[i] = decimal % 2;
            decimal = decimal / 2;
            i++;
        }
   
        
        for (int j = i - 1; j >= 0; j--)
        	result = result.concat(binaryNum[j]+"");
		return result;
		
	}

	@Override
	public String OctalToBinary(String octal) {
		
		int i = 0;
		  
       
        String binaryValue = "";
  
       
        while (i < octal.length()) {
  
            
            char c = octal.charAt((int)i);
  
           
            switch (c) {
            case '0':
                binaryValue += "000";
                break;
            case '1':
                binaryValue += "001";
                break;
            case '2':
                binaryValue += "010";
                break;
            case '3':
                binaryValue += "011";
                break;
            case '4':
                binaryValue += "100";
                break;
            case '5':
                binaryValue += "101";
                break;
            case '6':
                binaryValue += "110";
                break;
            case '7':
                binaryValue += "111";
                break;
            default:
                System.out.println(
                    "\nInvalid Octal Digit "
                    + octal.charAt((int)i));
                break;
            }
            i++;
        }
  
        
        return binaryValue;
	}

	@Override
	public String HexaToBinary(String Hexa) {
		String binary = "";
		  
        
		Hexa = Hexa.toUpperCase();
  
        
        HashMap<Character, String> hashMap
            = new HashMap<Character, String>();
  
        
        hashMap.put('0', "0000");
        hashMap.put('1', "0001");
        hashMap.put('2', "0010");
        hashMap.put('3', "0011");
        hashMap.put('4', "0100");
        hashMap.put('5', "0101");
        hashMap.put('6', "0110");
        hashMap.put('7', "0111");
        hashMap.put('8', "1000");
        hashMap.put('9', "1001");
        hashMap.put('A', "1010");
        hashMap.put('B', "1011");
        hashMap.put('C', "1100");
        hashMap.put('D', "1101");
        hashMap.put('E', "1110");
        hashMap.put('F', "1111");
  
        int i;
        char ch;
  
        
        for (i = 0; i < Hexa.length(); i++) {
            
            ch = Hexa.charAt(i);
  
            
            if (hashMap.containsKey(ch))
  
                
                binary += hashMap.get(ch);
  
            
            else {
                binary = "Invalid Hexadecimal String";
                return binary;
            }
        }
  
        
        return binary;
	}

}
