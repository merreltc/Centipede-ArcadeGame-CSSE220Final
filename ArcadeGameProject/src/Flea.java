import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;

public class Flea extends Entity{
	public Flea(World world, Point2D centerPoint) {
		super(world, centerPoint);
		// TODO Auto-generated constructor stub.
	}

	private final int VELOCITY = 2;
	private final int SCORE_VALUE = 500;
	
	public void spawnMushroom(){
		if(Math.random() > .75)
			new Mushroom(this.getWorld(), this.getCenterPoint());
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public Shape getShape() {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public void timePassed() {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public boolean getIsPaused() {
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void checkCollision() {
		// TODO Auto-generated method stub.
		
	}
}

