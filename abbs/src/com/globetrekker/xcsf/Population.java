package com.globetrekker.xcsf;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author    chengen
 * @version   XCSF 1.0
 * @since     JDK1.8
 */
public class Population<T> extends ArrayList<T>{

	public Population(int maxpopsize) {
		super(maxpopsize);
	}
	private static final long serialVersionUID = 1326061483981456487L;
	public int nrActions=0;
	public void discovery(Environment environment) {
		// TODO Auto-generated method stub
		
	}

}
