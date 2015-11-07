import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Mushroom extends Entity {
	private boolean poisoned;

	public Mushroom(World world, Point2D centerPoint) {
		super(world, centerPoint);
		this.radius = 10;
		this.health = 4;
		this.poisoned = false;
	}

	public boolean isPoisoned() {
		return poisoned;
	}

	public void setPoisoned(boolean poisoned) {
		this.poisoned = poisoned;
	}

	@Override
	public Color getColor() {
		if(this.poisoned) {
			return Color.CYAN;
		}
		return new Color(255 / this.getHealth(), 255 / (5 - this.getHealth()), 0);
	}

	@Override
	public Shape getShape() {
		return new Ellipse2D.Double(this.getCenterPoint().getX() - this.getWorld().CELL_WIDTH / 2,
				this.getCenterPoint().getY() - this.getWorld().CELL_WIDTH / 2, 20, 20);
	}

	@Override
	public void updatePosition() {
		if (checkCollision(getCenterPoint()) != null
				&& checkCollisionBottom(getCenterPoint())
				&& checkCollision(getCenterPoint()).getClass().equals(RapidFire.class)) {
			System.out.println("I have been hit");
			this.takeDamage();
		}
		if (this.getHealth() == 0) {
			die();
		}
	}
}
