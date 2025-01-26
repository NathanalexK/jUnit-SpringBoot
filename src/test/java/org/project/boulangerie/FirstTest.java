package org.project.boulangerie;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.project.boulangerie.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FirstTest {
    @InjectMocks
    private TestService testService;

    @Test
    public void testSum() {
        Double d1 = 4.2;
        Double d2 = 1.9;

        Double result = testService.sum(d1, d2);

        Assertions.assertEquals(6.1, result, "Add method should return the result of two numbers");
    }

    @Test
    public void testSum2() {
        Double d1 = 4.2;
        Double d2 = 1.9;

        Double result = testService.sum(d1, d2);

        Assertions.assertEquals(6.2, result, "Add method should return the result of two numbers");
    }


}
