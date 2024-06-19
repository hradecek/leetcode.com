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

def get_current_total_readme():
    with open("README.md", "r") as readme_file:
        lines = readme_file.readlines()

    for line in lines:
        if line.startswith("Total number of solved problems:"):
            return int(line.split(":")[1][3:-3].strip())

    return 0

def generate_statistics():
    language_icons = {lang: language_icon(lang) for lang in LANGUAGES}
    total_count, counts = count_solutions()
    current_total = get_current_total_readme()

    # Sort languages based on counts (descending order)
    sorted_counts = sorted(counts.items(), key=lambda item: item[1], reverse=True)

    # Generate Markdown for the statistics table
    statistics_md = "## Statistics\n\n"
    statistics_md += "| Language | Count |\n"
    statistics_md += "|----------|-------|\n"

    for language, count in sorted_counts:
        icon = language_icons.get(language, "")
        statistics_md += f"| {icon} {language} | {count} |\n"

    statistics_md += f"\nTotal number of solved problems: **{total_count}**\n\n"

    return statistics_md, total_count != current_total

def update_readme():
    statistics_md, count_changed = generate_statistics()

    if not count_changed:
        print("No change in total count. Skipping README.md update.")
        return

    with open("README.md", "r") as readme_file:
        readme_content = readme_file.read()

    start_marker = "## Statistics"
    end_marker = "## Problem List"
    start_index = readme_content.find(start_marker)
    end_index = readme_content.find(end_marker, start_index + len(start_marker))

    if start_index != -1 and end_index != -1:
        new_readme_content = readme_content[:start_index] + statistics_md + readme_content[end_index:]
    else:
        new_readme_content = readme_content + "\n\n" + statistics_md

    with open("README.md", "w") as readme_file:
        readme_file.write(new_readme_content)

if __name__ == "__main__":
    update_readme()

