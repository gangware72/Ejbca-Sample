/*
 * ====================================================================
 * Copyright (c) 1995-1999 Purple Technology, Inc. All rights
 * reserved.
 *
 * PLAIN LANGUAGE LICENSE: Do whatever you like with this code, free
 * of charge, just give credit where credit is due. If you improve it,
 * please send your improvements to alex@purpletech.com. Check
 * http://www.purpletech.com/code/ for the latest version and news.
 *
 * LEGAL LANGUAGE LICENSE: Redistribution and use in source and binary
 * forms, with or without modification, are permitted provided that
 * the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution.
 *
 * 3. The names of the authors and the names "Purple Technology,"
 * "Purple Server" and "Purple Chat" must not be used to endorse or
 * promote products derived from this software without prior written
 * permission. For written permission, please contact
 * server@purpletech.com.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHORS AND PURPLE TECHNOLOGY ``AS
 * IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE
 * AUTHORS OR PURPLE TECHNOLOGY BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * ====================================================================
 *
 **/
package org.ejbca.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @version $Id$
 *
 */
public class HTMLTools {
//	 see http://hotwired.lycos.com/webmonkey/reference/special_characters/
    static Object[][] ENTITIES = {
       // {"#39", Integer.valueOf(39)},       // ' - apostrophe
        {"quot", Integer.valueOf(34)},      // " - double-quote
        {"amp", Integer.valueOf(38)},       // & - ampersand
        {"lt", Integer.valueOf(60)},        // < - less-than
        {"gt", Integer.valueOf(62)},        // > - greater-than
        {"nbsp", Integer.valueOf(160)},     // non-breaking space
        {"copy", Integer.valueOf(169)},     // ?? - copyright
        {"reg", Integer.valueOf(174)},      // ?? - registered trademark
        {"Agrave", Integer.valueOf(192)},   // ?? - uppercase A, grave accent
        {"Aacute", Integer.valueOf(193)},   // ?? - uppercase A, acute accent
        {"Acirc", Integer.valueOf(194)},    // ?? - uppercase A, circumflex accent
        {"Atilde", Integer.valueOf(195)},   // ?? - uppercase A, tilde
        {"Auml", Integer.valueOf(196)},     // ?? - uppercase A, umlaut
        {"Aring", Integer.valueOf(197)},    // ?? - uppercase A, ring
        {"AElig", Integer.valueOf(198)},    // ?? - uppercase AE
        {"Ccedil", Integer.valueOf(199)},   // ?? - uppercase C, cedilla
        {"Egrave", Integer.valueOf(200)},   // ?? - uppercase E, grave accent
        {"Eacute", Integer.valueOf(201)},   // ?? - uppercase E, acute accent
        {"Ecirc", Integer.valueOf(202)},    // ?? - uppercase E, circumflex accent
        {"Euml", Integer.valueOf(203)},     // ?? - uppercase E, umlaut
        {"Igrave", Integer.valueOf(204)},   // ?? - uppercase I, grave accent
        {"Iacute", Integer.valueOf(205)},   // ?? - uppercase I, acute accent
        {"Icirc", Integer.valueOf(206)},    // ?? - uppercase I, circumflex accent
        {"Iuml", Integer.valueOf(207)},     // ?? - uppercase I, umlaut
        {"ETH", Integer.valueOf(208)},      // ?? - uppercase Eth, Icelandic
        {"Ntilde", Integer.valueOf(209)},   // ?? - uppercase N, tilde
        {"Ograve", Integer.valueOf(210)},   // ?? - uppercase O, grave accent
        {"Oacute", Integer.valueOf(211)},   // ?? - uppercase O, acute accent
        {"Ocirc", Integer.valueOf(212)},    // ?? - uppercase O, circumflex accent
        {"Otilde", Integer.valueOf(213)},   // ?? - uppercase O, tilde
        {"Ouml", Integer.valueOf(214)},     // ?? - uppercase O, umlaut
        {"Oslash", Integer.valueOf(216)},   // ?? - uppercase O, slash
        {"Ugrave", Integer.valueOf(217)},   // ?? - uppercase U, grave accent
        {"Uacute", Integer.valueOf(218)},   // ?? - uppercase U, acute accent
        {"Ucirc", Integer.valueOf(219)},    // ?? - uppercase U, circumflex accent
        {"Uuml", Integer.valueOf(220)},     // ?? - uppercase U, umlaut
        {"Yacute", Integer.valueOf(221)},   // ?? - uppercase Y, acute accent
        {"THORN", Integer.valueOf(222)},    // ?? - uppercase THORN, Icelandic
        {"szlig", Integer.valueOf(223)},    // ?? - lowercase sharps, German
        {"agrave", Integer.valueOf(224)},   // ?? - lowercase a, grave accent
        {"aacute", Integer.valueOf(225)},   // ?? - lowercase a, acute accent
        {"acirc", Integer.valueOf(226)},    // ?? - lowercase a, circumflex accent
        {"atilde", Integer.valueOf(227)},   // ?? - lowercase a, tilde
        {"auml", Integer.valueOf(228)},     // ?? - lowercase a, umlaut
        {"aring", Integer.valueOf(229)},    // ?? - lowercase a, ring
        {"aelig", Integer.valueOf(230)},    // ?? - lowercase ae
        {"ccedil", Integer.valueOf(231)},   // ?? - lowercase c, cedilla
        {"egrave", Integer.valueOf(232)},   // ?? - lowercase e, grave accent
        {"eacute", Integer.valueOf(233)},   // ?? - lowercase e, acute accent
        {"ecirc", Integer.valueOf(234)},    // ?? - lowercase e, circumflex accent
        {"euml", Integer.valueOf(235)},     // ?? - lowercase e, umlaut
        {"igrave", Integer.valueOf(236)},   // ?? - lowercase i, grave accent
        {"iacute", Integer.valueOf(237)},   // ?? - lowercase i, acute accent
        {"icirc", Integer.valueOf(238)},    // ?? - lowercase i, circumflex accent
        {"iuml", Integer.valueOf(239)},     // ?? - lowercase i, umlaut
        {"igrave", Integer.valueOf(236)},   // ?? - lowercase i, grave accent
        {"iacute", Integer.valueOf(237)},   // ?? - lowercase i, acute accent
        {"icirc", Integer.valueOf(238)},    // ?? - lowercase i, circumflex accent
        {"iuml", Integer.valueOf(239)},     // ?? - lowercase i, umlaut
        {"eth", Integer.valueOf(240)},      // ?? - lowercase eth, Icelandic
        {"ntilde", Integer.valueOf(241)},   // ?? - lowercase n, tilde
        {"ograve", Integer.valueOf(242)},   // ?? - lowercase o, grave accent
        {"oacute", Integer.valueOf(243)},   // ?? - lowercase o, acute accent
        {"ocirc", Integer.valueOf(244)},    // ?? - lowercase o, circumflex accent
        {"otilde", Integer.valueOf(245)},   // ?? - lowercase o, tilde
        {"ouml", Integer.valueOf(246)},     // ?? - lowercase o, umlaut
        {"oslash", Integer.valueOf(248)},   // ?? - lowercase o, slash
        {"ugrave", Integer.valueOf(249)},   // ?? - lowercase u, grave accent
        {"uacute", Integer.valueOf(250)},   // ?? - lowercase u, acute accent
        {"ucirc", Integer.valueOf(251)},    // ?? - lowercase u, circumflex accent
        {"uuml", Integer.valueOf(252)},     // ?? - lowercase u, umlaut
        {"yacute", Integer.valueOf(253)},   // ?? - lowercase y, acute accent
        {"thorn", Integer.valueOf(254)},    // ?? - lowercase thorn, Icelandic
        {"yuml", Integer.valueOf(255)},     // ?? - lowercase y, umlaut
        {"euro", Integer.valueOf(8364)},    // Euro symbol
    };
    
