package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class LocalTest {

    @Test
    public void test() {

        String target = "Insert OverWrite sdftable " +
                "select from sad asd select";
        String pattern = "(?s)(?i)((?=insert).+?)(?=select).+?";
        regexTest(target, pattern);
    }

    void regexTest(String target, String pattern) {
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(target);
        if (matcher.matches()) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                log.info(matcher.group(i + 1));
            }
            log.info(target.replace(matcher.group(1), "").trim());

            log.info(matcher.replaceAll(""));


        } else {
            log.error("Not Match Anything");
        }

    }
}
