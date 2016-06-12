package co.kton.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EngineLogger {

	private static Logger logger;

	public static Logger getLogger() {
		new EngineLogger();
		return logger;
	}

	private EngineLogger() {
		try {
			FileHandler fileHandler = new FileHandler();
			fileHandler.setFormatter(new SimpleFormatter());
			logger = Logger.getLogger(EngineLogger.class.getName());
			logger.addHandler(fileHandler);

		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}
}
