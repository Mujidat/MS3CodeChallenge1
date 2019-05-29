
package com.codebind;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ProcessRecord {
	static String filename = "bad-data-timestamp.csv";
	String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
	String header = "A, B, C, D, E, F, G, H, I, J";
	
	public List<LineRecord> processRecords (List<List<String>> fileElements) throws IOException {
		List<LineRecord> lineRecords = null;
		filename.replace("timestamp", "time");
		if (fileElements.size() > 0) {
			//try (BufferedWriter buffer = new BufferedWriter(new FileWriter(filename))) {
				BufferedWriter buffer = new BufferedWriter(new FileWriter(filename));
				lineRecords = new ArrayList<LineRecord>(fileElements.size());
                buffer.write(header);
                buffer.write("\n");
                for (int i = 0; i < fileElements.size(); i++) {
                	List<String> fileLine = fileElements.get(i);
                    LineRecord records = processLineRecord(fileLine);
                    if (records != null) {
                        lineRecords.add(records);
                    } else {
                        writeBadRecords(fileLine,buffer);
                    }
                
            }
      //  } catch (IOException e) {
       //     System.out.println(e.getMessage());
       // }
		}																
		return lineRecords;
	}
	
	public LineRecord processLineRecord(List<String> lineRec) {
		LineRecord record = new LineRecord();
		//String recordElement = "";
		if (lineRec.size() == 10) {
			if ((StringUtils.isEmpty(lineRec.get(0)) )|| (StringUtils.isEmpty(lineRec.get(1)) )|| (StringUtils.isEmpty(lineRec.get(2)) )||(StringUtils.isEmpty(lineRec.get(3)) )||(StringUtils.isEmpty(lineRec.get(4)) )||(StringUtils.isEmpty(lineRec.get(5)) )
					||(StringUtils.isEmpty(lineRec.get(6)) )||(StringUtils.isEmpty(lineRec.get(7)) )||(StringUtils.isEmpty(lineRec.get(8)) )||(StringUtils.isEmpty(lineRec.get(9)) ))
				return null;
			record.setA(lineRec.get(0));
			record.setB(lineRec.get(1));
			record.setC(lineRec.get(2));
			record.setD(lineRec.get(3));
			record.setE(lineRec.get(4));
			record.setF(lineRec.get(5));
			record.setG(lineRec.get(6));
			if("true".equalsIgnoreCase(lineRec.get(7)))
				record.setH(true);
			else if("false".equalsIgnoreCase(lineRec.get(7)))
				record.setH(false);
			
			if("true".equalsIgnoreCase(lineRec.get(8)))
				record.setI(true);
			else if("false".equalsIgnoreCase(lineRec.get(8)))
				record.setI(false);
			record.setJ(lineRec.get(9));
			//recordElement = lineRec.get(0);
//			if(!StringUtils.isEmpty(recordElement)) {
//				record.setA(recordElement);
//			}
//			else {
//				return null;
//			}
//			recordElement = lineRec.get(1);
//			if(!StringUtils.isEmpty(recordElement)) {
//				record.setB(recordElement);
//			}
//			else {
//				return null;
//			}
//			recordElement = lineRec.get(2);
//			if(!StringUtils.isEmpty(recordElement)) {
//				record.setC(recordElement);
//			}
//			else {
//				return null;
//			}
//			recordElement = lineRec.get(3);
//			if(!StringUtils.isEmpty(recordElement)) {
//				record.setD(recordElement);
//			}
//			else {
//				return null;
//			}
//			recordElement = lineRec.get(4);
//			if(!StringUtils.isEmpty(recordElement)) {
//				record.setE(recordElement);
//			}
//			else {
//				return null;
//			}
//			recordElement = lineRec.get(5);
//			if(!StringUtils.isEmpty(recordElement)) {
//				record.setF(recordElement);
//			}
//			else {
//				return null;
//			}
//			recordElement = lineRec.get(6);
//			if(!StringUtils.isEmpty(recordElement)) {
//				record.setG(recordElement);
//			}
//			else {
//				return null;
//			}
//			recordElement = lineRec.get(7);
//			if(!StringUtils.isEmpty(recordElement)) {
//				if("true".equalsIgnoreCase(recordElement))
//					record.setH(true);
//				else if("false".equalsIgnoreCase(recordElement))
//					record.setH(false);
//				else
//					return null;
//			}
//			else {
//				return null;
//			}
//			recordElement = lineRec.get(8);
//			if(!StringUtils.isEmpty(recordElement)) {
//				if("true".equalsIgnoreCase(recordElement))
//					record.setI(true);
//				else if("false".equalsIgnoreCase(recordElement))
//					record.setH(false);
//				else
//					return null;
//			}
//			else {
//				return null;
//			}
//			recordElement = lineRec.get(9);
//			if(!StringUtils.isEmpty(recordElement)) {
//				record.setJ(recordElement);
//			}
//			else {
//				return null;
//			}
		return record;
		}
		return null;
	}
	public static void writeBadRecords(List<String> content, BufferedWriter writer) throws IOException {
        for (String i:content) {
        	writer.write(i);
        }
        writer.write("\n");
    }

}
