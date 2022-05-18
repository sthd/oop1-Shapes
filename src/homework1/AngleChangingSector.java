package homework1;
import java.awt.*;

class AngleChangingSector extends Shape implements Animatable{
	int startAngle,arcAngle;
	public AngleChangingSector(Point location, Color color) {
		super(location, color);
	}

	@Override
	public void step(Rectangle bound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSize(Dimension dimension) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {
		g.fillArc(0, 0, 0, 0, 0, 0);
		
	}
	
}