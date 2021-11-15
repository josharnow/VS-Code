// In our controller file, we export different functions that perform the basic
// CRUD operations using our User model.
// Product is a constructor function which can create new joke objects and also has other methods that will talk to the database!
// the .then() will only execute upon successfully inserting data in the database
// the .catch() will execute only if there is an error.

const Product = require('../models/product.model');

module.exports.index = (req, res) => {
  res.json({
    message: "Hello World"
  });
}

module.exports.findAllProducts = (req, res) => {
  Product.find() // retrieve an array of all documents in the collection
    .then(allDaProducts => res.json({ products: allDaProducts }))
    .catch(err => res.json({ message: 'Something went wrong', error: err }));
}

module.exports.findOneSingleProduct = (req, res) => {
  Product.findOne({ _id: req.params.id })
    .then(oneSingleProduct => res.json({ product: oneSingleProduct}))
    .catch(err => res.json({ message: 'Something went wrong', error: err }));
}

module.exports.createNewProduct = (req, res) => {
  Product.create(req.body)
    // .then(res.json(Product))
    .then(newlyCreatedProduct => res.json({ product: newlyCreatedProduct }))
    .catch(err => res.json({ message: 'Something went wrong', error: err }));
}

module.exports.updateExistingProduct = (req, res) => {
  Product.findOneAndUpdate(
    { _id: req.params.id },
    req.body,
    { new: true, runValidators: true }
  )
    .then(updatedProduct => res.json({ product: updatedProduct }))
    .catch(err => res.json({ message: 'Something went wrong', error: err }));
}

module.exports.deleteAnExistingProduct = (req, res) => {
  Product.deleteOne({ _id: req.params.id })
    .then(result => res.json({ result: result }))
    .catch(err => res.json({ message: 'Something went wrong', error: err }));
}