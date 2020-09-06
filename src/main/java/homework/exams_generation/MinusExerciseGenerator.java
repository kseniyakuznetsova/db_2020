package homework.exams_generation;

import java.util.Random;

public class MinusExerciseGenerator implements ExerciseGenerator {

    private Random random = new Random();

    @Override
    public Exercise generate() {
        double firstArg  = random.nextInt(10);
        double secondArg  = random.nextInt(10);
        Exercise exercise = new Exercise(firstArg, secondArg);
        exercise.setAnswer(firstArg - secondArg);
        exercise.setOperator(Operator.MINUS);
        return exercise;
    }
}
