package homework1;
import java.awt.*;

/**
 * An AngleChangingSector is a sector of an oval shape with a set colour
 * that can change its portion of the oval shape using its step() method.
 *  A sector has a starting angle and an arc angle that determine its
 * portion. An AngleChangingSector consists of a set of properties: {location, color, shape, size}.
 * Shapes are mutable and cloneable.
 */

class AngleChangingSector extends Shape implements Animatable{
	private int startAngle , arcAngle;
	private boolean fillShapeClockwise;
	private int directionOf;
	private Dimension size = new Dimension(0,0);
	public AngleChangingSector(Point location, Color color, int startAngle, int arcAngle) {
		super(location, color);
		this.startAngle = startAngle;
		this.arcAngle = arcAngle;
		this.fillShapeClockwise = false;
		this.directionOf=1;
	}

	@Override
	public void step(Rectangle bound) {
		// TODO Auto-generated method stub
		if ((arcAngle % 359) != 0 ){
				arcAngle+=directionOf;
		}
		else{
			directionOf = -directionOf;
			arcAngle+=directionOf;
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