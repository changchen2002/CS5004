package sports.basketball;

import sports.IPlayer;

public class BasketballPlayer implements IPlayer <BasketballStats> {
  private String name;
  private int age;
  private double height;
  private BasketballStats stats;

  public BasketballPlayer(String name, int age, double height, BasketballStats stats) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.stats = stats;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getAge() {
    return age;
  }

  @Override
  public double getHeight() {
    return height;
  }

  @Override
  public BasketballStats getStats() {
    return stats;
  }

}
