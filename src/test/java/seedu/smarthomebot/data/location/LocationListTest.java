package seedu.smarthomebot.data.location;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.smarthomebot.commons.exceptions.DuplicateDataException;
import seedu.smarthomebot.commons.exceptions.InvalidLocationException;
import seedu.smarthomebot.data.appliance.ApplianceList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LocationListTest {

    private LocationList myHome;
    private ArrayList<String> expectedOutput;
    private ArrayList<String> emptyList;
    private ApplianceList myAppliances;

    @BeforeEach
    public void setUp() throws Exception {
        myHome = new LocationList();
        myAppliances = new ApplianceList();
        Location location = new Location("Living Room", myAppliances);
        myHome.addLocation(location);
        expectedOutput = new ArrayList<>();
        expectedOutput.add("Living Room");
        emptyList = new ArrayList<>();
    }

    @Test
    void addLocation_locationNotInList_locationAddedNormally() throws DuplicateDataException, InvalidLocationException {
        Location masterRoom = new Location("MasterRoom", myAppliances);
        myHome.addLocation(masterRoom);
        expectedOutput.add("MasterRoom");

        for (int i = 0; i < myHome.getAllLocations().size(); i++) {
            assertEquals(expectedOutput.get(i), myHome.getAllLocations().get(i).toString());
        }

    }

    @Test
    void addLocation_locationAlreadyInList_throwsDuplicateDataException() throws InvalidLocationException {
        Location location = new Location("Living Room", myAppliances);
        assertThrows(DuplicateDataException.class, () -> myHome.addLocation(location));
    }

    @Test
    void removeLocation_locationInList_locationRemovedNormally() throws InvalidLocationException {
        myHome.removeLocation("Living Room");
        assertEquals(emptyList, myHome.getAllLocations());
    }

    @Test
    void removeLocation_locationNotExist_throws_InvalidRemovalLocationException() {
        assertThrows(InvalidLocationException.class, () -> myHome.removeLocation("Other Places"));
    }

    @Test
    void getLocations() {
        assertEquals(expectedOutput, myHome.getAllLocations());
    }

    @Test
    void testToString() {
        assertEquals("Living Room\n", myHome.toString());
    }

    @Test
    void isLocationCreated_locationInList_returnTrue() {
        assertTrue(myHome.isLocationCreated("Living Room"));
    }

}