package com.globetrekker.xcsf;
/**
 * @author    chengen
 * @version   XCSF 1.0
 * @since     JDK1.8
 */
public class Command {	
	private Action action;
	private ActionSet<Indicator> actionSet;
	public ActionSet<Indicator> getActionSet() {
		return actionSet;
	}
	private double reward=0;
	public double getReward() {
		return reward;
	}
	public void setReward(double reward) {
		this.reward = reward;
	}
	Command(ActionSet<Indicator> actionSet, Action action){
	  this.actionSet= actionSet;
	  this.action = action;
	}
	public void response(){
		return;
	}
}
