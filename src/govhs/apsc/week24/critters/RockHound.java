package govhs.apsc.week24.critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class RockHound extends Critter {

	@Override
	public void processActors(ArrayList<Actor> arg0) {
		super.processActors(arg0);
		ArrayList<Location> locations = this.getGrid().getOccupiedLocations();
		for (Location i : locations)
			if (this.getGrid().get(i) instanceof Rock)
				this.getGrid().remove(i);
		
	}
}
