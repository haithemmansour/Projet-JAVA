package socket;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class ClientFrame extends JFrame {
	private String serverName = "localhost";
    private int serverPort = 8081;
    private Socket socket = null;
    private DataOutputStream dos = null;
	private JPanel contentPane;
	private DataInputStream dis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientFrame() throws IOException {
       
            socket = new Socket(serverName, serverPort);
            System.out.println("Client started on port " + socket.getLocalPort()+"...");
            System.out.println("Connected to server " + socket.getRemoteSocketAddress());
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
       
         
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 655, 457);
				contentPane = new JPanel();
				contentPane.setBackground(Color.WHITE);
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				JLabel Image0 = new JLabel("");
				
				Image0.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/OFF.jpg")));
				Image0.setForeground(Color.GREEN);
				Image0.setBackground(Color.GREEN);
				Image0.setBounds(167, 41, 108, 105);
				contentPane.add(Image0);
				
				JLabel Image1 = new JLabel("");
				Image1.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/OFF.jpg")));
				Image1.setForeground(Color.GREEN);
				Image1.setBackground(Color.GREEN);
				Image1.setBounds(357, 41, 108, 92);
				contentPane.add(Image1);
				
				JLabel Image2 = new JLabel("");
				Image2.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/OFF.jpg")));
				Image2.setForeground(Color.GREEN);
				Image2.setBackground(Color.GREEN);
				Image2.setBounds(167, 200, 108, 92);
				contentPane.add(Image2);
				
				JLabel Image3 = new JLabel("");
				Image3.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/OFF.jpg")));
				Image3.setForeground(Color.GREEN);
				Image3.setBackground(Color.GREEN);
				Image3.setBounds(357, 200, 108, 92);
				contentPane.add(Image3);
				
				JToggleButton Vanne0 = new JToggleButton("Vanne 0 OFF");
				Vanne0.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
						if(Vanne0.isSelected()) {
							Vanne0.setBackground(Color.GREEN);
							Vanne0.setText("Vanne 0 ON");
							Image0.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/ON.png")));
							dos.writeUTF("vanne 0 ON");
							
							}else {
								Vanne0.setBackground(Color.red);
								Vanne0.setText("Vanne 0 OFF");
								Image0.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/OFF.jpg")));
								dos.writeUTF("vanne 0 OFF");
							}
					}catch (Exception e) {
						e.printStackTrace();
					}
					}	
				});
				Vanne0.setBounds(12, 83, 137, 25);
				contentPane.add(Vanne0);
				
				JToggleButton Vanne1 = new JToggleButton("Vanne 1 OFF");
				Vanne1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						if(Vanne1.isSelected()) {
							Vanne1.setBackground(Color.GREEN);
							Vanne1.setText("Vanne 1 ON");
							Image1.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/ON.png")));
							dos.writeUTF("vanne 1 ON");
							
						}else {
								Vanne1.setBackground(Color.red);
								Vanne1.setText("Vanne 1 OFF");
								Image1.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/OFF.jpg")));
								dos.writeUTF("vanne 1 OFF");
							}
						}catch (Exception e1) {
								e1.printStackTrace();
							}
					}
				});
				Vanne1.setBounds(477, 83, 137, 25);
				contentPane.add(Vanne1);
				
				JToggleButton Vanne2 = new JToggleButton("Vanne 2 OFF");
				Vanne2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						if(Vanne2.isSelected()) {
							Vanne2.setBackground(Color.GREEN);
							Vanne2.setText("Vanne 2 ON");
							Image2.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/ON.png")));
							dos.writeUTF("vanne 2 ON");
						}else {
								Vanne2.setBackground(Color.red);
								Vanne2.setText("Vanne 2 OFF");
								Image2.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/OFF.jpg")));
								dos.writeUTF("vanne 2 OFF");}
						}catch (Exception e1) {
							e1.printStackTrace();
						}		
					}
					
				});
				Vanne2.setBounds(12, 236, 137, 25);
				contentPane.add(Vanne2);
				
				JToggleButton Vanne3 = new JToggleButton("Vanne 3 OFF");
				Vanne3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						if(Vanne3.isSelected()) {
							Vanne3.setBackground(Color.green);
							Vanne3.setText("Vanne 3 ON");
							Image3.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/ON.png")));
							dos.writeUTF("vanne 3 ON");	
							}else {
								Vanne3.setBackground(Color.red);
								Vanne3.setText("Vanne 3 OFF");
								Image3.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/OFF.jpg")));
								dos.writeUTF("vanne 3 OFF");
							}
							}catch (Exception e1) {
								e1.printStackTrace();
							}
								}
					});
				Vanne3.setBounds(477, 236, 137, 25);
				contentPane.add(Vanne3);
				
				JToggleButton VanneALL = new JToggleButton("Vanne ALL");
				VanneALL.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						if(VanneALL.isSelected()) {
							VanneALL.setBackground(Color.GREEN);
							VanneALL.setText("Vanne ALL ON");
							Image3.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/ON.png")));
							Image2.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/ON.png")));
							Image1.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/ON.png")));
							Image0.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/ON.png")));
							dos.writeUTF("vanne ALL ON");
							}else {
								VanneALL.setBackground(Color.red);
								VanneALL.setText("Vanne ALL OFF");
								Image3.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/OFF.jpg")));
								Image2.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/OFF.jpg")));
								Image1.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/OFF.jpg")));
								Image0.setIcon(new ImageIcon(ClientFrame.class.getResource("/socket/Image/OFF.jpg")));
								dos.writeUTF("vanne ALL OFF");}
						}catch (Exception e1) {
							e1.printStackTrace();
						}	
					}
				});
				VanneALL.setBounds(250, 348, 137, 25);
				contentPane.add(VanneALL);
				
				JTextPane msg = new JTextPane();
				msg.setBounds(250, 157, 158, 22);
				/*String vanne=dis.readUTF();
				msg.setText(vanne);
				dis.close();*/
				contentPane.add(msg);
				
				
		
	      
}	
}
