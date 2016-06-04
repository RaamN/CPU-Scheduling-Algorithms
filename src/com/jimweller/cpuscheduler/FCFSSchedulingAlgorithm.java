/** FCFSSchedulingAlgorithm.java
 * 
 * A first-come first-served scheduling algorithm.
 *
 * @author: Charles Zhu
 * Spring 2016
 *
 */
package com.jimweller.cpuscheduler;

import java.util.*;

public class FCFSSchedulingAlgorithm extends BaseSchedulingAlgorithm {

    private Vector<Process> jobs;
    private Random rand; 
    FCFSSchedulingAlgorithm()
    {        // Fill in this method
        /*------------------------------------------------------------*/
	activeJob = null;
	rand = new Random();
	jobs = new Vector<Process>();


        /*------------------------------------------------------------*/
    }

    /** Add the new job to the correct queue.*/
    public void addJob(Process p){
        // Remove the next lines to start your implementation
        
        // Fill in this method
        /*------------------------------------------------------------*/
	jobs.add(p);


        /*------------------------------------------------------------*/
    }
    
    /** Returns true if the job was present and was removed. */
    public boolean removeJob(Process p){
        // Remove the next lines to start your implementation

        // Fill in this method
        /*------------------------------------------------------------*/
	return jobs.remove(p);


        /*------------------------------------------------------------*/
    }

    /** Transfer all the jobs in the queue of a SchedulingAlgorithm to another, such as
    when switching to another algorithm in the GUI */
    public void transferJobsTo(SchedulingAlgorithm otherAlg) {
        throw new UnsupportedOperationException();
    }

    /** Returns the next process that should be run by the CPU, null if none available.*/
    public Process getNextJob(long currentTime){
        // Remove the next lines to start your implementation
        
        // Fill in this method
        /*------------------------------------------------------------*/
	long shortestArrivalTime = Long.MAX_VALUE; 
	for(int i = 0; i < jobs.size(); i++)
	{
		if(jobs.get(i).getArrivalTime() < shortestArrivalTime)
		{
			shortestArrivalTime = jobs.get(i).getArrivalTime();
			activeJob = jobs.get(i);
		}	
		else if(jobs.get(i).getArrivalTime() == shortestArrivalTime)
		{
			if(jobs.get(i).getPID() < activeJob.getPID())
			{
				activeJob = jobs.get(i);
			}	
		}
	}
	return activeJob;
	

        /*------------------------------------------------------------*/
    }

    public String getName(){
        return "First-Come First-Served";
    }
    
}
