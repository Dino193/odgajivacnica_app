package pas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.Color;




@SuppressWarnings("serial")
public class RasaPsa extends JFrame implements ActionListener{

	
	
    private Container c;
   
    
    private JTextArea textArea;
   
	private JButton btnExit;
	private JButton btnNext;
	private JButton btnPrikazi;
	private JButton btnUbaci;
	private JButton btnPromeni;
	private JButton btnIzbrisi;
	
	
	private JLabel labelUbaci;
	private JLabel labelIzmeni;
	private JLabel labelOpis;
	private JLabel labelIzmeniOpis;
	
	private JLabel labelTextSelect;
	private JLabel labelTextSelect2;
	private JLabel labelTextSelect3;
	private JLabel labelTextSelect4;
	
	
	private JTextField textUbaciImeRase;
	private JTextField textIzmeni;
	private JTextField textOpisRase;
	private JTextField textIzmeniOpis;
	
	
	


			
	
   public RasaPsa() {
		   
		   
	   setTitle("Rasa Psa Forma");
	   setExtendedState(JFrame.MAXIMIZED_BOTH);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   setResizable(false);
	   
	   c = getContentPane();
	   c.setLayout(null);
	   c.setBackground(Color.black);
	   
	   
	   JTable table = new JTable(); 
	   
	   
	   // Kreiranje table modela and set a Column Identifiers to this model 
       Object[] columns = {"Select rasu","Select opis"};
       DefaultTableModel model = new DefaultTableModel();
       model.setColumnIdentifiers(columns);
       
       // Setiranje modela to the table
       table.setModel(model);
       
       
       table.setBackground(Color.LIGHT_GRAY);
       table.setForeground(Color.black);
       Font font = new Font("",1,22);
       table.setFont(font);
       table.setRowHeight(30);
       
      
       JScrollPane pane = new JScrollPane(table);
       pane.setSize(300,300);
       pane.setLocation(400,500);
       
       
       c.setLayout(null);
       
       c.add(pane);
         
       // Kreiranje array of objects to set the row data
       Object[] row = new Object[1];
    
 
	      	   
	   textArea = new JTextArea();
       textArea.setFont(new Font("Arial", Font.PLAIN, 15));
       textArea.setSize(300, 300);
       textArea.setLocation(400, 50);
       textArea.setLineWrap(true);
       textArea.setBackground(Color.white);
       c.add(textArea);
	   
		
	   // Buttons section start 
	   
	   btnExit = new JButton("Idi na pocetnu stranu");
	   btnExit.setFont(new Font("Arial",Font.PLAIN,15));
	   btnExit.setSize(170,50);
	   btnExit.setLocation(400,930);
	   btnExit.addActionListener(this);
	   btnExit.setForeground(Color.RED);
	   c.add(btnExit);
	   
	   
	   btnNext = new JButton("Idi na vlasnika");
	   btnNext.setFont(new Font("Arial",Font.PLAIN,15));
	   btnNext.setSize(120,50);
	   btnNext.setLocation(580,930);
	   btnNext.setBackground(Color.blue);
	   btnNext.addActionListener(this);
	   btnNext.setForeground(Color.BLUE);
	   c.add(btnNext);
	   
	   
	   
	   btnPrikazi = new JButton("Prikazi sve rase");
	   btnPrikazi.setFont(new Font("Arial",Font.PLAIN,15));
	   btnPrikazi.setSize(200,50);
	   btnPrikazi.setLocation(20,40);
	   btnPrikazi.addActionListener(this);
	   c.add(btnPrikazi);
	   
	   btnUbaci = new JButton("Ubaci novu rasu");
	   btnUbaci.setFont(new Font("Arial",Font.PLAIN,15));
	   btnUbaci.setSize(200,50);
	   btnUbaci.setLocation(20,400);
	   btnUbaci.addActionListener(this);
	   c.add(btnUbaci);
	   
	   
	   btnPromeni = new JButton("Promeni selektovanu rasu");
	   btnPromeni.setFont(new Font("Arial",Font.PLAIN,15));
	   btnPromeni.setSize(200,50);
	   btnPromeni.setLocation(20,850);
	   btnPromeni.addActionListener(this);
	   c.add(btnPromeni);
	   
	   
	   btnIzbrisi = new JButton("Izbrisi selektovanu rasu");
	   btnIzbrisi.setFont(new Font("Arial",Font.PLAIN,15));
	   btnIzbrisi.setSize(200,50);
	   btnIzbrisi.setLocation(20,930);
	   btnIzbrisi.addActionListener(this);
	   c.add(btnIzbrisi);
	   
	   
	//Buttons Section end  
	   
	   
	//Labels Start
	   
	   labelUbaci = new JLabel("Unesi ime rase");
       labelUbaci.setFont(new Font("Arial", Font.PLAIN, 20));
       labelUbaci.setSize(200, 20);
       labelUbaci.setLocation(400, 370);
       labelUbaci.setForeground(Color.white);
       c.add(labelUbaci);
       
       labelOpis = new JLabel("Unesi opis rase");
       labelOpis.setFont(new Font("Arial", Font.PLAIN, 20));
       labelOpis.setSize(200, 20);
       labelOpis.setLocation(550, 370);
       labelOpis.setForeground(Color.white);
       c.add(labelOpis);
       
       labelIzmeni = new JLabel("Promeni ime");
       labelIzmeni.setFont(new Font("Arial", Font.PLAIN, 20));
       labelIzmeni.setSize(150, 20);
       labelIzmeni.setLocation(400, 820);
       labelIzmeni.setForeground(Color.white);
       c.add(labelIzmeni);
       
       
       labelIzmeniOpis = new JLabel("Promeni opis");
       labelIzmeniOpis.setFont(new Font("Arial", Font.PLAIN, 20));
       labelIzmeniOpis.setSize(150, 20);
       labelIzmeniOpis.setLocation(550, 820);
       labelIzmeniOpis.setForeground(Color.white);
       c.add(labelIzmeniOpis);
       
       // Label Text Select sekcija start 
       
       labelTextSelect = new JLabel("Da bi ste izmenili ime rase");
       labelTextSelect.setFont(new Font("Arial", Font.PLAIN, 20));
       labelTextSelect.setSize(500, 20);
       labelTextSelect.setLocation(20,600);
       labelTextSelect.setForeground(Color.white);
       c.add(labelTextSelect);
       
       
       labelTextSelect2 = new JLabel("ili izbrisali rasu pasa,");
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
       
       
       labelTextSelect4 = new JLabel("rasu u desnoj formi");
       labelTextSelect4.setFont(new Font("Arial", Font.PLAIN, 20));
       labelTextSelect4.setSize(500, 20);
       labelTextSelect4.setLocation(20,690);
       labelTextSelect4.setForeground(Color.white);
       c.add(labelTextSelect4);
       
       
       // Label Text Selekt sekcija end 
         
	
       // Labels End    

       
       
       
   //Text Field  Section Start
	   
	   
	   textUbaciImeRase = new JTextField();
       textUbaciImeRase.setFont(new Font("Arial", Font.PLAIN, 15));
       textUbaciImeRase.setSize(150, 50);
       textUbaciImeRase.setLocation(400, 400);
       c.add(textUbaciImeRase);
       
       textOpisRase = new JTextField();
       textOpisRase.setFont(new Font("Arial", Font.PLAIN, 15));
       textOpisRase.setSize(150, 50);
       textOpisRase.setLocation(550, 400);
       c.add(textOpisRase);
       
       
       textIzmeni = new JTextField();
       textIzmeni.setFont(new Font("Arial", Font.PLAIN, 15));
       textIzmeni.setSize(150, 50);
       textIzmeni.setLocation(400, 850);
       c.add(textIzmeni);
       
       textIzmeniOpis = new JTextField();
       textIzmeniOpis.setFont(new Font("Arial", Font.PLAIN, 15));
       textIzmeniOpis.setSize(150, 50);
       textIzmeniOpis.setLocation(550, 850);
       c.add(textIzmeniOpis);
       
      
	   
  // Text Field Section end 
	  
	   
	   
	   
	   
	   
		
	   
	   
	   
	   setVisible(true);   
		   
	   


  

 //Insertovanje Rase Psa  
 btnUbaci.addActionListener(new ActionListener(){
	   
   
@Override
public void actionPerformed(ActionEvent e) {
	
	 //Dodavanje da ili ne pitanje 
    int confirmResult = JOptionPane.showConfirmDialog(c, "Da li  zelite da dodate novu Rasu psa", "Confirmation", JOptionPane.YES_NO_OPTION);
         	        		 
    if (confirmResult == JOptionPane.YES_OPTION) {
	
	int RasaID = 0;
    String ImeRase = textUbaciImeRase.getText();
    String OpisRase = textOpisRase.getText();

    try {
    	
        String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
        String user = "root";
        String password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection2 = DriverManager.getConnection(dbURL, user, password);
        System.out.println("Sada sam konektovan na bazu podataka");

        // Prover da li  ImeRase postoji u  database
        String checkQuery = "SELECT COUNT(*) FROM RasaPsa WHERE ImeRase = ?";
        
        try (PreparedStatement checkStatement = connection2.prepareStatement(checkQuery)) {
            checkStatement.setString(1, ImeRase);
            
            ResultSet resultSet = checkStatement.executeQuery();
            resultSet.next();

            int count = resultSet.getInt(1);
            if (count > 0) {
                JOptionPane.showMessageDialog(btnUbaci, "Ova rasa psa vec postoji");
            } else {
                // Insert ImeRase into RasaPsa table
                String insertQuery = "INSERT INTO RasaPsa (RasaID,ImeRase,Opis) VALUES (?, ?, ?)";
                
                try (PreparedStatement preparedStatement = connection2.prepareStatement(insertQuery)) {
                    preparedStatement.setInt(1, RasaID);
                    preparedStatement.setString(2, ImeRase);
                    preparedStatement.setString(3, OpisRase);

                    int rowsAffected = preparedStatement.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(btnUbaci, "Uspesno ste ubacili novu rasu u bazu podataka");
                       
                    } else {
                        JOptionPane.showMessageDialog(btnUbaci, "Greska pri ubacivanju rase psa u bazu podataka");
                        
                    }
                    resultSet.close();
                    preparedStatement.close();
                    connection2.close();
                }
            }
        }

         

    } catch (Exception exception) {
        exception.printStackTrace();
    }

}
}
	 });
   

   
  //Nazad da glavnu formu
 btnExit.addActionListener(new ActionListener(){

@Override
public void actionPerformed(ActionEvent e) {
	
	 Odgajivacnica odgajivacnica = new Odgajivacnica();
     odgajivacnica.setVisible(true);
		
}
});
   
 
   
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
	       
