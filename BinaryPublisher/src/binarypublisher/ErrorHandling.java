package binarypublisher;

public class ErrorHandling {
	
	
	public boolean isOctal(String input) {

		int inputCopy = Integer.parseInt(input);

		while (inputCopy != 0) {
			if (inputCopy % 10 > 7)
				return false;
			inputCopy = inputCopy / 10;
		}
		return true;
	}
	
	public boolean isHexa(String input) {
		 int n = input.length();
		 
		 for (int i = 0; i < n; i++) {
			 
	            char ch = input.charAt(i);
	 
	            if ((ch < '0' || ch > '9') && (ch < 'A' || ch > 'F')) 
	                return false;
	        }
	 
	        return true;
	}

}
