package seedu.smarthomebot.common;

public class Messages {

    public static final String LINE = "-".repeat(Math.max(0, 52)) + "\n";
    public static final String DIVIDER = "=".repeat(Math.max(0, 52));
    public static final String MESSAGE_WELCOME = "Welcome to your SmartHomeBot V1.0!";
    public static final String MESSAGE_GOODBYE = "Good bye!";
    public static final String MESSAGE_IMPORT = "Importing data........Completed!";
    public static final String MESSAGE_EXPORT = "Exporting data........Completed!";
    public static final String MESSAGE_APPLIANCE_TYPE_NOT_EXIST = "Type Entered does not exist.";
    public static final String MESSAGE_APPLIANCE_EXIST = "Appliance name already exists.";
    public static final String MESSAGE_LOCATION_NOT_EXIST = "Location does not exist.";
    public static final String MESSAGE_DISPLAY_LOCATION = " | Location: ";
    public static final String MESSAGE_DISPLAY_STATUS = " | Status: ";
    public static final String MESSAGE_DISPLAY_USAGE = " | Usage: ";
    public static final String MESSAGE_DISPLAY_WATT = " | Watt: ";
    public static final String MESSAGE_DISPLAY_TYPE = " | Type: ";
    public static final String MESSAGE_TOTAL_POWER_USAGE = "\n\nTotal power consumption: ";
    public static final String MESSAGE_LIST_LOCATIONS = "Here are the location you have entered:";
    public static final String MESSAGE_LIST_APPLIANCES = "Here are the appliances in your list:";
    public static final String MESSAGE_POWER_USAGE = "Here are the power usage consumption:";
    public static final String MESSAGE_LIST_NO_LOCATIONS = "There is currently no locations in the list.";
    public static final String MESSAGE_LIST_NO_APPLIANCES = "There is currently no appliances in the list.";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid Command Format";
    public static final String MESSAGE_INVALID_ADD_COMMAND =
            "Please follow this order, add NAME l/[LOCATION_NAME] w/[WATTS] t/[TYPE_OF_APPLIANCE]";
    public static final String MESSAGE_INVALID_LIST_COMMAND =
            "Please enter either 'list appliance' or 'list location' or 'list appliance l/LOCATION_NAME'";
    public static final String MESSAGE_POWER_NOT_NUMBER = "Please enter a valid numerical value for wattage.";
    public static final String MESSAGE_POWER_EXCEEDED =
            "Appliance wattage is uncommon. Please enter between 0 to 9999.";
    public static final String MESSAGE_TIME_FORMAT_ERROR = "Time format is wrong.";
    public static final String MESSAGE_APPLIANCE_PREVIOUSLY_ON = "The appliance is already ON previously. ";
    public static final String MESSAGE_APPLIANCE_PREVIOUSLY_OFF = "The appliance is already OFF previously. ";
    public static final String MESSAGE_FILE_CORRUPTED = "Data file is corrupted, some data will not be entered";

    public static final String MESSAGE_APPLIANCE_NOT_EXIST = "Appliance does not exist in the list.";

    public static final String MESSAGE_INVALID_TEMPERATURE_AC =
            "Invalid Temperature is set, ensure that it is within 16-30 degrees. \n"
                    + "Previous set temperature will be set.";
    public static final String MESSAGE_INVALID_FAN_SPEED =
            "Invalid speed is set, ensure that it is within 1-3 speed. \n "
                    + "Previous set speed will be set.";
    public static final String MESSAGE_ILLEGAL_CHARACTER = "Illegal Character space or / detected in";
    public static final String MESSAGE_EMPTY_PARAMETER =
            "Empty Parameter detected! Please follow format and enter require parameters.";
    public static final String MESSAGE_INVALID_TEMPERATURE_WH =
            "Invalid speed is set, ensure that it is within 20-50 degrees. \n "
                    + "Previous set speed will be set.";
}