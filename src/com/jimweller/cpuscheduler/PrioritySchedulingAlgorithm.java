/** PrioritySchedulingAlgorithm.java
 * 
 * A single-queue priority scheduling algorithm.
 *
 * @author: Charles Zhu
 * Spring 2016
 *
 */
package com.jimweller.cpuscheduler;

import java.util.*;

import com.jimweller.cpuscheduler.Process;

public class PrioritySchedulingAlgorithm extends BaseSchedulingAlgorithm implements OptionallyPreemptiveSchedulingAlgorithm {

    private Vector<Process> jobs;
    private boolean isPreempt = false;
    PrioritySchedulingAlgorithm(){
        // Fill in this method
        /*------------------------------------------------------------*/
	activeJob = null;	
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
	if(isPreempt == true)
        {
                long highPriority = Long.MAX_VALUE;
                for(int i = 0; i < jobs.size(); i++)
                {
                        if(jobs.get(i).getPriorityWeight() < highPriority)
                        {
                                highPriority = jobs.get(i).getPriorityWeight();
                                activeJob = jobs.get(i);
                        }
                        else if(jobs.get(i).getPriorityWeight() == highPriority)
                        {
                                if(jobs.get(i).getPID() < activeJob.getPID())
                                {
                                        activeJob = jobs.get(i);
                                }
                        }
                }
        }
        else if(isPreempt == false)
        {
                long highPriority = Long.MAX_VALUE;
                activeJob = jobs.get(0);
                for(int i = 0; i < jobs.size(); i++)
                {
                        if(activeJob.isActive() != true)
                        {
                                if(jobs.get(i).getPriorityWeight() < highPriority)
                                {
                                        highPriority = jobs.get(i).getPriorityWeight();
                                        activeJob = jobs.get(i);
                                }
                                else if(jobs.get(i).getPriorityWeight() == highPriority)
                                {
                                        if(jobs.get(i).getPID() < activeJob.getPID())
                                        {
                                                activeJob = jobs.get(i);
                                        }
                                }
                        }
                }
        }
        return activeJob;



        /*------------------------------------------------------------*/
    }

    public String getName(){
        return "Single-Queue Priority";
    }

    /**
     * @return Value of preemptive.
     */
    public boolean isPreemptive(){
        // Remove the next lines to start your implementation
        
        // Fill in this method
        /*------------------------------------------------------------*/

	return isPreempt;

        /*------------------------------------------------------------*/
    }
    
    /**
     * @param v Value to assign to preemptive.
     */
    public void setPreemptive(boolean v){
        // Remove the next lines to start your implementation
        
        // Fill in this method
        /*------------------------------------------------------------*/

	isPreempt = v;

        /*------------------------------------------------------------*/
    }
    
}
