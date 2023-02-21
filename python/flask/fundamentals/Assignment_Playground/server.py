from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def main():
    return "Welcome"

@app.route('/play/<int:number>')
def play(number):
    return render_template('index.html',number=number)

@app.route('/play/<int:number>/<string:color>')
def playground(number,color):
    return render_template('index.html',number=number,color=color)


if (__name__== "__main__"):
    app.run(debug=True)
