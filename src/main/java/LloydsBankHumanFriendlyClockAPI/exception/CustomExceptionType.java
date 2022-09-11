package LloydsBankHumanFriendlyClockAPI.exception;

public enum CustomExceptionType {

    INVALID_INPUT("Incorrect Time. Please enter time in the 24hr format hh:mm"),
    INVALID_FORMAT("Incorrect Format of Time. Please enter time in correct 24hr format hh:mm");

    private String message;

    private CustomExceptionType(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
