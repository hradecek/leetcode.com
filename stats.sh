#!/bin/bash

language_icon() {
    local language="${1}"
    echo "<img src=\"https://raw.githubusercontent.com/github/explore/main/topics/${language}/${language}.png\" alt=\"${language} logo\" width=\"20\">"
}

declare -A LANGUAGE_ICONS
LANGUAGES=("java" "python" "typescript" "javascript" "c" "go" "haskell")
for lang in "${LANGUAGES[@]}"; do
    LANGUAGE_ICONS["$lang"]="$(language_icon "$lang")"
done

declare -A COUNTS
TOTAL_COUNT=0

for problem_dir in */; do
    for language_dir in "${problem_dir}"*/; do
        language=$(basename "${language_dir}")
        count=$(find "${language_dir}" -maxdepth 1 -type f | wc -l)
        if [[ -n "${language}" ]]; then
            (( COUNTS["${language}"] += count ))
            (( TOTAL_COUNT += count ))
        fi
    done
done

echo "## LeetCode Solutions Statistics"
echo ""
echo "| Language | Count |"
echo "|----------|-------|"
for language in "${!COUNTS[@]}"; do
    count="${COUNTS["${language}"]}"
    icon="${LANGUAGE_ICONS["${language}"]}"
    echo "| ${icon} ${language} | ${count} |"
done
echo ""

# Print out the total number of solutions
echo "Total number of solutions: ${total_count}"

