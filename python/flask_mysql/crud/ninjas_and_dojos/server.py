from flask_app import app

@app.route('/')
def home():
    return "hello"

if __name__=="__main__":
    app.run(debug = True)