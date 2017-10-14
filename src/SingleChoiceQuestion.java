public class SingleChoiceQuestion implements Question
{
    private String answers[];

    public String[] choices()
    {
        answers = new String[]{ "A", "B", "C", "D" };
        return answers;
    }

    public String getChoice(int index)
    {
        return answers[index];
    }
}
