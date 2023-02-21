from flask import Flask
app = Flask(__name__)
# Create a root route ("/") that responds with "Hello World!"
@app.route('/')
def home():
    return 'Hello World !'

# Create a route that responds with "Dojo!"
@app.route('/dojo')
def dojo_page():
    return 'Dojo !'
# Create a route that responds with "Hi" and whatever name is in the URL after /say/
@app.route('/say/<string:name>')
def say_hi(name):
    return f'Hi {name}'
# Create a route that responds with the given word repeated as many times as specified in the URL
@app.route('/repeat/<times>/<word>')
def repeat_time(times,word):
    if ((type(times)==int) and (type(word)==str)):
        return f"{word} " * int(times)
    else:
        return "Sorry! No response. Try again."


if __name__=="__main__":
    app.run(debug=True)