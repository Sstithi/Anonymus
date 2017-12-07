public class stationzones
{
	public static void main (String[]args)
	{
		boolean quit = false;
		StationDatabase sdb = new StationDatabase();
		
		sdb = createStationDataBase();
		String choice = getChoice();
		while (quit == false)
		{
			if (choice.equals("Add"))
				sdb  = addEntry(sdb);
			else if (choice.equals("Find"))
				findEntry(sdb);
			else if (choice.equals("Quit"))
				quit = true;
		}
		System.exit(0);
		
	}

	public static StationDatabase createStationDataBase() {
	StationDatabase sdb = new StationDatabase();
		// TODO Auto-generated method stub
		sdb.stationarray = new Station[10];
		return sdb;
	}
}