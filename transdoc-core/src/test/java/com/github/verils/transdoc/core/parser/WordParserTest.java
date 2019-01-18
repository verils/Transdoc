package com.github.verils.transdoc.core.parser;

import com.github.verils.transdoc.core.model.WordDocument;
import com.github.verils.transdoc.core.parser.doc.DocWordDocument;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertTrue;

public class WordParserTest {

    @Test
    public void testParseDoc() {
        InputStream input = WordParserTest.class.getResourceAsStream("/test.doc");
        WordDocument document = WordParser.parse(input);
        assertTrue(document instanceof DocWordDocument);
    }

//    @Test
//    public void testParseDocx() throws IOException {
//        InputStream input = WordParserTest.class.getResourceAsStream("/test.docx");
//        WordParser parser = WordParser.parse(input);
//        assertTrue(parser instanceof DocxParser);
//    }

    @Test(expected = RuntimeException.class)
    public void testParseIllegalDoc() {
        InputStream input = WordParserTest.class.getResourceAsStream("/test");
        WordParser.parse(input);
    }
}
