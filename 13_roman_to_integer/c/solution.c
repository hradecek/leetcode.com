#include <stdio.h>
#include <string.h>

int getRomanValue(char roman) {
    switch (roman) {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
        default:
            return -1;
    }
}

int romanToInt(char* s) {
    int result = 0;
    for (int i = strlen(s) - 1; i >= 0; --i) {
        int current = getRomanValue(s[i]);
        if ((i - 1) >= 0) {
            int next = getRomanValue(s[i - 1]);
            if (next < current) {
                result += current - next;
                --i;
                continue;
            }
        }
        result += current;
    }
    return result;
}

