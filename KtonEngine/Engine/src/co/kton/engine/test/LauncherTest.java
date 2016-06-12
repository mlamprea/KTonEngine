package co.kton.engine.test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import co.kton.engine.Engine;
import co.kton.util.EngineLogger;

public class LauncherTest {

	private static Logger logger = EngineLogger.getLogger();
	
	public static void main(String[] args) {
		long idleTime;
		long maxJobs;
		long quantityThreads;
		if (args.length != 3) {
			logger.warning(("Parameters invalid Usage Engine.jar -quantityThreads -maxJobs -idleTime"));
			return;
		}
		try {
			quantityThreads = Long.parseLong(args[0]);
			maxJobs = Long.parseLong(args[1]);
			idleTime = Long.parseLong(args[2]);
			List<Thread> workers = new ArrayList<Thread>();
			for (int i = 0; i < quantityThreads; i++) {
				workers.add(new Thread(new WorkerTest((long)(1 + Math.random()*1000))));
			}
			Engine engine = new Engine(maxJobs, idleTime, workers);
			engine.execute();
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}

		
	}

}
