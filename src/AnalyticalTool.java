import java.util.ArrayList;
import java.util.List;

public class AnalyticalTool {

    public String analyzeWaitingTimeLine(List<WaitingTimeline> waitingTimelines, QueryLine queryLine) {
        List<Integer> timeList = new ArrayList<>();
        for (WaitingTimeline waitingTimeline : waitingTimelines) {
            if (compareWaitingAndQuery(waitingTimeline, queryLine)) {
                timeList.add(waitingTimeline.getTime());
            }
        }
        double avg = timeList.stream().mapToInt(time -> time).average().orElse(0);
        if (avg == 0) {
            return "-";
        } else {
            return String.valueOf(avg);
        }
    }

    public boolean compareWaitingAndQuery(WaitingTimeline waitingTimeline, QueryLine queryLine) {
        if (queryLine.getServiceId() != waitingTimeline.getServiceId() && queryLine.getServiceId() != Parser.matchAll) {
            return false;
        }
        if (queryLine.getQuestionTypeId() != waitingTimeline.getQuestionTypeId() && queryLine.getQuestionTypeId() != Parser.matchAll) {
            return false;
        }
        if (queryLine.getResponseType() != waitingTimeline.getResponseType()) {
            return false;
        }
        if (waitingTimeline.getDate().isBefore(queryLine.getDateFrom())) {
            return false;
        }
        if (queryLine.getDateTo() == null || queryLine.getDateTo().isBefore(waitingTimeline.getDate())) {
            return false;
        }

        if (queryLine.getVariationId() != 0 && queryLine.getVariationId() != waitingTimeline.getVariationId()) {
            return false;
        }
        if (queryLine.getCategoryId() != 0 && queryLine.getCategoryId() != waitingTimeline.getCategoryId()) {
            return false;
        }
        if (queryLine.getSubCategoryId() != 0 && queryLine.getSubCategoryId() != waitingTimeline.getSubCategoryId()) {
            return false;
        }
        return true;
    }
}