	      System.out.println("Izvlacenje Rase Psa liste  iz baze podataka");
	     
	      // Ciscenje Text Area  pre ubacivanja podataka
	      textArea.setText("");
	      

          String query = "SELECT ImeRase,Opis  FROM RasaPsa";
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
   
   
   
   //Akcije koje su povezane sa UPDATE sa SELECT iz liste mogucnosti
   
// button add row
   btnUbaci.addActionListener(new ActionListener(){

       @Override
       public void actionPerformed(ActionEvent e) {
    	   
    	      
           row[0] = textUbaciImeRase.getText();
         
           
           // add row to the model
           model.addRow(row);
           
          
       }
   });
  
   
   
// Get selected row data From table to textfields 
   table.addMouseListener(new MouseAdapter(){
   
   @Override
   public void mouseClicked(MouseEvent e){
       
       // index of the selected row
       int i = table.getSelectedRow();
       
       textUbaciImeRase.setText(model.getValueAt(i, 0).toString());
       
      
   }
   });
   

   
   // Button Prikazi za Update mogucnost
   btnPrikazi.addActionListener(new ActionListener(){
	   
       @Override
       public void actionPerformed(ActionEvent e) {
    	   
        
    	  
    	   try {
    		   
               String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
               String user = "root";
               String password = "";

               Class.forName("com.mysql.cj.jdbc.Driver");

               Connection connection = DriverManager.getConnection(dbURL, user, password);
               System.out.println("Connected to the database");
               
              
               String selectQuery = "SELECT * FROM RasaPsa";
               PreparedStatement statement = connection.prepareStatement(selectQuery);

               
               ResultSet resultSet = statement.executeQuery();

               model.setRowCount(0);
                
               // Populate the table model with data from the ResultSet
               while (resultSet.next()) {
            	   
                   String imeRase = resultSet.getString("ImeRase");
                   String opisRase = resultSet.getString("Opis");
                   
                   model.addRow(new Object[]{imeRase,opisRase}); // Add row to table model
                  // model.addRow(new Object[]{opisRase}); 
            
                   
               }
               
               connection.close();
           } catch (Exception ex) {
               ex.printStackTrace();
           }

       
       }
   });

   
   // Button update row
   btnPromeni.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            
        	 		
