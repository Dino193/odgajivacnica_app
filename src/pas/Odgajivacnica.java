package pas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.security.auth.Subject;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Odgajivacnica extends JFrame implements ActionListener {

	
	
    private Container c;
	private JTextArea textArea;
	private JTextArea textAreaRasaPsa;
	private JTextArea textAreaVlasnik;
	
	private JLabel labelImePsa;
	private JLabel labelGodinePsa;
	private JLabel labelRasaPsa;
	private JLabel labelVlasnikPsaJ;
	
	private JLabel labelListaImeRase;
	private JLabel labelListaVlasnika;
	private JLabel labelListaPsa;
	
	
	private JButton btnShowImeRaseList;
	private JButton btnShowImeVlasnikaList;
	private JButton btnShowImePsaList;
	
	private JButton btnRasaForma;
	private JButton btnVlasnikForma;
	private JButton btnPasForma;
	
	
	
   public Odgajivacnica() {
	   
	   setTitle("Odgajivacnica Forma");
	   setBounds(300,90,900,600);
	   setExtendedState(JFrame.MAXIMIZED_BOTH);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   setResizable(false);
	   
	   c = getContentPane();
	   c.setLayout(null);
	   c.setBackground(Color.BLUE);
	   
	   
	  // Start Text Areas
	   
	   
	   textArea = new JTextArea();
       textArea.setFont(new Font("Arial", Font.PLAIN, 15));
       textArea.setSize(400, 300);
       textArea.setLocation(1100, 50);
       textArea.setLineWrap(true);
       textArea.setBackground(Color.YELLOW);
       c.add(textArea);
       
       
       textAreaRasaPsa = new JTextArea();
       textAreaRasaPsa.setFont(new Font("Arial", Font.PLAIN, 15));
       textAreaRasaPsa.setSize(400, 300);
       textAreaRasaPsa.setLocation(30, 50);
       textAreaRasaPsa.setLineWrap(true);
       textAreaRasaPsa.setBackground(Color.GRAY);
       c.add(textAreaRasaPsa);
       
       textAreaVlasnik = new JTextArea();
       textAreaVlasnik.setFont(new Font("Arial", Font.PLAIN, 15));
       textAreaVlasnik.setSize(400, 300);
       textAreaVlasnik.setLocation(565, 50);
       textAreaVlasnik.setLineWrap(true);
       textAreaVlasnik.setBackground(Color.PINK);
       c.add(textAreaVlasnik);
       
     
     //End Text Area
       
       
     // Start Labels
       
       labelListaImeRase = new JLabel("Prikaz svih rasa");
       labelListaImeRase.setFont(new Font("Arial", Font.PLAIN, 20));
       labelListaImeRase.setSize(150, 20);
       labelListaImeRase.setLocation(35, 20);
       labelListaImeRase.setForeground(Color.white);
       c.add(labelListaImeRase);
       
       
       labelListaVlasnika = new JLabel("Prikaz svih vlasnika");
       labelListaVlasnika.setFont(new Font("Arial", Font.PLAIN, 20));
       labelListaVlasnika.setSize(200, 20);
       labelListaVlasnika.setLocation(565, 20);
       labelListaVlasnika.setForeground(Color.white);
       c.add(labelListaVlasnika);
       
       
       
       labelListaImeRase = new JLabel("Prikaz svih pasa");
       labelListaImeRase.setFont(new Font("Arial", Font.PLAIN, 20));
       labelListaImeRase.setSize(200, 50);
       labelListaImeRase.setLocation(1100,7);
       labelListaImeRase.setForeground(Color.white);
       c.add(labelListaImeRase);
       
       
 
    // End Labels 
       
       
	 // Start Butons Rasa Psa Sekcija
       
	   btnShowImeRaseList = new JButton("Prikazi sve rase pasa");
	   btnShowImeRaseList.setFont(new Font("Arial",Font.PLAIN,15));
	   btnShowImeRaseList.setSize(250,50);
	   btnShowImeRaseList.setLocation(90,450);
	   btnShowImeRaseList.addActionListener(this);
	   c.add(btnShowImeRaseList);
	   
	
	   
	   btnRasaForma = new JButton("Idi na formu rasa pasa");
	   btnRasaForma.setFont(new Font("Arial",Font.PLAIN,15));
	   btnRasaForma.setSize(250,50);
	   btnRasaForma.setLocation(90,500);
	   btnRasaForma.addActionListener(this);
	   c.add(btnRasaForma);
	   
	   btnVlasnikForma = new JButton("Idi na formu vlasnik psa");
	   btnVlasnikForma.setFont(new Font("Arial",Font.PLAIN,15));
	   btnVlasnikForma.setSize(250,50);
	   btnVlasnikForma.setLocation(630,500);
	   btnVlasnikForma.addActionListener(this);
	   c.add(btnVlasnikForma);
	   
	   
	   btnPasForma = new JButton("Idi na formu svi psi");
	   btnPasForma.setFont(new Font("Arial",Font.PLAIN,15));
	   btnPasForma.setSize(250,50);
	   btnPasForma.setLocation(1170,500);
	   btnPasForma.addActionListener(this);
	   c.add(btnPasForma);
	   
	   
	   
	   
	   

	  // End Buttons Rasa Psa Sekcija 
	   
	   
	   // Start Button Vlasnik sekcija
	   
	   btnShowImeVlasnikaList = new JButton("Prikazi sve vlasnike pasa");
	   btnShowImeVlasnikaList.setFont(new Font("Arial",Font.PLAIN,15));
	   btnShowImeVlasnikaList.setSize(250,50);
	   btnShowImeVlasnikaList.setLocation(630,450);
	   btnShowImeVlasnikaList.addActionListener(this);
	   c.add(btnShowImeVlasnikaList);
	   
	   // End Button Vlasnik sekcija
	   
	  
	   
	   // Start Button Pas Sekcija
	   
	   btnShowImePsaList = new JButton("Prikazi sve pse");
	   btnShowImePsaList.setFont(new Font("Arial",Font.PLAIN,15));
	   btnShowImePsaList.setSize(250,50);
	   btnShowImePsaList.setLocation(1170,450);
	   btnShowImePsaList.addActionListener(this);
	   c.add(btnShowImePsaList);
	   
	   // End Button Pas Sekcija
	   
	   
	   
	   
	   setVisible(true);
	   
	   
	
	
   //Pokazi listu Rase Psa
   btnShowImeRaseList.addActionListener(new ActionListener(){
	   
   
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
	       
	      System.out.println("Izvlacenje Rase Psa liste  iz baze podataka");
	     
	      // Ciscenje Text Area  pre ubacivanja podataka
	      textAreaRasaPsa.setText("");

          String query = "SELECT ImeRase FROM RasaPsa";
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
          textAreaRasaPsa.setText(result.toString());

         
           
          resultSet.close();
          preparedStatement.close();
          connection.close();
          
          
      } catch (ClassNotFoundException | SQLException ex) {
          ex.printStackTrace();
         
      }
  }

	      
   });
   
   
 //Prikazujem listu svih Vlasnika
 btnShowImeVlasnikaList.addActionListener(new ActionListener() {
   

@Override
public void actionPerformed(ActionEvent e) {
	
 
try {
	 
	String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
    String User ="root";
    String Password ="";
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    Connection connection = DriverManager.getConnection(dbURL, User, Password);
    System.out.println("Sada sam konektovan na bazu podataka");

    // Lista Vlasnika Sekcija Start

    System.out.println("Izvlacenje Vlasnika  liste  iz baze podataka");

    // Ciscenje Text Area  pre ubacivanja podataka
    textAreaVlasnik.setText("");

    String query = "SELECT ImeVlasnika  FROM VlasnikPsa";
    PreparedStatement preparedStatement = connection.prepareStatement(query);

    ResultSet resultSet = preparedStatement.executeQuery();

    // Prikazivanje liste u text are
    StringBuilder result = new StringBuilder();
    
    while (resultSet.next()) {
    	
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
        	
            result.append(resultSet.getString(i)).append("\t");
        }
        result.append("\n");
    }
    textAreaVlasnik.setText(result.toString());

    // Close resources
    resultSet.close();
    preparedStatement.close();
    connection.close();
} catch (ClassNotFoundException | SQLException ex) {
    ex.printStackTrace();
}
}
   });
   
   
   
 //Pokazi listu  Psa
   btnShowImePsaList.addActionListener(new ActionListener(){


@Override
public void actionPerformed(ActionEvent e) {
	
	 try {
		 
         String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
         String User ="root";
         String Password ="";
         
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         Connection connection = DriverManager.getConnection(dbURL, User, Password);
         System.out.println("Connected to the database");

         System.out.println("Izvlacenje Liste Pasa iz baze podataka");

         // Clear the text area before displaying new data
         textArea.setText("");

         String query = "SELECT Pas.ImePsa,Pas.Godine,RasaPsa.ImeRase,VlasnikPsa.ImeVlasnika\n"
         		+ "FROM Pas\n"
         		+ "INNER JOIN RasaPsa ON Pas.RasaID = RasaPsa.RasaID\n"
         		+ "INNER JOIN VlasnikPsa ON Pas.VlasnikID = VlasnikPsa.VlasnikID;";
         
         PreparedStatement preparedStatement = connection.prepareStatement(query);

         ResultSet resultSet = preparedStatement.executeQuery();

         // Show data in the text area
         StringBuilder result = new StringBuilder();
         
         while (resultSet.next()) {
        	 
             for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            	 
                 result.append(resultSet.getString(i)).append("\t");
             }
             result.append("\n");
         }
         textArea.setText(result.toString());

         // Close resources
         resultSet.close();
         preparedStatement.close();
         connection.close();
     } catch (ClassNotFoundException | SQLException ex) {
         ex.printStackTrace();
     }
	
	
}
   });
   
   
   
   
   // Rase Psa Forma
 btnRasaForma.addActionListener(new ActionListener(){
	   
	   
@Override
public void actionPerformed(ActionEvent e) {
	
	 RasaPsa rasaPsa = new RasaPsa();
     rasaPsa.setVisible(true);
	
}
});
   

   //Vlasnik Forma
 btnVlasnikForma.addActionListener(new ActionListener(){


   @Override
   public void actionPerformed(ActionEvent e) {
	
	 VlasnikPsa vlasnikPsa = new VlasnikPsa();
     vlasnikPsa.setVisible(true);
	
}
});
  
  
 //Pas Forma
 btnPasForma.addActionListener(new ActionListener(){

@Override
public void actionPerformed(ActionEvent e) {
	
	 Pas pas = new Pas();
    pas.setVisible(true);
		
}
});
   
	}  

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}




	
