
package Covenant;


// Imports the Google Cloud client library

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.io.FileInputStream;

public class QuickstartSample {
    public static void main(String... args) throws Exception {
        // Instantiates a client
        Translate translate = TranslateOptions.newBuilder()
                .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream("/Users/Alan/Documents/covenant.json")))
                .build()
                .getService();
        // Or you can use API key " Translate translate = TranslateOptions.newBuilder().setApiKey("myKey").build().getService(); "
        // The text to translate
        String text = "Hello,World.";


        // Translates some text into zh
        Translation translation =
                translate.translate(
                        text, TranslateOption.sourceLanguage("en"), TranslateOption.targetLanguage("zh"));

        System.out.printf("Text: %s%n", text);
        System.out.printf("Translation: %s%n", translation.getTranslatedText());
    }
}
// [END translate_quickstart]