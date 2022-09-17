package az.company.booking_project.IO;

public interface Console {
  String readLn();
  void print(String line);
  default void printLn(String line) {
    print(line);
    printLn();
  }
  default void printLn() {
    print("\n");
  }
  void close();
}
