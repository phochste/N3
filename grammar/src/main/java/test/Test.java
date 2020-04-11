package test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.n3ParserErrorListener;
import parser.n3LogLexerErrorListener;
import parser.n3LogParserErrorListener;
import parser.n3PrefixException;
import parser.antlr.n3Lexer;
import parser.antlr.n3Parser;
import parser.event.n3EventHandler;
import wvw.utils.log.Log;

public class Test {

	public static void main(String[] args) throws IOException {
		File file = new File("../../eye-tests/test0.n3");
		Log.d(file.getAbsolutePath());

		n3Lexer lexer = new n3Lexer(CharStreams.fromPath(file.toPath(), Charset.forName("UTF-8")));
		lexer.removeErrorListeners();
		lexer.addErrorListener(new n3LogLexerErrorListener(file.getName()));

		n3Parser parser = new n3Parser(new CommonTokenStream(lexer));
		parser.removeErrorListeners();
		parser.addErrorListener(new n3LogParserErrorListener(file.getName()));

		parser.removeParseListeners();
		parser.addParseListener(new n3EventHandler("", new n3ParserErrorListener("") {

			public void prefixError(String offendingPrefix, String pname, n3PrefixException e) {
				onError();
				Log.e(offendingPrefix + " - " + pname + " - " + e.getMessage());
			}
		}));

		parser.n3Doc();
	}
}