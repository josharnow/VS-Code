const mongoose = require("mongoose");

// Export a function to be called in server.js
module.exports = (db_name) => {
  mongoose
    .connect(mongodb://localhost/, {
      useNewUrlParser: true,
      useUnifiedTopology: true,
      useFindAndModify: false,
    })
    .then(() => {
      console.log(Successfully connected to );
    })
    .catch((err) => {
      console.log(mongoose connection to  failed:, err);
    });
};