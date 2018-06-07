
import java.util.*;

/**
 *
 * @author Zu
 */
public class SkiWeek {

    private ArrayList<Jumper> registration;
    private Scanner reader;
    private Random random = new Random();

    public SkiWeek(Scanner r) {
        this.registration = new ArrayList<Jumper>();
        this.reader = r;
    }

    public void registration() {
        System.out.println("Kumpula ski jumping week\n");
        String input;
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while (true) {
            System.out.print("  Participant name: ");
            input = reader.nextLine();
            if (input.isEmpty()) {
                System.out.println("");
                break;
            } else {
                registration.add(new Jumper(input, 0));
            }
        }
    }

    public void turnament() {
        System.out.println("The tournament begins!");
        String input;
        for (int i = 1; i > 0; i++) {
            System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
            input = reader.nextLine();
            if (!input.equals("jump")) {
                System.out.println("\nThanks!\n");
                break;
            } else {
                System.out.println("\nRound " + i + "\n");
                System.out.println("Jumping order:");
                jumpingOrder();
                System.out.println("\nResults of round " + i);
                jumpAndJudge();
            }
        }
    }

    public void jumpingOrder() {
        Collections.sort(registration);//swich around the compareTo if the order is backwords
        for (Jumper j : registration) {
            int index = registration.indexOf(j) + 1;
            System.out.println("  " + index + ". " + j);
        }
    }

    public void jumpAndJudge() {
        for (Jumper j : registration) {
            System.out.println("  " + j.getName());
            int length = random.nextInt(61) + 60;            
            System.out.println("    length: " + length);
            j.addJump(length);
            j.addPoints(length);
            ArrayList<Integer> votes = votes();
            System.out.println("    judge votes: " + Arrays.toString(votes.toArray()));
            Collections.sort(votes);
            votes.remove(4);
            votes.remove(0);
            for (int v : votes) {
                j.addPoints(v);
            }
        }
    }

    public ArrayList<Integer> votes() {
        ArrayList<Integer> votes = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            votes.add(random.nextInt(11) + 10);
        }
        return votes;
    }

    public void turnamentResults() {
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        Collections.sort(registration);
        Collections.reverse(registration);
        for (Jumper j : registration) {
            int index = registration.indexOf(j) + 1;
            System.out.println(index + "           " + j.toString());
            System.out.println("            jump lengths:" + j.printJumps());
        }
    }
}
