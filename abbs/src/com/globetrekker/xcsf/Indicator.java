package com.globetrekker.xcsf;
import java.io.Serializable;
import java.util.Date;

import com.globetrekker.xcsf.Action.ActionType;

/**
 * @author    chengen
 * @version   XCSF 1.0
 * @since     JDK1.8
 */

public abstract class Indicator implements Serializable {
	private static final long serialVersionUID = 1168319006808893927L;
	public String id="";
	public Action action;
	public Date createDate;
	public Date modifyDate;
	//Reputation is an expectation of how long an Indicator will remain effective (meet the match set criteria) after it becomes a member of [M]. 
	public Date reputation;
    //Duration is the current count of how long the XClassifier has been present in [M] and is used, alongwithreputation,toconstructthepredictionarray.
	public Date duration;
    //Finally, effectiveness is a count of the total number of times an XClassifier has been in [M], this parameter is used for deleting ABBs from [P] that never prove to be useful. 
	public int  effectiveness;
	public double profit;
	public double accuracy;
	
}
