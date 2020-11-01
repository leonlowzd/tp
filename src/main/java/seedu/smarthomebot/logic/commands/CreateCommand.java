package seedu.smarthomebot.logic.commands;

import seedu.smarthomebot.commons.exceptions.DuplicateDataException;
import seedu.smarthomebot.commons.exceptions.InvalidLocationException;
import seedu.smarthomebot.data.location.Location;

public class CreateCommand extends Command {

    public static final String COMMAND_WORD = "create";
    public static final String MESSAGE_USAGE = "Create location: " + COMMAND_WORD
            + " [LOCATION_NAME]";
    private static final String MESSAGE_LOCATION_EXIST = "Location already exist";
    private final String locationName;

    public CreateCommand(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public CommandResult execute() {
        try {
            Location location = new Location(this.locationName, this.applianceList);
            this.locationList.addLocation(location);
            return new CommandResult("Creating Location \"" + location + "\".....CREATED!");
        } catch (DuplicateDataException e) {
            return new CommandResult(MESSAGE_LOCATION_EXIST);
        } catch (InvalidLocationException e) {
            return new CommandResult(MESSAGE_LOCATION_EXIST
                    + " in applianceList, unable to create the Location.");
        }
    }
}
