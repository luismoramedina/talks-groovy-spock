import groovy.transform.ToString

/**
 * @author luis mora
 */
@ToString
public class Film {
    Integer id
    String name
    String plot
    String director
    List<String> stars
    Integer rating
}