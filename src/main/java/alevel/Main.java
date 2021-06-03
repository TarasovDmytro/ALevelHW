package alevel;

public class Main {

    public static void main(String[] args) {

        Report report = Report.builder().header("Header").body("Body").build();
        Report report1 = report.toBuilder().footer("Footer").build();
        System.out.print("");

        Pow exp = (int number, int pow) -> {
            int result = number;
            for (int i = 1; i < pow; i++) {
                result *= number;
            }
            return (pow == 0) ? 1 : result;
        };

        System.out.println(exp.exponentiation(5, 3));
        System.out.println(exp.exponentiation(5, 0));
        System.out.println(exp.exponentiation(0, 3));

        System.out.println(report.equals(report1));
        System.out.println(report1.equals(report));
        System.out.println(report.hashCode());
        System.out.println(report1.hashCode());
    }
}


