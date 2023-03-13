package task2;

import ui.ConsoleUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VocabularyUI extends ConsoleUI {
    private LanguageVocabulary vocabulary;


    private Tab getRootTab() {
        Tab root = new Tab(this.vocabulary.toString());

        Tab t1 = new Tab("Translate", (p)->{
            Scanner s = new Scanner(System.in);
            System.out.print("Enter word: ");
            var word = s.nextLine();
            System.out.println(vocabulary.translate(word));
            s.nextLine();
        });

        Tab t2 = new Tab("Edit words", (p)->{
            Scanner s = new Scanner(System.in);
            System.out.print("Enter word: ");
            var word = s.nextLine();
            System.out.println(vocabulary.translate(word));
            s.nextLine();
        });

        return root;
    }
    public VocabularyUI(LanguageVocabulary vocabulary) {

//        super(Tab.getTab("Main menu", List.of(
//                Tab.getTab("Translate", (x)->{
//                    System.out.println("Enter word: ");
//                }),
//                Tab.getTab("Edit", List.of(
//                    Tab.getTab("Words", List.of(
//                            Tab.getTab("Add word", (x)->{}),
//                            Tab.getTab("Remove word", (x)->{}),
//                            Tab.getTab("Replace word", (x)->{})
//                    )),
//                    Tab.getTab("Translations", List.of(
//                            Tab.getTab("Add translation to word", (x)->{}),
//                            Tab.getTab("Remove translation from word", (x)->{}),
//                            Tab.getTab("Replace translation in word", (x)->{})
//                    )),
//                    Tab.getTab("Vocabulary system", List.of(
//
//                    ))
//                    )
//                ))));
    }
}