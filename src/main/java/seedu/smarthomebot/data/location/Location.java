package seedu.smarthomebot.data.location;

import seedu.smarthomebot.commons.exceptions.InvalidLocationException;
import seedu.smarthomebot.data.appliance.ApplianceList;

public class Location {
    private String location;

    public Location(String location, ApplianceList applianceList) throws InvalidLocationException {
        if (!applianceList.isApplianceExist(location)) {
            this.location = location;
        } else {
            throw new InvalidLocationException();
        }
    }

    @Override
    public String toString() {
        return this.location;
    }
}
