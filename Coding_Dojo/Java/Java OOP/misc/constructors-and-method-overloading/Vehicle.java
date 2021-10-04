class Vehicle {
    private int numberOfWheels;
    private String color;
    
    // ex. new Vehicle()
    public Vehicle() {
    }
    // ex. new Vehicle("someColor")    
    public Vehicle(String color) {
        // setting the color attribute to the value from the color parameter
        this.color = color;
    }
    
    // ex. new Vehicle("someColor", 4)    
    public Vehicle(String color, int num) {
        this.color = color;
        this.numberOfWheels = num;
    }
        
    // GETTER
    public int getNumberOfWheels() {
      return numberOfWheels;
    }

    // SETTER
    public void setNumberOfWheels(int number) {
      numberOfWheels = number;
    }

    // GETTER
    public String getColor() {
      return color;
    }

    // SETTER
    public void setColor(String color) {
      this.color = color; // 1
    }
}