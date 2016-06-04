/** RoundRobinSchedulingAlgorithm.java
 * 
 * A scheduling algorithm that randomly picks the next job to go.
 *
 * @author: Kyle Benson
 * Winter 2013
 *
 */
package com.jimweller.cpuscheduler;

import java.util.*;

public class RoundRobinSchedulingAlgorithm extends BaseSchedulingAlgorithm {

    /** the time slice each process gets */
    private int quantum = 10;
    private int jobNum = 0;
    private int timer = 0;
    private Vector<Process> jobs;
    
    RoundRobinSchedulingAlgorithm() {
        // Fill in this method
        /*------------------------------------------------------------*/

	activeJob = null;
	jobs = new Vector<Process>();

        /*------------------------------------------------------------*/
    }

    /** Add the new job to the correct queue. */
    public void addJob(Process p) {
        // Remove the next lines to start your implementation
        
        // Fill in this method
        /*------------------------------------------------------------*/

	jobs.add(p);

        /*------------------------------------------------------------*/
    }

    /** Returns true if the job was present and was removed. */
    public boolean removeJob(Process p) {
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

    /**
     * Get the value of quantum.
     * 
     * @return Value of quantum.
     */
    public int getQuantum() {
        return quantum;
    }

    /**
     * Set the value of quantum.
     * 
     * @param v
     *            Value to assign to quantum.
     */
    public void setQuantum(int v) {
        this.quantum = v;
    }

    /**
     * Returns the next process that should be run by the CPU, null if none
     * available.
     */
    public Process getNextJob(long currentTime) {
        // Remove the next lines to start your implementation
        
        // Fill in this method
        /*------------------------------------------------------------*/

	if(activeJob == null)
	{
		activeJob = jobs.get(0);
	}
	if(activeJob.isFinished())
	{
		if(jobNum >= jobs.size())
		{
			jobNum = 0;
			activeJob = jobs.get(jobNum);
			timer = 0;
		}
		else if(jobs.get(jobNum).isActive() == false)
		{
			activeJob = jobs.get(jobNum);
			timer = 0;
		}
		else
		{
			activeJob = jobs.get(jobNum);
			timer = 0;
		}
	}
	if(timer == quantum && !isJobFinished())
	{

		if(jobNum  >= jobs.size())
		{
			jobNum = 0;
			activeJob = jobs.get(jobNum);
			timer = 0;
		}
		else
		{
			
			jobNum++;
			if(jobNum >= jobs.size())
			{
				jobNum = 0;
			}
			activeJob = jobs.get(jobNum);
			timer = 0;
		}
	}
	timer++;
	return activeJob;
			

        /*------------------------------------------------------------*/
    }

    public String getName() {
        return "Round Robin";
    }
    
}
