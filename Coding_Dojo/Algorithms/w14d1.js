class BSTNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}
class BST {
  constructor() {
    this.root = null;
  }

add(val) {
  var newNode = new BSTNode(val);
  if (this.root == null) {
    this.root = newNode;
    return;
  }

  var runner = this.root;

  while (runner != null) {
    if (newNode.value > runner.value) {
      if (runner.right == null) {
        runner.right = newNode;
        break;
      }
      runner = runner.right;
    }
    else if (newNode.value <= runner.value) {
      if (runner.left == null) {
        runner.left = newNode;
        break;
      }
      runner = runner.left;
    }
  }

}

findMin() {
  if (this.root == null) return;

  var min = this.root;
  while (min.left != null) {
    min = min.left;
  }

  return min.value;
}

findMax() {
  if (this.root == null) return;

  var max = this.root;
  while (max.right != null) {
    max = max.right;
  }

  return max.value;
}
}

// class BSTNode {
//   constructor(value) {
//     this.value = value;
//     this.left = null;
//     this.right = null;
//   }
// }
// class BST {
//   constructor() {
//     this.root = null;
//   }

//   add(value) {
//     // Add value
//     let node = new BSTNode(value);

    
//     if (!this.root) {
//       console.log(`Assigning this.root (${this.root}) the value of node.value (${node.value})`);
//       this.root = node.value;
//       this.left = null;
//       this.right = null;
//     } else if (!this.left && node.value <= this.root) {
//       console.log(`Assigning this.left (${this.left}) the value of node.value (${node.value})`);
//       // this.left = node.value;
//       // node.left = node.value;
//       this.left = node.value;
//       // node.left = value;
//       // this.left.value = node.value;
//     } else if (!this.right && node.value >= this.root){
//       console.log(`Assigning this.right (${this.right}) the value of node.value (${node.value})`);
//       this.right = node.value;
//     }

//     // } else if (node.value <= this.root.value) {
//     //   console.log(`Assigning this.left (${this.root}) the value of node.value (${node.value})`);
//     //   this.left = node.value;
//     //   // node.left = value;
//     //   // this.left.value = node.value;
//     // } else {
//     //   this.right = node;
//     // }
//   }

//   findMin() {
//     // Find min value
//   }
  
//   findMax() {
//     //Find max value
//   }

//   // printTree() {
//   //   let runner = this.root;
//   //   while (runner) {
//   //     console.log(runner.value);
//   //     runner = runner.left;
//   //   }
//   // }

//   printBST() {
//     let runner = this.root;
//     console.log(runner.value);
//     while (runner) {
//       console.log(runner.value);
//       runner = runner.next;
//     }
//   }

//   }
  


// const tree = new BST;

// tree.add(7);
// tree.add(6);
// tree.add(8);
// tree.add(20);

// // tree.add(20);

// console.log(tree);
// tree.printBST();

// // tree.printTree();
