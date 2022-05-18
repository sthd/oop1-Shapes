package homework1;

import java.awt.*;


/**
 * A Shape is an abstraction of a shape object. A typical Shape consists of
 * a set of properties: {location, color, shape, size}.
 * Shapes are mutable and cloneable.
 */
public abstract class Shape implements Cloneable {

	private Point location;
	private Color color;
	//AF(c) = An Abstract Shape where 
	// c.color = color of the shape
	// c.location = location of the top left corner 
	//of the bounding rectangle of shape
		
	//The rep invariant is:
	//c.location != null && c.color !=null &&
	//c.location is Point && c.color is Color
	
		
	
	/**
	 * @effects Initializes this with a a given location and color.
	 */
    public Shape(Point location, Color color) {
    	setLocation(location);
    	setColor(color);
    	checkRep();
    }


    /**
     * @return the top left corner of the bounding rectangle of this.
     */
    public Point getLocation() {
    	return location;
    }


    /**
     * @modifies this
     * @effects Moves this to the given location, i.e. this.getLocation()
     * 			returns location after call has completed.
     */
    public void setLocation(Point location) {
    	this.location = (Point)location.clone();
    	assert checkRep();
    }


    /**
     * @modifies this
     * @effects Resizes this so that its bounding rectangle has the specified
     * 			dimension.
     * 			If this cannot be resized to the specified dimension =>
     * 			this is not modified, throws ImpossibleSizeException
     * 			(the exception suggests an alternative dimension that is
     * 			 supported by this).
     */
    public abstract void setSize(Dimension dimension)
    	throws ImpossibleSizeException;

    
    /**
     * @return the bounding rectangle of this.
     */
    public abstract Rectangle getBounds();
  

    /**
     * @return true if the given point lies inside the bounding rectangle of
     * 		   this and false otherwise.
     */
    public boolean contains(Point point) {
    	return getBounds().contains(point);
    }
        

    /**
     * @return color of this.
     */
    public Color getColor() {
    	return color;
    }


    /**
     * @modifies this
     * @effects Sets color of this.
     */
    public void setColor(Color color) {
    	this.color = color;
    	assert checkRep();
    }


    /**
     * @modifies g
     * @effects Draws this onto g.
     */
    public abstract void draw(Graphics g);


    /**
     * @effects Creates and returns a copy of this.
     */
    public Object clone() {    	
    	Shape newShape = null;
    	try {
    		newShape = (Shape)super.clone();
    	} catch(CloneNotSupportedException e) {
    		assert false: "Shape.Clone() Exception CloneNotSupportedException";
    	}
    	newShape.location = (Point)location.clone(); //deep clone mutable class Point
    	return newShape;
    }
    
    
    
	/*
	 * @effects: Returns true if the rep invariant holds for this: otherwise returns
	 * false
	 */
    public boolean checkRep() {
    	if(location == null || color == null) {
    		return false;
    	}
    	else if(!(location instanceof Point)||!(color instanceof Color)) {
    		return false;
    	}
    	else return true;
    }

}



