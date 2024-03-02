package pas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;




public class Pas extends JFrame implements ActionListener {

	

    private Container c;
   
    
    private JTextArea textArea;
    private JTextArea textAreSelectIzmena;
   
	private JButton btnGlavnaStrana;
	private JButton btnVlasnik;
	private JButton btnPrikazi;
	private JButton btnUbaci;
	private JButton btnPromeni;
	private JButton btnIzbrisi;
	
	
	private JLabel labelUbaci;
	private JLabel labelIzmeni;
	private JLabel labelUbaciGodine;
	private JLabel labelIzmeniGodine;
	
	private JLabel labelImePsa;
	private JLabel labelGodinePsa;
	private JLabel labelRasaPsa;
	private JLabel labelVlasnikPsa;
	
	//Labels za select drop down list
	private JLabel labelRasa;
	private JLabel labelVlasnik;
	private JLabel labelPas;
	private JLabel labelGodine;
	
	private JLabel labelRasa2;
	private JLabel labelVlasnik2;
	private JLabel labelPas2;
	private JLabel labelGodine2;
	
	//end
	
	private JLabel labelSelectIzmenaRase;
	private JLabel labelSelectIzmenaVlasnika;
	
	
	private JTextField textUbaciPsa;
	private JTextField textIzmeni;
	private JTextField textUbaciGodine;
	private JTextField textIzmeniGodine;
	
	
	private JLabel labelTextSelect;
	private JLabel labelTextSelect2;
	private JLabel labelTextSelect3;
	private JLabel labelTextSelect4;
	
	
	private JComboBox padajucaListaVlasnik;
	private JComboBox padajucaListaRasa;
	private JComboBox padajucaListaImePsa;
	private JComboBox padajucaListaGodinePsa;
	
	
	private JComboBox padajucaListaVlasnik2;
	private JComboBox padajucaListaRasa2;
	private JComboBox padajucaListaImePsa2;
	private JComboBox padajucaListaGodinePsa2;
	
	
	
	
	public Pas() {
		
		
		
		 
		   setTitle("Pas Forma");
		   setExtendedState(JFrame.MAXIMIZED_BOTH);
		   setDefaultCloseOperation(EXIT_ON_CLOSE);
		   setResizable(false);
		   
		   c = getContentPane();
		   c.setLayout(null);
		   c.setBackground( new Color(161, 0, 0));
		   
		   
		   JTable table = new JTable(); 
		   JTable table2 = new JTable();
		   JTable table3 = new JTable();
		   JTable table4 = new JTable();
		   JTable tableIzmenaRasePsa = new JTable();
		   JTable tableIzmenaVlasnikaPsa = new JTable();
		   
		   
		   
		   JTable tableSelect = new JTable(); 
		   
		   
		   // Kreiranje table modela and set a Column Identifiers to this model 
	       Object[] columns = {"Ime Psa","Godine","Rasa Psa","Vlasnik Psa"};
	       DefaultTableModel modelSelect = new DefaultTableModel();
	       modelSelect.setColumnIdentifiers(columns);
	       
	       // Setiranje modela to the table
	       tableSelect.setModel(modelSelect);
	       
	       
	       tableSelect.setBackground(Color.LIGHT_GRAY);
	       tableSelect.setForeground(Color.black);
	       Font font = new Font("",1,22);
	       tableSelect.setFont(font);
	       tableSelect.setRowHeight(30);
	       
	      
	       JScrollPane paneSelect = new JScrollPane(tableSelect);
	       paneSelect.setSize(400,200);
	       paneSelect.setLocation(400,540);
		   
		   c.add(paneSelect);
		
		   
		  //Starting Combox Padajuce Liste 
		   
		   
		   padajucaListaVlasnik = new JComboBox();
		   padajucaListaVlasnik.setBounds(50, 100,90,20);
		   padajucaListaVlasnik.setSize(150,50);
		   padajucaListaVlasnik.setLocation(840,475);
		   
		   padajucaListaRasa = new JComboBox();
		   padajucaListaRasa.setBounds(50, 100,90,20);
		   padajucaListaRasa.setSize(150,50);
		   padajucaListaRasa.setLocation(665,475);
		   
   		   
		   
		   padajucaListaRasa2 = new JComboBox();
		   padajucaListaRasa2.setBounds(50, 100,90,20);
		   padajucaListaRasa2.setSize(150,50);
		   padajucaListaRasa2.setLocation(675,800);
		   
		   padajucaListaVlasnik2 = new JComboBox();
		   padajucaListaVlasnik2.setBounds(50, 100,90,20);
		   padajucaListaVlasnik2.setSize(150,50);
		   padajucaListaVlasnik2.setLocation(850,800);
		   
	
		   	   
		   		   
		   
		 //End Combox Padajuce Liste 
		   

		   
	     //#5  // Kreiranje table modela and set a Column Identifiers to this model (Izmena Imena Psa)
	       Object[] columns5 = {"Izmena Rase Psa"};
	       DefaultTableModel model5 = new DefaultTableModel();
	       model5.setColumnIdentifiers(columns5);
	       
	    // Setiranje modela to the table
	       tableIzmenaRasePsa.setModel(model5);  
	       
	       
	       //#6  // Kreiranje table modela and set a Column Identifiers to this model (Izmena Godina Psa)
	       Object[] columns6 = {"Izmena Vlasnika Psa"};
	       DefaultTableModel model6 = new DefaultTableModel();
	       model6.setColumnIdentifiers(columns6);
	       
	    // Setiranje modela to the table
	       tableIzmenaVlasnikaPsa.setModel(model6);  
	       
	      
	       
	       tableIzmenaRasePsa.setBackground(Color.LIGHT_GRAY);
	       tableIzmenaRasePsa.setForeground(Color.black);
	       Font font5 = new Font("",1,22);
	       tableIzmenaRasePsa.setFont(font5);
	       tableIzmenaRasePsa.setRowHeight(30);
	      
	       
	       tableIzmenaVlasnikaPsa.setBackground(Color.LIGHT_GRAY);
	       tableIzmenaVlasnikaPsa.setForeground(Color.black);
	       Font font6 = new Font("",1,22);
	       tableIzmenaVlasnikaPsa.setFont(font6);
	       tableIzmenaVlasnikaPsa.setRowHeight(30);
	       
	       
	       
	       c.setLayout(null);
	       
	      
	       c.add(padajucaListaVlasnik);
	       c.add(padajucaListaRasa);
	   
	       c.add(padajucaListaVlasnik2);
	       c.add(padajucaListaRasa2);
	      
	       
	       // Kreiranje array of objects to set the row data
	       Object[] row = new Object[2];
	       
	       Object[] row2 = new Object[4];
	    
	 
		      	   
		   textArea = new JTextArea();
	       textArea.setFont(new Font("Arial", Font.PLAIN, 15));
	       textArea.setSize(400, 400);
	       textArea.setLocation(400, 40);
	       textArea.setLineWrap(true);
	       textArea.setBackground(Color.white);
	       c.add(textArea);
		   
			
		   // Buttons section start 
		   
		   btnGlavnaStrana = new JButton("Idi na pocetnu stranu");
		   btnGlavnaStrana.setFont(new Font("Arial",Font.PLAIN,15));
		   btnGlavnaStrana.setSize(200,50);
		   btnGlavnaStrana.setLocation(550,900);
		   btnGlavnaStrana.addActionListener(this);
		   c.add(btnGlavnaStrana);
		   
		   
		   btnVlasnik = new JButton("Idi na vlasnika");
		   btnVlasnik.setFont(new Font("Arial",Font.PLAIN,15));
		   btnVlasnik.setSize(200,50);
		   btnVlasnik.setLocation(790,900);
		   btnVlasnik.addActionListener(this);
		   c.add(btnVlasnik);
		   
		   
		   
		   btnPrikazi = new JButton("Prikazi sve pse");
		   btnPrikazi.setFont(new Font("Arial",Font.PLAIN,15));
		   btnPrikazi.setSize(200,50);
		   btnPrikazi.setLocation(20,40);
		   btnPrikazi.addActionListener(this);
		   c.add(btnPrikazi);
		   
		   btnUbaci = new JButton("Ubaci novog psa");
		   btnUbaci.setFont(new Font("Arial",Font.PLAIN,15));
		   btnUbaci.setSize(200,50);
		   btnUbaci.setLocation(20,480);
		   btnUbaci.addActionListener(this);
		   c.add(btnUbaci);
		   
		   
		   btnPromeni = new JButton("Promeni selektovanog psa");
		   btnPromeni.setFont(new Font("Arial",Font.PLAIN,15));
		   btnPromeni.setSize(200,50);
		   btnPromeni.setLocation(20,800);
		   btnPromeni.addActionListener(this);
		   c.add(btnPromeni);
		   
		   
		   btnIzbrisi = new JButton("Izbrisi selektovanog psa");
		   btnIzbrisi.setFont(new Font("Arial",Font.PLAIN,15));
		   btnIzbrisi.setSize(200,50);
		   btnIzbrisi.setLocation(20,900);
		   btnIzbrisi.addActionListener(this);
		   c.add(btnIzbrisi);
		   
		   
		//Buttons Section end  
		   
		   
		//Labels Start
		   
		   labelUbaci = new JLabel("Ime psa");
	       labelUbaci.setFont(new Font("Arial", Font.PLAIN, 20));
	       labelUbaci.setSize(200, 20);
	       labelUbaci.setLocation(235, 450);
	       labelUbaci.setForeground(Color.white);
	       c.add(labelUbaci);
	       
	      
	       labelUbaciGodine = new JLabel("Godine psa");
	       labelUbaciGodine.setFont(new Font("Arial", Font.PLAIN, 20));
	       labelUbaciGodine.setSize(200, 20);
	       labelUbaciGodine.setLocation(450, 450);
	       labelUbaciGodine.setForeground(Color.white);
	       c.add(labelUbaciGodine);
	       
	      //Start Select Labels 
	       
	       labelRasa = new JLabel("Rasa psa");
	       labelRasa.setFont(new Font("Arial", Font.PLAIN, 20));
	       labelRasa.setSize(200, 20);
	       labelRasa.setLocation(670, 450);
	       labelRasa.setForeground(Color.white);
	       c.add(labelRasa);
	       
	       
	       labelVlasnik = new JLabel("Vlasnik psa");
	       labelVlasnik.setFont(new Font("Arial", Font.PLAIN, 20));
	       labelVlasnik.setSize(200, 20);
	       labelVlasnik.setLocation(840, 450);
	       labelVlasnik.setForeground(Color.white);
	       c.add(labelVlasnik);
	   
	           
	     
	       labelRasa2 = new JLabel("Izmena rase");
	       labelRasa2.setFont(new Font("Arial", Font.PLAIN, 20));
	       labelRasa2.setSize(200, 20);
	       labelRasa2.setLocation(680, 770);
	       labelRasa2.setForeground(Color.white);
	       c.add(labelRasa2);
	       
	       
	       labelVlasnik2 = new JLabel("Izmena vlasnika");
	       labelVlasnik2.setFont(new Font("Arial", Font.PLAIN, 20));
	       labelVlasnik2.setSize(200, 20);
	       labelVlasnik2.setLocation(850,770);
	       labelVlasnik2.setForeground(Color.white);
	       c.add(labelVlasnik2);
	       

	       	       
	       
	      //End Select Labels 
	       
	       // Label Text Select sekcija start 
	       
	       labelTextSelect = new JLabel("Da bi ste izmenili  psa");
	       labelTextSelect.setFont(new Font("Arial", Font.PLAIN, 20));
	       labelTextSelect.setSize(500, 20);
	       labelTextSelect.setLocation(20,600);
	       labelTextSelect.setForeground(Color.white);
	       c.add(labelTextSelect);
	       
	       
	       labelTextSelect2 = new JLabel("ili izbrisali psa,");
	       labelTextSelect2.setFont(new Font("Arial", Font.PLAIN, 20));
	       labelTextSelect2.setSize(500, 20);
	       labelTextSelect2.setLocation(20,630);
	       labelTextSelect2.setForeground(Color.white);
	       c.add(labelTextSelect2);
	       
	       
	       labelTextSelect3 = new JLabel("najpre morate seletkovati");
	       labelTextSelect3.setFont(new Font("Arial", Font.PLAIN, 20));
	       labelTextSelect3.setSize(500, 20);
	       labelTextSelect3.setLocation(20,660);
	       labelTextSelect3.setForeground(Color.white);
	       c.add(labelTextSelect3);
	       
	       
	       labelTextSelect4 = new JLabel("psa u desnoj formi");
	       labelTextSelect4.setFont(new Font("Arial", Font.PLAIN, 20));
	       labelTextSelect4.setSize(500, 20);
	       labelTextSelect4.setLocation(20,690);
	       labelTextSelect4.setForeground(Color.white);
	       c.add(labelTextSelect4);
	       
	       
	       // Label Text Selekt sekcija end 
	       
	       
	       labelIzmeni = new JLabel("Izmena imena ");
	       labelIzmeni.setFont(new Font("Arial", Font.PLAIN, 20));
	       labelIzmeni.setSize(200, 20);
	       labelIzmeni.setLocation(240, 770);
	       labelIzmeni.setForeground(Color.white);
	       c.add(labelIzmeni);
	       
	       
	       labelIzmeniGodine = new JLabel("Izmena godina");
	       labelIzmeniGodine.setFont(new Font("Arial", Font.PLAIN, 20));
	       labelIzmeniGodine.setSize(200, 20);
	       labelIzmeniGodine.setLocation(450, 770);
	       labelIzmeniGodine.setForeground(Color.white);
	       c.add(labelIzmeniGodine);
	       

	         
		// Labels End    
		   
	   //Text Field  Section Start
		   
		   
		   textUbaciPsa = new JTextField();
	       textUbaciPsa.setFont(new Font("Arial", Font.PLAIN, 15));
	       textUbaciPsa.setSize(200, 50);
	       textUbaciPsa.setLocation(230, 480);
	       c.add(textUbaciPsa);
	       
	       

		   textUbaciGodine = new JTextField();
	       textUbaciGodine.setFont(new Font("Arial", Font.PLAIN, 15));
	       textUbaciGodine.setSize(200, 50);
	       textUbaciGodine.setLocation(440, 480);
	       c.add(textUbaciGodine);
	       
	       
	       textIzmeni = new JTextField();
	       textIzmeni.setFont(new Font("Arial", Font.PLAIN, 15));
	       textIzmeni.setSize(200, 50);
	       textIzmeni.setLocation(240, 800);
	       c.add(textIzmeni);
	       
	       
	       textIzmeniGodine = new JTextField();
	       textIzmeniGodine.setFont(new Font("Arial", Font.PLAIN, 15));
	       textIzmeniGodine.setSize(200, 50);
	       textIzmeniGodine.setLocation(450, 800);
	       c.add(textIzmeniGodine);
	       
	       
	      
		   
	  // Text Field Section end 
		  
		   
		 		   
		   setVisible(true);   

		   
		   
 //Prikaz Liste
 btnPrikazi.addActionListener(new ActionListener(){

		  	 
		  @Override
		  public void actionPerformed(ActionEvent e) {
		  	

		  	try {
		  		
		  		 String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
		  		 String User ="root";
		  		 String Password ="";
		  			
		  		 Class.forName("com.mysql.cj.jdbc.Driver");
		  			
		  		 Connection connection = DriverManager.getConnection(dbURL,User,Password);
		  		 System.out.println("Sada sam konektovan na bazu podataka");
		  		 
		  		 
		  		 // Lista Pasa Sekcija Start
		  	       
		  	      System.out.println("Izvlacenje Imena Psa iz liste baze podataka");
		  	     
		  	      // Ciscenje Text Area  pre ubacivanja podataka
		  	      textArea.setText("");
		  	      

		        String query = "SELECT Pas.ImePsa,Pas.Godine,RasaPsa.ImeRase,VlasnikPsa.ImeVlasnika FROM Pas INNER JOIN RasaPsa ON Pas.RasaID = RasaPsa.RasaID INNER JOIN VlasnikPsa ON Pas.VlasnikID = VlasnikPsa.VlasnikID;";
		        PreparedStatement preparedStatement = connection.prepareStatement(query);

		           
		        ResultSet resultSet = preparedStatement.executeQuery();

		            // Pokazivanje podataka u text area
		            StringBuilder result = new StringBuilder();
		            
		            while (resultSet.next()) {
		            	
		                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
		                	
		                    result.append(resultSet.getString(i)).append("\t");
		                }
		                result.append("\n");
		            }
		            
		            textArea.setText(result.toString());
		            
		            

		           
		             
		            resultSet.close();
		            preparedStatement.close();
		            connection.close();
		            
		            
		        } catch (ClassNotFoundException | SQLException ex) {
		            ex.printStackTrace();
		           
		        }
		  }
		  });	
 
 
 
