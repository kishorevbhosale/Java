package CoreJava.Objects_Immutability_Switch;

import lombok.Data;

import java.util.Objects;

@Data
public class NullCheck_Customized_Exception {
    private final String name;
    private final String color;

    public NullCheck_Customized_Exception(String name, String color) {
        this.name = Objects.requireNonNull(name, "Name can not be null");
        this.color = Objects.requireNonNull(color, "Color can not be null");
    }

    public static void main(String[] args) {
        NullCheck_Customized_Exception nullChecker = new NullCheck_Customized_Exception("abc", null);

    }
}

/*

Output :

Exception in thread "main" java.lang.NullPointerException: Color can not be null
	at java.util.Objects.requireNonNull(Objects.java:228)
	at CoreJava.Objects_Immutability_Switch.NullCheck_Customized_Exception.<init>(NullCheck_Customized_Exception.java:16)
	at CoreJava.Objects_Immutability_Switch.NullCheck_Customized_Exception.main(NullCheck_Customized_Exception.java:20)

 */