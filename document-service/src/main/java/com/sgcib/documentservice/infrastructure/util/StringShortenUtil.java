package com.sgcib.documentservice.infrastructure.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringShortenUtil {

    public static final Charset charsetEBCDIC = Charset.forName("CP037");
    public static final Charset charsetUtf8 = StandardCharsets.UTF_8;

    public static String cleanContentForCharset(String content, Charset charset) {
        byte[] bytes = content.getBytes(charset);
        var result = new String(bytes, charset);
        return result.replaceAll("\\pC", "_");
    }

    public static String shortenContent(String fn, Charset charset) {
        // return oroginal file name if less than 81
        // return a file name in this format : PART_OF_ORIGIBAL_FILE_NAME-LAST_LETTER_BEFORE_DOT.EXTENSION, ex
        // BEFORE: this is a verry logggggggggggggggggng file name.pdf
        // AFTER : this is a verry loggggggggggggggggg-e.pdf
        String sfn = fn;
        String fileText = FilenameUtils.getExtension(sfn);
        sfn = cleanContentForCharset(FilenameUtils.getBaseName(sfn), charset);

        byte[] bytes = sfn.getBytes(charset);
        var reduce = false;
        if (bytes.length > 74) {
            bytes = Arrays.copyOfRange(bytes, 0, 73);
            reduce = true;
        }
        var encodedString = new String(bytes, charset) + (StringUtils.isNotEmpty(fileText) ? "." + fileText : StringUtils.EMPTY);

        int dot = FilenameUtils.indexOfExtension(encodedString);

        if (encodedString.length() <= 80 && !reduce) return encodedString;
        else if ((dot == -1)) return encodedString.substring(0, encodedString.length() - 1) + "-";
        else {
            var lastCharacterWithExtension = encodedString.substring(dot - 1);
            return encodedString.substring(0, encodedString.length() - lastCharacterWithExtension.length() - 1) + "-" + lastCharacterWithExtension;
        }


    }
}
