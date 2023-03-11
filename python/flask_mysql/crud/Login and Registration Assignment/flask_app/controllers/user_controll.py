from flask import render_template, session, redirect, request,flash
from flask_app import app
from flask_app.models.users_model import User

@app.route('/')
def main():
    return render_template("index.html")

@app.route('/new',methods=['post'])
def add_new():
    if User.validation(request.form):
        print(request.form)
        User.add_user(request.form)
        return redirect('/')
    return render_template("index.html")

@app.route('/user/login', methods=['post'])
def login_user():
    user_in_db=User.get_by_email({'email': request.form['email']})
    if user_in_db:
        if not(user_in_db.password, request.form['password']):
            flash('Invalid password/Email')
            return redirect('/')
        else:
            loggedin=request.form['first_name']
            return render_template("dashboard.html",loggedin=loggedin)
    