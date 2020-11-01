package seedu.smarthomebot.data.appliance.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.smarthomebot.commons.exceptions.DuplicateDataException;
import seedu.smarthomebot.commons.exceptions.InvalidLocationException;
import seedu.smarthomebot.data.appliance.Appliance;
import seedu.smarthomebot.data.appliance.ApplianceList;
import seedu.smarthomebot.data.location.Location;
import seedu.smarthomebot.data.location.LocationList;
import seedu.smarthomebot.logic.commands.exceptions.InvalidApplianceNameException;
import seedu.smarthomebot.logic.commands.exceptions.LocationNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FanTest {

    private Appliance fan;
    private LocationList locationList;
    private ApplianceList applianceList;

    @BeforeEach
    public void setUp() throws InvalidApplianceNameException, LocationNotFoundException,
            DuplicateDataException, InvalidLocationException {
        String bedroom = "bedroom";
        applianceList = new ApplianceList();
        Location location = new Location(bedroom, applianceList);
        locationList = new LocationList();
        locationList.addLocation(location);
        fan = new Fan("Speedy", bedroom, "150", locationList);
    }

    @Test
    void getType_nullInput_returnsFan() {
        assertEquals("fan", fan.getType());
    }

}