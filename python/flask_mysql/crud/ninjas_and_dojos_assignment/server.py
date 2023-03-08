from flask_app import app
from flask_app.controllers import dojo,ninja



if __name__=="__main__":
    app.run(debug=True,port=5002)