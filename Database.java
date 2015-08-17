import java.util.ArrayList;
import java.util.List;

public class Database {
	String name;
	ArrayList <Person> myPlayerList = new ArrayList <Person>(); 
	
	public Database (String name)
	{
		this.name = name;
	}
	public void addPlayer (Person currPerson)
	{
		myPlayerList.add(currPerson);
	}
	public boolean hasPlayer (String currPlayer)
	{
		for (Person i: myPlayerList)
		{
			if (i.name.equals(currPlayer))
			{
				return true;
			}
		}
		return false;
	}
	public Person getPlayer (String currPlayer)
	{
		for (Person i: myPlayerList)
		{
			if (i.name.equals(currPlayer))
			{
				return i;
			}
		}
		return null;
	}
}

