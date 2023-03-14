import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class QueryLine extends QueryStructure {

    private LocalDate dateFrom;
    private LocalDate dateTo;

    @Override
    public String toString() {
        return "QueryLine{" +
                "dateFrom=" + dateFrom.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                ", dateTo=" + dateTo +
                "} " + super.toString();
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public QueryLine(LocalDate dateFrom, LocalDate dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        QueryLine queryLine = (QueryLine) o;
        return Objects.equals(dateFrom, queryLine.dateFrom) && Objects.equals(dateTo, queryLine.dateTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateFrom, dateTo);
    }

    public QueryLine() {
    }
}
