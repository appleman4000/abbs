package com.globetrekker.xcsf;
import java.io.Serializable;
import java.util.Date;


/**
 * @author    chengen
 * @version   XCSF 1.0
 * @since     JDK1.8
 */
public abstract class Environment implements Serializable{

	private static final long serialVersionUID = -1938193484616872698L;
	private boolean terminated;
	private int numActions;
	public int getNumActions() {
		return numActions;
	}

	public void setNumActions(int numActions) {
		this.numActions = numActions;
	}

	public Environment() {
		// TODO Auto-generated constructor stub
	}

	public Date getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void sendCommand(Command command) {
		// TODO Auto-generated method stub
		
	}

	public synchronized void waitInstanceArrive() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return;

	}

	public synchronized void notifyInstanceArrive() {
        this.notify();
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void setTerminated(boolean terminated) {
		this.terminated = terminated;
	}

}
