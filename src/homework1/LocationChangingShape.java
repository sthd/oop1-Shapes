package homework1;

import java.awt.*;
import java.util.Random;

/**
 * A LocationChaningShape is a Shape that can change its location using its
 * step() method. A LocationChaningShape has a velocity property that determines
 * the speed of location changing. Thus, a typical LocationChaningShape consists
 * of the following set of properties: {location, color, shape, size, velocity}
 */

public abstract class LocationChangingShape extends Shape implements Animatable {
	private int velocityX, velocityY;

	
	/*
	 * AF(c) = Moving Shape that 
	 * c.velocityX is speed in x axis 
	 * c.velocityY is speed in y axis
	 */
	 

	/*
	 * The rep invariant is: 
	 * for i in {c.velocityX,c.velocityY}: 
	 * -5 <= i <= 5 && i != 0
	 */

	
	/**
	 * @effects Initializes this with a a given location and color. Each of the
	 *          horizontal and vertical velocities of the new object is set to a
	 *          random integral value i such that -5 <= i <= 5 and i != 0
	 */
	public LocationChangingShape(Point location, Color color) {
		super(location, color);
		int upperBoundExclusive = 6, lowerBoundInclusive = -5;
		Random rand = new Random();
		do {
			velocityX = rand.nextInt(lowerBoundInclusive, upperBoundExclusive);
			velocityY = rand.nextInt(lowerBoundInclusive, upperBoundExclusive);
		} while (velocityX == 0 || velocityY == 0);
		assert checkRep();
	}

	/**
	 * @return the horizontal velocity of this.
	 */
	public int getVelocityX() {
		return velocityX;

	}

	/**
	 * @return the vertical velocity of this.
	 */
	public int getVelocityY() {
		return velocityY;
	}

	/**
	 * @modifies this
	 * @effects Sets the horizontal velocity of this to velocityX and the vertical
	 *          velocity of this to velocityY.
	 */
	public void setVelocity(int velocityX, int velocityY) {
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		assert checkRep();
	}

	/**
	 * @modifies this
	 * @effects Let p = location v = (vx, vy) = velocity r = the bounding rectangle
	 *          of this If (part of r is outside bound) or (r is within bound but
	 *          adding v to p would bring part of r outside bound) { If adding v to
	 *          p would move r horizontally farther away from the center of bound,
	 *          vx = -vx If adding v to p would move r vertically farther away from
	 *          the center of bound, vy = -vy } p = p + v
	 */
	public void step(Rectangle bound) {
		boolean[] inBound = inLimit(bound);
		if (!inBound[0]) {
			velocityX = -velocityX;
		}
		if (!inBound[1]) {
			velocityY = -velocityY;
		}
		Point newLocation = this.getLocation();
		newLocation.move(newLocation.x + velocityX, newLocation.y + velocityY);
		setLocation(newLocation);
	}

	protected boolean[] inLimit(Rectangle bound) {
		boolean[] result = { true, true };
		Rectangle shape = getBounds();
		shape.setLocation(getLocation());

		int leftBorder = 0, rightBorder = bound.width, upperBorder = 0, lowerBorder = bound.height;
		if (shape.contains(leftBorder, shape.y) || shape.contains(rightBorder, shape.y)
				|| shape.contains(leftBorder - velocityX, shape.y)
				|| shape.contains(rightBorder - velocityX, shape.y)) {
			result[0] = false;
		}
		if (shape.contains(shape.x, upperBorder) || shape.contains(shape.x, lowerBorder)
				|| shape.contains(shape.x, upperBorder - velocityY)
				|| shape.contains(shape.x, lowerBorder - velocityY)) {
			result[1] = false;
		}
		return result;
	}
	/*
	 * @effects: Returns true if the rep invariant holds for this: otherwise returns
	 * false
	 */
    public boolean checkRep() {
    	if (! ((velocityX >= -5 )&&( velocityX <= 5 ))
    			|| !((velocityY >= -5 )&&( velocityY <= 5 ))){
    		return false;
    	}
    	else if ( velocityX==0 || velocityY == 0) {
    		return false;
    	}
    	else return true;
    }
	
	

}