 //Tabela Select ,popunjavanje polja za izmenu takodje
 tableSelect.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	 
	    @Override
	    public void valueChanged(ListSelectionEvent e) {
	    	
	        if (!e.getValueIsAdjusting()) {
	        	
	            int selectedRowIndex = tableSelect.getSelectedRow();
	            
	            if (selectedRowIndex != -1) {
	            	
	                String imePsa = tableSelect.getValueAt(selectedRowIndex, 0).toString();
	                String godine = tableSelect.getValueAt(selectedRowIndex, 1).toString();
	                String rasaPsa = tableSelect.getValueAt(selectedRowIndex, 2).toString();
	                String vlasnikPsa = tableSelect.getValueAt(selectedRowIndex, 3).toString();

	                // Ciscenje dropdown liste da se ne pokazuju duplikati
	                padajucaListaRasa2.removeAllItems();
	                padajucaListaVlasnik2.removeAllItems();

	              
	                textIzmeni.setText(imePsa);
	                textIzmeniGodine.setText(godine);

	                // Add all items from the full list to the dropdown list
	                for (int i = 0; i < padajucaListaRasa.getItemCount(); i++) {
	                	
	                    padajucaListaRasa2.addItem(padajucaListaRasa.getItemAt(i));
	                }

	                // Dodavanje itema koji sam selectovao u tabel
	                padajucaListaRasa2.setSelectedItem(rasaPsa);
	                

	                // Add all items from the full list to the vlasnik dropdown list
	                for (int i = 0; i < padajucaListaVlasnik.getItemCount(); i++) {
	                	
	                    padajucaListaVlasnik2.addItem(padajucaListaVlasnik.getItemAt(i));
	                }

	                // Dodavanje itema koji sam selectovao u tabel
	                padajucaListaVlasnik2.setSelectedItem(vlasnikPsa);
	            }
	        }
	    }
	});

	


