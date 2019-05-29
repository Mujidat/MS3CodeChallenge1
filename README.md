# MS3CodeChallenge1
MS3's code Challenge for entry level programmers
Run Class Main to start execution of code
It is required that you enter the path to the CSV file on your computer.
Press enter.
The console displays the successful records, failed records and total records.
The output will be in the main project folder; the output CSV file is bad-data-timestamp.csv; the data log file is data.log; the database is test.db

Approach
Accept input(csv file) from user in Class "Main"
Class "Main" instantiates Class "ReadCSVFile" and calls it to process file and read it into a list of list; returns the list of list
Class "Main" instantiates Class "ConnectDB" and calls it to setup database and create table
Class "Main" instantiates Class "ProcessCSVRecords" and calls it to separate records to successful or failed and write bad records to bad-data-timestamp.csv and return successful records
Class "Main" instantiates "WriteRecordDB" and calls it to save successful records to database and return the number of successful records
Class "Main" writes log statistics to log file
