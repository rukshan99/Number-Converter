package octalpublisher;

public class OctalConverter implements OctalService {
	

	@Override
	public String DecimalToOctal(String decimal) {
		
		 
		int dec = Integer.parseInt(decimal),rem;
		String octal=""; 
	    char octalchars[]={'0','1','2','3','4','5','6','7'}; 

	    while(dec>0)  
	    	
	    {  
	    	
	       rem=dec%8;   
	       octal=octalchars[rem]+octal;   
	       dec=dec/8;  
	       
	    }  
	    
	    return octal;  
	    
	}

	@Override
	public String BinaryToOctal(String binary) {
		
		
		int  bin = Integer.parseInt(binary) , decimal = 0, i = 0 , octal = 0;

	    while (bin != 0) {
	      decimal += (bin % 10) * Math.pow(2, i);
	      ++i;
	      bin /= 10;
	    }

	    i = 1;

	    while (decimal != 0) {
	      octal += (decimal % 8) * i;
	      decimal /= 8;
	      i *= 10;
	    }

	    return Integer.toString(octal);
	    
	}

	@Override
	public String HexaDecimalToOctal(String hexa) {
		
		String digits = "0123456789ABCDEF";
		
        hexa = hexa.toUpperCase();
        
        int dec = 0,rem;
        
        for (int i = 0; i < hexa.length(); i++)
        	
        {
        	
            char cha = hexa.charAt(i);
            int dig = digits.indexOf(cha);
            dec = 16*dec + dig;
            
        }
        
        String octal="";  
        
        char octalchars[]={'0','1','2','3','4','5','6','7'}; 
   
        while(dec>0)  
        	
        {  
        	
           rem=dec%8;   
           octal=octalchars[rem]+octal;   
           dec=dec/8;  
           
        }  
        
        return octal;  
        
        
        
	}


}
