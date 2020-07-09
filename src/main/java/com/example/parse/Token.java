package com.example.parse;

import java.util.Objects;

public class Token {
    private Symbol symbol;
    private String value;
    private int pos;

    public Token(Symbol symbol, String value, int pos) {
        this.symbol = symbol;
        this.value = value;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "Token{" +
                "symbol=" + symbol +
                ", value='" + value + '\'' +
                ", pos=" + pos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Token)) return false;
        Token token = (Token) o;
        return pos == token.pos &&
                symbol == token.symbol &&
                Objects.equals(value, token.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, value, pos);
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public boolean isEof() {
        return Symbol.EOF.equals(symbol);
    }

    public boolean isNumber() {
        return Symbol.NUMBER.equals(symbol) ;
    }

    public boolean isTermOp() {
        return Symbol.OP_PLUS.equals(symbol) || Symbol.OP_MINUS.equals(symbol);
    }

    public boolean isFactorOp() {
        return Symbol.OP_MULTIPLY.equals(symbol) || Symbol.OP_DIVIDE.equals(symbol);
    }

    public String getValue() {
        return value;
    }

    public int getPos() {
        return pos;
    }

    public static Token eof(int pos) {
        return new Token(Symbol.EOF, "", pos);
    }

    public static Token number(String value, int pos) {
        return new Token(Symbol.NUMBER, value, pos);
    }

    public static Token plus(int pos) {
        return new Token(Symbol.OP_PLUS, Symbol.OP_PLUS.getSymbolValue(), pos);
    }

    public static Token minus(int pos) {
        return new Token(Symbol.OP_MINUS, Symbol.OP_MINUS.getSymbolValue(), pos);
    }

    public static Token multiply(int pos) {
        return new Token(Symbol.OP_MULTIPLY, Symbol.OP_MULTIPLY.getSymbolValue(), pos);
    }

    public static Token divide(int pos) {
        return new Token(Symbol.OP_DIVIDE, Symbol.OP_DIVIDE.getSymbolValue(), pos);
    }
}
