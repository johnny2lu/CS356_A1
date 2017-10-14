import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IVoteService
{
    private String[] candidateAnswers;
    private Map<String, String> database;

    public IVoteService(Question type)
    {
        candidateAnswers = type.choices();
        database = new HashMap<String, String>(candidateAnswers.length);
    }

    public void submitAnswer(Student std)
    {
        database.put(std.getID(), std.getAnswer());
    }

    public void displayResults()
    {
        String output = "";
        for (int i = 0; i < candidateAnswers.length; i++)
        {
        	System.out.println(candidateAnswers[i]);
            output += candidateAnswers[i] + " : " + Collections.frequency(database.values(), candidateAnswers[i]) + " ";
        }
        System.out.println(output);
    }
}
