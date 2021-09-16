
public class Kitap {
	private String KitapId;
	private String KitapAdi;
	private String YazarAdi;
	private int KitapSayfaSayisi;
	private String KitapT�r�;

	public Kitap() {
	}

	public Kitap( String kitapAdi, String yazarAdi, int kitapSayfaSayisi, String kitapT�r�) {
		KitapAdi = kitapAdi;
		YazarAdi = yazarAdi;
		KitapSayfaSayisi = kitapSayfaSayisi;
		KitapT�r� = kitapT�r�;
	}

	@Override
	public String toString() {
		return "Kitap [KitapId=" + KitapId + ", KitapAdi=" + KitapAdi + ", YazarAdi=" + YazarAdi + ", KitapSayfaSayisi="
				+ KitapSayfaSayisi + ", KitapT�r�=" + KitapT�r� + "]";
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

	public String getKitapT�r�() {
		return KitapT�r�;
	}

	public void setKitapT�r�(String kitapT�r�) {
		KitapT�r� = kitapT�r�;
	}

}
