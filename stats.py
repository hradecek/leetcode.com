#!/usr/bin/env python3
import os
from collections import defaultdict

LANGUAGES = ["java", "python", "typescript", "javascript", "c", "go", "haskell"]

def language_icon(language):
    return f'<img src="https://raw.githubusercontent.com/github/explore/main/topics/{language}/{language}.png" alt="{language} logo" width="20">'

def count_solutions():
    total_count = 0
    counts = defaultdict(int)

    for problem_dir in [f for f in os.listdir('.') if not f.startswith('.')]:
        if os.path.isdir(problem_dir):
            for language_dir in os.listdir(problem_dir):
                if os.path.isdir(os.path.join(problem_dir, language_dir)):
                    count = len([name for name in os.listdir(os.path.join(problem_dir, language_dir)) if os.path.isfile(os.path.join(problem_dir, language_dir, name))])
                    counts[language_dir] += count
            total_count += count

    return total_count, counts

def print_statistics():
    language_icons = {lang: language_icon(lang) for lang in LANGUAGES}
    total_count, counts = count_solutions()
    sorted_counts = sorted(counts.items(), key=lambda item: item[1], reverse=True)

    print("## Statistics")
    print("")
    print("| Language | Count |")
    print("|----------|-------|")

    for language, count in sorted_counts:
        icon = language_icons.get(language, "")
        print(f"| {icon} {language} | {count} |")
    print("")
    print(f"Total number of solved problmes: **{total_count}**")

if __name__ == "__main__":
    print_statistics()

