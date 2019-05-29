package com.codebind;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WriteRecordDB {
	public static int insertRecord(List<LineRecord> correctFileElements) {
        int succeed = 0;
        String url = "jdbc:sqlite:test.db";
        String sql = "INSERT INTO csvFileRecord(A,B,C,D,E,F,G,H,I,J) VALUES(?,?, ?,?, ?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
          //  System.out.println("total number of records is " + fileElements.size());
            for (int m = 1; m < correctFileElements.size(); m++) {
                // write to database
            	conn.setAutoCommit(false);
                    
                    pstmt.setString(1, correctFileElements.get(m).getA());
                    pstmt.setString(2, correctFileElements.get(m).getB());
                    pstmt.setString(3, correctFileElements.get(m).getC());
                    pstmt.setString(4, correctFileElements.get(m).getD());
                    pstmt.setString(5, correctFileElements.get(m).getE());
                    pstmt.setString(6, correctFileElements.get(m).getF());
                    pstmt.setString(7, correctFileElements.get(m).getG());
                    pstmt.setBoolean(8, correctFileElements.get(m).getH());
                    pstmt.setBoolean(9, correctFileElements.get(m).getI());
                    pstmt.setString(10, correctFileElements.get(m).getJ());
                    pstmt.executeUpdate();
                    succeed += 1;
            }
            System.out.println("Records Inserted");
            conn.commit();
            conn.close();
            System.out.println("Records Inserted");
        } catch (SQLException msg) {
            System.out.println(msg.getMessage());
        }
        return succeed;
    }
}
