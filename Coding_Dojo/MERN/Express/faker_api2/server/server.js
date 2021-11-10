const express = require("express");
const faker = require("faker");
const app = express();
const port = 8000;

class User {
  constructor() {
    this._id = User.generateID().next().value;
    // this._id = User.incrementID();
    this.firstName = faker.name.firstName();
    this.lastName = faker.name.lastName();
    this.phoneNumber = faker.phone.phoneNumber();
    this.email = faker.internet.email();
    this.password = faker.internet.password();
  }

  // ES6 generator method - Infinite Data Stream
  static * generateID() {
    while (true) {
      if (!this.i) {
        yield this.i = 1;
      } else {
        yield ++this.i;
      }
    }
  }

  // // Static method ID generator
  // static incrementID() {
  //   if (!this.latestID) {
  //     this.latestID = 1;
  //   } else {
  //     this.latestID++;
  //   }
  //   return this.latestID;
  // }
}

class Company {
  constructor() {
    this._id = Company.generateID().next().value;
    // this._id = Company.incrementID();
    this.name = faker.company.companyName();
    this.streetAddress = faker.address.streetAddress();
    this.street = faker.address.streetName();
    this.state = faker.address.state();
    this.zipCode = faker.address.zipCode();
    this.country = faker.address.country();
  }

  // ES6 generator method - Infinite Data Stream
  static * generateID() {
    while (true) {
      if (!this.i) {
        yield this.i = 1;
      } else {
        yield ++this.i;
      }
    }
  }

  // // Static method ID generator
  // static incrementID() {
  //   if (!this.latestID) {
  //     this.latestID = 1;
  //   } else {
  //     this.latestID++;
  //   }
  //   return this.latestID;
  // }
}

// make sure these lines are above any app.get or app.post code blocks
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// req is shorthand for request
// res is shorthand for response
app.get("/api", (req, res) => {
  res.json({ message: "Hello World" });
});

app.get("/api/users/new", (req, res) => {
  console.log("Returning a new user...");
  res.json(new User());
});

app.get("/api/companies/new", (req, res) => {
  console.log("Returning a new company...");
  res.json(new Company());
});

app.get("/api/user/company", (req, res) => {
  console.log("Returning a new user and a new company...");
  // console.log(new User());
  // console.log(new Company());
  let user = new User();
  let company = new Company();
  // console.log(user);
  // console.log(company);
  const userAndCompany = { user, company };
  // console.log(userAndCompany);
  res.json(userAndCompany);
  // res.json(new Company());
});

// this needs to below the other code blocks
app.listen(port, () => console.log(`Listening on port: ${port}`)); // Runs server on specified port



// // req is shorthand for request
// // res is shorthand for response
// app.get("/api", (req, res) => {
//   res.json({ message: "Hello World" });
// });

// // this needs to below the other code blocks
// app.listen(port, () => console.log(`Listening on port: ${port}`)); // Runs server on specified port

// // make sure these lines are above any app.get or app.post code blocks
// app.use(express.json());
// app.use(express.urlencoded({ extended: true }));


// // GET
// // we can hard code some users like this
// // later on we will want to store users in a database
// const users = [
//   { firstName: "Reimu", lastName: "Hakurei" },
//   { firstName: "Marisa", lastName: "Kirisame" },
//   { firstName: "Sanae", lastName: "Kochiya" },
//   { firstName: "Sakuya", lastName: "Izayoi" },
//   { firstName: "Momiji", lastName: "Inubashiri" }
// ];

// app.get("/api/users", (req, res) => {
//   res.json(users);
// });

// // POST
// app.post("/api/users", (req, res) => {
//   // req.body will contain the form data from Postman or from React
//   console.log(req.body);
//   // we can push it into the users array for now...
//   // later on this will be inserted into a database
//   users.push(req.body);
//   // we always need to respond with something
//   res.json({ status: "ok" });
// });

// // Getting Data from a URL
// // if we want to get a user with a specific id, we can make the id a part of the url
// // be sure to preface the id variable with a `:` colon
// app.get("/api/users/:id", (req, res) => {
//   // we can get this `id` variable from req.params
//   console.log(req.params.id);
//   // assuming this id is the index of the users array we could return one user this way
//   res.json(users[req.params.id]);
// });

// // UPDATE
// app.put("/api/users/:id", (req, res) => {
//   // we can get this `id` variable from req.params
//   const id = req.params.id;
//   // assuming this id is the index of the users array we can replace the user like so
//   users[id] = req.body;
//   // we always need to respond with something
//   res.json({ status: "ok" });
// });

// // DELETE
// app.delete("/api/users/:id", (req, res) => {
//   // we can get this `id` variable from req.params
//   const id = req.params.id;
//   // assuming this id is the index of the users array we can remove the user like so
//   users.splice(id, 1);
//   // we always need to respond with something
//   res.json({ status: "ok" });
// });








// const express = require("express");
// const cors = require("cors");

// // Environment vars.
// const port = 8000;
// const db_name = "NAME_YOUR_DATABASE";

// // Immediately execute the import mongoose.config.js function.
// require("../config/mongoose.config")(db_name);

// const app = express();

// // req.body undefined without this!
// app.use(express.json());
// app.use(express.urlencoded({ extended: true }));
// app.use(cors());

// require("../routes/message.routes")(app);

// app.listen(port, () =>
//   console.log(`Listening on port ${port} for REQuests to RESpond to.`)
// );