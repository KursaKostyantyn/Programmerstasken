import java.util.Objects;

public class QueryStructure {
    private int serviceId;
    private int variationId;
    private int questionTypeId;
    private int categoryId;
    private int subCategoryId;
    private ResponseType responseType;

    @Override
    public String toString() {
        return "QueryStructure{" +
                "serviceId=" + serviceId +
                ", variationId=" + variationId +
                ", questionTypeId=" + questionTypeId +
                ", categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
                ", responseType=" + responseType +
                '}';
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getVariationId() {
        return variationId;
    }

    public void setVariationId(int variationId) {
        this.variationId = variationId;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public QueryStructure(int serviceId, int variationId, int questionTypeId, int categoryId, int subCategoryId, ResponseType responseType) {
        this.serviceId = serviceId;
        this.variationId = variationId;
        this.questionTypeId = questionTypeId;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.responseType = responseType;
    }

    public QueryStructure() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryStructure that = (QueryStructure) o;
        return serviceId == that.serviceId && variationId == that.variationId && questionTypeId == that.questionTypeId && categoryId == that.categoryId && subCategoryId == that.subCategoryId && responseType == that.responseType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, variationId, questionTypeId, categoryId, subCategoryId, responseType);
    }
}
