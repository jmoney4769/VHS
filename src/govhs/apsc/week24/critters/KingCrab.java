package govhs.apsc.week24.critters;

import info.gridworld.actor.Actor;

import java.util.ArrayList;

public class KingCrab extends CrabCritter {

	@Override
	public void processActors(ArrayList<Actor> arg0) {
		super.processActors(arg0); // do it twice
		super.processActors(arg0);
	}
}
