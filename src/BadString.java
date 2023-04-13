public class BadString {

  public static void main(String[] args) {

    FileProcessor fp = new FileProcessor("BadString.txt", 10);
    fp.processFile();
    System.out.println(fp);

  }// end main

}// end class