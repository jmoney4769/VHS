package govhs.apsc.week24.critters;

import info.gridworld.actor.Actor;

import java.awt.Color;
import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter {

	@Override
	public void processActors(ArrayList<Actor> actors) {
		boolean b = true;
		int row = this.getLocation().getRow();
		int collumn = this.getLocation().getRow();
		for (Actor i : actors) {
			int c = i.getLocation().getCol();
			int r = i.getLocation().getRow();
			// in reference to the actor
			if (collumn == c)
				if ((r == row + 1) || (r == row - 1)) { // if it is above or below, change the color
					this.setColor(i.getColor());
					b = false;
			}
		}
		if (b) {
			this.setColor(Color.BLACK); // not sure if there is a way to darken, but now it is darker
			return;
		}   
	}
}
