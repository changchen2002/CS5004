import javax.xml.namespace.QName;

public class Book {
  private String name;
  private Integer pages;
  private Double rate;

  public Book(String name, Integer pages, Double rate) {
    this.name = name;
    this.pages = pages;
    this.rate = rate;
  }

  public String getName() {
    return this.name;
  }

  public Integer getPages() {
    return this.pages;
  }

  public Double getRate() {
    return this.rate;
  }

}
