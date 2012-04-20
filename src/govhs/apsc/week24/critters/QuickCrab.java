package govhs.apsc.week24.critters;

import info.gridworld.grid.Location;


public class QuickCrab extends CrabCritter {
	
	@Override
	public void makeMove(Location loc) {
		Location left = new Location(loc.getRow(), loc.getCol() - 2); // get the left location
		Location right = new Location(loc.getRow(), loc.getCol() + 2); // get the right location
		if ((getGrid().get(left) == null) && (getGrid().get(right) == null)) { // check to see if empty
			double r = Math.random();
			if (r < 0.5) // pick a random spot to move to
				moveTo(left);
			else
				moveTo(right);
		}
		else // if they are occupied, do the superclass's method
			super.makeMove(loc);
	}
}
