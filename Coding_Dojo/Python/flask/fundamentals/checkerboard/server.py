from flask import Flask, render_template
app = Flask(__name__)
@app.route('/')
def index():
    # cell_x = 8
    # cell_y = 8
    # total_cells = (cell_x * cell_y)
    # checkerboard = x * y
    # for x in checkerboard:
    #     print(x)
    #     x += 1
    #     return x
    # for y in checkerboard:
    #     print(y)
    #     y += 1
    #     return y
    return render_template("index.html", phrase="hello", row=8, column=8, color1="black", color2="red")


@app.route('/<x>')
def row(x):
    # cell_x = 8
    # cell_y = 8
    # total_cells = (cell_x * cell_y)
    # checkerboard = x * y
    # for x in checkerboard:
    #     print(x)
    #     x += 1
    #     return x
    # for y in checkerboard:
    #     print(y)
    #     y += 1
    #     return y
    x = int(x)
    return render_template("index.html", phrase="hello", row=x, column=8, color1="black", color2="red")


@app.route('/<x>/<y>')
def grid(x, y):
    # cell_x = 8
    # cell_y = 8
    # total_cells = (cell_x * cell_y)
    # checkerboard = x * y
    # for x in checkerboard:
    #     print(x)
    #     x += 1
    #     return x
    # for y in checkerboard:
    #     print(y)
    #     y += 1
    #     return y
    x = int(x)
    y = int(y)
    return render_template("index.html", phrase="hello", row=x, column=y, color1="black", color2="red")


@app.route('/<x>/<y>/<color1>/<color2>')
def colorGrid(x, y, color1, color2):
    # cell_x = 8
    # cell_y = 8
    # total_cells = (cell_x * cell_y)
    # checkerboard = x * y
    # for x in checkerboard:
    #     print(x)
    #     x += 1
    #     return x
    # for y in checkerboard:
    #     print(y)
    #     y += 1
    #     return y
    x = int(x)
    y = int(y)
    return render_template("index.html", phrase="hello", row=x, column=y, color1=color1, color2=color2)

if __name__ == "__main__":
    app.run(debug=True)
