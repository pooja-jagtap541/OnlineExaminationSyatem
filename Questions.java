package onlineExam;

public class Questions {
    String question;
    String[] options;
    char answer;

    public Questions(String question, String[] options, char answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public void display() {
        System.out.println(question);
        char opt = 'A';
        for (String option : options) {
            System.out.println(opt + ". " + option);
            opt++;
        }
    }

    public boolean checkAnswer(char userAnswer) {
        return Character.toUpperCase(userAnswer) == Character.toUpperCase(answer);
    }
}

