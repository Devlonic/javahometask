package devices.musical;

import devices.Device;

public abstract class MusicalInstrument extends Device {
    public MusicalInstrument(String model, String description) {
        super(model, description);
    }

    public abstract void history();
}

