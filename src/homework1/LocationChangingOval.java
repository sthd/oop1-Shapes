package homework1;
import java.awt.*;

/*Overview: A LocationChangingOval is LocationChangingShape with 
 * size property and will draw into oval using draw() method.
 * Thus, a typical LocationChaningOval consists
 * of the following set of properties: {location, color, shape=Oval, size, velocity}
*/

public class LocationChangingOval extends LocationChangingShape{
	private Dimension size = new Dimension(0,0);
	
	/*
	 * AF(c) = A shape oval so that
	 * c.size is the size of the blocking rectangle of the oval
	 * (c.size.width == rectangle.width
	 * c.size.hight == rectangle.hight)
	 */
	
	/*
	 * The rep invariant is: 
	 * c.size != null && c.size is of type Dimension
	 */
	
	/**
	 * @effects Initializes this with a a given location and color. 
	 * size is initialized to be 0,0
	 */
	
	public LocationChangingOval(Point location, Color color) {
		super(location, color);
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
     * @effects will draw an Oval  
     * using  fillOval method of Graphics 
     */
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getLocation().x, getLocation().y ,
				size.width , size.height );	
	}
	
	/*
	 * @effects Returns true if the rep invariant holds for this: otherwise returns
	 * false
	 */
    public boolean checkRep() {
    	if(  (size == null) || !(size instanceof Dimension) ) {
    		return false;
    	}
    	else return true;
    }
    
    public Object Clone() {
    	LocationChangingOval newOval = (LocationChangingOval)super.clone();
    	newOval.size = (Dimension)size.clone();
    	return newOval;
    }
	
	
}