package com.example.parse;

public class TokenStream {

    private String input;
    private int pos ;

    public TokenStream(String input){
        this.input = input;
        pos = 0;
    }

    public Token next() {
        whitespace();
        if (isEOF()) return Token.eof(pos);

        SymbolMatcher matcher = new SymbolMatcher();
        Symbol symbol = matcher.match(input.charAt(pos),pos);
        switch( symbol) {
            case NUMBER:
                return consumeNumber();
            case OP_PLUS:
                return consumePlus();
            case OP_MINUS:
                return consumeMinus();
            case OP_MULTIPLY:
                return consumeMultiply();
            case OP_DIVIDE:
                return consumeDivide();
            default:
                throw new ParseException(String.format(
                        "Unexpected token '%s' pos: %s",symbol,pos));
        }
    }

    private String consumeNumberPart() {
        StringBuilder buf = new StringBuilder();
        if(pos < input.length()) {
            do {
                buf.append(input.charAt(pos));
                pos++;
            } while (!isEOF() && Character.isDigit(input.charAt(pos)));
        }
        return buf.toString();
    }

    private Token consumeNumber() {
        StringBuilder buf = new StringBuilder(consumeNumberPart());
        if(pos < input.length() && input.charAt(pos) == '.'){
            buf.append(consumeNumberPart());
        }
        return Token.number(buf.toString(),pos);
    }

    private Token consumePlus() {
        return Token.plus(pos++);
    }

    private Token consumeMinus() {
        return Token.minus(pos++);
    }

    private Token consumeMultiply() {
        return Token.multiply(pos++);
    }

    private Token consumeDivide() {
        return Token.divide(pos++);
    }

    private boolean isEOF() {
        return pos > input.length() - 1;
    }

    private void whitespace() {
        while( pos < input.length() && Character.isWhitespace(input.charAt(pos)) )
            pos++;
    }
}
