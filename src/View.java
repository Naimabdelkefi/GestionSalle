import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.List;
import  java.time.LocalDate;
import java.sql.Timestamp;
import java.awt.Desktop;


import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;
import java.sql.*;

public class View extends JFrame {
	public View() {


		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());


		JPanel head=new JPanel();


		JLabel title=new JLabel("Gestion des Salles");
		title.setFont(new Font("Verdana",1,20));
		JLabel labelDate=new JLabel("Date:");
		head.add(title);
		head.setBorder(new LineBorder(Color.BLACK));

		List<String> salleList = new ArrayList<String>();
		salleList.add("Amphi I");
		salleList.add("Amphi II");
		salleList.add("Amphi III");
		salleList.add("Amphi IV");
		salleList.add("Amphi V");
		salleList.add("Amphi VI");
		salleList.add("Thèse");
		salleList.add("Comité");
		salleList.add("Réunion");
		salleList.add("Conseil");
		salleList.add("Méde-fam");
		salleList.add("Anatomie");
		salleList.add("Simulation1");
		salleList.add("Simulation2");
		salleList.add("Simulation3");
		salleList.add("PAQ I");
		salleList.add("PAQ II");
		salleList.add("PAQ III");
		salleList.add("F4");
		salleList.add("F5");
		salleList.add("F6");
		salleList.add("F7");
		salleList.add("G1");
		salleList.add("G2");
		salleList.add("G3");
		salleList.add("Labo Histo");
		salleList.add("Labo Physio");
		salleList.add("Médiatheque 1");
		salleList.add("Médiatheque 2");
		salleList.add("Médiatheque 3");
		salleList.add("Sous Sol 1");
		salleList.add("Sous Sol 2");
		salleList.add("Sous Sol 3");

		Choice salle= new Choice();
		for (String sl : salleList) {
			salle.add(sl);
		}
		/*salle.add("Amphi I");
		salle.add("Amphi II");
		salle.add("Amphi III");
		salle.add("Amphi IV");
		salle.add("Amphi V");
		salle.add("Amphi VI");
		salle.add("Thèse");
		salle.add("Comité");
		salle.add("Réunion");
		salle.add("Conseil");
		salle.add("Méde-fam");
		salle.add("Anatomie");
		salle.add("Simulation1");
		salle.add("Simulation2");
		salle.add("Simulation3");
		salle.add("PAQ I");
		salle.add("PAQ II");
		salle.add("PAQ III");
		salle.add("F4");
		salle.add("F5");
		salle.add("F6");
		salle.add("F7");
		salle.add("G1");
		salle.add("G2");
		salle.add("G3");
		salle.add("Labo Histo");
		salle.add("Labo Physio");
		salle.add("Médiatheque 1");
		salle.add("Médiatheque 2");
		salle.add("Médiatheque 3");
		salle.add("Sous Sol 1");
		salle.add("Sous Sol 2");
		salle.add("Sous Sol 3");*/
		JLabel salleLabel=new JLabel("Salle:");
		JPanel sallePanel=new JPanel();
		sallePanel.add(salleLabel);
		sallePanel.add(salle);


		JPanel heurePanel= new JPanel();
		JLabel h1l=new JLabel("8 ----- 10H");
		JTextField h1 = new JTextField(15);
		JLabel h2l=new JLabel("10----12H");
		JTextField h2 = new JTextField(15);
		JLabel h3l=new JLabel("12----14H");
		JTextField h3 = new JTextField(15);
		JLabel h4l=new JLabel("14-----16H");
		JTextField h4 = new JTextField(15);
		JLabel h5l=new JLabel("16------18H");
		JTextField h5 = new JTextField(15);
		JLabel h6l=new JLabel("18------20H");
		JTextField h6 = new JTextField(15);
		heurePanel.setLayout(new BoxLayout(heurePanel, BoxLayout.Y_AXIS));
		heurePanel.add(h1l);
		heurePanel.add(h1);
		heurePanel.add(h2l);
		heurePanel.add(h2);
		heurePanel.add(h3l);
		heurePanel.add(h3);
		heurePanel.add(h4l);
		heurePanel.add(h4);
		heurePanel.add(h5l);
		heurePanel.add(h5);
		heurePanel.add(h6l);
		heurePanel.add(h6);

		List<JTextField> tfList = new ArrayList<JTextField>();
		tfList.add(h1);
		tfList.add(h2);
		tfList.add(h3);
		tfList.add(h4);
		tfList.add(h5);
		tfList.add(h6);

