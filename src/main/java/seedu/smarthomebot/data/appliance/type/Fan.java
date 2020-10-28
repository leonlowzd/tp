package seedu.smarthomebot.data.appliance.type;

import seedu.smarthomebot.data.appliance.Appliance;
import seedu.smarthomebot.data.location.LocationList;
import seedu.smarthomebot.logic.commands.exceptions.InvalidApplianceNameException;
import seedu.smarthomebot.logic.commands.exceptions.LocationNotFoundException;

import static seedu.smarthomebot.commons.Messages.MESSAGE_INVALID_FAN_SPEED;

public class Fan extends Appliance {

    public static final String TYPE_WORD = "fan";
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 4;
    private String speed;

    public Fan(String name, String location, String wattage, LocationList locationList)
            throws InvalidApplianceNameException, LocationNotFoundException {
        super(name, location, wattage, locationList);
        this.speed = "1";
    }

    public String getType() {
        return TYPE_WORD;
    }

    public String setSpeed(String speed) {
        String toPrint;
        if (speed.isEmpty()) {
            // default speed will be set.
            toPrint = toString();
        } else if (isParameterValid(speed, LOWER_BOUND, UPPER_BOUND)) {
            // user input speed will be set.
            this.speed = speed;
            toPrint = toString();
        } else {
            // user inputs an invalid speed.
            toPrint = "\n" + MESSAGE_INVALID_FAN_SPEED;
        }
        return toPrint;
    }

    @Override
    public String getParameter(boolean isList) {
        if (isList) {
            return " Speed " + getParameter(false);
        } else {
            return this.speed;
        }
    }

    public void getSpeedFromLoadFile(String loadedSpeed) {
        speed = loadedSpeed;
    }

    @Override
    public String writeFileFormat() {
        return super.writeFileFormat();
    }

    @Override
    public String toString() {
        String speedStatement;
        if (appliancePower.getStatus()) {
            speedStatement = " @" + getParameter(true);
        } else {
            speedStatement = "";
        }
        return super.toString() + speedStatement;
    }

}