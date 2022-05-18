package homework1;
import java.awt.*;

public class ImpossibleSizeException extends Exception{
	
	public Dimension alternativeSize;
	
	public ImpossibleSizeException() {
		super("Impossible Size Exception");}
//		alternativeSize = new Dimension(5,5);
		
	
}