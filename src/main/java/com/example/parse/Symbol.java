package com.example.parse;

public enum Symbol {
    EOF(""),
    NUMBER(""),
    OP_PLUS("+"),
    OP_MINUS("-"),
    OP_MULTIPLY("*"),
    OP_DIVIDE("/");

    private final String symbolValue;
    Symbol(String symbolValue){
        this.symbolValue = symbolValue;
    }
    public String getSymbolValue(){
        return symbolValue;
    }
}
