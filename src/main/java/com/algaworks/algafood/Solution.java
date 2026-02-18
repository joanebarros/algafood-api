package com.algaworks.algafood;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class Solution {

    public static void main(String[] args) {
        log.info("result: {}", minRemovals("leet (code"));
    }

    public static int minRemovals(String s) {
        int open = 0;
        int removals = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                } else {
                    removals++;
                }
            }
        }

        return removals + open;
    }
}
