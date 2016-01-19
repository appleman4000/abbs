package com.globetrekker.xcsf;
import java.io.Serializable;
import java.io.File;
import java.io.FileWriter; 
import java.io.BufferedWriter; 
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date; 

/**
 * @author    chengen
 * @version   XCSF 1.0
 * @since     JDK1.8
 */
public class XCSF implements Serializable
{
	private static final long serialVersionUID = 9098601426270833184L;

    private static Constants cons;

    private Environment environment;
    
    private Population<Indicator> population;
    
    private MatchSet<Indicator> matchSet;
    
    private PredictionArray<Indicator> predictionArray;
    private File outFile;

    /**
     * Constructs the LABBs system.
     */
    public XCSF(Environment environment)
    {
    	String outFileString="output.txt";
        outFile=new File(outFileString);
        run();
    }

    public void run()
    {
        FileWriter fW=null;
        BufferedWriter bW=null;
        PrintWriter pW = null;
        try{
            fW = new FileWriter(outFile);
            bW = new BufferedWriter(fW);
            pW = new PrintWriter(bW);
        }catch(Exception e){System.out.println("Mistake in create file Writers"+e);}

        startXCSF(pW);
    
        try{
            pW.flush();
            bW.flush();
            fW.flush();
            fW.close();
        }catch(Exception e){System.out.println("Mistake in closing the file writer!"+e);}
    }
  
    /**
     * 1) The environment at time t generates a signal St that is used as input to the population [P]. 
     * 2) The parameters of the population [P] are updated and compared to the input to identify matches. 
     * 3) A match set [M]t is created. 
     * 4) If|[M]t|< MSmin, then the covering algorithm attempts to create solutions to match St 
     * 5) The meta parameters of ABBs in the relative complement of [M]t in [M]t�???1 are updated ([M]t�???1 \ [M]t) 
     * 6) From [M]t a prediction array is formed, from which an action ai is selected 
     * 7) The action ai is performed in the environment. 
     * 8) A reward is received from the environment which is used to update the investment position of the MAG 
     */
    private void startXCSF(PrintWriter pW)
    {
            pW.println("Start XCSF");
            System.out.println("Start XCSF");
            population=new Population<Indicator>(cons.maxPopSize);
            
            while(!environment.isTerminated()){
            	environment.waitInstanceArrive();
            	SignalSet<Indicator> signalSet = new SignalSet<Indicator>(environment,population);	
            
            	MatchSet<Indicator> matchSet = new MatchSet<Indicator>(signalSet);
            
                if(matchSet.size()<cons.MSmin){
                	population.discovery(environment);
            		continue;
                }  
                PredictionArray<Indicator> predictionArray=new PredictionArray<Indicator>(matchSet);
                Action action = predictionArray.getBestAction();
                ActionSet<Indicator> actionSet  = new ActionSet<Indicator>(predictionArray,action);
                environment.sendCommand(new Command(actionSet,action){
                	@Override
                	public void response(){
                		this.getActionSet().update(this.getReward());
                		return;
                	}
                });
                signalSet=null;
                matchSet=null;
                predictionArray=null;
                actionSet=null;
            }
            population=null;
    }
}
