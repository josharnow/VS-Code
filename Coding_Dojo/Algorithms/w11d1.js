// create a function that accepts a string representing an int
// in binary notation, and returns the int
// you do not need to use parseInt
// should return integer >= 0 

// given "1010101", return 85
// given "100011", return 35

// The decimal number is equal to the sum of binary digits (dn) times their power of 2 (2n)

>= 
=== 
const binToDec = (str) => {
  let sum = 0;
  // for (let i = 0; i < str.length; i++) {
  //   sum += (parseInt(str[i]) * 2 ** i);
  //   console.log(sum);
  // }
  for (let i = 0; i >= (-1*str.length); --i) {
    sum += (parseInt(str[i]) * 2 ** i);
    console.log(sum);
  }
  return sum;
}

console.log(binToDec("1010101"));
console.log(binToDec("100011"));
console.log(binToDec("1001"));
console.log(binToDec("1000"));
console.log(binToDec("1111"));
console.log(binToDec("110101011"));