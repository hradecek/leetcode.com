class Solution {

    fun isValid(word: String): Boolean {
        // bit 1 - minimum of 3 characters
        // bit 2 - alphanumeric
        // bit 3 - at least one vowel
        // bit 4 - at least one consonant
        var validBits = 0b0010
        for ((index, c) in word.withIndex()) {
            if (index == 2) {
                validBits = validBits or 0b0001
            }
            if (!c.isLetterOrDigit()) {
                validBits = validBits and 0b1101
            }
            if (c.isVowel()) {
                validBits = validBits or 0b0100
            }
            if (c.isConsonant()) {
                validBits = validBits or 0b1000
            }
        }
        return validBits == 15
    }
}

fun Char.isVowel() = this.lowercaseChar() in setOf('a', 'e', 'i', 'o', 'u')

fun Char.isConsonant() = !this.isVowel() && this.lowercaseChar() in 'a' .. 'z'
