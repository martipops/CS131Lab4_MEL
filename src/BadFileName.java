//IO TestClass for bad file names
public class BadFileName {

  public static void main(String[] args) {

    FileProcessor fp = new FileProcessor("String1.txt", 10);
    fp.processFile();
    System.out.println(fp);
  }// end main

}// end class