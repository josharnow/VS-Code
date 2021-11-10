//aaabbbbzz -> a3b4z2

function encode(str) {
  let encodedStr = "";
  for (const element of str) {
    let num = 1;
    console.log(str[element])
    if (str[element] === str[element+1]) {
      num++;
      // console.log(`${element}: ${num}`);
    }
    // console.log(element)
  }
  // parseInt
}

// Consider cases >= 10

function decode(str) {
  console.log(isNaN("5"))
  for (const i of str) {
    console.log(str[i])
    if (!isNaN(str[i+1])) {
    }
    for (let i = 0; i < 3; i++) {
      
      
      console.log({str[i]});
    }
  }
}

const strA = "aaabbbbzz";
const strB = "a5b12z10";

console.log(encode(strA));
console.log(decode(strB));