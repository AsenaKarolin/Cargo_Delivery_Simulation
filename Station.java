package Util;
import java.util.*;
import java.io.*;
import CargoTrain.Train;
public class Station {
	private int id;
	private Queue<Cargo> cargoQueue;
	private PrintStream ps;
	
	public Station(int id, PrintStream ps){
		this.id=id;
		this.cargoQueue= new LinkedList<Cargo>();
		this.ps=ps;
	}
	public void addToQueue(Cargo crg) {
		this.cargoQueue.add(crg);
	}
	public void process(Train train) {
		Queue<Cargo> transfer = new LinkedList<Cargo>();
		Queue<Cargo> remain = new LinkedList<Cargo>();
		Cargo current;
		Cargo toBePrinted;
		train.unload(this.cargoQueue);
		while (!this.cargoQueue.isEmpty()) {
			current=cargoQueue.remove();
			if (current.getTargetStation()==this.id) {
				remain.add(current);
			}
			else {
				transfer.add(current);
			}
		}
		train.load(transfer);
		while (!remain.isEmpty()) {
			toBePrinted=remain.remove();
			cargoQueue.add(toBePrinted);
			ps.println(toBePrinted.getId() +" "+ toBePrinted.getLoadingStation() +" "+ toBePrinted.getTargetStation() +" "+ toBePrinted.getSize());
		}
		ps.println(this.id +" "+ train.getLength());
		
	}
}