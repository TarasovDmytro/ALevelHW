import utils.Run;

public class Api {

    public static void main(String[] args) {

        Run run = new Run();
        try {
            run.run();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
