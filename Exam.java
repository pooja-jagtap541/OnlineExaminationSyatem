package onlineExam;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Exam {
    Questions[] questions;
    char[] userAnswers;
    boolean timeUp = false;

    public Exam() {
        questions = new Questions[3];
        questions[0] = new Questions("Which keyword is used to inherit a class in Java?", new String[]{"this", "super", "extends", "implements"}, 'C');
        questions[1] = new Questions("Which method is the entry point of Java program?", new String[]{"start()", "main()", "run()", "init()"}, 'B');
        questions[2] = new Questions("Which of these is not a Java keyword?", new String[]{"class", "int", "goto", "implement"}, 'D');

        userAnswers = new char[questions.length];
    }

    public void startExam() {
        System.out.println("\n📝 Exam started. You have 30 seconds.");
        Scanner sc = new Scanner(System.in);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                timeUp = true;
                System.out.println("\n⏰ Time is up! Auto-submitting answers...");
            }
        }, 30000); // 30 seconds

        for (int i = 0; i < questions.length; i++) {
            if (timeUp) break;
            questions[i].display();
            System.out.print("Enter your answer (A/B/C/D): ");
            userAnswers[i] = sc.next().charAt(0);
        }

        timer.cancel();
        submitExam();
    }

    public void submitExam() {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            if (questions[i].checkAnswer(userAnswers[i])) {
                score++;
            }
        }
        System.out.println("✅ Exam submitted.");
        System.out.println("🎯 Your Score: " + score + "/" + questions.length);
    }
}
