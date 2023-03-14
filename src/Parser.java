import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parser {
    public static final int matchAll = 100;

    public WaitingTimeline parseIntoWaitingTimeline(String query) {
        WaitingTimeline waitingTimeline = new WaitingTimeline();
        String[] parsedQuery = query.split(" ");
        fillCommonFields(parsedQuery, waitingTimeline);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        waitingTimeline.setDate(LocalDate.parse(parsedQuery[4], formatter));
        waitingTimeline.setTime(Integer.parseInt(parsedQuery[5]));
        return waitingTimeline;
    }

    public QueryLine parseIntoQueryLine(String query) {
        QueryLine queryLine = new QueryLine();
        String[] parsedQuery = query.split(" ");
        if (parsedQuery[1].equals("*")) {
            parsedQuery[1] = String.valueOf(matchAll);
        }
        if (parsedQuery[2].equals("*")) {
            parsedQuery[2] = String.valueOf(matchAll);
        }
        fillCommonFields(parsedQuery, queryLine);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        String[] split = parsedQuery[4].split("-");
        switch (split.length) {
            case 1:
                queryLine.setDateFrom(LocalDate.parse(split[0], formatter));
                break;
            case 2:
                queryLine.setDateFrom(LocalDate.parse(split[0], formatter));
                queryLine.setDateTo(LocalDate.parse(split[1], formatter));
                break;
        }
        return queryLine;
    }

    private void fillCommonFields(String[] parsedQuery, QueryStructure queryStructure) {
        String[] split = parsedQuery[1].split("\\.");
        switch (split.length) {
            case 1:
                queryStructure.setServiceId(Integer.parseInt(split[0]));
                break;
            case 2:
                queryStructure.setServiceId(Integer.parseInt(split[0]));
                queryStructure.setVariationId(Integer.parseInt(split[1]));
                break;
        }
        split = parsedQuery[2].split("\\.");
        switch (split.length) {
            case 1:
                queryStructure.setQuestionTypeId(Integer.parseInt(split[0]));
                break;
            case 2:
                queryStructure.setQuestionTypeId(Integer.parseInt(split[0]));
                queryStructure.setCategoryId(Integer.parseInt(split[1]));
                break;
            case 3:
                queryStructure.setQuestionTypeId(Integer.parseInt(split[0]));
                queryStructure.setCategoryId(Integer.parseInt(split[1]));
                queryStructure.setSubCategoryId(Integer.parseInt(split[2]));
                break;
        }
        switch (parsedQuery[3]) {
            case "P":
                queryStructure.setResponseType(ResponseType.P);
                break;
            case "N":
                queryStructure.setResponseType(ResponseType.N);
                break;
        }
    }

}
