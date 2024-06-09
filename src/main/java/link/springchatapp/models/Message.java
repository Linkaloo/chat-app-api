package link.springchatapp.models;


public class Message {
    private String sender;
    private String message;
    private String date;

    public Message() {}

    public Message(String sender, String message, String date) {
        this.sender = sender;
        this.message = message;
        this.date = date;
    }

    public String getSender() {
        return sender;
    }
    public String getMessage() {
        return message;
    }
    public String getDate() {
        return date;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
