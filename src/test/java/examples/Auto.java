package examples;

/**
 * Created by Daniel on 21/07/2017.
 */
public class Auto {
    public String color;
    public String merk;
    public String deuren;
    public String motorType;

    public String getMerk() {
        return merk;
    }
    public void setMerk(String merk) {
        this.merk = merk;
    }
    public String getDeuren() {
        return deuren;
    }
    public void setDeuren(String deuren) {
        this.deuren = deuren;
    }
    public String getMotorType() {
        return motorType;
    }
    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public double calculateTorque(int force, int enginge)
    {
        return ((force * 5252) / enginge);

    }
}
