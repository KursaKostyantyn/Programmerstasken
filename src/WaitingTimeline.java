import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class WaitingTimeline extends QueryStructure {

    private LocalDate date;
    private int time;

    @Override
    public String toString() {
        return "WaitingTimeline{" +
                ", date=" + date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                ", time=" + time +
                "} " + super.toString();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public WaitingTimeline(LocalDate date, int time) {
        this.date = date;
        this.time = time;
    }

    public WaitingTimeline() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WaitingTimeline that = (WaitingTimeline) o;
        return time == that.time && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), date, time);
    }
}
