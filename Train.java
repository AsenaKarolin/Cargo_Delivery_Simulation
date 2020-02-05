package CargoTrain;
import Util.Cargo;
import Util.Station;
import java.util.*;
public class Train {
	private final int carCapacity; //capacity of each carriage
	private int length; //number of total carriages
	private Carriage head;
	private Carriage tail;
	private ArrayList<Station> stations;
	private int numberOfStations;
	
	public Train (int length, int carCapacity) {
		this.carCapacity=carCapacity;
		this.length=0;
		this.head=null;
		this.tail=null;
		this.stations = new ArrayList<>();
		this.numberOfStations=0;
	}
	public int getLength() {
		return this.length;
	}
	public ArrayList<Station> getStations(){
		return this.stations;
	}
	public void addStation(Station station) {
		this.stations.add(station);
		this.numberOfStations++;
	}
	public int getNumberOfStations() {
		return this.numberOfStations;
	}
	public void addCar() {
		if (this.tail!=null) {
		this.tail.setNext(new Carriage(this.carCapacity));
		this.tail.getNext().setPrev(this.tail);
		this.tail=this.tail.getNext();
		this.length++;}
		else {
			this.head=(new Carriage(this.carCapacity));
			this.tail=this.head;
			this.length++;
		}
	}
	public void removeCar() {
		if (this.tail!=null) {
		this.tail=this.tail.getPrev();
		this.length--;
		}
		if (this.tail!=null) {
		this.tail.setNext(null);}
		if (this.tail==null) {
			this.head=null;
		}
	}
	public void load (Queue<Cargo> cargos) {
		Cargo mail;
		Carriage current;
		Boolean isLoaded;
		while (!cargos.isEmpty()) {
			mail=cargos.remove();
			isLoaded=false;
			current = head;
			while (current!=null && !isLoaded) {
				if (current.getEmptySlot()>=mail.getSize()) {
					current.push(mail);
					isLoaded=true;
				}
				else {
					current=current.getNext();
				}
			}
			if (!isLoaded) {
				this.addCar();
				this.tail.push(mail);
				isLoaded=true;
			}
		}
		if (this.tail!=null) {
		while(this.tail.getEmptySlot()==this.carCapacity) {
			this.removeCar();
			if (this.tail==null) {
				break;
			}
		}}
		
		
	}
	public void unload (Queue<Cargo> cargos) {
		Carriage current=this.head;
		while(current!=null) {
			while(current.getEmptySlot()!=this.carCapacity) {
				cargos.add(current.pop());
			}
			current=current.getNext();
		}
		
	}
}