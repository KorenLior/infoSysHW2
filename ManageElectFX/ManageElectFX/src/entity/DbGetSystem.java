package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DbGetSystem {

	public DbGetSystem() {
		// TODO Auto-generated constructor stub
	}
	private ConstsDbSystem dbConsts = new ConstsDbSystem();
	
	
	
	public static SystemInfo getSystem() {
	
		String partyName = null;
		int managerId = -5555;
		Time startTime = null; 
		Time endTime = null;
		Calendar electionCalendarStart = null;
		Calendar electionCalendarEnd = null;
		 try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsDbSystem.CONN_STR);
			
			 PreparedStatement stmt = conn.prepareStatement(ConstsDbSystem.SQL_SEL_SYSTEM);
			
			 ResultSet rs = stmt.executeQuery()) {
			
			 int i = 1;
			 int ser = rs.getInt(i++);
			 partyName = rs.getString(i++);
			 managerId = rs.getInt(i++);
			 startTime = rs.getTime(i++, electionCalendarStart);
			 startTime = rs.getTime(i++, electionCalendarEnd);
			 
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}
		SystemInfo results = new SystemInfo(partyName, managerId, startTime, endTime, electionCalendarStart);
		return results;
	}

}
