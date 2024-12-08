import java.util.*;
import java.util.concurrent.TimeUnit;

public class QuizApp {
   
    static class Question {
        String questionText;
        String[] options;
        int correctOption;

        public Question(String questionText, String[] options, int correctOption) {
            this.questionText = questionText;
            this.options = options;
            this.correctOption = correctOption;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new String[] {"Berlin", "Madrid", "Paris", "Lisbon"}, 3));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[] {"Earth", "Mars", "Venus", "Jupiter"}, 2));
        questions.add(new Question("Who wrote 'Harry Potter'?", new String[] {"J.R.R. Tolkien", "George R.R. Martin", "J.K. Rowling", "C.S. Lewis"}, 3));
        questions.add(new Question("What is the largest ocean on Earth?", new String[] {"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, 4));
        questions.add(new Question("What is the boiling point of water?", new String[] {"90°C", "100°C", "110°C", "120°C"}, 2));

        int score = 0;
        Scanner sc = new Scanner(System.in);

        // Loop through all questions
        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);

            // Display the question and options
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.questionText);
            for (int j = 0; j < currentQuestion.options.length; j++) {
                System.out.println((j + 1) + ". " + currentQuestion.options[j]);
            }

            // Timer setup
            System.out.println("\nYou have 20 seconds to answer.");
            long startTime = System.currentTimeMillis();
            boolean answered = false;

            while (System.currentTimeMillis() - startTime < TimeUnit.SECONDS.toMillis(20) && !answered) {
                if (sc.hasNextInt()) {
                    int userAnswer = sc.nextInt();
                    if (userAnswer >= 1 && userAnswer <= currentQuestion.options.length) {
                        // Check if the answer is correct
                        if (userAnswer == currentQuestion.correctOption) {
                            System.out.println("Correct!");
                            score++;
                        } else {
                            System.out.println("Incorrect! The correct answer was: " + currentQuestion.options[currentQuestion.correctOption - 1]);
                        }
                        answered = true;
                    } else {
                        System.out.println("Please select a valid option (1-4).");
                    }
                }
            }

            if (!answered) {
                System.out.println("Time's up! The correct answer was: " + currentQuestion.options[currentQuestion.correctOption - 1]);
            }

            // Add a delay before moving to the next question
            Thread.sleep(1000);
        }

        // Display the final score
        System.out.println("\nQuiz Finished!");
        System.out.println("Your final score: " + score + " out of " + questions.size());

        sc.close();
    }
}
