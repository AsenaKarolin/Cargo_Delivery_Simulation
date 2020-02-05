package Util;
public class Cargo {
	private int id;
	private int loadingStation;
	private int targetStation;
	private int size;
	
	public Cargo(int id, int loadingStation, int targetStation, int size){
		this.id=id;
		this.loadingStation=loadingStation;
		this.targetStation=targetStation;
		this.size=size;
	}
	public int getSize() {
		return this.size;
	}
	public int getTargetStation(){
		return targetStation;
	}
	public int getLoadingStation() {
		return this.loadingStation;
	}
	public int getId() {
		return this.id;
	}
	@Override
	public String toString() {
		return Integer.toString(id);
	}
}