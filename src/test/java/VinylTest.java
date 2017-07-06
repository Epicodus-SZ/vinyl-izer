import org.junit.*;
import static org.junit.Assert.*;

public class VinylTest {
  @Test
  public void Vinyl_instantiatesCorrectly_true() {
    Vinyl testVinyl = new Vinyl("Kansas");
    assertEquals(true, testVinyl instanceof Vinyl);
  }
}
