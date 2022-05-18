package homework1;
import java.awt.*;

class LocationAndColorChangingTriangle extends LocationAndColorChangingShape{
	private Dimension size = new Dimension(0,0);
	LocationAndColorChangingTriangle(Point location, Color color) {
		super(location, color);
	}

	@Override
	public void setSize(Dimension dimension) throws ImpossibleSizeException {
		size.setSize(dimension);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getLocation(),size);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		Rectangle r = getBounds();
		int[] pointsX = {r.x,r.x + r.width , r.x};
		int[] pointsY = { r.y,r.y,r.y+r.height};
		g.fillPolygon(pointsX,pointsY, 3 );
		
	}
	
	
}