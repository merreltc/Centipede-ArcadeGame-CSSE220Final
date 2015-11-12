import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;

public class Centipede {

	private Color color;
	private boolean right, down, up, lastVert, moveRight;
	private ArrayList<CentipedeSegment> centipede;
	private World world;

	public Centipede(World world, boolean moveRight) {
		this.centipede = new ArrayList<CentipedeSegment>();
		this.world = world;
		this.moveRight = moveRight;
	}

	public synchronized void split(CentipedeSegment segment) throws IOException {
		int index = this.centipede.indexOf(segment);
		this.world.addEntity(new Mushroom(this.world, segment.getCenterPoint()));
		Centipede firstHalf = new Centipede(this.world, true);
		Centipede secondHalf = new Centipede(this.world, false);
		
		for (int k = 0; k < index; k++) {
			firstHalf.addHead(this.centipede.get(k).getCenterPoint());
			this.centipede.get(k).die();
		}
		for (int k = index + 1; k < this.centipede.size(); k++) {
			secondHalf.addHead(this.centipede.get(k).getCenterPoint());
			this.world.removeEntity(this.centipede.get(k));
		}
	}

	public void addHead(Point2D center) throws IOException {
		CentipedeSegment segment = new CentipedeSegment(this.world, center, this);
		this.centipede.add(segment);
		this.centipede.get(this.centipede.size()-1).setDirection(this.moveRight);
		this.world.addEntity(segment);
	}
	
	public ArrayList<CentipedeSegment> getList() {
		return this.centipede;
	}
	
	
}