package com.codebind;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class WriteLog {
	public void writeLog(int succeed, int rcvd, int failed) {

        // write logs to a log file
        Logger log = Logger.getLogger(Main.class.getName());
        FileHandler fileHandler;
		try {
			fileHandler = new FileHandler("data.log", true);
			log.addHandler(fileHandler);
	        log.info("Number of records received in csvfile was " + rcvd + " number of records successful was " + 
			succeed + " number of records failed was " + failed);
		} catch (IOException e) {			
			e.printStackTrace();
		}
        
	}
}
