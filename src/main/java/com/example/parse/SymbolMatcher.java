package com.example.parse;

public class SymbolMatcher {
    public Symbol match(char c, int pos) {
        if(c == '+') {
            return Symbol.OP_PLUS;
        } else if(c == '-') {
            return Symbol.OP_MINUS;
        } else if(c == '*') {
            return Symbol.OP_MULTIPLY;
        } else if(c == '/') {
            return Symbol.OP_DIVIDE;
        } else if(Character.isDigit(c)) {
            return Symbol.NUMBER;
        } else {
            throw new ParseException(String.format("Unrecognised start char '%s', pos: '%s",c, pos));
        }
    }
}
