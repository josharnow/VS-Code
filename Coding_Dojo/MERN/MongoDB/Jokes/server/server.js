const express = require("express");
const cors = require("cors");

// Environment vars.
const port = 8000;
const db_name = "Joke";
// export { db_name };
module.exports = db_name;

// Immediately execute the import mongoose.config.js function.
// require() statement basically reads a JavaScript file, executes it, and then proceeds to return the export object.
require("./config/mongoose.config")(db_name); // passes in db_name as a parameter
// require("../config/mongoose.config")(db_name);

const app = express();

// req.body undefined without this!
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(cors());

require("./routes/joke.routes")(app);
// const AllMyJokeRoutes = require("./routes/joke.routes");
// AllMyJokeRoutes(app);

app.listen(port, () =>
  console.log(`Listening on port ${port} for REQuests to RESpond to.`)
);
