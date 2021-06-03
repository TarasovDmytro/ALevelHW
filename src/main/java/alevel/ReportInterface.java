package alevel;

@FunctionalInterface
public interface ReportInterface {

    String header = "Header";
    String footer = "Footer";

    String getBody(String body);

    default String getHeader() {
        return header;
    }

    default String getFooter() {
        return footer;
    }

}
