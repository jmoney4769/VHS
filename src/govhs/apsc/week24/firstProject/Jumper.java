package govhs.apsc.week24.firstProject;

/* Group:	Silver Group
 * Date:	Friday 20 April, 2012
 * Project:	Jumper Class
 */
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Jumper extends Bug {

	/*	Author:  Jared Moore
	 *	Precondition:	The Jumper wants to move
	 *	Postcondition:	The Jumper will move the appropriate amount of spaces or turn
	 */
	@Override
	public void move() {
		Grid<Actor> grid = getGrid();
		if (grid != null) {
			if (canMove()) 
				moveTo(getLocation().getAdjacentLocation(getDirection()).
						getAdjacentLocation(getDirection())); // move two spaces
			else if ((grid.isValid((getLocation().
					getAdjacentLocation(getDirection())))) && ((grid.get(getLocation().
							getAdjacentLocation(getDirection())) 
						instanceof Flower) || (grid.get(getLocation().getAdjacentLocation(getDirection())
								) == null)))
					moveTo(getLocation().getAdjacentLocation(getDirection())); 
					// "bounce back of the two spaces in front and move one forward
			else {
				turn();
				turn(); // turn 90 degrees and continue
			}
		}
	}
	/*	Author:	Jacob Watson
	 * 	Precondition:	The Jumper needs to know if there is anything in the way
	 * 	Postcondition:	The Jumper will know if there is anything in the spot two in front
	 */
	@Override
	public boolean canMove()
	{
		Grid<Actor> plane = getGrid();

		if (plane != null) { // cannot perform any of this on a null grid
		Location local 	 = getLocation();
		Location one = local.getAdjacentLocation(getDirection());
		Location next = one.getAdjacentLocation(getDirection());


		if(plane.isValid(next)) {	// cannot get location of an invalid location		

			Actor act = plane.get(next);
			if((act==null)||(act instanceof Flower))
				return true;
			}
		}
		return false; // return false as a default, only true if it should be
	}
	
	/*	Author:	Jared Moore
	 *	Precondition:	The Jumper is doing nothing
	 *	Postcondition:	The Jumper is calling the move() method
	 */
	@Override
	public void act() {
		move(); // method handles everything that needs to be done, including turning
	}
}
