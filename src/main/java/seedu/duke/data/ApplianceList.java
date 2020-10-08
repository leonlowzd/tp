package seedu.duke.data;

import seedu.duke.data.framework.Appliance;
import seedu.duke.exceptions.InvalidAdditionOfAppliance;

import java.util.ArrayList;

public class ApplianceList {

    private static ArrayList<Appliance> appliances;

    public ApplianceList() {
        appliances = new ArrayList<>();
    }

    public void addAppliance(Appliance appliance) throws InvalidAdditionOfAppliance {
        if (!isAppliance(appliance)) {
            appliances.add(appliance);
        } else {
          throw new InvalidAdditionOfAppliance();
        }
    }

    public void removeAppliance(int index) {
        appliances.remove(index);
    }

    public Appliance getAppliance(int index) {
        return appliances.get(index);
    }

    public ArrayList<Appliance> getAllAppliance() {
        return appliances;
    }

    public void setAppliance(int index, Appliance appliance) {
        appliances.set(index, appliance);
    }

    private Boolean isAppliance(Appliance toAddAppliance) {
        boolean isExist = false;
        for (Appliance a : appliances) {
            if (a.getName().equals(toAddAppliance.getName())) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

}
