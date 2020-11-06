package seedu.smarthomebot.logic.commands;

import seedu.smarthomebot.commons.exceptions.DuplicateDataException;
import seedu.smarthomebot.commons.exceptions.InvalidLocationException;

import java.util.logging.Level;

import static seedu.smarthomebot.commons.Messages.LINE;

//@@author zongxian-ctrl

/**
 * Represent the command for creating a location in the LocationList.
 */
public class CreateCommand extends Command {

    public static final String COMMAND_WORD = "create";
    public static final String MESSAGE_USAGE = "Create location: " + COMMAND_WORD
            + " [LOCATION_NAME]";
    private static final String MESSAGE_LOCATION_EXIST = "Location already exist";
    private final String userEnteredLocation;

    public CreateCommand(String location) {
        assert location.isEmpty() != true : "CreateCommand must not accept empty location";
        this.userEnteredLocation = location;
    }

    @Override
    public CommandResult execute() {
        try {
            if (!applianceList.isApplianceExist(userEnteredLocation)) {
                locationList.addLocation(userEnteredLocation);
            } else {
                throw new InvalidLocationException();
            }
            commandLogger.log(Level.INFO, "Created new Location " + userEnteredLocation);
            return new CommandResult("Creating Location \"" + userEnteredLocation + "\".....CREATED!");
        } catch (DuplicateDataException e) {
            commandLogger.log(Level.WARNING, "Location already exists");
            return new CommandResult(MESSAGE_LOCATION_EXIST);
        } catch (InvalidLocationException e) {
            commandLogger.log(Level.WARNING, "Duplicate name found in ApplianceList");
            return new CommandResult(MESSAGE_LOCATION_EXIST
                    + " as an Appliance, please choose another name.");
        }
    }
}
