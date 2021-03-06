# CPU-Scheduling-Algorithms
# Algorithms

#1. First-Come, First-Serve Scheduling (FCFS Scheduler)

FCFS is a non-preemptive scheduling algorithm that schedules processes in the order they arrive. For a detailed description of this algorithm please refer to the course book, page 266.
There may be multiple processes with the same arrival time. See below on how to break a tie.
There will not be any entries for process share in the input file.

#2. Shortest Remaining Time First Scheduling (aka Preemptive SJF)

SRTF is a preemptive version of the shortest job first (SJF) scheduling algorithm. In this scheduling algorithm, the process with the smallest amount of time remaining until completion is selected to execute. For a detailed description of this algorithm please refer to the course book, starting on page 269 with last paragraph.
There may be multiple processes with the same arrival time OR with the same burst time, but not both. See below on how to break a tie.
There will not be any processes with same remaining time at the same CPU time. Example is say if we have a process A arriving at time 0 with a burst time of 5, then we will not have a process B arriving at time 2 with a burst time of 3 since at time=2, both A and B will have the same remaining time.
There will not be any entries for process share in the input file.

#3. Proportional Share Scheduling (PS Scheduler)

This will be a bonus credit to the assignment.
PS is a type of scheduling which pre-allocates certain amount of CPU time to each of the processes. In a proportional share algorithm every job has a weight, and jobs receive a share of the available resources proportional to the weight of every job. For a detailed description of this algorithm please refer to the course book, page 289.
Take total shares to be 100.
A process will not be run unless it is completely given the requested share. Example is say we have process D which requests 30 shares, however system only has 25 shares available. Then, an admission controller would deny D entry into the system. D will be run when there are at least 30 shares available.