package com.example.parse;

import java.util.ArrayList;
import java.util.List;

/**
 * Parse Stream according to following syntax using
 * recursive descent method.
 *
 * ```
 *   term      ::= factor ( termOp factor )*
 *
 *   termOp    ::= OP_PLUS | OP_MINUS
 *
 *   factor    ::= NUMBER ( factorOp NUMBER )*
 *
 *   factorOp  ::= OP_MULTIPLY | OP_DIVIDE
 * ```
 */
public class TermParser {
    private TokenStream tokenStream ;
    private List<Token> consumed = new ArrayList<>();

    public TermParser(TokenStream tokenStream) {
        this.tokenStream = tokenStream;
    }

    public List<Token> parse() {
        return term(new ArrayList<Token>());
    }

    private Token eat() {
        Token next = tokenStream.next();
        consumed.add(next);
        return next;
    }

}