//Prikaz u arei za Select, za izmenu
 btnPrikazi.addActionListener(new ActionListener(){
	   
     @Override
     public void actionPerformed(ActionEvent e) {
    	 
  	   
  	   try {
  		   
             String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
             String user = "root";
             String password = "";

             Class.forName("com.mysql.cj.jdbc.Driver");

             try (Connection connection = DriverManager.getConnection(dbURL, user, password)) {
                 System.out.println("Konektovani smo na bazu podataka");
                 
                 modelSelect.setRowCount(0);
                 
                 String query = "SELECT Pas.ImePsa, Pas.Godine, RasaPsa.ImeRase, VlasnikPsa.ImeVlasnika " +
                                "FROM Pas " +
                                "INNER JOIN RasaPsa ON Pas.RasaID = RasaPsa.RasaID " +
                                "INNER JOIN VlasnikPsa ON Pas.VlasnikID = VlasnikPsa.VlasnikID";
                 
                 PreparedStatement statement = connection.prepareStatement(query);
                 
                 ResultSet resultSet = statement.executeQuery();

                
              

                 while (resultSet.next()) {
                	 
                     String imePsa = resultSet.getString("ImePsa");
                     String godine = resultSet.getString("Godine");
                     String imeRase = resultSet.getString("ImeRase");
                     String imeVlasnika = resultSet.getString("ImeVlasnika");

                     modelSelect.addRow(new Object[]{imePsa, godine, imeRase, imeVlasnika});
                 }

                 connection.close();
             }
         } catch (Exception ex) {
             ex.printStackTrace();
         }
     }
 });

			
		   
	 
	 //Nazad da glavnu formu
	 btnGlavnaStrana.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 Odgajivacnica odgajivacnica = new Odgajivacnica();
	     odgajivacnica.setVisible(true);
			
	}
	});
	   
	   
	 //Nazad da glavnu formu
	btnVlasnik.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			VlasnikPsa v1 = new VlasnikPsa();
			v1.setVisible(true);
				
		}
		});
	   
	   
	   
	   
	   
	   //Akcije koje su povezane sa SELECT iz liste mogucnosti za Ubaci u bazu
	   
	  
	// Button Prikazi za Select ImeRase i Prikaz za Select za Izmenu Rase
	   btnPrikazi.addActionListener(new ActionListener(){
		   
	       @Override
	       public void actionPerformed(ActionEvent e) {
	    	   
	    	   try {
	    		   
	               String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
	               String user = "root";
	               String password = "";

	               Class.forName("com.mysql.cj.jdbc.Driver");

	               try (Connection connection = DriverManager.getConnection(dbURL, user, password)) {
	                   System.out.println("Connected to the database");
	                   
	                   //Cistim drop down liste da ne bi doslo do dupliranja
	                   padajucaListaRasa.removeAllItems();
	                   padajucaListaRasa2.removeAllItems();
	                   
	                   String selectQuery = "SELECT RasaID, ImeRase FROM RasaPsa";
	                   PreparedStatement statement = connection.prepareStatement(selectQuery);
	                   
	                   ResultSet resultSet = statement.executeQuery();

	                  

	                   
	                   while (resultSet.next()) {
	                	   
	                       String imeRase = resultSet.getString("ImeRase");
	                       
	                	   padajucaListaRasa.addItem(resultSet.getString("imeRase"));
	                	   
	                	   padajucaListaRasa2.addItem(resultSet.getString("imeRase"));
	                	   
	                   
	                       
	                   }

	                   connection.close();
	               }
	           } catch (Exception ex) {
	               ex.printStackTrace();
	           }
	       }
	   });
	    	  
	   
	   
		  
		// Button Prikazi za Select Vlasnik i select za update Vlasnik
		   btnPrikazi.addActionListener(new ActionListener(){
			   
		       @Override
		       public void actionPerformed(ActionEvent e) {
		    	   
		        
		    	  
		    	   try {
		    		   
		               String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
		               String user = "root";
		               String password = "";

		               Class.forName("com.mysql.cj.jdbc.Driver");

		               try (Connection connection = DriverManager.getConnection(dbURL, user, password)) {
		                   System.out.println("Connected to the database");
		                   
		                 //Cistim drop down liste da ne bi doslo do dupliranja
		                   padajucaListaVlasnik.removeAllItems();
		                   padajucaListaVlasnik2.removeAllItems();
		                   
		                   String selectQuery = "SELECT  ImeVlasnika FROM VlasnikPsa";
		                   PreparedStatement statement = connection.prepareStatement(selectQuery);
		                   
		                   ResultSet resultSet = statement.executeQuery();

		                   //model2.setRowCount(0);
		                   model6.setRowCount(0);
		                   

		                   // Populate the table model with data from the ResultSet
		                   while (resultSet.next()) {
		                       
		                	   String imeVlasnika = resultSet.getString("ImeVlasnika");
		                	   
		                	   
		                	  //padajucaListaVlasnik.add(new Object[] {imeVlasnika});
		                	  padajucaListaVlasnik.addItem(resultSet.getString("ImeVlasnika")); 
		                	   
		                	  padajucaListaVlasnik2.addItem(resultSet.getString("ImeVlasnika"));
		                	   
		                	   
		                	  
		                       
		                	   
		               
		                       
		                   }

		                   connection.close();
		               }
		           } catch (Exception ex) {
		               ex.printStackTrace();
		           }
		       }
		   });
		   
		   
		// Button Prikazi za Select Ime Psa
		   btnPrikazi.addActionListener(new ActionListener(){
			   
		       @Override
		       public void actionPerformed(ActionEvent e) {
		    	   
		        
		    	  
		    	   try {
		    		   
		               String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
		               String user = "root";
		               String password = "";

		               Class.forName("com.mysql.cj.jdbc.Driver");

		               try (Connection connection = DriverManager.getConnection(dbURL, user, password)) {
		                   System.out.println("Connected to the database");
		                   
		                   String selectQuery = "SELECT  ImePsa FROM Pas";
		                   PreparedStatement statement = connection.prepareStatement(selectQuery);
		                   
		                   ResultSet resultSet = statement.executeQuery();

		      

		                   // Populate the table model with data from the ResultSet
		                   while (resultSet.next()) {
		                       
		                       //String imePsa = resultSet.getString("ImePsa");
		                	   
		                	   padajucaListaImePsa.addItem(resultSet.getString("ImePsa"));
		                	   
		                	   padajucaListaImePsa2.addItem(resultSet.getString("ImePsa"));
		                     
		                 
		                     
		                   }

		                   connection.close();
		               }
		           } catch (Exception ex) {
		               ex.printStackTrace();
		           }
		       }
		   });
		   
		// Button Prikazi za Select Godine Psa
		   btnPrikazi.addActionListener(new ActionListener(){
			   
		       @Override
		       public void actionPerformed(ActionEvent e) {
		    	   
		        
		    	   try {
		    		   
		               String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
		               String user = "root";
		               String password = "";

		               Class.forName("com.mysql.cj.jdbc.Driver");

		               try (Connection connection = DriverManager.getConnection(dbURL, user, password)) {
		                   System.out.println("Connected to the database");
		                   
		                   String selectQuery = "SELECT  Godine FROM Pas";
		                   PreparedStatement statement = connection.prepareStatement(selectQuery);
		                   ResultSet resultSet = statement.executeQuery();

		               

		                   // Populate the table model with data from the ResultSet
		                   while (resultSet.next()) {
		                       
		                    //String godinePsa = resultSet.getString("Godine");
		                    
		               
		                       
		                    padajucaListaGodinePsa.addItem(resultSet.getString("Godine"));
		                 
		                    padajucaListaGodinePsa2.addItem(resultSet.getString("Godine"));
		                 
		               
		                	  
		                      
		                   }

		                   connection.close();
		               }
		           } catch (Exception ex) {
		               ex.printStackTrace();
		           }
		       }
		   });
		   
	 // button  Add
     btnUbaci.addActionListener(new ActionListener(){
    	 
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	      
    	    	 String imePsa = textUbaciPsa.getText();
                 String godine = textUbaciGodine.getText();

                 int confirmResult = JOptionPane.showConfirmDialog(btnUbaci, "Da li želite da dodate novog Psa?",
                         "Confirmation", JOptionPane.YES_NO_OPTION);

                 if (confirmResult == JOptionPane.YES_OPTION) {
                	 
                     try {
                    	 
                         String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
                         String user = "root";
                         String password = "";

                         Class.forName("com.mysql.cj.jdbc.Driver");

                         try (Connection connection = DriverManager.getConnection(dbURL, user, password)) {
                             System.out.println("Konektovani ste na bazu podataka");

                             int selectedRowIndexRasa = padajucaListaRasa.getSelectedIndex();
                             int selectedRowIndexVlasnik = padajucaListaVlasnik.getSelectedIndex();

                             if (selectedRowIndexRasa >= 0 && selectedRowIndexVlasnik >= 0) {
                                 
                            	 String selectedItemRasa = padajucaListaRasa.getSelectedItem().toString();
                                 String selectedItemVlasnik = padajucaListaVlasnik.getSelectedItem().toString();

                                 // Retrieve the corresponding IDs from the database
                                 int selectedRasaID = getRasaID(selectedItemRasa, connection);
                                 int selectedVlasnikID = getVlasnikID(selectedItemVlasnik, connection);

                        
                                 // Insert into the database using the retrieved IDs
                                 String insertQuery = "INSERT INTO Pas (ImePsa, Godine, RasaID, VlasnikID) "
                                         + "VALUES (?, ?, ?, ?)";

                                 try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                                     statement.setString(1, imePsa);
                                     statement.setString(2, godine);
                                     statement.setInt(3, selectedRasaID);
                                     statement.setInt(4, selectedVlasnikID);

                                     int rowsAdded = statement.executeUpdate();

                                     if (rowsAdded > 0) {
                                         JOptionPane.showMessageDialog(btnUbaci, "Uspesno ste ubacili novog psa");
                                   
                                     } else {
                                         JOptionPane.showMessageDialog(btnUbaci, "Doslo je do greske pri dodavanju psa");
                                     }
                                 }
                             } else {
                                 JOptionPane.showMessageDialog(btnUbaci, "Morate da selektujete  rows u obe tabele");
                             }
                         }
                     } catch (NumberFormatException ex) {
                         JOptionPane.showMessageDialog(btnUbaci, "Invalid ID format: " + ex.getMessage(), "Error",
                                 JOptionPane.ERROR_MESSAGE);
                     } catch (SQLException ex) {
                         ex.printStackTrace();
                         JOptionPane.showMessageDialog(btnUbaci, "An error occurred: " + ex.getMessage(), "Error",
                                 JOptionPane.ERROR_MESSAGE);
                     } catch (Exception ex) {
                         ex.printStackTrace();
                         JOptionPane.showMessageDialog(btnUbaci, "An unexpected error occurred: " + ex.getMessage(),
                                 "Error", JOptionPane.ERROR_MESSAGE);
                     }
                 }
             }
         
     
     // Pomocna metoda  da  retrieve the corresponding IDs from the database
     private int getRasaID(String imeRase, Connection connection) throws SQLException {
    	 
         String selectQuery = "SELECT RasaID FROM RasaPsa WHERE ImeRase = ?";
         
         try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
             statement.setString(1, imeRase);
             
             ResultSet resultSet = statement.executeQuery();
             
             if (resultSet.next()) {
                 return resultSet.getInt("RasaID");
                 
             } else {
                 throw new SQLException("Rasa not found for ImeRase: " + imeRase);
             }
         }
     }

     private int getVlasnikID(String imeVlasnika, Connection connection) throws SQLException {
    	 
         String selectQuery = "SELECT VlasnikID FROM VlasnikPsa WHERE ImeVlasnika = ?";
         
         try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
             statement.setString(1, imeVlasnika);
             
             ResultSet resultSet = statement.executeQuery();
             
             if (resultSet.next()) {
            	 
                 return resultSet.getInt("VlasnikID");
                 
             } else {
                 throw new SQLException("Vlasnik not found for ImeVlasnika: " + imeVlasnika);
             }
	       }
     }
     });
     
     //Akcija Delete
     // button remove row
     btnIzbrisi.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent e) {
      	   
     //Dodavanje da ili ne pitanje 		
     int confirmResult = JOptionPane.showConfirmDialog(c, "Da li  zelite da izbrisete  Psa?", "Confirmation", JOptionPane.YES_NO_OPTION);
      		        		 
     if (confirmResult == JOptionPane.YES_OPTION) {  	     
      	   
      	   try {
      		   
                 String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
                 String user = "root";
                 String password = "";

                 Class.forName("com.mysql.cj.jdbc.Driver");

                 Connection connection = DriverManager.getConnection(dbURL, user, password);
                 System.out.println("Konektovani ste na bazu podataka");

                 
                 
                 int selectedRowIndexImePsa = tableSelect.getSelectedRow();
                
                 
                 if ( selectedRowIndexImePsa  >= 0) {
              	   
                  
                     String selectedItem3 = tableSelect.getValueAt(selectedRowIndexImePsa, 0).toString();
                   

                     
                   
                     String deleteQuery = "DELETE  FROM Pas WHERE ImePsa = ?";
                     PreparedStatement statement = connection.prepareStatement(deleteQuery);

                     
                     statement.setString(1, selectedItem3);

              
                     int rowsDeleted = statement.executeUpdate();
                     
                     if (rowsDeleted > 0) {
                         JOptionPane.showMessageDialog(btnIzbrisi, "Uspesno ste izbrisali psa");
                       
                         ((DefaultTableModel) table.getModel()).removeRow(selectedRowIndexImePsa);
                     } else {
                         JOptionPane.showMessageDialog(btnIzbrisi, "Doslo je do greske pri brisanju psa");
                     }

                     statement.close();
                 } else {
              	   
               JOptionPane.showMessageDialog(btnIzbrisi, "No row selected");
                 }

                 connection.close();
             } catch (Exception ex) {
                 ex.printStackTrace();
             }
         }
         }
     });
	 
     
  // Akcija Update 
   btnPromeni.addActionListener(new ActionListener() {
	   
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	
    	    	 String imePsa = textIzmeni.getText();
                 String godine = textIzmeniGodine.getText();
    	    	
    	    	
    	        int confirmResult = JOptionPane.showConfirmDialog(btnPromeni, "Da li želite da izmenite podatke o psu?",
    	                "Confirmation", JOptionPane.YES_NO_OPTION);

    	        if (confirmResult == JOptionPane.YES_OPTION) {
    	        	
    	            try {
    	            	
    	                String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
    	                String user = "root";
    	                String password = "";

    	                Class.forName("com.mysql.cj.jdbc.Driver");

    	                try (Connection connection = DriverManager.getConnection(dbURL, user, password)) {
    	                    System.out.println("Konektovani ste na bazu podataka");
    	                    

    	                    int selectedRowIndexRasa = padajucaListaRasa2.getSelectedIndex();
                            int selectedRowIndexVlasnik = padajucaListaVlasnik2.getSelectedIndex();
                            
    	                    int selectedRowIndexImePsa = tableSelect.getSelectedRow();

    	                    if (selectedRowIndexImePsa >= 0) {

    	                        String updatedValueImePsa = textIzmeni.getText();
    	                        String updatedValueGodine = textIzmeniGodine.getText();
    	                        
    	                        String selectedItemRasa = padajucaListaRasa2.getSelectedItem().toString();
                                String selectedItemVlasnik = padajucaListaVlasnik2.getSelectedItem().toString();

                                // Retrieve the corresponding IDs from the database
                                int selectedRasaID = getRasaID(selectedItemRasa, connection);
                                int selectedVlasnikID = getVlasnikID(selectedItemVlasnik, connection);


    	                        String selectImePsaString = tableSelect.getValueAt(selectedRowIndexImePsa, 0).toString();

    	                        String updateQuery = "UPDATE Pas SET ImePsa = ?, Godine = ?, RasaID = ?, VlasnikID = ? WHERE ImePsa = ?";
    	                       
    	                        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
    	                            statement.setString(1, updatedValueImePsa);
    	                            statement.setString(2, updatedValueGodine);
    	                            statement.setInt(3, selectedRasaID);
    	                            statement.setInt(4, selectedVlasnikID);
    	                            statement.setString(5, selectImePsaString);
    	                            
    	                           
    	                     
    	                            int rowsUpdated = statement.executeUpdate();

    	                            if (rowsUpdated > 0) {
    	                                JOptionPane.showMessageDialog(btnPromeni, "Uspesno ste izmenili podatke o psu");
    	                            } else {
    	                                JOptionPane.showMessageDialog(btnPromeni,
    	                                        "Doslo je do greske pri izmeni podataka o psu");
    	                            }
    	                        }
    	                    } else {
    	                        JOptionPane.showMessageDialog(btnPromeni, "Niste selektovali nijedan red u tabeli");
    	                    }
    	                }
    	            } catch (ClassNotFoundException ex) {
    	                ex.printStackTrace();
    	                JOptionPane.showMessageDialog(btnPromeni, "Driver not found", "Error",
    	                        JOptionPane.ERROR_MESSAGE);
    	            } catch (SQLException ex) {
    	                ex.printStackTrace();
    	                JOptionPane.showMessageDialog(btnPromeni, "Error: " + ex.getMessage(),
    	                        "Database Error", JOptionPane.ERROR_MESSAGE);
    	            }
    	        }
    	    }
   }); 
	}


    		  
    // Pomocna metoda  da  retrieve the corresponding IDs from the database
    private int getRasaID(String imeRase, Connection connection) throws SQLException {
   	 
        String selectQuery = "SELECT RasaID FROM RasaPsa WHERE ImeRase = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setString(1, imeRase);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	
                return resultSet.getInt("RasaID");
                
            } else {
                throw new SQLException("Rasa not found for ImeRase: " + imeRase);
            }
        }
    }

    private int getVlasnikID(String imeVlasnika, Connection connection) throws SQLException {
   	 
        String selectQuery = "SELECT VlasnikID FROM VlasnikPsa WHERE ImeVlasnika = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setString(1, imeVlasnika);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	
                return resultSet.getInt("VlasnikID");
                
            } else {
                throw new SQLException("Vlasnik not found for ImeVlasnika: " + imeVlasnika);
            }
	       }
    }
   
   
  
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
     
	}
