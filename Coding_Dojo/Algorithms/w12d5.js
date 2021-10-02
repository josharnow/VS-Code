const big = [
  [67, 34, 45, 56],
  [98, 87, 76, 65],
  [56, 67, 78, 89],
  [54, 43, 32, 21]
];

const small = [
  [67, 78],
  [43, 32]
];

const anotherSmall = [
  [67, 7],
  [43, 32]
];


// function matrixSearch(larger, smaller) {
//   for (let i = 0; i < larger.length; ++i) {
//     // console.log(smaller[0][0]);
//     // console.log(larger[i][0]);
//     if (larger[i][0] === smaller[0][0]) {
//       return true;
//     } else{
//       return false;
//     }
//   }
// }

// function matrixSearch(larger, smaller) {
//   for (let i = 0; i < larger.length; ++i) {
//     for (let j = 0; j < smaller.length; j++) {
      
//       if (larger[i][0] === smaller[0][0] && larger[i][1] === smaller[1][1]) {
//         console.log(`Larger array position: ${i}`);
//         console.log(`Smaller array position: ${j}`);
//         return true;
//       } else{
//         return false;
//       }
//     }
//     // console.log(smaller[0][0]);
//     // console.log(larger[i][0]);
//   }
// }

// function matrixSearch(larger, smaller) {
//   for (let i = 0; i < larger.length; ++i) {
//     // console.log(`Outer Loop: ${larger[i][j]}`);
//     console.log(`Outer Loop: ${larger[i][i + 1]}`);
//     for (let j = 0; j < smaller.length; ++j) {
//       console.log(`Big array position: ${larger[i][j]});
//       // console.log(`Inner Loop: ${larger[i][j]}`);
      
//       // if (larger[i][0] === smaller[0][0] && larger[i][1] === smaller[0][1]) {
//       //   console.log(`Larger array position: ${i}`);
//       //   console.log(`Smaller array position: ${j}`);
//       //   return true;
//       // } else{
//       //   return false;
//       // }
    
//     // console.log(smaller[0][0]);
//     // console.log(larger[i][0]);
//   }
// }
// }

function matrixSearch(larger, smaller) {

  for (var i = 0; i < larger.length; i++) {
    for (var j = 0; j < larger[i].length; j++) {
      if (larger[i][j] == smaller[0][0]) {
        if (larger[i][j + 1] == smaller[0][1]) {
          if (larger[i + 1][j] == smaller[1][0]) {
            if (larger[i + 1][j + 1] == smaller[1][1]) {
              return true
            }
          }
        }
      }
    }
  }

  return false
}



console.log(matrixSearch(big, small));
console.log(matrixSearch(big, anotherSmall));




// if found, true, if not, false