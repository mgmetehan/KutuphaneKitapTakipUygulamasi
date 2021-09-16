import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.k33ptoo.components.KGradientPanel;
import java.awt.Color;
import com.k33ptoo.utils.ComponentMoverUtil;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import com.k33ptoo.components.KButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.k33ptoo.utils.ComponentResizerUtil;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel w_panel;
	private JTextField txtMail;
	private JTextField txtSifre;
	private JTextField txtAdKayit;
	private JTextField txtSifreKayit;
	private JTextField txtSoyadKayit;
	private JTextField txtMailKayit;
	Helper helper = new Helper();
	private JTextField txtKullaniciAdiKayit;
	private JTextField txtKullaniciAdi;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 705);
		w_panel = new JPanel();
		w_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_panel);
		w_panel.setLayout(null);

		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.kEndColor = Color.CYAN;
		gradientPanel.setBounds(0, 0, 586, 668);
		w_panel.add(gradientPanel);
		gradientPanel.setLayout(null);

		JLabel lblFirmaAdi = new JLabel("DonaExpress");
		lblFirmaAdi.setForeground(Color.WHITE);
		lblFirmaAdi.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 28));
		lblFirmaAdi.setBounds(208, 28, 222, 75);
		gradientPanel.add(lblFirmaAdi);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBorder(null);
		tabbedPane.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		tabbedPane.setBounds(92, 131, 402, 503);
		gradientPanel.add(tabbedPane);

		JPanel panelGirisYap = new JPanel();
		panelGirisYap.setLocation(2, -122);
		panelGirisYap.setBackground(Color.WHITE);
		panelGirisYap.setBorder(null);
		tabbedPane.addTab("Giri\u015F Yap", null, panelGirisYap, null);
		panelGirisYap.setLayout(null);

		JLabel lblMail = new JLabel("E-posta Adresi");
		lblMail.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblMail.setBounds(29, 11, 338, 55);
		panelGirisYap.add(lblMail);

		KButton btnGirisYap = new KButton();
		btnGirisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mail = txtMail.getText();
				String sifre = txtSifre.getText();
				String kullaniciAdi = txtKullaniciAdi.getText();
				Kisi kisi = new Kisi(mail, sifre, kullaniciAdi);
				String find = DBProcesses.findKisi(kisi);

				if (find.equals("")) {
					JOptionPane.showMessageDialog(null, "Hesab Bilgilerini Kontrol Ediniz!", "Uyarý",
							JOptionPane.WARNING_MESSAGE);
					txtMail.setText("");
					txtKullaniciAdi.setText("");
					txtSifre.setText("");

				} else {
					helper.mailGonder("Oturumunuz Açýlmýþtýr.", "Oturum Ýþlemi", txtMail.getText());

					Anasayfa anasayfa = new Anasayfa();
					anasayfa.setVisible(true);
					dispose();
				}
			}
		});
		btnGirisYap.kHoverStartColor = new Color(51, 51, 255);
		btnGirisYap.kHoverForeGround = new Color(102, 0, 204);
		btnGirisYap.kPressedColor = new Color(51, 204, 255);
		btnGirisYap.kSelectedColor = new Color(255, 255, 255);

		btnGirisYap.kStartColor = new Color(255, 153, 51);
		btnGirisYap.kHoverEndColor = new Color(255, 0, 153);
		btnGirisYap.kEndColor = new Color(255, 51, 102);
		btnGirisYap.kBorderRadius = 30;
		btnGirisYap.kBackGroundColor = Color.black;
		btnGirisYap.setBounds(29, 305, 338, 55);
		btnGirisYap.setText("Giriþ Yap");
		btnGirisYap.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		panelGirisYap.add(btnGirisYap);

		txtMail = new JTextField();
		txtMail.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtMail.setBounds(29, 73, 338, 42);
		panelGirisYap.add(txtMail);
		txtMail.setColumns(10);

		JLabel lblSifre = new JLabel("\u015Eifre");
		lblSifre.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblSifre.setBounds(29, 173, 338, 55);
		panelGirisYap.add(lblSifre);

		txtSifre = new JTextField();
		txtSifre.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtSifre.setColumns(10);
		txtSifre.setBounds(29, 239, 338, 42);
		panelGirisYap.add(txtSifre);

		JButton btnSifremiUnuttum = new JButton("\u015Eifremi Unuttum");
		btnSifremiUnuttum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SifremiUnuttum sifremiUnuttum = new SifremiUnuttum();
				sifremiUnuttum.setVisible(true);
				dispose();
			}
		});
		btnSifremiUnuttum.setBorderPainted(false);
		btnSifremiUnuttum.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnSifremiUnuttum.setForeground(new Color(247, 159, 31));
			}

			public void mouseExited(MouseEvent e) {
				btnSifremiUnuttum.setForeground(new Color(238, 90, 36));
			}
		});
		btnSifremiUnuttum.setHorizontalAlignment(SwingConstants.LEFT);
		btnSifremiUnuttum.setBorder(null);
		btnSifremiUnuttum.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		btnSifremiUnuttum.setForeground(new Color(238, 90, 36));
		btnSifremiUnuttum.setBackground(new Color(255, 255, 255));
		btnSifremiUnuttum.setBounds(39, 397, 188, 59);
		panelGirisYap.add(btnSifremiUnuttum);

		JLabel lblKullaniciAdi_1 = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullaniciAdi_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblKullaniciAdi_1.setBounds(29, 136, 123, 39);
		panelGirisYap.add(lblKullaniciAdi_1);

		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtKullaniciAdi.setColumns(10);
		txtKullaniciAdi.setBounds(172, 136, 195, 42);
		panelGirisYap.add(txtKullaniciAdi);

		JPanel panelKayitOl = new JPanel();
		panelKayitOl.setBackground(Color.WHITE);
		panelKayitOl.setLocation(321, 25);
		panelKayitOl.setLayout(null);
		tabbedPane.addTab("\u00DCye Ol", null, panelKayitOl, null);

		JLabel lblAdKayit = new JLabel("Ad");
		lblAdKayit.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblAdKayit.setBounds(30, 22, 166, 39);
		panelKayitOl.add(lblAdKayit);

		KButton btnUyeOl = new KButton();
		btnUyeOl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helper.mailGonder("Kaydýnýz Baþaralý Þekilde Oluþturulmuþtur.", "Yeni Üyelik", txtMail.getText());

				String KisiAdi = txtAdKayit.getText();
				String KisiSoyadi = txtSoyadKayit.getText();
				String KisiMail = txtMailKayit.getText();
				String KisiSifre = txtSifreKayit.getText();
				String KisiKullaniciAdi = txtKullaniciAdiKayit.getText();
				Kisi kisi = new Kisi(KisiAdi, KisiSoyadi, KisiMail, KisiSifre, KisiKullaniciAdi);
				DBProcesses.saveKisi(kisi);

				int i = KisiSifre.length();
				if (i == 4) {
					Anasayfa anasayfa = new Anasayfa();
					anasayfa.setVisible(true);
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Þifre 4 karakterden fazla olamaz", "Uyarý",
							JOptionPane.WARNING_MESSAGE);
					txtSifreKayit.setText("");
				}
			}
		});
		btnUyeOl.kHoverStartColor = new Color(51, 51, 255);
		btnUyeOl.kHoverForeGround = new Color(102, 0, 204);
		btnUyeOl.kPressedColor = new Color(51, 204, 255);
		btnUyeOl.kSelectedColor = new Color(255, 255, 255);

		btnUyeOl.kStartColor = new Color(255, 153, 51);
		btnUyeOl.kHoverEndColor = new Color(255, 0, 153);
		btnUyeOl.kEndColor = new Color(255, 51, 102);
		btnUyeOl.kBorderRadius = 30;
		btnUyeOl.kBackGroundColor = Color.black;
		btnUyeOl.setBounds(30, 389, 338, 55);
		btnUyeOl.setText("Üye Ol");
		btnUyeOl.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		panelKayitOl.add(btnUyeOl);

		txtAdKayit = new JTextField();
		txtAdKayit.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtAdKayit.setColumns(10);
		txtAdKayit.setBounds(30, 58, 166, 42);
		panelKayitOl.add(txtAdKayit);

		JLabel lblSifreKayit = new JLabel("\u015Eifre");
		lblSifreKayit.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblSifreKayit.setBounds(32, 270, 67, 55);
		panelKayitOl.add(lblSifreKayit);

		txtSifreKayit = new JTextField();
		txtSifreKayit.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtSifreKayit.setColumns(10);
		txtSifreKayit.setBounds(30, 336, 338, 42);
		panelKayitOl.add(txtSifreKayit);

		txtSoyadKayit = new JTextField();
		txtSoyadKayit.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtSoyadKayit.setColumns(10);
		txtSoyadKayit.setBounds(206, 58, 166, 42);
		panelKayitOl.add(txtSoyadKayit);

		JLabel lblSoyadKayit = new JLabel("Soyad");
		lblSoyadKayit.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblSoyadKayit.setBounds(206, 22, 166, 39);
		panelKayitOl.add(lblSoyadKayit);

		JLabel lblMailKayit = new JLabel("E-posta Adresi");
		lblMailKayit.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblMailKayit.setBounds(30, 111, 338, 55);
		panelKayitOl.add(lblMailKayit);

		txtMailKayit = new JTextField();
		txtMailKayit.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtMailKayit.setColumns(10);
		txtMailKayit.setBounds(30, 158, 338, 42);
		panelKayitOl.add(txtMailKayit);

		txtKullaniciAdiKayit = new JTextField();
		txtKullaniciAdiKayit.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtKullaniciAdiKayit.setColumns(10);
		txtKullaniciAdiKayit.setBounds(173, 227, 195, 42);
		panelKayitOl.add(txtKullaniciAdiKayit);

		JLabel lblKullaniciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullaniciAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblKullaniciAdi.setBounds(30, 227, 123, 39);
		panelKayitOl.add(lblKullaniciAdi);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/Pic/logo150.png")));
		lblLogo.setBounds(67, 11, 138, 129);
		gradientPanel.add(lblLogo);
	}
}
