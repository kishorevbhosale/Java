import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CreatingSpliterator {
    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/People.txt");

        try (Stream<String> lines = Files.lines(path)) {
            Spliterator<String> lineSpliterator = lines.spliterator();
            Spliterator<Person> personSpliterator = new PersonSpliterator(lineSpliterator);

            Stream<Person> personStream = StreamSupport.stream(personSpliterator, false);
            personStream.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Exception came");
        }
    }
}
