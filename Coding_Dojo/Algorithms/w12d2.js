// Binary Search

// Given a sorted array and a value, return whether
//  the array contains that value. Do not sequentially 
//  iterate the array. Instead 'divide and conquer'. 
//  Taking advantage of the fact that array is sorted. 


function binarySearch(arr, value) {
  arr.forEach(value => {
    let half === (arr.length / 2);
    console.log(half);
  });
}

// function binarySearchRecursive(arr, target) { 
//   if (target < arr[0]) {
//     return false;
//   }
//   if (target > arr[arr.length+1]) {
//     return false;
//   }
//   else {
//     return true;
//   }
//   // if (binarySearchRecursive()) {
    
//   // }
//   // for (let i = 0; i < array.length; i++) {
//   //   const element = array[i];
    
//   // }
// }

function binarySearchRecursive(arr, target) {
  var mid = Math.floor(arr.length / 2);
  console.log(arr[mid]);

  if (arr[mid] === target) {
    return true;
  }
  else if (arr.length === 1) {
    return false;
  }

  if (arr[mid] < target) {
    let newArr = arr.slice(mid + 1, arr.length + 1);
    console.log(newArr)
    return binarySearchRecursive(newArr, target);
  }
  else if (arr[mid] > target) {
    let newArr2 = arr.slice(0, mid);
    console.log("bottom array")
    return binarySearchRecursive(newArr2, target);
  }

}


// console.log(binarySearch([1,2,3,4,5,6,7,8,9,10], 9));
// ---> 1 2 3 4 5  |  6 7 8 9 10
// ---> 6 7  |  8 9 10
// ---> 8  [9]  10  (found)

// console.log(binarySearchRecursive([1,2,3,4,5,6,7,8,9,10,12,13], 10))    TRUE
// console.log(binarySearchRecursive([0, 2, 4, 6, 8, 10, 12, 14, 16], 9 ))    FALSE
// console.log(binarySearchRecursive([0, 2, 4, 6, 8, 10, 12, 14, 16], 16 ))    TRUE
// console.log(binarySearchRecursive([0, 2, 4, 6, 8, 12, 14, 16], 8 ))    TRUE
// console.log(binarySearchRecursive([8], 8 ))   TRUE