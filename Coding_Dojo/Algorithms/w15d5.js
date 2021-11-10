//This was a coding challenge that a TC graduate received from Wayfair; she was told not to use recursion to solve it which makes it considerably more tricky.

//Given a multidimensional array of words (there can be any number of inner arrays and the arrays can be of any length)

let words = [
  ["quick", "lazy"],
  ["brown", "red", "grey"],
  ["fox", "dog"]
];

//return an array of all combinations of the words combined

let givenCombinations = [
  "quick brown fox",
  "quick brown dog",
  "quick red fox",
  "quick red dog",
  "quick grey fox",
  "quick grey dog",
  "lazy brown fox",
  "lazy brown dog",
  "lazy red fox",
  "lazy red dog",
  "lazy grey fox",
  "lazy grey dog"
];

//This can be solved either recursively or iteratively.

const arrayCombo = (words) => {
  let myCombinations = [];
  let xCounter = 0;
  let yCounter = 0;
  for (const x of words) {
    // console.log(x);
    ++xCounter;
    myCombinations.push(x);
    console.log(`Outer Loop Iteration #${xCounter}: ${x}`);
    for (const y of x) {
      // console.log(y);
      ++yCounter;
      console.log(`Inner Loop Iteration #${yCounter}: ${y}`);
    
    }
    
  }

  // for (const iterator of object) {
    
  // }
  
  return myCombinations;
}

// const testArrayCombo = new arrayCombo();

arrayCombo(words);