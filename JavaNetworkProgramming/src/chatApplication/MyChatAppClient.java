package chatApplication;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import static java.lang.System.out;

public class MyChatAppClient extends JFrame implements ActionListener {
	String username;
	PrintWriter pw;
	BufferedReader br;
	JTextArea taMessages;
	JTextField tfInput;
	JButton btnSend, btnExit;
	Socket client;

	public MyChatAppClient(String username, String serverName) throws IOException {
		super(username);
		this.username = username;

		client = new Socket(serverName, 9999);
		br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		pw = new PrintWriter(client.getOutputStream(), true);
		pw.println(username);
		buildInterface();
		new MessagesThread().start();

	}

	public void buildInterface() {
		btnSend = new JButton("Send");
		btnExit = new JButton("Exit");
		taMessages = new JTextArea();
		taMessages.setRows(10);
		taMessages.setColumns(50);
		taMessages.setEditable(false);
		tfInput = new JTextField(50);
		JScrollPane sp = new JScrollPane(taMessages, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		add(sp, "Center");
		JPanel bp = new JPanel(new FlowLayout());
		bp.add(tfInput);
		bp.add(btnSend);
		bp.add(btnExit);
		add(bp, "South");
		btnSend.addActionListener(this);
		btnExit.addActionListener(this);

		setSize(550, 300);
		setVisible(true);
		pack();

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btnExit) {
			pw.println("end");
			System.exit(0);
		} else {
			pw.println(tfInput.getText());
		}
	}
	
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog(null, "Enter your name : ", 
				"Username" , JOptionPane.PLAIN_MESSAGE);
		
		String servername = "localhost";
		try {
			new MyChatAppClient(name, servername);
		}catch(Exception exception) {
			out.println("Error : -> " + exception.getMessage());
		}
	}
	
	class MessagesThread extends Thread {
		public void run() {
			String line;
			try {
				while(true) {
					line = br.readLine();
					taMessages.append(line + "\n");
					
					
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
