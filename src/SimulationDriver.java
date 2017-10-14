import java.util.Random;
import java.util.UUID;

public class SimulationDriver
{
    private final static int MAX_STUDENTS = 100;

    public static void main(String[] args) {
    	Random rand = new Random();
        // Create question type
        Question question = null;
        QuestionType questionType = QuestionType.getRandom();
        // Configure answers choices
        if (questionType == QuestionType.SINGLE)
        {
            question = new SingleChoiceQuestion();
            System.out.println("Single Choice:");
        }
        else if (questionType == QuestionType.MULTIPLE)
        {
            question = new MultipleChoiceQuestion();
            System.out.println("Multiple Choice:");
        }
        // Configure question for iVote service
        IVoteService voteManager = new IVoteService(question);
        // Generate random number of students
        Student students[] = new Student[rand.nextInt(MAX_STUDENTS + 1)];
        for (int i = 0; i < students.length; i++)
        {
            // Generate random student ID
            students[i] = new Student(UUID.randomUUID().toString());
            // Generate random answers
            students[i].setAnswer(question.getChoice(rand.nextInt(question.choices().length)));
            // Submit student answers to iVote service
            voteManager.submitAnswer(students[i]);
        }
        // Call iVote service to display results
        voteManager.displayResults();
        System.out.println("Number of students: " + students.length);
    }
}
