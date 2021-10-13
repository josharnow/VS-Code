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

  printBST(node) {

    // if the BST is empty (Edge case)
    if (node == null) {
      return this;
    }

    // print out the node with value left and right
    this.printBST(node.left);
    console.log(node.value);

    this.printBST(node.right);

  }

  contains(value, runner = this.root, found = false) {
    if (runner) {
      if (runner.left && value < runner.value) found = this.contains(value, runner.left, found);
      if (runner.right && value > runner.value) found = this.contains(value, runner.right, found);
      if (value == runner.value) found = true;
      return found;
    }
    return found;
  }

  size(runner = this.root, count = 0) {
    if (runner) {
      if (runner.left) count = this.size(runner.left, count);
      if (runner.right) count = this.size(runner.left, count);
      return ++count;
    }
    return count;
  }
}

const tree = new BST;

tree.add(7);
tree.add(9);
tree.add(3);
tree.printBST(tree);