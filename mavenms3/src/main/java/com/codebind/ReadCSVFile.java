package com.codebind;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

public class ReadCSVFile {
	public List<List<String>> readFile(String csvFile) {
		List<List<String>> fileLines = new ArrayList<List<String>>();
		CSVReader reader = null;
		int rcvd =0;
	        try {
	            reader = new CSVReader(new FileReader(csvFile));
	            String[] line;
	            line = reader.readNext(); //skip header line
	            while ((line = reader.readNext()) != null) {	              
	            	fileLines.add(Arrays.asList(line));
	            	//System.out.println("Line " + rcvd + "contains " +fileLines.get(rcvd).size());
	            	rcvd+=1;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return fileLines;
	}
}
