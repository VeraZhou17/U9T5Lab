import java.util.ArrayList;

public class Cabaret
{
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String n)
    {
        name = n;
        performers = new ArrayList<Performer>();
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Performer> getPerformers()
    {
        return performers;
    }

    public boolean addPerformer(Performer performer)
    {
        if (performers.indexOf(performer) == -1)
        {
            performers.add(performer);
            return true;
        }
        return false;
    }

    public boolean removePerformer(Performer performer)
    {
        int index = performers.indexOf(performer);

        if (index != -1)
        {
            performers.remove(index);
            return true;
        }
        return false;
    }

    public double averagePerformerAge()
    {
        int ageSum = 0;

        for (Performer performer : performers)
        {
            ageSum += performer.getAge();
        }
        double average = ageSum / (double) performers.size();
        return average;
    }

    public ArrayList<Performer> performersOverAge(int age)
    {
        ArrayList<Performer> overAgeList = new ArrayList<Performer>();

        for (Performer performer: performers)
        {
            if (performer.getAge() >= age)
            {
                overAgeList.add(performer);
            }
        }
        return overAgeList;
    }

    public void groupRehearsal()
    {
        for (Performer performer : performers)
        {
            System.out.println("REHEARSAL CALL! " + performer.getName());

            if (performer instanceof Comedian)
            {
                Comedian temp = (Comedian) performer;
                temp.rehearse(false);
            }
            else
            {
                performer.rehearse();
            }
        }
    }

    public void cabaretShow()
    {
        for (Performer performer : performers)
        {
            System.out.println("Welcome to the cabaret! Next act up... " + performer.getName());

            if (performer instanceof Dancer)
            {
                Dancer temp = (Dancer) performer;
                temp.pirouette(2);
            }
            performer.perform();
        }
    }
}
