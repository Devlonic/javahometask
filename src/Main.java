import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class TextFinder {
    private final List<String> databaseOfTexts = new ArrayList<>();
    private final String text;

    TextFinder(String text) {
        this.text = text;
        databaseOfTexts.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vitae sapien pellentesque habitant morbi tristique senectus et. Orci dapibus ultrices in iaculis nunc. Integer malesuada nunc vel risus. Viverra maecenas accumsan lacus vel facilisis volutpat est. Sit amet porttitor eget dolor morbi non arcu. Sodales ut eu sem integer vitae. Ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget. Vel eros donec ac odio tempor orci dapibus ultrices. Morbi tincidunt ornare massa eget egestas. Consectetur a erat nam at lectus urna duis convallis. Enim sit amet venenatis urna cursus eget nunc scelerisque viverra. Ultricies tristique nulla aliquet enim tortor at auctor urna nunc.");
        databaseOfTexts.add("Lorem ipsum dolor sit amet");
    }

    public int findWordPosition(String word) {
        return text.indexOf(word);
    }
    public int getPercentageOfUnique() {
        AtomicInteger countMatches = new AtomicInteger();
        databaseOfTexts.forEach(t-> {
            var v = t.split(text);
            countMatches.addAndGet(v.length);
        });
        return countMatches.get();
    }
    public List<String> getDublicateWOrds() {
        var words = text.split("\\s+");
        var duplicateWords = new ArrayList<String>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equalsIgnoreCase(words[j]) && !duplicateWords.contains(words[i])) {
                    duplicateWords.add(words[i]);
                }
            }
        }

        return duplicateWords;
    }
}

public class Main {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vitae sapien pellentesque habitant morbi tristique senectus et. Orci dapibus ultrices in iaculis nunc. Integer malesuada nunc vel risus. Viverra maecenas accumsan lacus vel facilisis volutpat est. Sit amet porttitor eget dolor morbi non arcu. Sodales ut eu sem integer vitae. Ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget. Vel eros donec ac odio tempor orci dapibus ultrices. Morbi tincidunt ornare massa eget egestas. Consectetur a erat nam at lectus urna duis convallis. Enim sit amet venenatis urna cursus eget nunc scelerisque viverra. Ultricies tristique nulla aliquet enim tortor at auctor urna nunc.";
        TextFinder tf = new TextFinder(text);
        System.out.println(tf.findWordPosition("dolor"));
        System.out.println(tf.getPercentageOfUnique());
        System.out.println(tf.getDublicateWOrds());
    }
}
