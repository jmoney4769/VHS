package govhs.apsc.week24.critters;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter {

	private int c = 0;
	
	public BlusterCritter(int c) {
		super();
		setC(c);
	}
	
	public void setC(int c) {
		this.c = c;
	}
	
	public int getC() {
		return c;
	}
	
	@Override
	public void processActors(ArrayList<Actor> arg0) {
		if (arg0.size() < c)
			setColor(Color.WHITE); // brighter :)
		else
			setColor(Color.BLACK); // darker
	}
	
	@Override
	public ArrayList<Actor> getActors() {
		Location here = this.getLocation(); // store critters location
		ArrayList<Actor> array = new ArrayList<Actor>(); // hold the actors
		for (int i = here.getCol() - 2; i <= here.getCol() + 2; i++) // loop through possible columns
			for (int j = here.getRow() - 2; i <= here.getRow() + 2; j++) // loop through possible rows
				if ((getGrid().get(new Location(j, i)) != null) && !(new Location(j, i).equals(here)))
					// if there is something and it is not the bluster critter
					array.add(getGrid().get(new Location(j, i))); // add it to the array
		return array;
	}
}
