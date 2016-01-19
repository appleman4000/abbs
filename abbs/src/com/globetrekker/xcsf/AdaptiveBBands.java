package com.globetrekker.xcsf;
/**
 * @author    chengen
 * @version   XCSF 1.0
 * @since     JDK1.8
 Parameter Range Max Velocity 
 Upper Band {-4,4} 0.10 
 Lower Band {-4,4} 0.10 
 MA Type {0 �?? 1} 0.10 
 Stop Loss {-0.99,0} 0.10 
 Window Size {5,500} 20
 Time period {5M,15M,30M,1H,4H,1D}
 *
 */
public class AdaptiveBBands extends Indicator {
	private static final long serialVersionUID = 3743236962708780738L;
	public double upperBand;
	public double lowerBand;
	public int maType;
	public double stopLoss;
	public int windowSize;
	public String timePeriod;
}