    static Object[][] HTML_ENTITIES_REDUCED_LIST = {
            {"quot", Integer.valueOf(34)},      // " - double-quote
            {"amp", Integer.valueOf(38)},       // & - ampersand
            {"lt", Integer.valueOf(60)},        // < - less-than
            {"gt", Integer.valueOf(62)},        // > - greater-than
   };
    
    static Map<String,Integer> E2I = new HashMap<>();
    static Map<Integer,String> I2E = new HashMap<>();
    static Map<Integer,String> I2ERL = new HashMap<>();
    static {
        for (Object[] element : ENTITIES) {
            E2I.put((String)element[0] , (Integer)element[1]);
            I2E.put((Integer)element[1], (String)element[0]);
        }
        for (Object[] element : HTML_ENTITIES_REDUCED_LIST) {
            I2ERL.put((Integer)element[1], (String)element[0]);
        }
    }

    /**
     * Turns funky characters into HTML entity equivalents<p>
     * e.g. <tt>"bread" & "butter"</tt> => <tt>&amp;quot;bread&amp;quot; &amp;amp; &amp;quot;butter&amp;quot;</tt>.
     * Update: supports nearly all HTML entities, including funky accents. See the source code for more detail.
     * @see #htmlunescape(String)
     **/
    public static String htmlescape(String s1) {
    	if (s1 == null) {
    		return null;
    	}
    	final StringBuilder buf = new StringBuilder();
        int i;
        for (i=0; i<s1.length(); ++i) {
            char ch = s1.charAt(i);
            String entity = I2E.get( Integer.valueOf(ch) );
            if (entity == null) {
                if ((ch) > 128) {
                    buf.append("&#" + ((int)ch) + ";");
                }
                else {
                    buf.append(ch);
                }
            }
            else {
                buf.append("&" + entity + ";");
            }
        }
        return buf.toString();
    }

