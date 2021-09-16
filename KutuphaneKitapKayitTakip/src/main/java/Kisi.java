
public class Kisi {
	private String KisiAdi;
	private String KisiSoyadi;
	private String KisiMail;
	private String KisiSifre;
	private String KisiKullaniciAdi;

	public Kisi() {
	}

	public Kisi(String kisiMail, String kisiKullaniciAdi) {
		KisiMail = kisiMail;
		KisiKullaniciAdi = kisiKullaniciAdi;
	}

	public Kisi(String kisiMail, String kisiSifre, String kisiKullaniciAdi) {
		KisiMail = kisiMail;
		KisiSifre = kisiSifre;
		KisiKullaniciAdi = kisiKullaniciAdi;
	}

	public Kisi(String kisiAdi, String kisiSoyadi, String kisiMail, String kisiSifre, String kisiKullaniciAdi) {
		KisiAdi = kisiAdi;
		KisiSoyadi = kisiSoyadi;
		KisiMail = kisiMail;
		KisiSifre = kisiSifre;
		KisiKullaniciAdi = kisiKullaniciAdi;
	}

	@Override
	public String toString() {
		return "Kisi [KisiAdi=" + KisiAdi + ", KisiSoyadi=" + KisiSoyadi + ", KisiMail=" + KisiMail + ", KisiSifre="
				+ KisiSifre + ", KisiKullaniciAdi=" + KisiKullaniciAdi + "]";
	}

	public String getKisiAdi() {
		return KisiAdi;
	}

	public void setKisiAdi(String kisiAdi) {
		KisiAdi = kisiAdi;
	}

	public String getKisiSoyadi() {
		return KisiSoyadi;
	}

	public void setKisiSoyadi(String kisiSoyadi) {
		KisiSoyadi = kisiSoyadi;
	}

	public String getKisiMail() {
		return KisiMail;
	}

	public void setKisiMail(String kisiMail) {
		KisiMail = kisiMail;
	}

	public String getKisiSifre() {
		return KisiSifre;
	}

	public void setKisiSifre(String kisiSifre) {
		KisiSifre = kisiSifre;
	}

	public String getKisiKullaniciAdi() {
		return KisiKullaniciAdi;
	}

	public void setKisiKullaniciAdi(String kisiKullaniciAdi) {
		KisiKullaniciAdi = kisiKullaniciAdi;
	}

}
