const strStr = (haystack: string, needle: string): number => {
  for (let hi = 0; hi < haystack.length; ++hi) {
    for (let ni = 0; ni < needle.length && hi + ni < haystack.length; ++ni) {
      if (haystack[hi + ni] !== needle[ni]) {
        break;
      }
      if (ni === needle.length - 1) {
        return hi;
      }
    }
  }
  return -1;
};

