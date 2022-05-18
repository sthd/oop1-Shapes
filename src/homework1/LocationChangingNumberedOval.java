package homework1;
import java.awt.*;
public class LocationChangingNumberedOval extends LocationChangingOval{
	private static Integer counter = 1;
	private Integer number;
	public LocationChangingNumberedOval(Point location, Color color) {
		super(location, color);
		number = (counter++).intValue();
	}
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.BLACK);
		g.drawString(number.toString()
				,getLocation().x +(int)(getBounds().width/2)
				, getLocation().y+ (int)(getBounds().height/2));
	}
	public static void restartCounter() {
		counter=1;
	}
	
	
	
}