package io.github.ricardofagodoy.codingproblems.hello;

import org.junit.Assert;
import org.junit.Test;

public class HelloTest {

    @Test
    public void givenNameWhenSayHiThenCompleteSentenceMustBeReturned() {

        Hello hello = new Hello();

        Assert.assertEquals("Hello, Ricardo", hello.sayHello("Ricardo"));
    }
}