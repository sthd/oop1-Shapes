package homework1;

import java.awt.*;


/**
 * A ColorAndLocationChaningShape is a Shape that can change its location and color using its step()
 * method.
 * Thus, a typical ColorAndLocationChaningShape consists of the following set of
 * properties: {location, color, shape, size, velocity}
 */
public abstract class LocationAndColorChangingShape extends LocationChangingShape{

	
	/*
	 * AF(c) = Moving Shape and Color Changing Shape 
	 * so that each time it hits a wall inside Bounding Rectangle 
	 * it changes his color
	 */
	 

	/*
	 * The rep invariant is: 
	 * The same rep invariant of the parents
	 */

	
    /**
     * @effects Initializes this with a a given location and color. Each
     *          of the horizontal and vertical velocities of the new
     *          object is set to a random integral value i such that
     *          -5 <= i <= 5 and i != 0
     */
    LocationAndColorChangingShape(Point location, Color color) {
    	super(location,color);
    }

    /**
     * @modifies this
     * @effects Changes the location of this as described in the specification
     *          of LocationChangingShape.step(Rectangle bound) and
	 *			if the velocity of this needs to be changed (as described in LocationChangingShape.step(Rectangle bound)),
	 *			changes the color of this to a new random color;
	 *			else, does not change the color of this.
     */
    public void step(Rectangle bound) {
    	super.step(bound);
    	for(boolean b: inLimit(bound)) { if(!b) {
    		super.setColor(new Color((int)(Math.random() * 0x1000000)));
    		break;
    		}
    	}
    }
}
