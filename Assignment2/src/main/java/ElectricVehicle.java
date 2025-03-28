public class ElectricVehicle {
  private String name;
  private double batterySize;
  private double stateOfCharge;
  private double defaultEfficiency;
  private double currentEfficiency;

  public ElectricVehicle(String name, double batterySize, double stateOfCharge, double defaultEfficiency) {
    //clamp battery size
    if (batterySize < 10.0){
      batterySize = 10.0;
    } else if (batterySize > 150.0){
      batterySize = 150.0;
    }

    //clamp default efficiency
    if (defaultEfficiency < 0.5){
      defaultEfficiency = 0.5;
    } else if (defaultEfficiency > 4.5){
      defaultEfficiency = 4.5;
    }

    //check the name of EV
    if (name == null || name.equals("")){
      name = "unknown EV";
    }

    //clamp state of charge
    if (stateOfCharge < 0.15){
      stateOfCharge = 0.15;
    } else if (stateOfCharge > 1){
      stateOfCharge = 1;
    }

    this.name = name;
    this.batterySize = batterySize;
    this.stateOfCharge = stateOfCharge;
    this.defaultEfficiency = defaultEfficiency;
    this.currentEfficiency = defaultEfficiency;
  }

  public double range() {
    return currentEfficiency * this.stateOfCharge * this.batterySize;
  }

  public void updateEfficiency(double temperature){
    if (temperature >= 65.0 && temperature <= 77.0){
      currentEfficiency = 1.00;
    } else if (temperature > 77.0){
      currentEfficiency = 0.85;
    } else if (temperature < 65.0){
      currentEfficiency = 1 - (65 - temperature)*0.01;
      if (currentEfficiency < 0.5){
        currentEfficiency = 0.5;
      }
    }
  }

  public Double getCurrentEfficiency() {
    return currentEfficiency;
  }

  public Double getBatterySize() {
    return batterySize;
  }

  public Double getStateOfCharge() {
    return stateOfCharge;
  }

  public String getName() {
    return name;
  }

  public void setStateOfCharge(Double stateOfCharge) {
    if (stateOfCharge < 0.15){
      this.stateOfCharge = 0.15;
    } else if (stateOfCharge > 1){
      this.stateOfCharge = 1;
    } else {
      this.stateOfCharge = stateOfCharge;
    }
  }

  public String toString(){
    double soc = (double) this.stateOfCharge * 100;
    String range = String.format("%.1f", range());
    return name + " SOC: " + soc + "% Range (miles): " + range;
  }
}
