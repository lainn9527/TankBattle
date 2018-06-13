package local;
import java.awt.Rectangle;

import local.Status.Direction;

public class Bullet {
	protected Data data = null;
	public static final int PER_MOVE = 50;
	public static final int SPEED = 5;
	private boolean visible = true;

	
	Bullet(int x, int y, Player player) {
		data = new Data();
		data.setX(x);
		data.setY(y);
		data.setDirect(player.data.getDirect());
	}
	
	public void move() {
		int x = data.getX();
		int y = data.getY();
		if(data.getDirect() == Direction.UP)
			data.setY(y - SPEED);
		else if(data.getDirect() == Direction.DOWN)
			data.setY(y + SPEED);
		else if(data.getDirect() == Direction.LEFT)
			data.setX(x - SPEED);
		else if(data.getDirect() == Direction.RIGHT)
			data.setX(x + SPEED);
	}
	public Rectangle getBound() {
		return new Rectangle(data.getX(), data.getY(), PER_MOVE, PER_MOVE);
	}
	public boolean getVisible() {
		return visible;
	}
	public void setVisible(boolean flag) {
		visible = flag;
	}
}
