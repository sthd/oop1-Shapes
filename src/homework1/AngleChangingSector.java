package homework1;
import java.awt.*;

/**
 * An AngleChangingSector is a sector of an oval shape with a set colour
 * that can change its portion of the oval shape using its step() method.
 * A sector has a starting angle and an arc angle that determine its
 * portion. An AngleChangingSector consists of a set of properties:
 * {location, color, startAngle, arcAngle}.
 */

class AngleChangingSector extends Shape implements Animatable{
	private int startAngle , arcAngle;
	private int directionOf;
	private Dimension size = new Dimension(0,0);
	/*
	 * AF(c) = A shape oval so that
	 * c.size is the size of the blocking rectangle of the oval
	 * c.startAngle is the start Angle of the sector of the oval
	 * c.arcAngle is the angle arc of the sector
	 * c.directionof is the direction of the arc movement
	 */

	/*
	 * The rep invariant is:
	 * c.size != null && c.size is of type Dimension
	 * 0<= c.startAngle <= 359
	 * 0<= c.arcAngle <= 359
	 * directionof is -1 or 1
	 */
	
	
	/**
	 * @effects Initializes this with a a given start angle , arc angle, location and color. 
	 * size is initialized to be 0,0
	 */
	public AngleChangingSector(Point location, Color color, int startAngle, int arcAngle) {
		super(location, color);
		this.startAngle = startAngle;
		this.arcAngle = arcAngle;
		this.directionOf=1;
		assert checkRep();
	}


    /**
     * @effects will draw an Oval  
     * using  fillOval method of Graphics
     * @modifies Graphics g 
     */
	public void step(Rectangle bound) {
		if ((arcAngle % 359) != 0 ){
				arcAngle+=directionOf;
		}
		else{
			directionOf = -directionOf;
			arcAngle+=directionOf;
			}
		assert checkRep();
		}

    /**
     * @modifies this
     * @effects Resizes this so that its bounding rectangle has the specified
     * 			dimension.
     */
	public void setSize(Dimension dimension) {
		this.size.setSize(dimension);
		assert checkRep();
	}

    /**
     * @effects return the bounding rectangle of this 
     * with size and location of top left point
     */
	public Rectangle getBounds() {
		return new Rectangle(getLocation(),size);
	}

    /**
     * @modifies Graphics g 
     * @effects will draw an sector of an oval  with angle 
     * using  fillarc method of Graphics
     */
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillArc(this.getLocation().x, this.getLocation().y, this.size.width, this.size.height, startAngle, arcAngle);
	}
	
	/*
	 * @effects Returns true if the rep invariant holds for this: otherwise returns
	 * false
	 */
    public boolean checkRep() {
    	if(  (size == null) || !(size instanceof Dimension) ) {
    		return false;
    	}
    	else if(!( startAngle<360 && startAngle>=0 )) {
    		return false;
    	}
    	else if(!( arcAngle<360 && arcAngle>=0 )) {
    		return false;
    	}
    	else if ((directionOf != 1 && directionOf != -1)) {
    		return false;
    	}
    	else return true;
    }
    
    public Object Clone() {
    	AngleChangingSector newSector = 
    			(AngleChangingSector)super.clone();
    	newSector.size = (Dimension) size.clone();
    	newSector.arcAngle = arcAngle;
    	newSector.startAngle = startAngle;
    	return newSector;
    	

    }


}