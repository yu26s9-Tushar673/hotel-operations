package com.pluralsight;
import com.pluralsight.models.Room;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest
{
    @Test
    public void checkIn_should_makeRoom_dirtyAndOccupied() {
        // arrange
        Room room = new Room(2, 150, false, false);

        // act
        room.checkIn();

        // assert
        assertTrue(room.isDirty() && room.isOccupied());
    }

    @Test
    public void checkOut_should_makeRoomUnoccupied() {
        // arrange
        Room room = new Room(2, 150, true, true);

        // act
        room.checkout();

        // assert
        assertFalse(room.isOccupied());
    }

    @Test
    public void cleanRoom_should_makeRoomNotDirty() {
        // arrange
        Room room = new Room(2, 150, false, true);

        // act
        room.cleanRoom();

        // assert
        assertFalse(room.isDirty());
    }
}
