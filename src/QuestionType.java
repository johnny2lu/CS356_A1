public enum QuestionType {
     SINGLE,
     MULTIPLE;

     public static QuestionType getRandom()
     {
         return values()[(int) (Math.random() * values().length)];
     }
 }
