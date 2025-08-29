package tcgen3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DateTest {
@Test
@DisplayName("next - 1_1")
void testNext_1_1() throws Exception {
	Date self = new Date(1, 12, 31);
	var actual = self.next();

	int y=2, m=1, d=1;
	assertEquals(y, actual.getYear());
	assertEquals(m, actual.getMonth());
	assertEquals(d, actual.getDay());

}

@Test
@DisplayName("next - 1_2")
void testNext_1_2() throws Exception {
	Date self = new Date(1, 12, 20);
	var actual = self.next();

	int y=1, m=12, d=21;
	assertEquals(y, actual.getYear());
	assertEquals(m, actual.getMonth());
	assertEquals(d, actual.getDay());

}

@Test
@DisplayName("Date - 1_1")
void testDate_1_1() {
	assertThrows(Date.DateErrorException.class, () -> { new Date(-1, -1, -1); });
}
}