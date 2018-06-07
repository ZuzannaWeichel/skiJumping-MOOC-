import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
       Scanner reader = new Scanner(System.in);
        SkiWeek kumpula = new SkiWeek(reader);
        
        kumpula.registration();
        kumpula.turnament();
        kumpula.turnamentResults();
    }
}
