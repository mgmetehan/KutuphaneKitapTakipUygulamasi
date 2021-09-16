
public class Kitap {
	private String KitapId;
	private String KitapAdi;
	private String YazarAdi;
	private int KitapSayfaSayisi;
	private String KitapTürü;

	public Kitap() {
	}

	public Kitap( String kitapAdi, String yazarAdi, int kitapSayfaSayisi, String kitapTürü) {
		KitapAdi = kitapAdi;
		YazarAdi = yazarAdi;
		KitapSayfaSayisi = kitapSayfaSayisi;
		KitapTürü = kitapTürü;
	}

	@Override
	public String toString() {
		return "Kitap [KitapId=" + KitapId + ", KitapAdi=" + KitapAdi + ", YazarAdi=" + YazarAdi + ", KitapSayfaSayisi="
				+ KitapSayfaSayisi + ", KitapTürü=" + KitapTürü + "]";
	}

	public String getKitapId() {
		return KitapId;
	}

//	public void setKitapId(String kitapId) {
//		KitapId = kitapId;
//	}

	public String getKitapAdi() {
		return KitapAdi;
	}

	public void setKitapAdi(String kitapAdi) {
		KitapAdi = kitapAdi;
	}

	public String getYazarAdi() {
		return YazarAdi;
	}

	public void setYazarAdi(String yazarAdi) {
		YazarAdi = yazarAdi;
	}

	public int getKitapSayfaSayisi() {
		return KitapSayfaSayisi;
	}

	public void setKitapSayfaSayisi(int kitapSayfaSayisi) {
		KitapSayfaSayisi = kitapSayfaSayisi;
	}

	public String getKitapTürü() {
		return KitapTürü;
	}

	public void setKitapTürü(String kitapTürü) {
		KitapTürü = kitapTürü;
	}

}
