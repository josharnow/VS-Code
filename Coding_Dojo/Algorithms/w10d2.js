// Union Sorted Arrays
// Efficiently combine two pre-sorted arrays into a new sorted array
// Don't use built in functions

// Eg. given [2,4,7,9,10] and [2,3,5,7,9,10], return [2,3,4,5,7,9,10]
// given [1,2,2,2,7] and [2,2,6,6,7], return [1,2,2,2,6,6,7]

let countLeft = {};
let countRight = {};
let combined = [];
const union = (arrLeft, arrRight) => {
    for (let i = 0; i < arrLeft.length; i++) {
        // combined.push(arrLeft[i]);
        // if () {
            
        // }
        // countLeft["key3"] = arrLeft[i];
        // countLeft += arrLeft[i];
        // countLeft[`${arrLeft[i]}`] += 1;
        countLeft[`${arrLeft[i]}`] = `${i}`;
        // console.log(countLeft)
        for (let j = 0; j < arrRight.length; j++) {
            // countRight[`${arrRight[j]}`] += 1;
            countRight[`${arrRight[j]}`] = `${j}`;
            // if (arrRight) {
                
                // }
                // combined += arrLeft[i];
                // if (arrLeft[i] === arrRight[j]) {
                    // console.log(arrLeft[i])
            if (`${arrRight[j]}`)
        }
    }
            // return combined;
    for (let index = 0; index < array.length; index++) {
        const element = array[index];
        
        if (countRight[])
    }
    console.log(Object.keys(countLeft));
    console.log(Object.keys(countRight));
    console.log(countLeft)
    console.log(countRight);
    console.log(combined);
    return combined;
}

// 
// for (let  = 0;  < array.length; ++) {
//     const element = array[];
    
// }
// if (count["2"])
    
// }



console.log(union([1, 2, 2, 2, 7],[2, 2, 6, 6, 7]));