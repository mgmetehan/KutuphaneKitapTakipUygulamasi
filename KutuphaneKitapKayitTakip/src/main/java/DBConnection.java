import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnection {
	private static final Logger logger = LogManager.getLogger();

	public static Connection getConnection() {// Baglanti baslatiyor
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.warn("Mysql Driver Bulunamad�! Hata: " + e);
		}

		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_kutuphane?", "root",
					"toor");
			logger.info("Mysql Ba�lant�s� Ba�ar�l�");
		} catch (SQLException e) {
			e.printStackTrace();
			logger.info("Mysql Ba�lant�s� Ba�lat�lmad�!!");
		}
		return connection;
	}

	public static void closeConnection(Connection connection, PreparedStatement preparedStatement) {// Baglanti
																									// Kapatildi
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
				logger.warn("PreparedStatement Kapat�ld�");
			} catch (SQLException e) {
				logger.warn("PreparedStatement Kapat�l�rken Hata Olu�tu " + e);
			}
		}

		if (connection != null) {
			try {
				connection.close();
				logger.info("Ba�lant� Ba�ar�l� �ekilde Kapat�ld�");
			} catch (SQLException e) {
				logger.warn("Ba�lant� Kapan�rken Bir Hata Olu�tu");
			}

		}
	}


}
