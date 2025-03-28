import java.util.Objects;

class Animal {
  protected String name;
  protected double feet;

  public Animal() {
    this.name = name;
    this.feet = feet;
  }

  public Animal(String name, double feet) {
    this.name = name;
    this.feet = feet;
  }

  public double getFeet() {
    return feet;
  }

  public void setFeet(double feet) {
    this.feet = feet;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null|| getClass() != obj.getClass()) return false;

    Animal animal = (Animal) obj;
    return Double.compare(animal.feet, feet) == 0 &&
            Objects.equals(name, animal.name);
  }

  @Override
  public String toSting() {
    return "Animal{name='" + name + "', feet=" + feet + "}";
  }

}

class Dog extends Animal {
  public Dog() {
    super();
  }
  public Dog(String name, double feet) {
    super(name, feet);
  }

  @Override
  public String toString() {
    return "Dog{name='" + getName() + "', feet=" + getFeet() + "}";
  }
}