const addBinary = (a: string, b: string): string => {
  let result = '';
  let carry = false;
  for (let ai = a.length - 1, bi = b.length - 1; ai >= 0 || bi >= 0; --ai, --bi) {
    const left = ai >= 0 ? a[ai] : '0';
    const right = bi >= 0 ? b[bi] : '0';

    if (left === right) {
      result = (carry ? '1' : '0') + result;
      carry = left === '1';
    } else {
      result = (carry ? '0' : '1') + result;
    }
  }

  return (carry ? '1' : '') + result;
};

