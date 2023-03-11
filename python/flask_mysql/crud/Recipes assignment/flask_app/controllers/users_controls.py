from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models.user_models import User
from flask_app import DATABASE,app
import re
from flask import flash,render_template,redirect,session,request
from flask_bcrypt import Bcrypt 

bcrypt = Bcrypt(app)


@app.route('/')
def home():
    return render_template("index.html")

@app.route('/new_user', methods=['post'])
def add_user():
    if User.validation(request.form):
        User.create_user(request.form)
    return redirect('/')



