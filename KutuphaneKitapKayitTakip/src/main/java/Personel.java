
public class Personel {
	private String PersonelId;
	private String PersonelKullaniciAdi;
	private String PersonelSifre;
	private String PersonelAd;
	private String PersonelSoyad;
	private int PersonelDogumYili;

	public Personel() {
	}

	public Personel(String personelKullaniciAdi, String personelSifre) {
		PersonelKullaniciAdi = personelKullaniciAdi;
		PersonelSifre = personelSifre;
	}

	public Personel(String personelId, String personelKullaniciAdi, String personelSifre, String personelAd,
			String personelSoyad, int personelDogumYili) {
		PersonelId = personelId;
		PersonelKullaniciAdi = personelKullaniciAdi;
		PersonelSifre = personelSifre;
		PersonelAd = personelAd;
		PersonelSoyad = personelSoyad;
		PersonelDogumYili = personelDogumYili;
	}

	@Override
	public String toString() {
		return "Personel [PersonelId=" + PersonelId + ", PersonelKullaniciAdi=" + PersonelKullaniciAdi
				+ ", PersonelSifre=" + PersonelSifre + ", PersonelAd=" + PersonelAd + ", PersonelSoyad=" + PersonelSoyad
				+ ", PersonelDogumYili=" + PersonelDogumYili + "]";
	}

	public String getPersonelId() {
		return PersonelId;
	}

	/*
	 * public void setPersonelId(String personelId) { PersonelId = personelId; }
	 */

	public String getPersonelKullaniciAdi() {
		return PersonelKullaniciAdi;
	}

	public void setPersonelKullaniciAdi(String personelKullaniciAdi) {
		PersonelKullaniciAdi = personelKullaniciAdi;
	}

	public String getPersonelSifre() {
		return PersonelSifre;
	}

	public void setPersonelSifre(String personelSifre) {
		PersonelSifre = personelSifre;
	}

	public String getPersonelAd() {
		return PersonelAd;
	}

	public void setPersonelAd(String personelAd) {
		PersonelAd = personelAd;
	}

	public String getPersonelSoyad() {
		return PersonelSoyad;
	}

	public void setPersonelSoyad(String personelSoyad) {
		PersonelSoyad = personelSoyad;
	}

	public int getPersonelDogumYili() {
		return PersonelDogumYili;
	}

	public void setPersonelDogumYili(int personelDogumYili) {
		PersonelDogumYili = personelDogumYili;
	}

}
