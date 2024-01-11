from flask import Flask
from flask_app.controllers.user_controll import user_api
from    flask_app import app 

app.register_blueprint(user_api)

if __name__ =="__main__":
    app.run(debug=True ,port=5004)