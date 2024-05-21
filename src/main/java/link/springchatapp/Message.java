package link.springchatapp;

public class Message {
    private String name;

    public Message() {
        System.out.println("Default Message");
    }

    public Message(String name) {
        System.out.println("name Message");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
