package link.springchatapp.models;

public class Room {
    private String owner;

    public Room() {};

    public Room(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
