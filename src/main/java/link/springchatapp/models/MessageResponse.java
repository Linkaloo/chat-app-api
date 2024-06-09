package link.springchatapp.models;

public class MessageResponse {
    private String sender;
    private String content;

    public MessageResponse() {}
    public MessageResponse(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }
}
