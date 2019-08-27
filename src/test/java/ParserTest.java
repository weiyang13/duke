import duke.DukeException;
import duke.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ParserTest {
    @Test
    public void parse_unrecognisedCommand_exceptionThrown() {
        try {
            Parser.parse("UwU");
            fail();
        } catch (DukeException e) {
            assertEquals("Unrecognised command.", e.getMessage());
        }
    }
}
