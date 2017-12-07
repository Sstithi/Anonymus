import java.util.Scanner;

public class stationzones
{
	public static void main (String[]args)
	{
		String name="";
		int zone=0;
		boolean quit = false;
		StationDatabase sdb = new StationDatabase();
		Station s = new Station();
		
		sdb = createStationDataBase();
		
		while (quit == false)
		{
			String choice = getChoice();
			if (choice.equals("Add"))
			{
				sdb  = addEntry(sdb,name,zone,s);
			}
			else if (choice.equals("Find"))
			{
				findEntry(sdb);
			}
			else if (choice.equals("Quit"))
			{
				quit = true;
		}
		}
		System.exit(0);
		
	}

	private static String getChoice() {
		// TODO Auto-generated method stub
		
		return input ("Choose Add, Find or Quit");
	}

	private static String input(String m) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		System.out.println(m);
		return sc.nextLine();
	}

	public static void findEntry(StationDatabase sdb) {
		// TODO Auto-generated method stub
		String key = input("What should I find?");
		int zone = getZoneOfStation(sdb,key);
		if (zone==-1)
			System.out.println("No Idea");
		else
			System.out.println("It is in zone " + zone);
		
	}

	private static int getZoneOfStation(StationDatabase sdb, String key) {
		// TODO Auto-generated method stub
		int zone = searchstation(sdb.stationarray,sdb.nextfree,key);
		return zone;
	}

	private static int searchstation(Station[] stationarray, int nextfree, String key) {
		// TODO Auto-generated method stub
		for (int i=0;i<nextfree;i++)
		{
			if (getStation(stationarray[i]).equals(key))
				return getZone(stationarray[i]);
		}
		return -1;
	}

	public static StationDatabase addEntry(StationDatabase sdb, String name, int zone,Station s) {
		// TODO Auto-generated method stub
		name = input("What is the name of the station?");
		zone = Integer.parseInt(input("What is the zone of the station?"));
		s = createStation(name,zone,s);
		addtoStationDataBase(sdb,s);
		return sdb;
		
	}

	private static StationDatabase addtoStationDataBase(StationDatabase sdb, Station s) {
		// TODO Auto-generated method stub
	Station [] sarray = sdb.stationarray;
	if (sdb.nextfree<sarray.length)
	{
	sdb.stationarray[sdb.nextfree]= s;
	sdb.nextfree = sdb.nextfree +1;
	}
	return sdb;
	}

	public static Station createStation(String name, int zone,Station s) {
		// TODO Auto-generated method stub
		s = setStation(s,name);
		s= setZone(s,zone);
		return s;
	}
private static Station setZone(Station s, int zone) {
		// TODO Auto-generated method stub
	s.zone = zone;
		return s;
	}

private static Station setStation(Station s, String name) {
		// TODO Auto-generated method stub
	s.station = name;
		return s;
	}

public static String getStation(Station s)
{
	return s.station;
}
public static int getZone(Station s)
{
	return s.zone;
}
	public static StationDatabase createStationDataBase() {
	StationDatabase sdb = new StationDatabase();
		// TODO Auto-generated method stub
		sdb.stationarray = new Station[10];
		sdb.nextfree =0;
		return sdb;
	}
	
}