		JPanel date2=new JPanel(new GridLayout(5,1));
		date2.add(labelDate);
		date2.add(datePicker);
		date2.add(sallePanel);
		Button afficherButton= new Button("Afficher");
		date2.add(afficherButton);
		JPanel westPanel =new JPanel();
		westPanel.setLayout(new BorderLayout());
		Button Save = new Button("Enregistrer");
		westPanel.add("North",date2);
		westPanel.add("Center",heurePanel);
		westPanel.add("South",Save);
		westPanel.setBorder( new EmptyBorder( 3, 10, 3, 0 ) );
		setLayout(new BorderLayout());
		GridBagConstraints c=new GridBagConstraints();
		add("West",westPanel);

		add("North",head);



		JPanel FilterPanel= new JPanel();
		FilterPanel.setLayout(new GridLayout(6,1));



		JLabel filterSalleLabel=new JLabel("Salle");
		Choice salle1= new Choice();
		for (String sl : salleList) {
			salle1.add(sl);
		}
		/*salle1.add("Amphi I");
		salle1.add("Amphi II");
		salle1.add("Amphi III");
		salle1.add("Amphi IV");
		salle1.add("Amphi V");
		salle1.add("Amphi VI");
		salle1.add("Thèse");
		salle1.add("Comité");
		salle1.add("Réunion");
		salle1.add("Conseil");
		salle1.add("Méde-fam");
		salle1.add("Anatomie");
		salle1.add("Simulation1");
		salle1.add("Simulation2");
		salle1.add("Simulation3");
		salle1.add("PAQ I");
		salle1.add("PAQ II");
		salle1.add("PAQ III");
		salle1.add("F4");
		salle1.add("F5");
		salle1.add("F6");
		salle1.add("F7");
		salle1.add("G1");
		salle1.add("G2");
		salle1.add("G3");
		salle1.add("Labo Histo");
		salle1.add("Labo Physio");
		salle1.add("Médiatheque 1");
		salle1.add("Médiatheque 2");
		salle1.add("Médiatheque 3");
		salle1.add("Sous Sol 1");
		salle1.add("Sous Sol 2");
		salle1.add("Sous Sol 3");*/

		JLabel ChercherPanel=new JLabel("Chercher");
		JLabel filterDate=new JLabel("Date");
		FilterPanel.add(ChercherPanel);
		FilterPanel.add(filterDate);
		FilterPanel.add(datePicker2);
		FilterPanel.add(filterSalleLabel);
		FilterPanel.add(salle1);
        Button chercher = new Button("Chercher");
        FilterPanel.add(chercher);
        FilterPanel.setBorder(new EmptyBorder( 3, 0, 3, 10 ));

        JPanel exportPanel= new JPanel();
        exportPanel.setLayout(new GridLayout(5,1));
        JLabel exportlabel= new JLabel("Exporter");
		JLabel ExporterSalleLabel=new JLabel("Salle");
		Choice salle2= new Choice();
		for (String sl : salleList) {
			salle2.add(sl);
		}

		Button exportButton = new Button("Exporter");
		Button openButton = new Button("Ouvrir Dossier");
		exportPanel.add(exportlabel);
		exportPanel.add(ExporterSalleLabel);
		exportPanel.add(salle2);
		exportPanel.add(exportButton);
		exportPanel.add(openButton);


		JPanel eastPanel=new JPanel();
		eastPanel.setLayout(new GridLayout(2,1));
		eastPanel.add(FilterPanel);
		eastPanel.add(exportPanel);



        add("East",eastPanel);

		JPanel infoPanel =new JPanel();
		JTextArea info =new JTextArea(2,200);
		info.setEnabled(false);
		JLabel infoLabel= new JLabel("Info:");
		infoPanel.add(infoLabel);
		infoPanel.add(info);
		info.setFont(new Font("sansserif", Font.PLAIN, 16));
		//info.setBackground(Color.gray);
		add("South",info);


		Save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Date selectedDatePicker = (Date) datePicker.getModel().getValue();
				LocalDate selectedDate = selectedDatePicker.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionsalle", "root", "");
					PreparedStatement preparedStatement = con.prepareStatement ("INSERT INTO `" +salle.getSelectedItem() +"` (`date`, `8h-10h`, `10h-12h`, `12h-14h`, `14h-16h`, `16h-18h`, `18h-20h`) VALUES (?,?,?,?,?,?,?)"+
							"ON DUPLICATE KEY UPDATE `8h-10h`= ?,`10h-12h`= ?, `12h-14h`= ?, `14h-16h`= ?, `16h-18h`= ?, `18h-20h`= ?;"
							);
					java.sql.Date sqlDate = new java.sql.Date(selectedDatePicker.getTime());
					preparedStatement.setDate (1,sqlDate);
					int i=2;
					for (JTextField tf : tfList) {
						preparedStatement.setObject(i,tf.getText());
						preparedStatement.setObject(i+6,tf.getText());
						i++;
					}

