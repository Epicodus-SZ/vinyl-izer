import org.junit.*;
import static org.junit.Assert.*;

public class VinylTest {
  @Test
  public void Vinyl_instantiatesCorrectly_true() {
    Vinyl testVinyl = new Vinyl("Dark Side of the Moon");
    assertEquals(true, testVinyl instanceof Vinyl);
  }

  @Test
  public void getTitle_returnsTitle_DSOFM() {
    Vinyl testVinyl = new Vinyl("Dark Side of the Moon");
    assertEquals("Dark Side of the Moon", testVinyl.getTitle());
  }

  @Test
  public void reset_resetsTheVinylList_0() {
    Vinyl testVinyl = new Vinyl("Dark Side of the Moon");
    Vinyl.reset();
    assertEquals(0, Vinyl.getSize());
  }

  @Test
  public void getSize_ReturnsTheSizeOfTheVinylList_2() {
    Vinyl.reset();
    Vinyl testVinyl = new Vinyl("Ok Computer");
    Vinyl test2Vinyl = new Vinyl("Dark Side of the Moon");
    assertEquals(2, Vinyl.getSize());
  }

  @Test
  public void getId_returnsIdNum_1() {
    Vinyl.reset();
    Vinyl testVinyl = new Vinyl("Dark Side of the Moon");
    assertEquals(1, testVinyl.getId());
  }

  @Test
  public void find_ReturnsAVinylObject() {
    Vinyl.reset();
    Vinyl testVinyl = new Vinyl("Dark Side of the Moon");
    Vinyl gotVinyl = Vinyl.find(1);
    assertEquals(true, gotVinyl instanceof Vinyl);
  }

  @Test
  public void find_ReturnsTheCorrectVinylObject() {
    Vinyl.reset();
    Vinyl testVinyl = new Vinyl("Dark Side of the Moon");
    Vinyl v2Vinyl = new Vinyl("OK Computer");
    Vinyl gotVinyl = Vinyl.find(1);
    assertEquals("Dark Side of the Moon", gotVinyl.getTitle());
  }


}