    public static String htmlEscapeWithLanguageConsideration(String str) {
        if (str == null) {
            return null;
        }
        final StringBuilder buf = new StringBuilder();
        str.chars().mapToObj(charInString -> (char) charInString)
        .forEach(charInString -> {
            String entity = I2ERL.get(Integer.valueOf(charInString));
            if (entity == null) {
                buf.append(charInString);
            } else {
                buf.append("&" + entity + ";");
            }
        });
        return buf.toString();
    }
    
    /**
     * Given a string containing entity escapes, returns a string
     * containing the actual Unicode characters corresponding to the
     * escapes.
     *
     * Note: nasty bug fixed by Helge Tesgaard (and, in parallel, by
     * Alex, but Helge deserves major props for emailing me the fix).
     * 15-Feb-2002 Another bug fixed by Sean Brown <sean@boohai.com>
     *
     * @see #htmlescape(String)
     **/
    public static String htmlunescape(String s1) {
    	if (s1 == null) {
    		return null;
    	}
    	final StringBuilder buf = new StringBuilder();
        int i;
        for (i=0; i<s1.length(); ++i) {
            char ch = s1.charAt(i);
            if (ch == '&') {
                int semi = s1.indexOf(';', i+1);
                if (semi == -1) {
                    buf.append(ch);
                    continue;
                }
                String entity = s1.substring(i+1, semi);
                Integer iso;
                if (entity.charAt(0) == '#') {
                    iso = Integer.valueOf(entity.substring(1));
                }
                else {
                    iso = E2I.get(entity);
                }
                if (iso == null) {
                    buf.append("&" + entity + ";");
                }
                else {
                    buf.append((char)(iso.intValue()));
                }
                i = semi;
            }
            else {
                buf.append(ch);
            }
        }
        return buf.toString();
    }
    
    public static String javascriptEscape(String str) {
    	String ret = str;
    	// In Javascript strings we need to escape the backslash and apostrophe/quote characters
    	ret = ret.replaceAll("\\\\", "\\\\\\\\").replaceAll("'", "\\\\'").replaceAll("\"", "\\\\\"").replaceAll("<", "\\\\x3c").replaceAll(">", "\\\\x3e");
    	return ret;
    }
}
