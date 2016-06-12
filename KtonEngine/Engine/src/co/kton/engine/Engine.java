package co.kton.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Milton Lamprea
 */

public class Engine {

	private long maxJobs;
	private long idleTime;
	private List<Thread> threads;
	private List<Thread> poolThreads;
	private long count;

	public Engine(long maxJobs, long idleTime, List<Thread> threads) {
		this.maxJobs = maxJobs;
		this.idleTime = idleTime;
		this.threads = threads;
		this.poolThreads = new ArrayList<Thread>();
		this.count = 0;
	}

	public void execute() {
		for (Iterator<Thread> iterator = threads.iterator(); iterator.hasNext();) {
			Thread thread = (Thread) iterator.next();
			if (count < maxJobs - 1) {
				addPoolThreads(thread);
			} else {
				addPoolThreads(thread);
				boolean isExecuted = false;
				while (!isExecuted) {
					isExecuted = freePoolThreads();
				}
				poolThreads = new ArrayList<Thread>();
				count = 0;
			}
		}
	}

	private void addPoolThreads(Thread thread) {
		count++;
		poolThreads.add(thread);
		thread.start();
	}

	private boolean freePoolThreads() {
		boolean isFree = true;
		for (Iterator<Thread> iterator = poolThreads.iterator(); iterator
				.hasNext();) {
			Thread thread = (Thread) iterator.next();
			isFree = !thread.isAlive() && isFree;
		}
		return isFree;
	}

	public long getMaxJobs() {
		return maxJobs;
	}

	public void setMaxJobs(long maxJobs) {
		this.maxJobs = maxJobs;
	}

	public long getIdleTime() {
		return idleTime;
	}

	public void setIdleTime(long idleTime) {
		this.idleTime = idleTime;
	}

	public List<Thread> getThreads() {
		return threads;
	}

	public void setThreads(List<Thread> threads) {
		this.threads = threads;
	}

}
