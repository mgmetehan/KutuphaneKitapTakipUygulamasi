import java.sql.*;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBProcesses {
	private static final Logger logger = LogManager.getLogger();

	public static void saveKitap(Kitap kitap) {// Kitap Ekleme
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		String sorgu = "Insert Into tblkitaplar(KitapAdi,YazarAdi,KitapSayfaSayisi,KitapTürü) Values (?,?,?,?)";

		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setString(1, kitap.getKitapAdi());
			preparedStatement.setString(2, kitap.getYazarAdi());
			preparedStatement.setInt(3, kitap.getKitapSayfaSayisi());
			preparedStatement.setString(4, kitap.getKitapTürü());

			int i = preparedStatement.executeUpdate();
			logger.info("Kitap Baþaralý Bir Þekilde Eklendi i=" + i);// i =-1 ise hatavar demektir
		} catch (Exception e) {
			logger.warn("Kitap Eklenirken Bir Hata Oluþtu!!");
		} finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
	}

	public static void savePersonel(Personel personel) {// Personel Ekleme

		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		String sorgu = "Insert into tblpersonel(PersonelKullaniciAdi,PersonelSifre,PersonelAd,PersonelSoyad,PersonelDogumYili) values (?,?,?,?,?)";

		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setString(1, personel.getPersonelKullaniciAdi());
			preparedStatement.setString(2, personel.getPersonelSifre());
			preparedStatement.setString(3, personel.getPersonelAd());
			preparedStatement.setString(4, personel.getPersonelSoyad());
			preparedStatement.setInt(5, personel.getPersonelDogumYili());

			int i = preparedStatement.executeUpdate();
			logger.info("Personel Baþaralý Bir Þekilde Eklendi i=" + i);// i =-1 ise hatavar demektir
		} catch (Exception e) {
			logger.warn("Personel Eklenirken Bir Hata Oluþtu!!");
		} finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
	}

	public static void saveKisi(Kisi kisi) {// Kisi Ekleme
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		String sorgu = "Insert Into tblkisiler(KisiAdi, KisiSoyadi, KisiMail, KisiSifre,KisiKullaniciAdi) Values (?,?,?,?,?)";

		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setString(1, kisi.getKisiAdi());
			preparedStatement.setString(2, kisi.getKisiSoyadi());
			preparedStatement.setString(3, kisi.getKisiMail());
			preparedStatement.setString(4, kisi.getKisiSifre());
			preparedStatement.setString(5, kisi.getKisiKullaniciAdi());

			int i = preparedStatement.executeUpdate();
			logger.info("Kitap Baþaralý Bir Þekilde Eklendi i=" + i);// i =-1 ise hatavar demektir
		} catch (Exception e) {
			logger.warn("Kitap Eklenirken Bir Hata Oluþtu!!");
		} finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
	}

	public static ResultSet yap() {// Tablo Cekmek
		Connection connection = DBConnection.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from tblkitaplar");
			return resultSet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public static String findKisi(Kisi kisi) {// Kisi Kontrol
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String kullaniciAdi = "";
		String sorgu = "select * from tblkisiler where KisiMail=? and KisiSifre=? and KisiKullaniciAdi=?";
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setString(1, kisi.getKisiMail());
			preparedStatement.setString(2, kisi.getKisiSifre());
			preparedStatement.setString(3, kisi.getKisiKullaniciAdi());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String mail = resultSet.getString(4);
				String sifre = resultSet.getString(5);
				kullaniciAdi = resultSet.getString(6);
				return kullaniciAdi;
			}
			logger.info("Kisi Bullundu");
		} catch (Exception e) {
			logger.warn("Kisi Bulunamadý!!!!! Hata: " + e);
		} finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
		return kullaniciAdi;
	}

	public static String SifremiUnuttumKisi(Kisi kisi) {// Kisi Kontrol
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sifre = "";
		String sorgu = "select * from tblkisiler where KisiMail=? and KisiKullaniciAdi=?";
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setString(1, kisi.getKisiMail());
			preparedStatement.setString(2, kisi.getKisiKullaniciAdi());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				sifre = resultSet.getString(5);
				return sifre;
			}
			logger.info("Kisi Bullundu");
		} catch (Exception e) {
			logger.warn("Kisi Bulunamadý!!!!! Hata: " + e);
		} finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
		return sifre;
	}

	public static String findPersonel(Personel personel) {// Personel Kontrol
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String kullaniciAdi = "";
		String sorgu = "select * from tblpersonel where PersonelKullaniciAdi=? and PersonelSifre=?;";
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setString(1, personel.getPersonelKullaniciAdi());
			preparedStatement.setString(2, personel.getPersonelSifre());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				kullaniciAdi = resultSet.getString(6);
				return kullaniciAdi;
			}
			logger.info("Kisi Bullundu");
		} catch (Exception e) {
			logger.warn("Kisi Bulunamadý!!!!! Hata: " + e);
		} finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
		return kullaniciAdi;
	}

	public static String kitapOduncAlKisiKontrol(String kullaniciAdi) {// Kisi Kontrol
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sorgu = "select KisiSifre from tblkisiler where KisiKullaniciAdi=?";
		String KisiSifre = "";
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setString(1, kullaniciAdi);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				KisiSifre = resultSet.getString("KisiSifre");
				logger.info("Kisi Bullundu");
				return KisiSifre;
			}
		} catch (Exception e) {
			logger.warn("Kisi Bulunamadý!!!!! Hata: " + e);
		} finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
		return KisiSifre;
	}

	public static String kitapUpdate(String kitapBarkodNo, String kullaniciAdi, String kitapDurumu) {// Kitap Odunc Alma
		Connection connection = DBConnection.getConnection();// Kitap alinmissa durum 1
		PreparedStatement preparedStatement = null;
		String sorgu = "update tblkitaplar set KitapDurumu=?, KitapOdunc=? where KitapId=?;";
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setString(1, kitapDurumu);
			preparedStatement.setString(2, kullaniciAdi);
			preparedStatement.setString(3, kitapBarkodNo);
			preparedStatement.executeUpdate();

			logger.info("Kitap Güncellendi");
		} catch (Exception e) {
			logger.warn("Kitap Güncellenemedi!!!!! Hata: " + e);
		} finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
		return "1";
	}

	public static String KitapIadeEt(int barkodNo) {// Kitabi Alan Kontrol
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sorgu = "Select kitapDurumu , KitapOdunc from tblkitaplar where KitapId=?";
		String kitapDurumu = "";
		String KitapOdunc = "";
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, barkodNo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				kitapDurumu = resultSet.getString("kitapDurumu");
				KitapOdunc = resultSet.getString("KitapOdunc");
				System.out.println(KitapOdunc);

				if (kitapDurumu.equals("0")) {
					JOptionPane.showMessageDialog(null, "Bu Kitap Ödünç Alýnmamýþ", "Uyarý",
							JOptionPane.WARNING_MESSAGE);
				} else {
					return KitapOdunc;
				}
			}
			logger.info("Kisi Bullundu");
		} catch (Exception e) {
			logger.warn("KitapIadeEt !!!!! Hata: " + e);
		} finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
		return KitapOdunc;
	}

}
