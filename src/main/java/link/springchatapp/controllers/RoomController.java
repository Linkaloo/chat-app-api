package link.springchatapp.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class RoomController {
    private ArrayList<Room> roomList = new ArrayList<Room>();

    @MessageMapping("/room/create")
    @SendTo("/topic/rooms")
    public ArrayList<Room> createRoom(link.springchatapp.models.Room room) throws Exception {
        // Create room in a database
        System.out.println("Creating a room, for " + room.getOwner());

        for (Room r: roomList) {
            if(r.getOwner().equals(room.getOwner())) {
                System.err.println("Error: Room with same owner name");
                return roomList;
            }
        }

        Room newRoom = new Room(room.getOwner());
        roomList.add(newRoom);

        System.out.println(roomList);
        return roomList;
    }

    @MessageMapping("/room/join/{id}")
    @SendTo("/topic/room/{id}")
    public void joinRoom() throws Exception {
        // Join a room in the database
    }

    @MessageMapping("/room/leave/{id}")
    @SendTo("/topic/room/{id}")
    public void leaveRoom() throws Exception {
        // leave a room in the database
    }
}
