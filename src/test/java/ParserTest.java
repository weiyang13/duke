import duke.DukeException;
import duke.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Encapsulates the tests for the Parser class.
 */
public class ParserTest {
    /**
     * Executes a test for the parse method for when the command is unrecognised.
     * Asserts if the correct exception is thrown.
     */
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
