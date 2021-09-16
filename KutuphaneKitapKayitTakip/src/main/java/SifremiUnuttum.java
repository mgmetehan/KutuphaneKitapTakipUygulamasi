import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import com.k33ptoo.components.KGradientPanel;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SifremiUnuttum extends JFrame {

	private JPanel w_panel;
	private JTextField txtKullaniciSifremiUnuttum;
	private JTextField txtMail;
	Helper helper = new Helper();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SifremiUnuttum frame = new SifremiUnuttum();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SifremiUnuttum() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 490);
		w_panel = new JPanel();
		w_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_panel);
		w_panel.setLayout(null);

		txtKullaniciSifremiUnuttum = new JTextField();
		txtKullaniciSifremiUnuttum.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtKullaniciSifremiUnuttum.setColumns(10);
		txtKullaniciSifremiUnuttum.setBounds(72, 307, 338, 42);
		w_panel.add(txtKullaniciSifremiUnuttum);

		JLabel lblKullaniciAdi = new JLabel("Kullanici Adi");
		lblKullaniciAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblKullaniciAdi.setBounds(72, 232, 338, 55);
		w_panel.add(lblKullaniciAdi);

		txtMail = new JTextField();
		txtMail.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtMail.setColumns(10);
		txtMail.setBounds(72, 170, 338, 42);
		w_panel.add(txtMail);

		JLabel lblMail = new JLabel("E-posta Adresi");
		lblMail.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblMail.setBounds(72, 95, 338, 55);
		w_panel.add(lblMail);

		JButton btnDevamEt = new JButton("Devam Et");
		btnDevamEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mail = txtMail.getText();
				String kullaniciAdi = txtKullaniciSifremiUnuttum.getText();
				Kisi kisi = new Kisi(mail, kullaniciAdi);
				String sifre = DBProcesses.SifremiUnuttumKisi(kisi);

				if (sifre.equals("")) {
					JOptionPane.showMessageDialog(null, "Hesab Bilgilerini Kontrol Ediniz!", "Uyarý",
							JOptionPane.WARNING_MESSAGE);
					txtMail.setText("");
					txtKullaniciSifremiUnuttum.setText("");
				} else {

					helper.SifremiUnuttummailGonder(
							"Hesabýnýzýn Þifresi : " + sifre
									+ "\nLütfen Güvenliðiniz Ýçin Þifrenizi Baþkalarýyla Paylaþmayýnýz!! ",
							"Þifremi Unuttum", txtMail.getText());

					Login login = new Login();
					login.setVisible(true);
					dispose();
				}
			}
		});
		btnDevamEt.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		btnDevamEt.setBounds(72, 369, 338, 59);
		w_panel.add(btnDevamEt);

		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setBounds(0, 0, 483, 453);
		w_panel.add(gradientPanel);
		gradientPanel.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(SifremiUnuttum.class.getResource("/Pic/show_password_80px.png")));
		lblLogo.setBounds(42, 0, 112, 98);
		gradientPanel.add(lblLogo);

		JLabel lblMetin = new JLabel("\u015Eifre Yenileme");
		lblMetin.setBounds(153, 22, 177, 55);
		gradientPanel.add(lblMetin);
		lblMetin.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 24));
	}
}
