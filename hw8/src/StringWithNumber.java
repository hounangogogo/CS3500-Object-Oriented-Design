/**
 * Method to represent the stringwithnumber
 *
 * @author Haonan Zhao
 * @version 3/14/2014
 */
public class StringWithNumber implements MyMapVisitor<Integer, String> {
  /**
   * @param integer given key
   * @param s       given value
   * @return a suitable new value
   */
  @Override
  public String visit(Integer integer, String s) {
    return s + " " + integer.toString();
  }

}