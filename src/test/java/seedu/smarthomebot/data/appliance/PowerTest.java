package seedu.smarthomebot.data.appliance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.smarthomebot.commons.exceptions.DuplicateDataException;
import seedu.smarthomebot.commons.exceptions.InvalidLocationException;
import seedu.smarthomebot.data.appliance.type.Fan;
import seedu.smarthomebot.data.location.Location;
import seedu.smarthomebot.data.location.LocationList;
import seedu.smarthomebot.logic.commands.exceptions.InvalidApplianceNameException;
import seedu.smarthomebot.logic.commands.exceptions.LocationNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


class PowerTest {

    private Appliance coolingFan;
    private LocationList locationList;
    private ApplianceList applianceList;

    @BeforeEach
    public void setUp() throws InvalidApplianceNameException,
            LocationNotFoundException, DuplicateDataException, InvalidLocationException {
        String bedroom = "bedroom";
        locationList = new LocationList();
        Location location = new Location(bedroom, applianceList);
        locationList.addLocation(location);
        coolingFan = new Fan("Speedy", bedroom, "150", locationList);
    }

    @Test
    void onAppliance_applianceOffPreviously_onNormally() {
        coolingFan.switchOff();
        assertTrue(coolingFan.switchOn());
    }

    @Test
    void onAppliance_applianceAlreadyOn_returnFalse() {
        coolingFan.switchOn();
        assertFalse(coolingFan.switchOn());
    }

    @Test
    void offAppliance_applianceOnPreviously_onNormally() {
        coolingFan.switchOn();
        assertTrue(coolingFan.switchOff());
    }

    @Test
    void offAppliance_applianceAlreadyOff_returnFalse() {
        coolingFan.switchOff();
        assertFalse(coolingFan.switchOff());
    }

    @Test
    void resetPower_fanOnForThreeSeconds_powerResetToZero() throws InterruptedException {
        useFanForThreeSeconds();
        coolingFan.resetPowerUsage();
        assertEquals("0.00", coolingFan.getPowerInString());
    }

    @Test
    void getPower_fanOnForThreeSeconds_returnPowerValue() throws InterruptedException {
        useFanForThreeSeconds();
        assertEquals(0.0, coolingFan.getPowerInDouble());
    }

    @Test
    void testToString() throws InterruptedException {
        useFanForThreeSeconds();
        assertEquals("0.00", coolingFan.getPowerInString());
    }

    private void useFanForThreeSeconds() throws InterruptedException {
        coolingFan.switchOn();
        // Appliance will be on for 3000ms which equals to 30 minutes in SmartHomeBot
        Thread.sleep(3000);
        coolingFan.switchOff();
    }

}