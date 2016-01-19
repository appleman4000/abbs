package com.globetrekker.xcsf;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author    chengen
 * @version   XCSF 1.0
 * @since     JDK1.8
 */
public class PredictionArray<T> extends ArrayList<T> {

	public PredictionArray(MatchSet<Indicator> matchSet) {
		// TODO Auto-generated constructor stub
	}
	public Action getBestAction(){
		return new Action();
	}

}
