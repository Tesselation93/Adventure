package game;
// Finally I can go back to english! All the double cooments are brilliant, now it's cleasr what is my code and what package game;

import java.util.ArrayList;

public class Room {
    private Room northRoom;
    private Room eastRoom;
    private Room southRoom;
    private Room westRoom;

    private String name;
    private String description;
    private ArrayList<Item> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    // Convenience methods for creating and adding Item
    public void addItem(String description) {
        this.addItem(new Item(description));
    }

    // Convenience methods for creating and adding Item with custom short name
    public void addItem(String description, String name) {
        this.addItem(new Item(description, name));
    }

    public Room getNorthRoom() {
// Return the northRoom field stored in this Room instance
// Gives the room located to the north (or null if none)
        return northRoom;

    }

    public void setNorthRoom(Room northRoom) {
// Assign the northRoom field of this object to reference the passed-in room
// Link this room’s north to the given room
        this.northRoom = northRoom;

// If the passed-in room isn’t null and doesn’t already point back south to this, set its southRoom to this
// Also link the given room’s south back to this room if not already linked
        if (northRoom != null && northRoom.southRoom != this) northRoom.southRoom = this;

    }

    public Room getEastRoom() {
        // Return the eastRoom field stored in this Room instance
        // Gives the room located to the east or null if none
        return eastRoom;

    }

    public void setEastRoom(Room eastRoom) {
        // Assign the eastRoom field of this object to reference the passed-in room
        // Link this room’s east to the given room
        this.eastRoom = eastRoom;

// If the passed-in room isn’t null and doesn’t already point back west to this, set its westRoom to this
// Also link the given room’s west back to this room if not already linked
        if (eastRoom != null && eastRoom.westRoom != this) eastRoom.westRoom = this;

    }

    public Room getSouthRoom() {
        // Return the southRoom field stored in this Room instance
        // Gives the room located to the south or null if none
        return southRoom;

    }

    public void setSouthRoom(Room southRoom) {
        // Assign the southRoom field of this object to reference the passed-in room
        // Link this room’s south to the given room
        this.southRoom = southRoom;

// If the passed-in room isn’t null and doesn’t already point back north to this, set its northRoom to this
// Also link the given room’s north back to this room if not already linked
        if (southRoom != null && southRoom.northRoom != this) southRoom.northRoom = this;

    }

    public Room getWestRoom() {
        // Return the westRoom field stored in this Room instance
        // Gives the room located to the west (or null if none)
        return westRoom;

    }

    public void setWestRoom(Room westRoom) {
        // Assign the westRoom field of this object to reference the passed-in room
        // Link this room’s west to the given room
        this.westRoom = westRoom;

// If the passed-in room isn’t null and doesn’t already point back east to this, set its eastRoom to this
// Also link the given room’s east back to this room if not already linked
        if (westRoom != null && westRoom.eastRoom != this) westRoom.eastRoom = this;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Item removeItem(String itemName) {
        Item itemToBeRemoved = findItem(itemName);
        if (itemToBeRemoved != null) {
            // Remove the found Item object from this room’s items list using ArrayList.remove(Object)
            // Deletes the item so it’s no longer in the room
            items.remove(itemToBeRemoved);

        }
        return itemToBeRemoved;
    }

    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                // Return the matching Item object when its name equals the search term (case-insensitive)
                // Finds an item by name in this room’s item list
                return item;

            }
        }
        return null;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
