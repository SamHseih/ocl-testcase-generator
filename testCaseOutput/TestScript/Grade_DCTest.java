package TestScript;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Grade_DCTest {
@Test
@DisplayName("tcgen_Grade_Grade_DC_1")
void testGrade_1() throws Exception {
	Grade self = new Grade(67);
	assertEquals(, );
}

@Test
@DisplayName("tcgen_Grade_Grade_DC_2")
void testGrade_2() throws Exception {
	Grade self = new Grade(-16095);
	assertEquals(illegalargumentexception, );
}

@Test
@DisplayName("tcgen_Grade_Grade_DC_1")
void testGrade_1() throws Exception {
	Grade self = new Grade(67);
	assertEquals(, );
}

@Test
@DisplayName("tcgen_Grade_Grade_DC_2")
void testGrade_2() throws Exception {
	Grade self = new Grade(-16095);
	assertEquals(illegalargumentexception, );
}

@Test
@DisplayName("tcgen_Grade_rating_DC_1")
void testrating_1() throws Exception {
	Grade self = new Grade(59);
	Grade actual = self.Rating();
	assertEquals(F,Grade actual = self.Rating(); );
}

@Test
@DisplayName("tcgen_Grade_rating_DC_2")
void testrating_2() throws Exception {
	Grade self = new Grade(65);
	Grade actual = self.Rating();
	assertEquals(D,Grade actual = self.Rating(); );
}

@Test
@DisplayName("tcgen_Grade_rating_DC_3")
void testrating_3() throws Exception {
	Grade self = new Grade(70);
	Grade actual = self.Rating();
	assertEquals(C,Grade actual = self.Rating(); );
}

@Test
@DisplayName("tcgen_Grade_rating_DC_4")
void testrating_4() throws Exception {
	Grade self = new Grade(87);
	Grade actual = self.Rating();
	assertEquals(B,Grade actual = self.Rating(); );
}

@Test
@DisplayName("tcgen_Grade_rating_DC_5")
void testrating_5() throws Exception {
	Grade self = new Grade(100);
	Grade actual = self.Rating();
	assertEquals(A,Grade actual = self.Rating(); );
}

@Test
@DisplayName("tcgen_Grade_Grade_DC_1")
void testGrade_1() throws Exception {
	Grade self = new Grade(67);
	assertEquals(, );
}

@Test
@DisplayName("tcgen_Grade_Grade_DC_2")
void testGrade_2() throws Exception {
	Grade self = new Grade(-16095);
	assertEquals(illegalargumentexception, );
}

@Test
@DisplayName("tcgen_Grade_rating_DC_1")
void testrating_1() throws Exception {
	Grade self = new Grade(59);
	Grade actual = self.Rating();
	assertEquals(F,Grade actual = self.Rating(); );
}

@Test
@DisplayName("tcgen_Grade_rating_DC_2")
void testrating_2() throws Exception {
	Grade self = new Grade(65);
	Grade actual = self.Rating();
	assertEquals(D,Grade actual = self.Rating(); );
}

@Test
@DisplayName("tcgen_Grade_rating_DC_3")
void testrating_3() throws Exception {
	Grade self = new Grade(70);
	Grade actual = self.Rating();
	assertEquals(C,Grade actual = self.Rating(); );
}

@Test
@DisplayName("tcgen_Grade_rating_DC_4")
void testrating_4() throws Exception {
	Grade self = new Grade(87);
	Grade actual = self.Rating();
	assertEquals(B,Grade actual = self.Rating(); );
}

@Test
@DisplayName("tcgen_Grade_rating_DC_5")
void testrating_5() throws Exception {
	Grade self = new Grade(100);
	Grade actual = self.Rating();
	assertEquals(A,Grade actual = self.Rating(); );
}

@Test
@DisplayName("tcgen_Grade_getNumber_DC_1")
void testgetNumber_1() throws Exception {
	Grade self = new Grade(83);
	Grade actual = self.GetNumber();
	assertEquals(83,Grade actual = self.GetNumber(); );
}
}