        //Dodavanje da ili ne pitanje 
       int confirmResult = JOptionPane.showConfirmDialog(c, "Da li  zelite izmenite selektovanu Rasu psa", "Confirmation", JOptionPane.YES_NO_OPTION);
      	        		 
       if (confirmResult == JOptionPane.YES_OPTION) {
        	
        	
                	  
                  try {
                		   
                           String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
                           String user = "root";
                           String password = "";

                           Class.forName("com.mysql.cj.jdbc.Driver");

                           Connection connection = DriverManager.getConnection(dbURL, user, password);
                           System.out.println("Connected to the database");
               

               int selectedRowIndex = table.getSelectedRow();
               
               if (selectedRowIndex >= 0) {
            	   
                   String updatedValue = textIzmeni.getText();
                   String updatedValueOpis = textIzmeniOpis.getText();
                   
                   // Get the existing value from the selected row in the table
                   String existingValue = table.getValueAt(selectedRowIndex, 0).toString();

                   String updateQuery = "UPDATE RasaPsa SET ImeRase = ? ,Opis = ? WHERE ImeRase = ?";
                   
                   PreparedStatement statement = connection.prepareStatement(updateQuery);
                   
                   // Set parameters for the prepared statement
                   statement.setString(1, updatedValue);
                   statement.setString(2, updatedValueOpis);
                   statement.setString(3, existingValue);

                   int rowsAffected = statement.executeUpdate();
                   
                   if (rowsAffected > 0) {
                      JOptionPane.showMessageDialog(btnPromeni, "Podaci su uspesno izmenjeni");
                      
                   } else {
               
                       JOptionPane.showMessageDialog(btnPromeni, "Doslo je do greske pri izmeni");
                   }

                   statement.close();
               } else {
                      JOptionPane.showMessageDialog(btnPromeni, "Nije selektovan nijedan row u tabeli");
               }

               connection.close();
           } catch (Exception ex) {
               ex.printStackTrace();
           }
   
                   }
   
        }
});
        
       
   
  // button remove row
   btnIzbrisi.addActionListener(new ActionListener(){

       @Override
       public void actionPerformed(ActionEvent e) {
    	   
    	   int selectedRowIndex = table.getSelectedRow();
           
           if (selectedRowIndex == -1) {
        	   
               JOptionPane.showMessageDialog(c, "Molimo vas da prvo odaberete red za brisanje.");
               return;
           }

           int confirmResult = JOptionPane.showConfirmDialog(c, "Da li želite da izbrišete Rasu Psa?", "Confirmation", JOptionPane.YES_NO_OPTION);

           if (confirmResult == JOptionPane.YES_OPTION) {
        	   
               try {
            	   
                   String imeRaseToDelete = table.getValueAt(selectedRowIndex, 0).toString();

                   String dbURL = "jdbc:mysql://127.0.0.1:3306/PsiAplikacija";
                   String user = "root";
                   String password = "";

                   Class.forName("com.mysql.cj.jdbc.Driver");

                   Connection connection = DriverManager.getConnection(dbURL, user, password);
                   System.out.println("Konektovani ste na bazu podataka");

                   // Pokusaj brisanja
                   String deleteQuery = "DELETE FROM RasaPsa WHERE ImeRase = ?";
                   
                   try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
                       statement.setString(1, imeRaseToDelete);
                       
                       int rowsDeleted = statement.executeUpdate();
                       
                       if (rowsDeleted > 0) {
                           JOptionPane.showMessageDialog(c, "Uspesno ste izbrisali Ime Rase");
                           ((DefaultTableModel) table.getModel()).removeRow(selectedRowIndex);
                       } else {
                           JOptionPane.showMessageDialog(c, "Doslo je do greske pri brisanju");
                       }
                   }
               } catch (SQLException | ClassNotFoundException ex) {
                   if (ex instanceof SQLIntegrityConstraintViolationException) {
                       JOptionPane.showMessageDialog(c, "Rasu psa ne moze da izbrisemo jer vec postoji u tabeli pas.");
                   } else {
                       ex.printStackTrace();
                   }
               }
           }
       }
   });
   
   
   //Next Forma
    btnNext.addActionListener(new ActionListener(){

 @Override
 public void actionPerformed(ActionEvent e) {
 	
	 VlasnikPsa vlasnikPsa = new VlasnikPsa();
     vlasnikPsa.setVisible(true);
 	
 }
 });
    
   
   
   
   }
   
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}