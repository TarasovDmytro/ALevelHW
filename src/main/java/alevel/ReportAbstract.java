package alevel;

public abstract class ReportAbstract {
    private String header;
    private String footer;

    public ReportAbstract(String header, String footer) {
        setHeader(header);
        setFooter(footer);
    }

    String getHeader() {
        return header;
    }

    void setHeader(String header) {
        this.header = header;
    }

    String getFooter() {
        return footer;
    }

    void setFooter(String footer) {
        this.footer = footer;
    }

}
