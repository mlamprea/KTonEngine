package co.kton.engine.test;

import java.util.logging.Logger;

import co.kton.util.EngineLogger;

public class WorkerTest implements Runnable {

	private long timeSleep;
	private Logger logger = EngineLogger.getLogger();

	public WorkerTest(long timeSleep) {
		this.timeSleep = timeSleep;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeSleep);
			logger.info("Thread " + this.hashCode()
					+ " terminated after " + timeSleep + " ms.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
