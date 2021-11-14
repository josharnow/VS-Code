// based on (5) at https://login.codingdojo.com/m/130/6419/45637
// In our controller file, we export different functions that perform the basic
// CRUD operations using our User model.
// Joke is a constructor function which can create new joke objects and also has other methods that will talk to the database!
// the .then() will only execute upon successfully inserting data in the database
// the .catch() will execute only if there is an error.

const Joke = require('../models/joke.model');

module.exports.findAllJokes = (req, res) => {
  Joke.find() // retrieve an array of all documents in the collection
    .then(allDaJokes => res.json({ jokes: allDaJokes }))
    .catch(err => res.json({ message: 'Something went wrong', error: err }));
}

module.exports.findOneSingleJoke = (req, res) => {
  Joke.findOne({ _id: req.params.id })
    .then(oneSingleJoke => res.json({ joke: oneSingleJoke }))
    .catch(err => res.json({ message: 'Something went wrong', error: err }));
}

module.exports.createNewJoke = (req, res) => {
    console.log(req.body);
  Joke.create(req.body)
    // .then(res.json(Joke))
    .then(newlyCreatedJoke => res.json({ joke: newlyCreatedJoke }))
    .catch(err => res.json({ message: 'Something went wrong', error: err }));
}

module.exports.updateExistingJoke = (req, res) => {
  Joke.findOneAndUpdate(
    { _id: req.params.id },
    req.body,
    { new: true, runValidators: true }
  )
    .then(updatedJoke => res.json({ joke: updatedJoke }))
    .catch(err => res.json({ message: 'Something went wrong', error: err }));
}

module.exports.deleteAnExistingJoke = (req, res) => {
  Joke.deleteOne({ _id: req.params.id })
    .then(result => res.json({ result: result }))
    .catch(err => res.json({ message: 'Something went wrong', error: err }));
}
