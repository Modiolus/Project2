package myLessons.tasks_stepik;

import java.util.Arrays;

public class Stepik2_4_3 {
    public static void main(String[] args) {
        String[] roles = {
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles, textLines));
//printTextPerRole(roles, textLines);
        StringBuilder st = new StringBuilder();
//        Городничий:
//        1) Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
//        4) Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.
//
//        Аммос Федорович:
//        2) Как ревизор?
//        5) Вот те на!

//        for (int i = 0; i < roles.length; i++) {
//
//            st.append(roles[i])
//                    .append(":")
//                    .append("\n");
//
//            for (int j = 0; j < textLines.length; j++) {
//                if (textLines[j].startsWith((roles[i]) + ":")) {
//                    int a = textLines[j].indexOf(":");
//                    st.append(j + 1)
//                            .append(")")
//                            .append(textLines[j].substring(a + 1))
//                            .append("\n");
//
//                }
//            }
//            st.append("\n");
//        }
//        System.out.println(st);
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            str.append(roles[i])
                    .append(":")
                    .append("\n");

            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith((roles[i]) + ":")) {
                    int a = textLines[j].indexOf(":");
                    str.append(j + 1)
                            .append(")")
                            .append(textLines[j].substring(a + 1))
                            .append("\n");
                }
            }
            str.append("\n");

        }
        return str.toString();
    }
}

