package hexapublisher;

public class HexaConverterCalculator implements HexaService {

	@Override
	public String DecimalHexadecimal(int decimal) {
		int rem;
		String hex = "";
		char hexchars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (decimal > 0) {
			rem = decimal % 16;
			hex = hexchars[rem] + hex;
			decimal = decimal / 16;
		}
		return hex;
	}

	@Override
	public String OctalHexadecimal(String oct) {
	
		int decimal = Integer.parseInt(oct,8);
		int rem;
		String hex = "";
		char hexchars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (decimal > 0) {
			rem = decimal % 16;
			hex = hexchars[rem] + hex;
			decimal = decimal / 16;
		}
		return hex;
	}

	@Override
	public String BinaryHexadecimal(String binary) {
		int decimal = Integer.parseInt(binary,2);
		int rem;
		String hex = "";
		char hexchars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (decimal > 0) {
			rem = decimal % 16;
			hex = hexchars[rem] + hex;
			decimal = decimal / 16;
		}
		return hex;
	}


}