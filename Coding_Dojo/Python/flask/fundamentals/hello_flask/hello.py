from flask import Flask, render_template  # added render_template!
app = Flask(__name__)

@app.route('/')
def index():
    # Instead of returning a string,
    # we'll return the result of the render_template method, passing in the name of our HTML file
    return render_template("index.html", phrase="hello", times=5)	# notice the 2 new named arguments!

if __name__ == "__main__":
    app.run(debug=True)