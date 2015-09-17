/*
 @Author Congyao Zheng
 */
public class Movie implements Comparable<Movie>{
   //instance variables
   private String title;
   private String director;
   private int year;
   private String stars;
   
   //no arguments
   public Movie(){
      title = "";
      director = "";
      year = 0;
      stars = "";
   }
   
   public Movie(String t, String d, int y, String s){
      title = t;
      director = d;
      year = y;
      stars = s;
   }
   
   public void setTitle(String t){
      title = t;
   }
   
   public void setDirector(String d){
      director = d;
   }
   
   public void setYear(int y){
      year = y;
   }
   
   public void setStars(String s){
      stars = s;
   }
   
   public String getTitle(){
      return title;
   }
   
   public String getDirector(){
      return director;
   }
   
   public int getYear(){
      return year;
   }
   
   public String getStars(){
      return stars;
   }
   
   public String toString(){
      return ("Title:"+title+", Director:"+director+", Year:"+year+", Stars:"+stars);
   }
  
   public int compareTo(Movie m){
      if(year>m.year)
        return 1;
      else if( year < m.year)
        return -1;
      else return this.title.compareToIgnoreCase(m.title);
   }
}
