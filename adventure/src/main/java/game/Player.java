package game;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventory;

    public Player() {
        inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room startRoom) {
        this.currentRoom = startRoom;
    }

    public boolean move(Direction direction) {
        Room requestedRoom = null;

        switch (direction) {
            case NORTH:
                requestedRoom = currentRoom.getNorthRoom();
                break;
            case SOUTH:
                // Retrieve the room to the south of currentRoom (could be null)
// Gets the room if the player can move south
                requestedRoom = currentRoom.getSouthRoom();

                break;
            case EAST:
                // Retrieve the room to the east of currentRoom (could be null)
// Gets the room if the player can move east
                requestedRoom = currentRoom.getEastRoom();

                break;
            case WEST:
                // Retrieve the room to the west of currentRoom (could be null)
// Gets the room if the player can move west
                requestedRoom = currentRoom.getWestRoom();

                break;
        }

// Check if move is possible by verifying requestedRoom isn't null
// Only update currentRoom when an adjacent room exists
        if (requestedRoom != null) {
            // Assign the currentRoom field of this Player instance to the requestedRoom
// Updates the player's position to the new room
            currentRoom = requestedRoom;
            // Indicate the move succeeded by returning true
// Ensures callers know the player moved successfully
            return true;


        }

// Indicate the move failed by returning false
// Ensures callers know the player didn’t move when no adjacent room exists
        return false;

    }

    public List<Item> getInventory() {
        return inventory;
    }

    public boolean takeItem(String itemName) {
        Item pickupFromRoom = currentRoom.removeItem(itemName);
        if (pickupFromRoom != null) {
            // Add the picked-up Item object to the player's inventory list
// Stores the item so it travels with the player
            inventory.add(pickupFromRoom);

            return true;
        }
        return false;
    }
}
