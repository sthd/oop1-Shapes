package homework1;
import java.awt.*;

class AngleChangingSector extends Shape implements Animatable{
	private int startAngle , arcAngle;
	private boolean fillCounterClockwise;
	private Dimension size = new Dimension(0,0);
	public AngleChangingSector(Point location, Color color, int startAngle, int arcAngle) {
		super(location, color);
		this.startAngle = startAngle;
		this.arcAngle = arcAngle;
	}

	@Override
	public void step(Rectangle bound) {
		// TODO Auto-generated method stub
		if (arcAngle < 359){
			arcAngle++;
		}
		else{
			arcAngle=0;
		}
	}

	@Override
	public void setSize(Dimension dimension) {
		// TODO Auto-generated method stub
		this.size.setSize(dimension);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(getLocation(),size);
		//return null;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillArc(this.getLocation().x, this.getLocation().y, this.size.width, this.size.height, startAngle, arcAngle);
	}
	
}