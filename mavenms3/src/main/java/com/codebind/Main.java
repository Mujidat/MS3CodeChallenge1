package com.codebind;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

        String csvFile = "C:\\Users\\tawla\\OneDrive\\Desktop\\MJ\\ms3\\ms3Interview.csv";
        List<List<String>> fileElements = new ArrayList<List<String>>();
        int succeed; int failed; int rcvd;
        ReadCSVFile GetFileElements = new ReadCSVFile();
        fileElements = GetFileElements.readFile(csvFile);
        ConnectDB ConnectToDB = new ConnectDB();
        ConnectToDB.createTable();;
        rcvd = fileElements.size();
        ProcessRecord ProcessCSVRecords = new ProcessRecord();
        List<LineRecord> successfulRecs = new ArrayList<LineRecord>();
        successfulRecs = ProcessCSVRecords.processRecords(fileElements);
        succeed = successfulRecs.size();
        failed = rcvd - succeed;
        WriteLog WriteToLog = new WriteLog();
        WriteToLog.writeLog(succeed, rcvd, failed);
   //     System.out.println("Succeed, Failed, Rcvd " + succeed + " " + failed +" " + rcvd);

    }

}
