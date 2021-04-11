package com.mtit.osgi.decimalconverter;

public interface DecimalConverterService {

	public int BinaryToDecimal(String num);
	public int OctalToDecimal(String num);
	public int HexaToDecimal(String num);
}
