        import static org.junit.jupiter.api.Assertions.*;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;
        import java.util.Arrays;
        

    public class DateTest {

        @Test
        @DisplayName("next - 1_1")
        void testNext_1_1() {
        Date self = new Date(1, 12, 31);
    var actual = self.next();
        int y=2, m=1, d=1;
    assertEquals(y, actual.getYear());
    assertEquals(m, actual.getMonth());
    assertEquals(d, actual.getDay());

        }
        \n@Test
        @DisplayName("Date - 1_1")
        void testDate_1_1() {
          assertThrows(new Date(-1, -1, -1).class, () -> { Date.DateErrorException; });
        }
        
    }
    