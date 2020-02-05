package Main;
import java.io.*;
import java.util.*;
import CargoTrain.Train;
import Util.Station;
import Util.Cargo;
public class Main{
	
	public static Train readAndInitialize(String[] args) throws FileNotFoundException{
		File inputFile = new File(args[0]);
		File outputFile = new File(args[1]);
		Scanner scanner = new Scanner(inputFile);
		Train Tr= new Train(scanner.nextInt(), scanner.nextInt());
		PrintStream ps= new PrintStream(outputFile);
		int numberOfStations = scanner.nextInt();
		int cargoId;
		int cargoLoad;
		for (int i=0; i<numberOfStations; i++) {
			Tr.addStation(new Station(i,ps));
		}
		while (scanner.hasNext()) {
			cargoId=scanner.nextInt();
			cargoLoad=scanner.nextInt();
			Tr.getStations().get(cargoLoad).addToQueue(new Cargo(cargoId,cargoLoad,scanner.nextInt(),scanner.nextInt()));
		}
		scanner.close();
		return Tr;
		
	}
	public static void execute(Train train) {
		for (int i=0; i<train.getNumberOfStations(); i++) {
			train.getStations().get(i).process(train);
		}
		
	}
	public static boolean OutputsEqual(String f1, String f2) throws Exception
	{
		Scanner s1 = new Scanner(new File(f1));
		Scanner s2 = new Scanner(new File(f2));
		
		while(s1.hasNext() && s2.hasNext())
		{
			if(!s1.next().equals( s2.next()))
			{
				s1.close();
				s2.close();
				return false;
			}
		}
		s1.close();
		s2.close();
		return true;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		
		execute(readAndInitialize(args));	
		
		
	}
}