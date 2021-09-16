// Intersect two arrays to create an unsorted multiset
// return the new array of all the values that both arrays have in common
// eg [6,7,2,7,6,2], [2,7,2,1,2] returns [7,2,2]

const intersectUnsorted = (leftArr,rightArr) => {
    // for i in leftArr
    for (let i = 0; i < leftArr.length; i++) {
        for (let j = 0; j < rightArr.length; j++) {
            console.log
            
        }
        
    }
    for (let i = 0; i< leftArr.length - 1 ; i++) 
    const element = array[i]; }
    while (leftArr < ) {
        
    }
    for (let i = 0; i < leftArr.length; i++) {
        const element = [i];
        
    }
}

console.log(intersectUnsorted([6,7,2,7,]))



// Intersect two arrays to create an unsorted multiset //return the new array of
// all the values that both arrays //have in common  //[6,7,2,7,6,2],
// [2,7,2,1,2] returns [7,2,2]  const intersectUnsorted = (leftArr,rightArr) =>
// {     newArr = []     for (let i = 0; i < leftArr.length; i++) {
// const L = leftArr[i];         for (let j = 0; j < rightArr.length; j++) {
// const R = rightArr[j];             if (L===R) {                 //
// console.log(`L is ${L}`)                 // console.log(`L index is ${i}`)
// // console.log(`R is ${R}`)                 // console.log(`R index is ${j}`)
// newArr.push(L)                 rightArr.splice(j,1)                 break
// }         }     }     return newArr }  //loop through leftArr //loop through
// right arr //compare left Arr to right arr element     //if it matches
// //add the matching value to a new Arr  //return newArr
