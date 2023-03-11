from flask import render_template, session, redirect, request,flash
from flask_app import app
from flask_app.models.users_model import User
from flask_bcrypt import Bcrypt

bcrypt = Bcrypt(app)

@app.route('/')
def main():
    return render_template("index.html")

@app.route('/new',methods=['post'])
def add_new():
    if User.validation(request.form):
        hashed_password=bcrypt.generate_password_hash(request.form['password'])
        print(request.form)
        user_data={
            **request.form,
            'password':hashed_password
        }
        print(request.form['password'],"="*20,hashed_password)
        session['user_id']=User.add_user(user_data)
        return redirect('/')
    return render_template("index.html")

@app.route('/user/login', methods=['post'])
def login_user():
    data={
        "email":request.form['email'],
        "password":request.form['password']
    }
    
    user_in_db=User.get_by_email({'email': request.form['email']})
    
    if user_in_db:
        if not bcrypt.check_password_hash(user_in_db.password, data['password']):
            flash('Invalid password/Email')
            return redirect('/')
        else:
            session['user_id']=user_in_db.id
            return redirect('/dashboard')
            
    flash('Invalid password/Email')
    return redirect('/')
    
@app.route('/dashboard')
def dashboard():
    user_logged_in=User.get_by_id({"id": session['user_id']})
    return render_template("dashboard.html",loggedin=user_logged_in)

@app.route('/logout')
def logout_user():
    session.clear()
    return redirect('/')