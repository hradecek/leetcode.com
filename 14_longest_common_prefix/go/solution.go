package main

import "bytes"

func longestCommonPrefix(strs []string) string {
    if len(strs) == 0 {
        return ""
    }

    var lcp bytes.Buffer
    for i := 0; i < len(strs[0]); i++ {
        nextChar := strs[0][i]
        for j := 1; j < len(strs); j++ {
            if len(strs[j]) <= i || strs[j][i] != nextChar {
                return lcp.String()
            }
        }
        lcp.WriteByte(nextChar)
    }
    return lcp.String()
}

