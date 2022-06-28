package com.projectname.backend.util;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LogBackEnd {

	private static Logger log = LogManager.getRootLogger();

	public enum TypeLog {
		INFO, DEBUG, WARN, ERROR
	}

	public static void log(TypeLog type, String message, Exception error) {

		switch (type) {

		case INFO:
			log.info(message);
			break;

		case DEBUG:
			log.debug(message);
			break;

		case WARN:
			log.warn(message);
			break;

		case ERROR:
			log.error(message);
			break;

		default:
			log.debug(message);
			break;

		}

	}

}
