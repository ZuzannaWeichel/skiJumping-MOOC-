import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Zu
 */
public class Jumper implements Comparable<Jumper>{
    private Scanner reader;
    private String name;
    private int points;
    private ArrayList<Integer> jumpLengths = new ArrayList<Integer>();;
    
    public Jumper( Scanner s){
         this.reader = s;
      
    }
    public Jumper(String name,int points){
        this.name = name;
        this.points = 0;
    }
    
    public String getName(){
        return name;
    }
    public int getPoints(){
        return points;
    }
    public void addPoints(int p){
        this.points += p;
    }
    
    public void addJump(int j){
       this.jumpLengths.add(j);
    }
    
    public String printJumps(){
        String jumps = " ";
        for(int length : jumpLengths){
           jumps += " "+length+" m,";
        }
         return jumps.substring(1,jumps.length()-1);
    }
    
    @Override
    public int compareTo(Jumper j){
        return this.points - j.getPoints();
    }
    
    @Override
    public String toString(){
        return name + " ("+points+" points)";
    }
}
