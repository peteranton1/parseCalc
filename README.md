# parseCalc

Project demonstrating parsing using the recursive descent algorithm for a simple calculator language.

The language supports the following eBnf

  term      ::= factor ( termOp factor )*
  termOp    ::= '+' | '-'
  factor    ::= NUMBER ( factorOp NUMBER )*
  factorOp  ::= '*' | '/'
  
examples of the language :-

  5.2
  7+3
  2*3+4*6
