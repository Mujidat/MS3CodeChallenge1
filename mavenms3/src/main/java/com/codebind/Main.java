package com.codebind;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException, SQLException {

		Scanner sc = new Scanner(System.in); // initialize scanner to take csv filename from user
        System.out.println("Please enter your csv file name");
        String csvfile = sc.nextLine(); // take csv file input
        List<List<String>> fileElements = new ArrayList<List<String>>();
        int succeed; int failed; int rcvd;
        ReadCSVFile GetFileElements = new ReadCSVFile();
        fileElements = GetFileElements.readFile(csvfile);
        ConnectDB ConnectToDB = new ConnectDB();
        ConnectToDB.createTable();
        rcvd = fileElements.size();
        ProcessRecord ProcessCSVRecords = new ProcessRecord();
        List<LineRecord> successfulRecs = new ArrayList<LineRecord>();
        successfulRecs = ProcessCSVRecords.processRecords(fileElements);
    //    System.out.println(fileElements.get(0).get(0));
     //   System.out.print(successfulRecs.get(0).getA());
        WriteRecordDB completeRecs = new WriteRecordDB();
        succeed = completeRecs.insertRecord(successfulRecs);
        failed = rcvd - succeed;
        WriteLog WriteToLog = new WriteLog();
        WriteToLog.writeLog(succeed, rcvd, failed);
   //     System.out.println("Succeed, Failed, Rcvd " + succeed + " " + failed +" " + rcvd);

    }

}
