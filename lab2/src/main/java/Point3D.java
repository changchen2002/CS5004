public class Point3D {
  private Integer x;
  private Integer y;
  private Integer z;

  //Default constructor
  public Point3D() {
    this.x = 0;
    this.y = 0;
    this.z = 0;
  }

  //A constructor that takes 3 integers
  public Point3D(Integer x, Integer y, Integer z){
    this.x = x;
    this.y = y;
    this.z = z;
  }

  //Copy constructor
  public Point3D copyPoint(Point3D point3D){
    Point3D copy  = new Point3D();
    copy.x = point3D.x;
    copy.y = point3D.y;
    copy.z = point3D.z;
    return copy;
  }

  //Three "getter" methods
  public Integer getX() {
    return this.x;
  }
  public Integer getY() {
    return this.y;
  }
  public Integer getZ() {
    return this.z;
  }

  //Calculate the answer
  public Double distanceTo(Point3D other){
    return Math.sqrt(
            Math.pow(other.x - this.getX(), 2) +
            Math.pow(other.y - this.getY(), 2) +
            Math.pow(other.z - this.getZ(), 2)
    );
  }

  //Check if equal
  public boolean equals(Point3D other){
    return this.x.equals(other.x) && this.y.equals(other.y) && this.z.equals(other.z);
  }

  //String representation
  public String toString(){
    return "Point3D{x=" + this.x +
                    ", y=" + this.y +
                    ", z=" + this.z + "}";
  }


}

