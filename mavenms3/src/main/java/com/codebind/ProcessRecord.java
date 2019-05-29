
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
			if ((lineRec.get(0).equalsIgnoreCase("A")) || (lineRec.get(1).equalsIgnoreCase("B")) || 
					(lineRec.get(2).equalsIgnoreCase("C"))
					|| (lineRec.get(3).equalsIgnoreCase("D")) || (lineRec.get(4).equalsIgnoreCase("E")) || 
					(lineRec.get(5).equalsIgnoreCase("F")) || (lineRec.get(6).equalsIgnoreCase("G")) || 
					(lineRec.get(7).equalsIgnoreCase("H")) || (lineRec.get(8).equalsIgnoreCase("I")) || 
					(lineRec.get(9).equalsIgnoreCase("J")))
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
