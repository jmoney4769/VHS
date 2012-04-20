package govhs.apsc.week24.firstProject;

/*
Group: Silver Group
*/
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
//There was quite a bit to import there, I think i got everything.

public class Jump extends Bug
{
	public Jump(Color actColor)
	{
		setColor(actColor);
	}

	public Jump()
	{
		setColor(Color.BLUE);
	}



	public void act()
	{
		if(canMove())
		{
			move();
		}
		else
			turn();
	}

	public void move()
	{
		Grid<Actor> plane = getGrid();

		Location local 	 = getLocation();
		Location one = local.getAdjacentLocation(getDirection());
		Location two = one.getAdjacentLocation(getDirection());

		if(plane.isValid(two))
		{
			moveTo(two);
		}

		else{
			removeSelfFromGrid();
		}
	}


	public boolean canMove()
	{
		Grid<Actor> plane = getGrid();

		if (plane != null) {
		Location local 	 = getLocation();
		Location one = local.getAdjacentLocation(getDirection());
		Location next = one.getAdjacentLocation(getDirection());

		Actor act = plane.get(next);

		if(plane.isValid(next)==false)
			return false;

		if((act==null)||(act instanceof Flower))
			return true;

		else
			return true;
		}
		return false;
	}

}

