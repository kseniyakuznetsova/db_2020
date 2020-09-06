package homework.exams_generation;

public class Main {
    public static void main(String[] args) {
        Examinator examinator = new Examinator();
        examinator.addGenerator(new MinusExerciseGenerator());
        examinator.addGenerator(new PlusExerciseGenerator());
        System.out.println(examinator.generate(5));

        System.out.println("-------------------------------");

        Examinator multiplyExaminator = new Examinator();
        multiplyExaminator.addGenerator(new MultiplyExerciseGenerator());
        System.out.println(multiplyExaminator.generate(10));
    }
}
