import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class TruffulaOptionsTest {

  @Test
  void testValidDirectoryIsSet(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", "-h", directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertTrue(options.isShowHidden());
    assertFalse(options.isUseColor());
  }

  @Test
  void testValidDirectoryNoArgs(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder"); // tempdir/subfolder
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    System.out.println(directoryPath);
    String[] args = {directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertFalse(options.isShowHidden());
    assertTrue(options.isUseColor());
  }

  @Test
  void testMissingPath(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    String[] args = {"-nc", "-h"};

    // Assert: Check that the root directory is set correctly
    assertThrows(IllegalArgumentException.class, () -> {
      TruffulaOptions options = new TruffulaOptions(args);
    });
  }

  @Test
  void testNotDirectory(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File file = new File(tempDir, "subfolder.txt");
    try{
      file.createNewFile();
    }
    catch(IOException e){
    }

    String directoryPath = file.getAbsolutePath();
    System.out.println(directoryPath);
    System.out.println("is file: " + file.isFile());
    System.out.println("is dir: " + file.isDirectory());
    String[] args = {directoryPath};

    // Assert: Check that the root directory is set correctly
    assertThrows(FileNotFoundException.class, () -> {
      TruffulaOptions options = new TruffulaOptions(args);
    });
  }

    @Test
  void testWrongArgs(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    System.out.println(directoryPath);
    String[] args = {"-e", directoryPath};

    // Assert: Check that the root directory is set correctly
    assertThrows(IllegalArgumentException.class, () -> {
      TruffulaOptions options = new TruffulaOptions(args);
    });
  }
}
