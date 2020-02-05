package CargoTrain;
import Util.Cargo;
import java.util.*;
public class Carriage {
	private int emptySlot;
	private Stack<Cargo> cargos;
	private Carriage next;
	private Carriage prev;
	
	public Carriage(int capacity) {
		this.emptySlot=capacity;
		this.next=null;
		this.prev=null;
		this.cargos= new Stack<>();
	}
	public boolean isFull() {
		if (emptySlot==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void push(Cargo cargo) {
		this.cargos.push(cargo);
		this.emptySlot=this.emptySlot-cargo.getSize();
	}
	public Cargo pop() {
		Cargo toBePoped=this.cargos.pop();
		this.emptySlot=this.emptySlot+toBePoped.getSize();
		return toBePoped;
	}
	public Carriage getNext() {
		return this.next;
	}
	public Carriage getPrev() {
		return this.prev;
	}
	public void setNext(Carriage car) {
		this.next=car;
	}
	public void setPrev(Carriage car) {
		this.prev=car;
	}
	public int getEmptySlot() {
		return this.emptySlot;
	}
	public void setEmptySlot(int remain) {
		this.emptySlot=remain;
	}
}