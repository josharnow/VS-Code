// import * as JokeController from "../controllers/joke.controller";
const JokeController = require('../controllers/joke.controller');

module.exports = (app) => {
  app.get('/api/jokes', JokeController.findAllJokes);
  app.get('/api/jokes/:id', JokeController.findOneSingleJoke);
  app.put('/api/jokes/:id', JokeController.updateExistingJoke);
  app.post('/api/jokes', JokeController.createNewJoke);
  app.delete('/api/jokes/:id', JokeController.deleteAnExistingJoke);
}
