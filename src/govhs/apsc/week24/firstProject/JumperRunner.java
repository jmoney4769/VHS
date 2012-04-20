package govhs.apsc.week24.firstProject;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;

public class JumperRunner {

	public static void main(String[] args) {
		
		ActorWorld world = new ActorWorld();
		world.add(new Jumper());
		world.add(new Rock());
		world.show();
	}
}
