/*
 Copyright 2009 David Hall, Daniel Ramage

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/
package chalk.text

/**
 * Utilities for processing and escaping HTML entities.
 *
 * @author dramage
 */
object HTML {

  val regex = "&#?\\w+;".r;

  /** Unescapes all HTML entities in the given input. */
  def unescapeEntitiesIn(input : String) = {
    regex.replaceAllIn(input, m => {
      val txt = m.group(0);
      try {
        val codepoint = {
          if (txt(1) == '#') {
            if (txt(2) == 'x') {
              Integer.parseInt(txt.substring(3, txt.length-1), 16);
            } else {
              Integer.parseInt(txt.substring(2, txt.length-1));
            }
          } else {
            entities(txt.substring(1, txt.length-1));
          }
        }
        if (codepoint == '$') {
          new String("\\$");
        } else {
          new String(Character.toChars(codepoint));
        }
      } catch {
        case _:Exception =>
          // exception while processing .. append raw input
          txt;
      }
    });
  }

  /** List of HTML entities with their corresponding code points borrowed from pythons htmlentities package. */
  lazy val entities = Map(
    "aring" -> 229,
    "gt" -> 62,
    "sup" -> 8835,
    "Ntilde" -> 209,
    "upsih" -> 978,
    "Yacute" -> 221,
    "Atilde" -> 195,
    "radic" -> 8730,
    "otimes" -> 8855,
    "aelig" -> 230,
    "Psi" -> 936,
    "Uuml" -> 220,
    "Epsilon" -> 917,
    "Icirc" -> 206,
    "Eacute" -> 201,
    "Lambda" -> 923,
    "Prime" -> 8243,
    "Kappa" -> 922,
    "sigmaf" -> 962,
    "lrm" -> 8206,
    "cedil" -> 184,
    "ensp" -> 8194,
    "AElig" -> 198,
    "prime" -> 8242,
    "Tau" -> 932,
    "lceil" -> 8968,
    "dArr" -> 8659,
    "ge" -> 8805,
    "sdot" -> 8901,
    "lfloor" -> 8970,
    "lArr" -> 8656,
    "Auml" -> 196,
    "brvbar" -> 166,
    "Otilde" -> 213,
    "Theta" -> 920,
    "Pi" -> 928,
    "OElig" -> 338,
    "Scaron" -> 352,
    "egrave" -> 232,
    "sub" -> 8834,
    "iexcl" -> 161,
    "ordf" -> 170,
    "sum" -> 8721,
    "ntilde" -> 241,
    "atilde" -> 227,
    "theta" -> 952,
    "nsub" -> 8836,
    "hArr" -> 8660,
    "Oslash" -> 216,
    "THORN" -> 222,
    "yuml" -> 255,
    "Mu" -> 924,
    "thinsp" -> 8201,
    "ecirc" -> 234,
    "bdquo" -> 8222,
    "Aring" -> 197,
    "nabla" -> 8711,
    "permil" -> 8240,
    "Ugrave" -> 217,
    "eta" -> 951,
    "Agrave" -> 192,
    "forall" -> 8704,
    "eth" -> 240,
    "rceil" -> 8969,
    "iuml" -> 239,
    "Egrave" -> 200,
    "divide" -> 247,
    "igrave" -> 236,
    "otilde" -> 245,
    "pound" -> 163,
    "frasl" -> 8260,
    "ETH" -> 208,
    "lowast" -> 8727,
    "chi" -> 967,
    "Aacute" -> 193,
    "cent" -> 162,
    "Beta" -> 914,
    "perp" -> 8869,
    "there4" -> 8756,
    "pi" -> 960,
    "empty" -> 8709,
    "euml" -> 235,
    "notin" -> 8713,
    "uuml" -> 252,
    "icirc" -> 238,
    "bull" -> 8226,
    "upsilon" -> 965,
    "Oacute" -> 211,
    "kappa" -> 954,
    "ccedil" -> 231,
    "cap" -> 8745,
    "mu" -> 956,
    "deg" -> 176,
    "tau" -> 964,
    "emsp" -> 8195,
    "hellip" -> 8230,
    "ucirc" -> 251,
    "ugrave" -> 249,
    "cong" -> 8773,
    "Iota" -> 921,
    "quot" -> 34,
    "rarr" -> 8594,
    "Rho" -> 929,
    "uacute" -> 250,
    "acirc" -> 226,
    "sim" -> 8764,
    "phi" -> 966,
    "diams" -> 9830,
    "Euml" -> 203,
    "Ccedil" -> 199,
    "Eta" -> 919,
    "Gamma" -> 915,
    "euro" -> 8364,
    "thetasym" -> 977,
    "sect" -> 167,
    "ldquo" -> 8220,
    "hearts" -> 9829,
    "oacute" -> 243,
    "zwnj" -> 8204,
    "yen" -> 165,
    "ograve" -> 242,
    "Chi" -> 935,
    "trade" -> 8482,
    "xi" -> 958,
    "nbsp" -> 160,
    "tilde" -> 732,
    "lsaquo" -> 8249,
    "oelig" -> 339,
    "equiv" -> 8801,
    "le" -> 8804,
    "auml" -> 228,
    "cup" -> 8746,
    "Yuml" -> 376,
    "lt" -> 60,
    "Upsilon" -> 933,
    "ndash" -> 8211,
    "yacute" -> 253,
    "real" -> 8476,
    "psi" -> 968,
    "rsaquo" -> 8250,
    "darr" -> 8595,
    "Alpha" -> 913,
    "not" -> 172,
    "amp" -> 38,
    "oslash" -> 248,
    "acute" -> 180,
    "zwj" -> 8205,
    "laquo" -> 171,
    "rdquo" -> 8221,
    "Igrave" -> 204,
    "micro" -> 181,
    "shy" -> 173,
    "supe" -> 8839,
    "szlig" -> 223,
    "clubs" -> 9827,
    "agrave" -> 224,
    "Ocirc" -> 212,
    "harr" -> 8596,
    "larr" -> 8592,
    "frac12" -> 189,
    "prop" -> 8733,
    "circ" -> 710,
    "ocirc" -> 244,
    "asymp" -> 8776,
    "uml" -> 168,
    "prod" -> 8719,
    "reg" -> 174,
    "rlm" -> 8207,
    "infin" -> 8734,
    "Sigma" -> 931,
    "mdash" -> 8212,
    "uarr" -> 8593,
    "times" -> 215,
    "rArr" -> 8658,
    "or" -> 8744,
    "gamma" -> 947,
    "lambda" -> 955,
    "rang" -> 9002,
    "sup3" -> 179,
    "dagger" -> 8224,
    "Ouml" -> 214,
    "image" -> 8465,
    "alefsym" -> 8501,
    "sube" -> 8838,
    "alpha" -> 945,
    "Nu" -> 925,
    "plusmn" -> 177,
    "sup1" -> 185,
    "sup2" -> 178,
    "frac34" -> 190,
    "oline" -> 8254,
    "Delta" -> 916,
    "loz" -> 9674,
    "iota" -> 953,
    "iacute" -> 237,
    "para" -> 182,
    "ordm" -> 186,
    "epsilon" -> 949,
    "weierp" -> 8472,
    "part" -> 8706,
    "delta" -> 948,
    "omicron" -> 959,
    "copy" -> 169,
    "Iuml" -> 207,
    "Xi" -> 926,
    "Dagger" -> 8225,
    "Ograve" -> 210,
    "Ucirc" -> 219,
    "scaron" -> 353,
    "lsquo" -> 8216,
    "isin" -> 8712,
    "Zeta" -> 918,
    "minus" -> 8722,
    "and" -> 8743,
    "ang" -> 8736,
    "curren" -> 164,
    "int" -> 8747,
    "rfloor" -> 8971,
    "crarr" -> 8629,
    "exist" -> 8707,
    "oplus" -> 8853,
    "Acirc" -> 194,
    "piv" -> 982,
    "ni" -> 8715,
    "Phi" -> 934,
    "Iacute" -> 205,
    "Uacute" -> 218,
    "Omicron" -> 927,
    "ne" -> 8800,
    "iquest" -> 191,
    "sbquo" -> 8218,
    "Ecirc" -> 202,
    "zeta" -> 950,
    "Omega" -> 937,
    "nu" -> 957,
    "macr" -> 175,
    "frac14" -> 188,
    "aacute" -> 225,
    "uArr" -> 8657,
    "beta" -> 946,
    "fnof" -> 402,
    "rho" -> 961,
    "eacute" -> 233,
    "omega" -> 969,
    "middot" -> 183,
    "lang" -> 9001,
    "spades" -> 9824,
    "rsquo" -> 8217,
    "thorn" -> 254,
    "ouml" -> 246,
    "raquo" -> 187,
    "sigma" -> 963
  );
}
