package com.example.parse;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.example.parse.Token.*;
import static org.hamcrest.CoreMatchers.is;

public class TokenStreamTest {

    @Test
    public void shouldSuccessNext() {
        List<String> inputs = List.of(
                "",
                "+",
                " - ",
                "*",
                "/",
                "1",
                "12",
                "1234",
                "12.345",
                "1+2",
                "12*3.14",
                "              61 + 2.1 * 0.3"
        );
        List<List<Token>> outputs = List.of(
                List.of(eof(0)), //"",
                List.of(plus(0),eof(1)), //"+",
                List.of(minus(1),eof(3)), //" - ",
                List.of(multiply(0),eof(1)), //"*",
                List.of(divide(0),eof(1)), //"/",
                List.of(number("1",1),eof(1)), //"1",
                List.of(number("12",2),eof(2)), //"12",
                List.of(number("1234",4),eof(4)), //"1234",
                List.of(number("12.345",6),eof(6)), //"12.345",
                List.of(number("1",1), plus(1), number("2",3),eof(3)), //"1+2",
                List.of(number("12",2), multiply(2), number("3.14",7),eof(7)), //"12*3.14"
                List.of(number("61",16),
                        plus(17),
                        number("2.1",22),
                        multiply(23),
                        number("0.3",28), eof(28)) //"              61 + 2.1 * 0.3"
        );
        TokenStream underTest;
        for(int i=0;i<inputs.size();i++){
            String input = inputs.get(i);
            List<Token> expected = outputs.get(i);
            underTest = new TokenStream(input);
            List<Token> actual = new ArrayList<>();
            System.out.println("input: '" + input + "', len=" + input.length());
            do {
                Token token = underTest.next();
                System.out.println("\t" + token);
                actual.add(token);
            } while(!actual.get(actual.size()-1).isEof());

            MatcherAssert.assertThat(actual, is(expected));
        }
    }
}