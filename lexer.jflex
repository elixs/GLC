package cup.main;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;

%%

%class Lexer
%implements sym
%public
%unicode
%line
%column
%cup
%char
%{
	

    public Lexer(ComplexSymbolFactory sf, java.io.InputStream is){
		this(is);
        symbolFactory = sf;
    }
	public Lexer(ComplexSymbolFactory sf, java.io.Reader reader){
		this(reader);
        symbolFactory = sf;
    }
    
    private StringBuffer sb;
    private ComplexSymbolFactory symbolFactory;
    private int csline,cscolumn;

    public Symbol symbol(String name, int code){
		return symbolFactory.newSymbol(name, code,
						new Location(yyline+1,yycolumn+1, yychar), // -yylength()
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength())
				);
    }
    public Symbol symbol(String name, int code, String lexem){
	return symbolFactory.newSymbol(name, code, 
						new Location(yyline+1, yycolumn +1, yychar), 
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }
    
    protected void emit_warning(String message){
    	System.out.println("scanner warning: " + message + " at : 2 "+ 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
    
    protected void emit_error(String message){
    	System.out.println("scanner error: " + message + " at : 2" + 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
%}

Newline    = \r | \n | \r\n
Whitespace = [ \t\f] | {Newline}
Number     = [0-9]+
Color 	   = A | R | V | B | Ne
Direction  = S | N | E | O

%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%state CODESEG

%%  

<YYINITIAL> {

  {Whitespace}		{																				}
  "bajar-pluma"		{ return symbolFactory.newSymbol("SETPENDOWN", SETPENDOWN);						}
  "levantar-pluma"	{ return symbolFactory.newSymbol("SETPENUP", SETPENUP);							}
  "color-pluma"		{ return symbolFactory.newSymbol("SETPENCOLOR", SETPENCOLOR);					}
  "direccion-pluma"	{ return symbolFactory.newSymbol("SETPENDIR", SETPENDIR);						}
  "avanzar"			{ return symbolFactory.newSymbol("MOVE", MOVE);									}
  "if"				{ return symbolFactory.newSymbol("IF", IF);										}
  "then"			{ return symbolFactory.newSymbol("THEN", THEN);									}
  "else"			{ return symbolFactory.newSymbol("ELSE", ELSE);									}
  "while"			{ return symbolFactory.newSymbol("WHILE", WHILE);								}
  "do"				{ return symbolFactory.newSymbol("DO", DO);										}
  "and"				{ return symbolFactory.newSymbol("AND", AND);									}
  "or"				{ return symbolFactory.newSymbol("OR", OR);										}
  "not"				{ return symbolFactory.newSymbol("NOT", NOT);									}
  ";"				{ return symbolFactory.newSymbol("SEMI", SEMI);									}
  "tablero-col"		{ return symbolFactory.newSymbol("ISBOARDCOLOR", ISBOARDCOLOR);					}
  "borde"			{ return symbolFactory.newSymbol("EDGE", EDGE);									}
  "pluma-dir"		{ return symbolFactory.newSymbol("CHECKPENDIR", CHECKPENDIR);					}
  "pluma-col"		{ return symbolFactory.newSymbol("CHECKPENCOLOR", CHECKPENCOLOR);				}
  "pluma-arriba"	{ return symbolFactory.newSymbol("ISPENUP", ISPENUP);							}
  "pluma-abajo"		{ return symbolFactory.newSymbol("ISPENDOWN", ISPENDOWN);						}
  {Color}			{ return symbolFactory.newSymbol("COLOR", COLOR, yytext());						}
  {Direction}		{ return symbolFactory.newSymbol("DIRECTION", DIRECTION, yytext());				}
  {Number}			{ return symbolFactory.newSymbol("NUMBER", NUMBER, Integer.parseInt(yytext()));	}
  "{"				{ return symbolFactory.newSymbol("LKEY", LKEY);									}
  "}"				{ return symbolFactory.newSymbol("RKEY", RKEY);									}
}



// error fallback
.|\n          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }
