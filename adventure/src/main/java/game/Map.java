package game;

public class Map {

    private Room startRoom;

    public void buildMap() {
        //create room
        Room room1 = new Room("Outside", "forrest outside a cave - the cave-entrance splits in two different directions.");
        room1.addItem("an old rusty flashlight");
        room1.addItem("a crinkly paper map with a big X in the middle", "map");
        Room room2 = new Room("Narrow cave", "narrow cave that seems to bend up and down almost infinitely");
        Room room3 = new Room("Large grotto", "large grotto with an opening very far above where sunlight shines through.");
        room3.addItem("a wicker bird cage");
        //TODO create rest of the 9 rooms in cave

        // Connect rooms
        room1.setEastRoom(room2);
        // Assign the southRoom field of this Map instance to reference the new Room object
// Create the room that lies to the south of the cave entrance
        Room room4 = new Room("Wet cave", "large dark cave - the floor is quite wet and slippery here.");
// Invoke setSouthRoom on room1, passing room4 to link them
// Connect startRoom’s south to the Wet cave instance
        room1.setSouthRoom(room4);

// Link the southRoom of room1 to room4 via setSouthRoom
// Connect startRoom south to Wet cave
        room1.setSouthRoom(room4);

        room2.setEastRoom(room3);
        //TODO connect all rooms according to the specified map

        // Assign the startRoom field of this Map instance to reference the first room created (room1)
// Defines which room players begin in when the map is built
        this.startRoom = room1;

    }

    public Room getStartRoom() {
        return startRoom;
    }
}
