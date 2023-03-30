import java.util.*;

public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name) {
        this.name = name;
        performers = new ArrayList<Performer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Performer> getPerformers() {
        return performers;
    }

    public boolean addPerformer(Performer performer) {
        if (performers.contains(performer)) {
            return false;
        } else {
            performers.add(performer);
            return true;
        }
    }

    public boolean removePerformer(Performer performer) {
        int idx = performers.indexOf(performer);
        if (idx != -1) {
            performers.remove(idx);
            return true;
        } else {
            return false;
        }
    }

    public double averagePerformerAge() {
        double avg = 0;
        for (Performer performer : performers) {
            avg += performer.getAge();
        }
        return avg / performers.size();
    }

    public ArrayList<Performer> performersOverAge(int age) {
        ArrayList<Performer> overAge = new ArrayList<Performer>();
        for (Performer performer : performers) {
            if (performer.getAge() >= age) {
                overAge.add(performer);
            }
        }
        return overAge;
    }

    public void groupRehearsal() {
        for (Performer performer : performers) {
            System.out.println("REHEARSAL CALL! " + performer.getName());
            if (performer instanceof Comedian) {
                Comedian temp = (Comedian) performer;
                temp.rehearse(false);
            } else {
                performer.rehearse();
            }
        }
    }

    public void cabaretShow() {
        for (Performer performer : performers) {
            System.out.println("Welcome to the cabaret! Next up... " + performer.getName());
            if (performer instanceof Dancer) {
                Dancer temp = (Dancer) performer;
                temp.pirouette(2);
            }
            performer.perform();
        }
    }
}
