package decimalconverter;

public class DecimalConverterCalculator implements DecimalConverterService {

	@Override
	public int BinaryToDecimal(String num) {
		return Integer.parseInt(num,2);
	}

	@Override
	public int OctalToDecimal(String num) {
		return Integer.parseInt(num,8); 
	}

	@Override
	public int HexaToDecimal(String num) {
		return Integer.parseInt(num,16);
	}

}
