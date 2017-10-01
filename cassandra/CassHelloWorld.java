package CassHelloWorld;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class CassHelloWorld {

	public static void main(String[] args) {
		CassandraConnection conn = new CassandraConnection();
		conn.connect("192.168.0.100", "cassdba", "flynnLives");
		
		String strSELECT ="SELECT cluster_name,data_center,"
                   + "listen_address,release_version "
				   + "FROM system.local WHERE key='local'";
		
		System.out.println("Hello from:");
		ResultSet rows = conn.query(strSELECT);
		for (Row row : rows) {
		    System.out.print(
                  row.getString("cluster_name") + " " +
                  row.getString("data_center") + " " +
		    	  row.getString("release_version"));
		}		
		conn.close();
	}
}
