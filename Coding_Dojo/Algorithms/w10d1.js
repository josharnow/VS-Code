// Intersect Sorted Arrays
// Given 2 sorted arrays, return a new array containing all the numbers they
// have in common
// This includes duplicates too! The intersection of [2,2] and [2,2,2] would be
// [2,2]
// eg. given [2,4,7,9,10] and [2,3,5,7,9,10], return [2,7,9,10]

// for 

const intersect = (arrLeft, arrRight) => {
    const newArr = [];
    let i = 0;
    arrLeft.length > arrRight.length ? 
    if (arrLeft.length > arrRight.length) {
        newArr.length = 
    } else {

    }
    while (i < arrLeft.length) {
        let j = 0;
        while (j < arrRight.length) {
            
        }
        if (arrLeft[i] === arrRight[i]) {
            newArr.push(arrLeft[i]);
        }
        i++;
    }
    console.log(newArr)

    // for (let i = 0; i < arrLeft.length - 1; i++) {
    //     console.log(arrLeft[i])
        
    // }
}
console.log(intersect([2, 4, 7, 9, 10], [2, 3, 5, 7, 9, 10]))