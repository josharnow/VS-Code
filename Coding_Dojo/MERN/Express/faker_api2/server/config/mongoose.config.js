const mongoose = require("mongoose");

// Export a function to be called in server.js
module.exports = (db_name) => {
  mongoose
    .connect(`mongodb://localhost/${db_name}`, {
      useNewUrlParser: true,
      useUnifiedTopology: true,
      useFindAndModify: false,
    })
    .then(() => {
      console.log(`Successfully connected to ${db_name}`);
    })
    .catch((err) => {
      console.log(`mongoose connection to ${db_name} failed:`, err);
    });
};