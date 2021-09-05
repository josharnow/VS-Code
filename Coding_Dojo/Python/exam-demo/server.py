from flask_app import app
# from flask_app.controllers import login, exam
from flask_app.controllers import users, shows

if __name__ == "__main__":
    app.run(debug = True)
