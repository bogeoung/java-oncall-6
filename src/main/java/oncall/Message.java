package oncall;

public enum Message {
    GET_MONTH_AND_START_DAY("비상 근무를 배정할 월과 시작 요일을 입력하세요>"),
    GET_WEEK_DAY_LIST("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>"),
    GET_WEEKEND_LIST("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>");

    private final String content;

    Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}

