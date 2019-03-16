import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintpWriter;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileexist {
   public static void main(String[] args) throws IOException {
      File f = new File(System.getProperty("user.dir")+"/folder/file.txt");
      System.out.println(f.exists());
      
      if(!f.getParentFile().exists()){
         f.getParentFile().mkdirs();
      } 
      if(!f.exists()){
         try {
            f.createNewFile();
         } catch (Exception e) {
            e.printStackTrace();
         } 
      } 
      try {
         File dir = new File(f.getParentFile(), f.getName());
         PrintpWriter pWriter = new PrintpWriter(dir);
         pWriter.print("writing anything...");
         pWriter.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } 
   }
}
