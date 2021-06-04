package alevel;

import java.util.Objects;

public class Report extends ReportAbstract {

    private final String header;
    private final String body;
    private final String footer;

    private Report(String header, String body, String footer) {
        super(header, footer);
        this.header = super.getHeader();
        this.body = body;
        this.footer = super.getFooter();
    }

    public static ReportBuilder builder() {
        return new ReportBuilder();
    }

    public ReportBuilder toBuilder() {
        return new ReportBuilder(this.header, this.body, this.footer);
    }

    public static class ReportBuilder {
        private String header;
        private String body;
        private String footer;

        public ReportBuilder() {
        }

        public ReportBuilder(String header, String body, String footer) {
            this.header = header;
            this.body = body;
            this.footer = footer;
        }

        public ReportBuilder header(String header) {
            this.header = header;
            return this;
        }

        public ReportBuilder body(String body) {
            this.body = body;
            return this;
        }

        public ReportBuilder footer(String footer) {
            this.footer = footer;
            return this;
        }

        public Report build() {
            return new Report(this.header, this.body, this.footer);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return header.equals(report.header) && body.equals(report.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, body, footer);
    }
}
