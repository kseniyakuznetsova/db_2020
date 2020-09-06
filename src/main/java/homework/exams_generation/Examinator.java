package homework.exams_generation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class Examinator {
    private Random random = new Random();
    private List<ExerciseGenerator> exerciseGeneratorList = new ArrayList<>();

    public void addGenerator(ExerciseGenerator exerciseGenerator){
        exerciseGeneratorList.add(exerciseGenerator)  ;
    }

    public List<Exercise> generate(int amount) {
        List<Exercise> exercises = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            ExerciseGenerator randomGenerator = exerciseGeneratorList.get(random.nextInt(exerciseGeneratorList.size()));
            exercises.add(randomGenerator.generate());
        }
        return exercises;
    }
}
