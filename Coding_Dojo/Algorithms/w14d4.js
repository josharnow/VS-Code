depth(runner = this.root, count = 0){
  if (runner) {
    let leftCount = count;
    let rightCount = count;
    if (runner.left) leftCount = this.depth(runner.left, count);
    if (runner.right) rightCount = this.depth(runner.right, count);
    if (leftCount > rightCount) {
      count = leftCount
    } else {
      count = rightCount
    }
    console.log(`Value: ${runner.value}`);
    console.log(`Count: ${count}`);
    return ++count;
  }
  return count;
}

isBalance(runner = this.root, count = 0){
  if (runner) {
    let leftCount = count;
    let rightCount = count;
    if (runner.left) leftCount = this.depth(runner.left, count);
    if (runner.right) rightCount = this.depth(runner.right, count);
    if (runner === this.root) {
      if (Math.abs(leftCount - rightCount) <= 1) {
        return true;
      } else {
        return false;
      }
    }
    if (leftCount > rightCount) {
      count = leftCount
    } else {
      count = rightCount
    }
    console.log(`Value: ${runner.value}`);
    console.log(`Count: ${count}`);
    return ++count;
  }
  return count;
}