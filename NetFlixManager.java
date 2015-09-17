/*
 @Author Congyao Zheng
 @Version 1.0
*/
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.util.ArrayList;
public class NetFlixManager extends JFrame implements ActionListener{

   ArrayList<Movie> netFlix = new ArrayList<Movie>();
   
   public static final int WIDTH = 380;
	public static final int HEIGHT = 700;
   
  	JPanel introPanel, buttonPanel, titlePanel, outputPanel;
	JLabel titleLabel, movieLabel, directorLabel, yearLabel, starLabel, outputLabel, scrollPanel;
	JButton addButton, removeButton, clearButton, listButton;
   JTextField movie, director, year, star;
   JScrollPane scroll;
   JTextArea textArea;
	
	public JPanel content(){
	   //a bottom panel to put everything on
	   JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);
		
		//Intro Panel
		introPanel = new JPanel();
		introPanel.setLayout(new GridLayout(1,1));
		introPanel.setLocation(0,0);
		introPanel.setSize(370,30);
		titleLabel = new JLabel("Welcom to NetFlix!", SwingConstants.CENTER);
      introPanel.add(titleLabel);
      totalGUI.add(introPanel);  
       
		//Add Remove Panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,2));
		buttonPanel.setLocation(0,40);
		buttonPanel.setSize(370,70);
        //Buttons
		//AddButton
		addButton = new JButton("Add");
		addButton.addActionListener(this);
		buttonPanel.add(addButton);
		//removeButton
		removeButton = new JButton("Remove");
		removeButton.addActionListener(this);
		buttonPanel.add(removeButton);
		//clearButton
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		buttonPanel.add(clearButton);
		//exitButton
		listButton = new JButton("List");
		listButton.addActionListener(this);
		buttonPanel.add(listButton);
      totalGUI.add(buttonPanel);
		
		//Title Panel
		titlePanel = new JPanel();
		titlePanel.setLayout(new GridLayout(4,2));
		titlePanel.setLocation(0,120);
		titlePanel.setSize(370,160);
      //Labels
		//Movie title
		movieLabel = new JLabel("Movie Title:", SwingConstants.LEFT);
      directorLabel = new JLabel("Director:", SwingConstants.LEFT);
      yearLabel = new JLabel("Year:", SwingConstants.LEFT);
      starLabel = new JLabel("Star:", SwingConstants.LEFT);
      //TextField
      movie = new JTextField("");
      director = new JTextField("");
      year = new JTextField("");
      star = new JTextField("");
      //add to titlePanel
      titlePanel.add(movieLabel);
      titlePanel.add(movie);
      titlePanel.add(directorLabel);
      titlePanel.add(director);
      titlePanel.add(yearLabel);
      titlePanel.add(year);
      titlePanel.add(starLabel);
      titlePanel.add(star);
      totalGUI.add(titlePanel);
		
		//output Panel
		outputPanel = new JPanel();
		//outputPanel.setLayout(new GridLayout(1,1));
		outputPanel.setLocation(0,300);
		outputPanel.setSize(370,140);
      //output msg
      outputLabel = new JLabel("", SwingConstants.CENTER);
      outputPanel.add(outputLabel);
      totalGUI.add(outputPanel);
      
      //scrollPanel
      JPanel scrollPanel = new JPanel();
      JTextArea movieList = new JTextArea(370, 350);
      JScrollPane scroll = new JScrollPane(movieList);
      movieList.setEditable(false);
      scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      scrollPanel.add(scroll);
      totalGUI.add(scrollPanel);
    
      totalGUI.setVisible(true);
      return totalGUI;
   }
    //remove movie method
    public static void removeMovie(ArrayList<Movie> netFlix, String titleName){
      for(int i=0; i<netFlix.size(); i++){
         if (netFlix.get(i).getTitle().compareTo(titleName)==0)
            netFlix.remove(i);
      }
   }
   //add movie method
   public static void addMovie(ArrayList<Movie> netFlix, String titleName, String directorName, int yearName, String starName){

      Movie newMovie = new Movie (titleName, directorName, yearName, starName);
      netFlix.add(newMovie);
   }
   //action performance
   public void actionPerformed(ActionEvent e){
      String titleName, directorName, starName;
      int yearName;
      if(e.getSource()==addButton){
         titleName = movie.getText();
         directorName = director.getText();
         yearName = Integer.parseInt(year.getText());
         starName  = star.getText();
         addMovie(netFlix, titleName, directorName, yearName, starName);
         
         outputLabel.setText("Movie " + titleName + " added");
         for(int i=0; i<netFlix.size(); i++){
             System.out.println(netFlix.get(i));
           }
      }else if(e.getSource()==removeButton){
         titleName = movie.getText(); 
         removeMovie(netFlix, titleName);
         
         outputLabel.setText("Movie " + titleName + " removed");
         for(int i=0; i<netFlix.size(); i++){
            System.out.println(netFlix.get(i));}
      }else if(e.getSource()==clearButton){
         movie.setText("");
         director.setText("");
         year.setText("");
         star.setText("");
      }else if(e.getSource()==listButton){
          System.exit(0);
           }         
      }             
   }
   
   public static void showGUI(){
      
      JFrame.setDefaultLookAndFeelDecorated(true);      
      JFrame frame = new JFrame("NetFlix Movie Manager");
      
      NetFlix_GUI demo = new NetFlix_GUI();     
      frame.add(demo.content());
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(380, 400);
      frame.setVisible(true);   
   }
   
   public static void main (String args[]){
     showGUI();
   }  
}