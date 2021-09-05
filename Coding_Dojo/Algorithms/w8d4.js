// changes array in place, without needing a sliced array
// return the index of the pivot
// const partition2 = (arr, left, right) => {
// }

// changes array in place, but needs a sliced array
// returns the index of the pivot

// sample arr => [8, 3, 5, 1, 19, 9, 13]
// partitioned arr => [3, 5, 1, 8, 19, 9, 13] returns index of pivot at arr[3]
// 

const partition = (arr) => {
    let pivot = arr[0];
    let left = [];
    let right = [];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < pivot) {
            left.push(arr[i])
        }
        if (arr[i] > pivot) {
            right.push(arr[i]);
        }
    }
    finalArr = [...left, pivot, ...right];
    return left.length;
}

console.log(partition([8, 3, 5, 1, 19, 9, 13]))


// time for recursion again!!
// partition your array, then quickSort the left half
// and the right half.
// Each half should be partitioned and quickSorted recursively.

// const quickSort = (arr) => {
// }

// console.log(quickSort([7,45,2,67,3,2,1]));