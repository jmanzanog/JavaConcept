import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LabTest {

    @Test()
    public void immutableObject() {
        String name = "baeldung";
        String newName = name.replace("dung", "----");
        assertEquals("baeldung", name);
        assertEquals("bael----", newName);
    }


}