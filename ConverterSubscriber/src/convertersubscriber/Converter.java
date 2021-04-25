package convertersubscriber;

public class Converter implements ConverterService{
	
	ConverterMenu converterMenu;

	@Override
	public void startService() {
		
		converterMenu = new ConverterMenu();
		converterMenu.setVisible(true);
		
	}

	@Override
	public void stopService() {
		
		converterMenu.dispose();
		
	}
	
	
	

	
}
