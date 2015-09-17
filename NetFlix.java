/*
@Author Chris Zheng
@Date Apr.02 
@version 1.0*/
import java.util.*;
import java.util.Scanner;
public class NetFlix{
   ArrayList<Movie> netFlix = new ArrayList<Movie>();
   Scanner keyboard = new Scanner(System.in);
   
   public static void main(String args[]){
      ArrayList<Movie> netFlix = new ArrayList<Movie>();  
      Scanner keyboard = new Scanner(System.in);
      Movie groundHog= new Movie ("Groundhog Day", "Harold Ramis",	1993,"Bill Murray");
      Movie slumDog = new Movie ("Slumdog Millionaire",	"Danny Boyle",	 2008,"Anil Kooper");
      Movie missDaisy=new Movie ("Driving Miss Daisy",  "Bruce Beresford",1989,"Morgan Freeman");
      Movie hustle=new Movie ("American Hustle","David O. Russell", 2013,"Christian Bale");
      Movie frozen = new Movie("Frozen","Chris Buck",	2013 ,"Kristen Bell");
      
      netFlix.add(groundHog);
      netFlix.add(slumDog);
      netFlix.add(missDaisy);
      netFlix.add(hustle);
      netFlix.add(frozen);
      
      int userChoice = 0;
      
      do{userChoice = processMenu(keyboard);
         menuChoice(userChoice, netFlix, keyboard);}while(userChoice!=5);
   }
      
   public static void removeMovie(ArrayList<Movie> netFlix, Scanner keyboard){
      System.out.println("");
      String a = keyboard.nextLine();
      System.out.println("which movie do you want to remove:");
      String t = keyboard.nextLine();
      for(int i=0; i<netFlix.size(); i++){
         if (netFlix.get(i).getTitle().compareTo(t)==0)
            netFlix.remove(i);
      }
   }
   
   public static void addMovie(ArrayList<Movie> netFlix, Scanner keyboard){
      System.out.println("");
      String a = keyboard.nextLine();
      System.out.print("Title:");
      String t = keyboard.nextLine();
      System.out.println("");
      System.out.print("Director:");
      String director = keyboard.nextLine();
      System.out.println("");
      System.out.print("Year:");
      int year = keyboard.nextInt();
      System.out.println("");
      String b = keyboard.nextLine();
      System.out.print("Stars:");
      String stars = keyboard.nextLine();
      System.out.println("");
      
      Movie newMovie = new Movie (t, director, year, stars);
      netFlix.add(newMovie);
   }
     
   public static int processMenu(Scanner keyboard){
      System.out.println("1. Add a Movie (name,director year,star) to your database"+"\n" 
                        +"2. Remove a Movie from your database"+"\n"
                        +"3. List the entire database  sorted - "+"\n"
                        +"4. List all movies made in a given year. "+"\n"
                        +"5. Quit");
     System.out.println("Please enter your choice:");
      return keyboard.nextInt();
      
   }
   
   public static void menuChoice(int choice, ArrayList<Movie> netFlix, Scanner keyboard){
      if(choice==1)
        addMovie(netFlix, keyboard);
      else if(choice == 2 )
        removeMovie(netFlix, keyboard);
      else if(choice==3){
        Collections.sort(netFlix);
        for(int i=0; i<netFlix.size(); i++){
            System.out.println(netFlix.get(i));}
      }
      else if(choice==4){
        System.out.print("Enter the year:");
        int y = keyboard.nextInt();
        System.out.println();
        System.out.println("There are the movies in "+y);
        for(int i=0; i<netFlix.size(); i++){
           if(netFlix.get(i).getYear()==y)
              System.out.println(netFlix.get(i));
        }
        System.out.println();
      }
      else if(choice==5){
        System.exit(0);
      }
      else 
        System.out.println("Please type a valid choice");  
   }
   
   public static void getMovieInYear(ArrayList<Movie> netFlix, Scanner keyboard){
      System.out.println("Enter the year:");
      int y = keyboard.nextInt();
        for(int i=0; i<netFlix.size(); i++){
           if(netFlix.get(i).getYear()==y)
              System.out.println(netFlix.get(i));
        }

   }
} 

/*   
  ----jGRASP exec: java NetFlix
 
 1. Add a Movie (name,director year,star) to your database
 2. Remove a Movie from your database
 3. List the entire database  sorted - 
 4. List all movies made in a given year. 
 5. Quit
 Please enter your choice:
 1
 
 Title:A
 
 Director:B
 
 Year:2015
 
 Stars:C
 
 1. Add a Movie (name,director year,star) to your database
 2. Remove a Movie from your database
 3. List the entire database  sorted - 
 4. List all movies made in a given year. 
 5. Quit
 Please enter your choice:
 3
 Title:Driving Miss Daisy, Director:Bruce Beresford, Year:1989, Stars:Morgan Freeman
 Title:Groundhog Day, Director:Harold Ramis, Year:1993, Stars:Bill Murray
 Title:Slumdog Millionaire, Director:Danny Boyle, Year:2008, Stars:Anil Kooper
 Title:American Hustle, Director:David O. Russell, Year:2013, Stars:Christian Bale
 Title:Frozen, Director:Chris Buck, Year:2013, Stars:Kristen Bell
 Title:A, Director:B, Year:2015, Stars:C
 1. Add a Movie (name,director year,star) to your database
 2. Remove a Movie from your database
 3. List the entire database  sorted - 
 4. List all movies made in a given year. 
 5. Quit
 Please enter your choice:
 2
 
 which movie do you want to remove:
 A
 1. Add a Movie (name,director year,star) to your database
 2. Remove a Movie from your database
 3. List the entire database  sorted - 
 4. List all movies made in a given year. 
 5. Quit
 Please enter your choice:
 3
 Title:Driving Miss Daisy, Director:Bruce Beresford, Year:1989, Stars:Morgan Freeman
 Title:Groundhog Day, Director:Harold Ramis, Year:1993, Stars:Bill Murray
 Title:Slumdog Millionaire, Director:Danny Boyle, Year:2008, Stars:Anil Kooper
 Title:American Hustle, Director:David O. Russell, Year:2013, Stars:Christian Bale
 Title:Frozen, Director:Chris Buck, Year:2013, Stars:Kristen Bell
 1. Add a Movie (name,director year,star) to your database
 2. Remove a Movie from your database
 3. List the entire database  sorted - 
 4. List all movies made in a given year. 
 5. Quit
 Please enter your choice:
 4
 Enter the year:2013
 
 There are the movies in 2013
 Title:American Hustle, Director:David O. Russell, Year:2013, Stars:Christian Bale
 Title:Frozen, Director:Chris Buck, Year:2013, Stars:Kristen Bell
 
 1. Add a Movie (name,director year,star) to your database
 2. Remove a Movie from your database
 3. List the entire database  sorted - 
 4. List all movies made in a given year. 
 5. Quit
 Please enter your choice:
 6
 Please type a valid choice
 1. Add a Movie (name,director year,star) to your database
 2. Remove a Movie from your database
 3. List the entire database  sorted - 
 4. List all movies made in a given year. 
 5. Quit
 Please enter your choice:
 5
 
  ----jGRASP: operation complete.
 */