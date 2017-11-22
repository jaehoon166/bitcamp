package bitcamp.java100.ch02;

public class Test15_11_3 {

  public static void main(String[] args) {
      
      int p1 = 0;
      
      p1 = 0b0_111_101_101;
      
      final int DIRECTORY     = 0x0200;
      final int OWNER_READ    = 0x0100;
      final int OWNER_WRITE   = 0x0080;
      final int OWNER_EXE     = 0x0040;
      final int GROUP_READ    = 0x0020;
      final int GROUP_WRITE   = 0x0010;
      final int GROUP_EXE     = 0x0008;
      final int OTHER_READ    = 0x0004;
      final int OTHER_WRITE   = 0x0002;
      final int OTHER_EXE     = 0x0001;
      
      System.out.print((p1 & DIRECTORY) == DIRECTORY ? "d" : "-");
      System.out.print((p1 & OWNER_READ) == OWNER_READ ? "r" : "-");
      System.out.print((p1 & OWNER_WRITE) == OWNER_WRITE ? "w" : "-");
      System.out.print((p1 & OWNER_EXE) == OWNER_EXE ? "x" : "-");
      System.out.print((p1 & GROUP_READ) == GROUP_READ ? "r" : "-");
      System.out.print((p1 & GROUP_WRITE) == GROUP_WRITE ? "w" : "-");
      System.out.print((p1 & GROUP_EXE) == GROUP_EXE ? "x" : "-");
      System.out.print((p1 & OTHER_READ) == OTHER_READ ? "r" : "-");
      System.out.print((p1 & OTHER_WRITE) == OTHER_WRITE ? "w" : "-");
      System.out.print((p1 & OTHER_EXE) == OTHER_EXE ? "x" : "-");
      System.out.println();
  }
}