//combine two pre-sorted arrays into one sorted array
//return the newly combined array
//bonus challenge: combine in place into leftArr instead of a new array

const combine = (leftArr, rightArr) => {
    var newArr = [];
    let i = 0;
    while (leftArr.length > 0 || rightArr > 0) {
        if (leftArr[0] > rightArr[0] || leftArr.length == 0) {
            newArr.push(rightArr[0]);
            rightArr.splice(0, 1);
        }
        else if (leftArr[0] < rightArr[0] || rightArr.length == 0) {
            newArr.push(leftArr[0]);
            leftArr.splice(0, 1);
        }
    }
    return newArr;
}

// should return [0,1,2,3,4,6,7,9,11]
// console.log(combine([1,2,7,9],[0,3,4,6,11]));

// should return [0,1]
// console.log(combine([1],[0]));

// Use recursion to break up the array into halves and combine two sorted halves. 
// Each half should be split in half, and so on, until you get single item
// arrays
// use combine() to combine the arrays

const mergeSort = (arr) => {
    
}