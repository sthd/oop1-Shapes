package homework1;
import java.awt.*;
/*Overview: A LocationAndColorChangingTriangle is ColorAndLocationChaningShape with 
 * size property and will draw into oval using draw() method.
 * Thus, a typical LocationAndColorChangingTriangle consists
 * of the following set of properties: {location, color, shape=Triangle, size, velocity}
*/
class LocationAndColorChangingTriangle extends LocationAndColorChangingShape{
	private Dimension size = new Dimension(0,0);
	
	/*
	 * AF(c) = A shape triangle so that
	 * c.size is the size of the blocking rectangle of the triangle
	 * (c.size.width == vertical length of the triangle
	 * c.size.hight == horiztional length of the triangle)
	 */
	
	/*
	 * The rep invariant is: 
	 * c.size != null && c.size is of type Dimension
	 */
	
	
	/**
	 * @effects Initializes this with a a given location and color. 
	 * size is initialized to be 0,0
	 */
	
	LocationAndColorChangingTriangle(Point location, Color color) {
		super(location, color);
	}

    /**
     * @modifies this
     * @effects Resizes this so that its bounding rectangle has the specified
     * 			dimension.
     */
	public void setSize(Dimension dimension) throws ImpossibleSizeException {
		size.setSize(dimension);
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
		Rectangle r = getBounds();
		int[] pointsX = {r.x,r.x + r.width , r.x};
		int[] pointsY = { r.y,r.y,r.y+r.height};
		g.fillPolygon(pointsX,pointsY, 3 );
		
	}
    public Object Clone() {
    	LocationAndColorChangingTriangle newTrinagle = (LocationAndColorChangingTriangle)super.clone();
    	newTrinagle.size = (Dimension)size.clone();
    	return newTrinagle;
    }
	
}