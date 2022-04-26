import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {
    private String name;
    private int age;
    private String city;
}
