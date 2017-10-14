public class MultipleChoiceQuestion implements Question
{
    private String answers[];

    public String[] choices()
    {
        answers = new String[]{"Right", "Wrong"};
        return answers;
    }

    public String getChoice(int index)
    {
        return answers[index];
    }
}