					preparedStatement.executeUpdate ( );
					info.setText("Success");
					for (JTextField tf : tfList) {
						tf.setText("");
					}
				}
				catch(Exception ex){
					info.setText(ex.getMessage());
					System.out.println(ex);
				}
			}
		});
		//chercher panel

		chercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame newFrame = new JFrame("Chercher par Salle");
				newFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				Date selectedDatePicker = (Date) datePicker2.getModel().getValue();
				LocalDate selectedDate = selectedDatePicker.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				java.sql.Date sqlDate = new java.sql.Date(selectedDatePicker.getTime());
				JPanel heure1= new JPanel();
				heure1.setLayout(new BoxLayout(heure1, BoxLayout.Y_AXIS));
				JLabel SalleLabel= new JLabel(salle1.getSelectedItem());
				SalleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				heure1.add(SalleLabel);
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionsalle", "root", "");
					PreparedStatement preparedStatement = con.prepareStatement("SELECT * from  `"+salle1.getSelectedItem()+"` where date= '"+sqlDate+" '");
					ResultSet resultSet = preparedStatement.executeQuery();
					ResultSetMetaData rsmd = resultSet.getMetaData();
					int columnsNumber = rsmd.getColumnCount();
					while (resultSet.next()) {
						for (int i = 1; i <= columnsNumber ; i++) {
								String columnValue = resultSet.getString(i);
								JLabel hlabel = new JLabel(rsmd.getColumnName(i));
								JTextField htext = new JTextField(15);
								htext.setText(columnValue);
								htext.setEditable(false);
								heure1.add(hlabel);
								heure1.add(htext);
								System.out.print(columnValue + " " + rsmd.getColumnName(i));
                            info.setText("Success");
						}

					}
				}

				catch(Exception ex){
                    info.setText(ex.getMessage());
					System.out.println(ex);
				}

				newFrame.pack();
				newFrame.setVisible(true);
				newFrame.setSize(200,400);
				newFrame.add(heure1);
				newFrame.setLocationRelativeTo(null);

			}
		});
		exportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionsalle", "root", "");
                    PreparedStatement preparedStatement = con.prepareStatement ("(SELECT 'date','8h-10h','10h-12h','12h-14h','14h-16h','16h-18h','18h-20h') " +
                            "UNION (SELECT * FROM `"+salle2.getSelectedItem()+"` WHERE 1 " +
                            "INTO OUTFILE 'C:/wamp64/tmp/"+salle2.getSelectedItem()+" "+ new SimpleDateFormat("ddMMMMMyyyy HHmmss").format(new Date(new Timestamp(System.currentTimeMillis()).getTime()))+".csv' " +
                            "FIELDS ENCLOSED BY '\"' " +
                            "TERMINATED BY ';' " +
                            "ESCAPED BY '\"' " +
                            "LINES TERMINATED BY '\\r\\n')"
                    );
					preparedStatement.executeUpdate ( );
					info.setText("Success");
				}
				catch(Exception ex){
                    info.setText(ex.getMessage());
					System.out.println(ex);
				}
			}
		});
		openButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().open(new File("C:\\wamp64\\tmp"));
					info.setText("Success");
				} catch (IOException ex) {
					ex.printStackTrace();
					info.setText(ex.getMessage());
				}
			}
		});

		afficherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (JTextField tf : tfList) {
					tf.setText("");
				}

				Date selectedDatePicker = (Date) datePicker.getModel().getValue();
				LocalDate selectedDate = selectedDatePicker.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				java.sql.Date sqlDate = new java.sql.Date(selectedDatePicker.getTime());
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionsalle", "root", "");
					PreparedStatement preparedStatement = con.prepareStatement("SELECT * from  `"+salle.getSelectedItem()+"` where date= '"+sqlDate+" '");
					ResultSet resultSet = preparedStatement.executeQuery();
					ResultSetMetaData rsmd = resultSet.getMetaData();
					int columnsNumber = rsmd.getColumnCount();
					while (resultSet.next()) {
						int i=2;
						for (JTextField tf : tfList) {
							tf.setText(resultSet.getString(i));
							i++;
						}
						}
			}

				catch(Exception  ex ){
					info.setText(ex.getMessage());
					System.out.println(ex);
				}
			}
		});

		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(500,550);
		setTitle("Gestion Salle");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}


	public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

		private String datePattern = "yyyy-MM-dd";
		private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}

			return "";
		}

	}

}
