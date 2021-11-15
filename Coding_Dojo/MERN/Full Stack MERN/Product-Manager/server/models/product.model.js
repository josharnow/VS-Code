const mongoose = require("mongoose");
const db_name = require("../server");

const ProductSchema = new mongoose.Schema(
  {
  "title": {
    type: String,
    required: [true, "Title is required!"],
    minlength: [10, "Title must be at least 10 characters long!"]
  },
  "price": {
    type: Number,
    required: [true, "Price is required!"],
    min: [0.01, "Price must be at least $0.01!"]
  },
  "description": {
    type: String,
    required: [true, "Description is required!"],
    minlength: [10, "Description must be at least 10 characters long!"]
  }
  },
  { timestamps: true } // Assigns createdAt and updatedAt fields
);

const Product = mongoose.model(db_name, ProductSchema);
module.exports = Product;