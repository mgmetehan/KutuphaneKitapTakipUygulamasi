import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.k33ptoo.components.KGradientPanel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Anasayfa extends JFrame {

	private JPanel w_panel;
	JPanel panelIadeEt = new JPanel();
	JPanel panelKitapEkle = new JPanel();
	private JTextField txtEkleKitapAdi;
	private JTextField txtEkleYazarAdi;
	private JTextField txtEkleSayfaSayisi;
	private JTextField txtEklePersonelSifre;
	private JTextField txtEklePersonelKullaniciAdi;
	private JTextField txtEkleKitapTuru;
	private JTextField txtIadeEtKUllaniciAdi;
	private JTextField txtIadeEtBarkodNo;
	private JTextField txtOduncAlKullaniciAdi;
	private JTextField txtOduncAlBarkodNo;
	KGradientPanel gradientPanel = new KGradientPanel();
	JLabel lblLogo = new JLabel("");
	JLabel lblFirmaAdi = new JLabel("DonaExpress");
	JButton btnKitaplar = new JButton("Kitaplar");
	JButton btnKitapOduncAl = new JButton("Kitap \u00D6d\u00FCn\u00E7 Al");
	JButton btnKitapIadeEt = new JButton("Kitap \u0130ade Et");
	JButton btnKitapEkle = new JButton("Kitap Ekle");
	JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
	JLabel lblIadEtLogo = new JLabel("");
	JButton btnIadeEt = new JButton("Iade Et");
	JLabel lblIadeEtBarkodNo = new JLabel("Kitap Barkod No");
	JLabel lblIadeEtKullaniciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
	JLabel lblEkleKitapAdi = new JLabel("Kitap Adi");
	JLabel lblEkleYazarAdi = new JLabel("Yazar Adi");
	JLabel lblEkleKitapTuru = new JLabel("Kitap T\u00FCr\u00FC");
	JLabel lblEkleSayfaSayisi = new JLabel("Sayfa Sayisi");
	JLabel lblEklePresonelSifre = new JLabel("Personel \u015Eifre");
	JLabel lblEklePersonelKullaniciAdi = new JLabel("Personel Kullan\u0131c\u0131 Ad\u0131");
	JButton btnEkleKitapEkle = new JButton("Kitap Ekle");
	JPanel panelOduncAl = new JPanel();
	JLabel lblOduncAlLogo = new JLabel("");
	JButton btnOduncAl = new JButton("\u00D6d\u00FCn\u00E7 Al");
	JLabel lblOduncAlBarkodNo = new JLabel("Kitap Barkod No");
	JLabel lblOduncAlKullaniciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131");

	private JTable table_2;
	private final JPanel panel = new JPanel();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JTable table_1 = new JTable();

	public static ResultSet yap1() {// Tablo Cekmek
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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anasayfa frame = new Anasayfa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void panelDuzenle(int i) {
		switch (i) {
		case 1:
			scrollPane_1.setVisible(true);
			panelOduncAl.setVisible(false);
			panelIadeEt.setVisible(false);
			panelKitapEkle.setVisible(false);
			break;
		case 2:
			scrollPane_1.setVisible(false);
			panelOduncAl.setVisible(true);
			panelIadeEt.setVisible(false);
			panelKitapEkle.setVisible(false);
			break;
		case 3:
			scrollPane_1.setVisible(false);
			panelOduncAl.setVisible(false);
			panelIadeEt.setVisible(true);
			panelKitapEkle.setVisible(false);
			break;
		case 4:
			scrollPane_1.setVisible(false);
			panelOduncAl.setVisible(false);
			panelIadeEt.setVisible(false);
			panelKitapEkle.setVisible(true);
			break;
		default:
			break;
		}
	}

	public Anasayfa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1012, 843);
		w_panel = new JPanel();
		w_panel.setBackground(Color.WHITE);
		w_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_panel);
		w_panel.setLayout(null);
		panelOduncAl.setVisible(true);
		panelIadeEt.setVisible(false);
		panelKitapEkle.setVisible(false);
		scrollPane_1.setVisible(false);

		gradientPanel.kStartColor = new Color(243, 104, 224);
		gradientPanel.kEndColor = new Color(255, 159, 243);
		gradientPanel.setBounds(0, 11, 994, 116);
		w_panel.add(gradientPanel);
		gradientPanel.setLayout(null);

		lblLogo.setIcon(new ImageIcon(Anasayfa.class.getResource("/Pic/logo90.png")));
		lblLogo.setBounds(10, 11, 90, 94);
		gradientPanel.add(lblLogo);

		lblFirmaAdi.setForeground(Color.WHITE);
		lblFirmaAdi.setFont(new Font("Yu Gothic Medium", Font.BOLD, 43));
		lblFirmaAdi.setBounds(111, 35, 338, 70);
		gradientPanel.add(lblFirmaAdi);

		btnKitaplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDuzenle(1);
				DefaultTableModel modelim = new DefaultTableModel();
				Object[] kolonlar = { "Kitap Id", "Kitap Adi", "Yazar Adi", "Sayfa Sayisi", "Türü", "Kitap Durumu",
						"Kitap Kimde" };
				Object[] satirlar = new Object[7];

				modelim.setColumnIdentifiers(kolonlar);
				scrollPane_1.setViewportView(table_2);
				modelim.setRowCount(0);
				table_2.setModel(modelim);

				ResultSet myRs = yap1();

				try {
					while (myRs.next()) {
						satirlar[0] = myRs.getInt("KitapId");
						satirlar[1] = myRs.getString("KitapAdi");
						satirlar[2] = myRs.getString("YazarAdi");
						satirlar[3] = myRs.getInt("KitapSayfaSayisi");
						satirlar[4] = myRs.getString("KitapTürü");
						satirlar[5] = myRs.getBoolean("KitapDurumu");
						satirlar[6] = myRs.getString("KitapOdunc");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnKitaplar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnKitaplar.setBackground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnKitaplar.setBackground(new Color(243, 104, 224));
			}
		});

		btnKitaplar.setHorizontalAlignment(SwingConstants.LEFT);
		btnKitaplar.setForeground(Color.WHITE);
		btnKitaplar.setBackground(new Color(243, 104, 224));
		btnKitaplar.setIcon(new ImageIcon(Anasayfa.class.getResource("/Pic/books.png")));
		btnKitaplar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		btnKitaplar.setBounds(10, 175, 252, 90);
		w_panel.add(btnKitaplar);
		btnKitapOduncAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDuzenle(2);

			}
		});

		btnKitapOduncAl.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnKitapOduncAl.setBackground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnKitapOduncAl.setBackground(new Color(243, 104, 224));
			}
		});
		btnKitapOduncAl.setForeground(Color.WHITE);
		btnKitapOduncAl.setBackground(new Color(243, 104, 224));
		btnKitapOduncAl.setIcon(new ImageIcon(Anasayfa.class.getResource("/Pic/borrow_book.png")));
		btnKitapOduncAl.setHorizontalAlignment(SwingConstants.LEFT);
		btnKitapOduncAl.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		btnKitapOduncAl.setBounds(10, 299, 252, 90);
		w_panel.add(btnKitapOduncAl);
		btnKitapIadeEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDuzenle(3);
			}
		});

		btnKitapIadeEt.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnKitapIadeEt.setBackground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnKitapIadeEt.setBackground(new Color(243, 104, 224));
			}
		});
		btnKitapIadeEt.setHorizontalAlignment(SwingConstants.LEFT);
		btnKitapIadeEt.setForeground(Color.WHITE);
		btnKitapIadeEt.setBackground(new Color(243, 104, 224));
		btnKitapIadeEt.setIcon(new ImageIcon(Anasayfa.class.getResource("/Pic/sell.png")));
		btnKitapIadeEt.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		btnKitapIadeEt.setBounds(10, 431, 252, 90);
		w_panel.add(btnKitapIadeEt);
		btnKitapEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDuzenle(4);
			}
		});

		btnKitapEkle.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnKitapEkle.setBackground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnKitapEkle.setBackground(new Color(243, 104, 224));
			}
		});
		btnKitapEkle.setHorizontalAlignment(SwingConstants.LEFT);
		btnKitapEkle.setForeground(Color.WHITE);
		btnKitapEkle.setBackground(new Color(243, 104, 224));
		btnKitapEkle.setIcon(new ImageIcon(Anasayfa.class.getResource("/Pic/add.png")));
		btnKitapEkle.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		btnKitapEkle.setBounds(10, 557, 252, 90);
		w_panel.add(btnKitapEkle);
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnCikis.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnCikis.setBackground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCikis.setBackground(new Color(243, 104, 224));
			}
		});
		btnCikis.setHorizontalAlignment(SwingConstants.LEFT);
		btnCikis.setForeground(Color.WHITE);
		btnCikis.setBackground(new Color(243, 104, 224));
		btnCikis.setIcon(new ImageIcon(Anasayfa.class.getResource("/Pic/closs.png")));
		btnCikis.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		btnCikis.setBounds(10, 692, 252, 90);
		w_panel.add(btnCikis);

		panelOduncAl.setLayout(null);
		panelOduncAl.setBackground(Color.WHITE);
		panelOduncAl.setBounds(323, 185, 671, 610);
		w_panel.add(panelOduncAl);

		lblOduncAlLogo.setIcon(new ImageIcon(Anasayfa.class.getResource("/Pic/read_96px.png")));
		lblOduncAlLogo.setBounds(271, 38, 128, 177);
		panelOduncAl.add(lblOduncAlLogo);
		btnOduncAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oduncAl = txtOduncAlKullaniciAdi.getText();
				String no = txtOduncAlBarkodNo.getText();
				String kontrol = DBProcesses.kitapOduncAlKisiKontrol(oduncAl);
				if (kontrol.equals("")) {
					JOptionPane.showMessageDialog(null, "Böyle Bir Kullanýcý Bullunmamaktadýr!!", "Uyarý",
							JOptionPane.WARNING_MESSAGE);
					txtOduncAlKullaniciAdi.setText("");
					txtOduncAlBarkodNo.setText("");
				} else {
					DBProcesses.kitapUpdate(no, oduncAl, "1");
					JOptionPane.showMessageDialog(null, "Kitap Alma Ýþlemi Baþaralý ", "Bilgi",
							JOptionPane.INFORMATION_MESSAGE);
					txtOduncAlKullaniciAdi.setText("");
					txtOduncAlBarkodNo.setText("");
				}

			}
		});

		btnOduncAl.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnOduncAl.setBackground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnOduncAl.setBackground(new Color(243, 104, 224));
			}

		});

		btnOduncAl.setForeground(Color.WHITE);
		btnOduncAl.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		btnOduncAl.setBackground(new Color(243, 104, 224));
		btnOduncAl.setBounds(209, 427, 252, 90);
		panelOduncAl.add(btnOduncAl);

		lblOduncAlBarkodNo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblOduncAlBarkodNo.setBounds(66, 325, 148, 55);
		panelOduncAl.add(lblOduncAlBarkodNo);

		lblOduncAlKullaniciAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblOduncAlKullaniciAdi.setBounds(66, 244, 178, 55);
		panelOduncAl.add(lblOduncAlKullaniciAdi);

		txtOduncAlKullaniciAdi = new JTextField();
		txtOduncAlKullaniciAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtOduncAlKullaniciAdi.setColumns(10);
		txtOduncAlKullaniciAdi.setBounds(272, 244, 338, 42);
		panelOduncAl.add(txtOduncAlKullaniciAdi);

		txtOduncAlBarkodNo = new JTextField();
		txtOduncAlBarkodNo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtOduncAlBarkodNo.setColumns(10);
		txtOduncAlBarkodNo.setBounds(272, 325, 338, 42);
		panelOduncAl.add(txtOduncAlBarkodNo);

		table_2 = new JTable();
		panelIadeEt.setBounds(323, 185, 671, 610);
		w_panel.add(panelIadeEt);
		panelIadeEt.setVisible(false);

		panelIadeEt.setBackground(Color.WHITE);
		panelIadeEt.setLayout(null);

		lblIadEtLogo.setIcon(new ImageIcon(Anasayfa.class.getResource("/Pic/booksIadeEt.png")));
		lblIadEtLogo.setBounds(271, 38, 128, 177);
		panelIadeEt.add(lblIadEtLogo);
		btnIadeEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kullanici = txtIadeEtKUllaniciAdi.getText();
				String no = txtIadeEtBarkodNo.getText();
				String kontrol = DBProcesses.kitapOduncAlKisiKontrol(kullanici);
				if (kontrol.equals("")) {
					JOptionPane.showMessageDialog(null, "Böyle Bir Kullanýcý Bullunmamaktadýr!!", "Uyarý",
							JOptionPane.WARNING_MESSAGE);
					txtIadeEtKUllaniciAdi.setText("");
					txtIadeEtBarkodNo.setText("");
				} else {
					String kim = DBProcesses.KitapIadeEt(Integer.valueOf(no));
					if (kim.equals(kullanici)) {
						DBProcesses.kitapUpdate(no, "", "0");
						JOptionPane.showMessageDialog(null, "Kitap Ýade Ýþlemi Baþaralý ", "Bilgi",
								JOptionPane.INFORMATION_MESSAGE);
						txtOduncAlKullaniciAdi.setText("");
						txtOduncAlBarkodNo.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Bu Kullanýcý Bu Kitabý Almamýþ!!", "Uyarý",
								JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});

		btnIadeEt.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnIadeEt.setBackground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnIadeEt.setBackground(new Color(243, 104, 224));
			}
		});
		btnIadeEt.setForeground(Color.WHITE);
		btnIadeEt.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		btnIadeEt.setBackground(new Color(243, 104, 224));
		btnIadeEt.setBounds(209, 427, 252, 90);
		panelIadeEt.add(btnIadeEt);

		lblIadeEtBarkodNo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblIadeEtBarkodNo.setBounds(66, 325, 148, 55);
		panelIadeEt.add(lblIadeEtBarkodNo);

		lblIadeEtKullaniciAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblIadeEtKullaniciAdi.setBounds(66, 244, 178, 55);
		panelIadeEt.add(lblIadeEtKullaniciAdi);

		txtIadeEtKUllaniciAdi = new JTextField();
		txtIadeEtKUllaniciAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtIadeEtKUllaniciAdi.setColumns(10);
		txtIadeEtKUllaniciAdi.setBounds(272, 244, 338, 42);
		panelIadeEt.add(txtIadeEtKUllaniciAdi);

		txtIadeEtBarkodNo = new JTextField();

		txtIadeEtBarkodNo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtIadeEtBarkodNo.setColumns(10);
		txtIadeEtBarkodNo.setBounds(272, 325, 338, 42);
		panelIadeEt.add(txtIadeEtBarkodNo);
		panelKitapEkle.setBounds(323, 185, 671, 610);
		w_panel.add(panelKitapEkle);
		panelKitapEkle.setVisible(false);

		panelKitapEkle.setBackground(Color.WHITE);
		panelKitapEkle.setLayout(null);

		lblEkleKitapAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblEkleKitapAdi.setBounds(23, 19, 148, 55);
		panelKitapEkle.add(lblEkleKitapAdi);

		txtEkleKitapAdi = new JTextField();
		txtEkleKitapAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtEkleKitapAdi.setColumns(10);
		txtEkleKitapAdi.setBounds(229, 19, 338, 42);
		panelKitapEkle.add(txtEkleKitapAdi);

		lblEkleYazarAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblEkleYazarAdi.setBounds(23, 100, 148, 55);
		panelKitapEkle.add(lblEkleYazarAdi);

		txtEkleYazarAdi = new JTextField();
		txtEkleYazarAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtEkleYazarAdi.setColumns(10);
		txtEkleYazarAdi.setBounds(229, 100, 338, 42);
		panelKitapEkle.add(txtEkleYazarAdi);

		lblEkleKitapTuru.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblEkleKitapTuru.setBounds(23, 267, 148, 55);
		panelKitapEkle.add(lblEkleKitapTuru);

		lblEkleSayfaSayisi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblEkleSayfaSayisi.setBounds(23, 186, 148, 55);
		panelKitapEkle.add(lblEkleSayfaSayisi);

		txtEkleSayfaSayisi = new JTextField();
		txtEkleSayfaSayisi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtEkleSayfaSayisi.setColumns(10);
		txtEkleSayfaSayisi.setBounds(229, 186, 338, 42);
		panelKitapEkle.add(txtEkleSayfaSayisi);

		txtEklePersonelSifre = new JTextField();
		txtEklePersonelSifre.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtEklePersonelSifre.setColumns(10);
		txtEklePersonelSifre.setBounds(229, 431, 338, 42);
		panelKitapEkle.add(txtEklePersonelSifre);

		lblEklePresonelSifre.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblEklePresonelSifre.setBounds(23, 431, 148, 55);
		panelKitapEkle.add(lblEklePresonelSifre);

		lblEklePersonelKullaniciAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblEklePersonelKullaniciAdi.setBounds(23, 350, 178, 55);
		panelKitapEkle.add(lblEklePersonelKullaniciAdi);

		txtEklePersonelKullaniciAdi = new JTextField();
		txtEklePersonelKullaniciAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtEklePersonelKullaniciAdi.setColumns(10);
		txtEklePersonelKullaniciAdi.setBounds(229, 350, 338, 42);
		panelKitapEkle.add(txtEklePersonelKullaniciAdi);
		btnEkleKitapEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String personelkullaniciAdi = txtEklePersonelKullaniciAdi.getText();
				String personelSifre = txtEklePersonelSifre.getText();

				Personel personel = new Personel(personelkullaniciAdi, personelSifre);
				String personelfind = DBProcesses.findPersonel(personel);
				if (personelfind.equals("")) {
					JOptionPane.showMessageDialog(null, "Personel  Bilgilerini Kontrol Ediniz!", "Uyarý",
							JOptionPane.WARNING_MESSAGE);
					txtEklePersonelKullaniciAdi.setText("");
					txtEklePersonelSifre.setText("");
				} else {
					String kitapAdi = txtEkleKitapAdi.getText();
					String yazarAdi = txtEkleYazarAdi.getText();
					int sayfaSayisi = Integer.valueOf(txtEkleSayfaSayisi.getText());
					String turu = txtEkleKitapTuru.getText();
					Kitap kitap = new Kitap(kitapAdi, yazarAdi, sayfaSayisi, turu);
					DBProcesses.saveKitap(kitap);
					JOptionPane.showMessageDialog(null, "Kitap Baþarýlý Þekilde Eklendi", "Bilgi",
							JOptionPane.INFORMATION_MESSAGE);
					txtEkleKitapAdi.setText("");
					txtEkleKitapTuru.setText("");
					txtEklePersonelKullaniciAdi.setText("");
					txtEklePersonelSifre.setText("");
					txtEkleSayfaSayisi.setText("");
					txtEkleYazarAdi.setText("");
				}
			}
		});

		btnEkleKitapEkle.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnEkleKitapEkle.setBackground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEkleKitapEkle.setBackground(new Color(243, 104, 224));
			}
		});
		btnEkleKitapEkle.setForeground(Color.WHITE);
		btnEkleKitapEkle.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		btnEkleKitapEkle.setBackground(new Color(243, 104, 224));
		btnEkleKitapEkle.setBounds(209, 497, 252, 90);
		panelKitapEkle.add(btnEkleKitapEkle);

		txtEkleKitapTuru = new JTextField();
		txtEkleKitapTuru.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtEkleKitapTuru.setColumns(10);
		txtEkleKitapTuru.setBounds(229, 274, 338, 42);
		panelKitapEkle.add(txtEkleKitapTuru);
		scrollPane_1.setBounds(323, 185, 671, 610);

		w_panel.add(scrollPane_1);
		panel.setLayout(null);
		table_1.setBounds(101, 31, 87, 58);

	}
}
