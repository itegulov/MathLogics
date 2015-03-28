package formalarithmetic.deductor;

import exceptions.InvalidProofException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;

public class HashDeductorTest {
    private File file;
    private Deductor deductor;

    @Before
    public void setUp() throws Exception {
        file = new File("test.in");
        deductor = new HashDeductor();
    }

    @After
    public void tearDown() throws Exception {

    }
    
    @Rule public ExpectedException exception = ExpectedException.none();

    @Test
    public void testDeductIncorrect1() throws InvalidProofException, FileNotFoundException, ParseException {
        exception.expect(InvalidProofException.class);
        exception.expectMessage("Вывод некорректен, начиная с формулы номер 5: " +
                "используется правило с квантором по переменной a, входящей свободно в допущение P(a)");
        System.out.println(deductor.deduct(new File("res/tests/formal_arithmetic_deductor/incorrect/incorrect1.in"), null));
    }

    @Test
    public void testDeductIncorrect2() throws InvalidProofException, FileNotFoundException, ParseException {
        exception.expect(InvalidProofException.class);
        exception.expectMessage("Вывод некорректен начиная с формулы номер 1");
        System.out.println(deductor.deduct(new File("res/tests/formal_arithmetic_deductor/incorrect/incorrect2.in"), null));
    }

    @Test
    public void testDeductIncorrect3() throws InvalidProofException, FileNotFoundException, ParseException {
        exception.expect(InvalidProofException.class);
        exception.expectMessage("Вывод некорректен, начиная с формулы номер 2: " +
                "переменная y входит свободно в формулу @t(P(f(y)))");
        System.out.println(deductor.deduct(new File("res/tests/formal_arithmetic_deductor/incorrect/incorrect3.in"), null));
    }

    @Test
    public void testDeductIncorrect4() throws InvalidProofException, FileNotFoundException, ParseException {
        exception.expect(InvalidProofException.class);
        exception.expectMessage("Вывод некорректен, начиная с формулы номер 2: " +
                "используется правило с квантором по переменной x, входящей свободно в допущение @x(P(x))&Q(x)");
        System.out.println(deductor.deduct(new File("res/tests/formal_arithmetic_deductor/incorrect/incorrect4.in"), null));
    }

    @Test
    public void testDeductIncorrect5() throws InvalidProofException, FileNotFoundException, ParseException {
        exception.expect(InvalidProofException.class);
        exception.expectMessage("Вывод некорректен, начиная с формулы номер 6: " +
                "переменная x входит свободно в формулу Q(x)&@x(P(x))");
        System.out.println(deductor.deduct(new File("res/tests/formal_arithmetic_deductor/incorrect/incorrect5.in"), null));
    }

    @Test
    public void testDeductIncorrect6() throws InvalidProofException, FileNotFoundException, ParseException {
        exception.expect(InvalidProofException.class);
        exception.expectMessage("Вывод некорректен, начиная с формулы номер 6: " +
                "переменная x входит свободно в формулу @x(P(x))&Q(x)");
        System.out.println(deductor.deduct(new File("res/tests/formal_arithmetic_deductor/incorrect/incorrect6.in"), null));
    }

    @Test
    public void testDeductIncorrect7() throws InvalidProofException, FileNotFoundException, ParseException {
        exception.expect(InvalidProofException.class);
        exception.expectMessage("Вывод некорректен, начиная с формулы номер 1: " +
                "терм ((y+(y*y))+(g((f(x)+(y*y)))*y)) не свободен для подстановки в формулу @x(P(x,y)) вместо переменной y");
        System.out.println(deductor.deduct(new File("res/tests/formal_arithmetic_deductor/incorrect/incorrect7.in"), null));
    }

    @Test
    public void testDeductIncorrect8() throws InvalidProofException, FileNotFoundException, ParseException {
        exception.expect(InvalidProofException.class);
        exception.expectMessage("Вывод некорректен начиная с формулы номер 2");
        System.out.println(deductor.deduct(new File("res/tests/formal_arithmetic_deductor/incorrect/incorrect8.in"), null));
    }

    @Test
    public void testDeductIncorrect9() throws InvalidProofException, FileNotFoundException, ParseException {
        exception.expect(InvalidProofException.class);
        exception.expectMessage("Вывод некорректен, начиная с формулы номер 4: " +
                "используется правило с квантором по переменной x, входящей свободно в допущение Q(x)");
        System.out.println(deductor.deduct(new File("res/tests/formal_arithmetic_deductor/incorrect/incorrect9.in"), null));
    }

    @Test
    public void testDeductIncorrect10() throws InvalidProofException, FileNotFoundException, ParseException {
        exception.expect(InvalidProofException.class);
        exception.expectMessage("Вывод некорректен, начиная с формулы номер 93: " +
                "переменная x входит свободно в формулу Q(x)&((0=0)->((0=0)->(0=0)))");
        System.out.println(deductor.deduct(new File("res/tests/formal_arithmetic_deductor/incorrect/incorrect10.in"), null));
    }

    @Test
    public void testDeductIncorrect11() throws InvalidProofException, FileNotFoundException, ParseException {
        exception.expect(InvalidProofException.class);
        exception.expectMessage("Вывод некорректен начиная с формулы 11750");
        System.out.println(deductor.deduct(new File("res/tests/formal_arithmetic_deductor/incorrect/incorrect11.in"), null));
    }
    
    @Test 
    public void testDeductGood() throws Exception {
        deductor.deduct(new File("res/tests/formal_arithmetic_deductor/correct/correct1.in"), null);
        deductor.deduct(new File("res/tests/formal_arithmetic_deductor/correct/correct2.in"), null);
        for (int i = 5; i <= 10; i++) {
            deductor.deduct(new File("res/tests/formal_arithmetic_deductor/correct/correct" + i + ".in"), null);
        }
        for (int i = 12; i <= 14; i++) {
            deductor.deduct(new File("res/tests/formal_arithmetic_deductor/correct/correct" + i + ".in"), null);
        }
    }

    @Test
    public void testDeductHard() throws Exception {
        //deductor.deduct(new File("res/tests/formal_arithmetic_deductor/correct/correct11.in"), null);
    }
}