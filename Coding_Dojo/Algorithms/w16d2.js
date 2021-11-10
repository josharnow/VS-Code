const findUnion = (setA, setB) => {
  // let myCar = {
  //   number: "",
  //   counter: 0
  // };

  // let newSet = { 
  //   number: setA,
    
  // };
  let newSet = [...setA, ...setB]
  
  // for (let index = 0; index < array.length; index++) {
  //   const element = array[index];
    
  // }

  let obj = {
    num: "",
    counter: 0
  }

  for (const num of newSet) {
    console.log(num);

    obj.num == 

    obj.counter++;
    console.log(`Count: ${obj.counter}`)

    if (num) {
      
    }
  
}
  
  return newSet;
}

console.log(findUnion([1,3,5,7,9], [2,3,4,7,10]));

// combine 2 sets into 1 set that represents all values that exist

// If numbers overlap, include in union once rather than twice
