
from flask_app.models.user_models import User
from flask_app import app
import re
from flask import flash,render_template,redirect,session,request
from flask_bcrypt import Bcrypt 
from flask_app.models.recipe_models import Recipe

bcrypt = Bcrypt(app)


@app.route('/')
def home():
    return render_template("index.html")

@app.route('/users/register', methods=['post'])
def register():
    if not User.validation(request.form):
        return redirect('/')  
    hash_pwd=bcrypt.generate_password_hash(request.form['password'])
    user_data={
        **request.form,
        'password' : hash_pwd
    }
    user_id=User.create_user(user_data)
    session[user_id]=user_id
    return redirect('/dashboard')
    

@app.route('/user/login',methods=['post'])
def login():
    user_from_db=User.get_by_email({'email':request.form['email']})
    if not user_from_db:
        flash('Invalid password/Email',"login")
        return('/')
    if not bcrypt.check_password_hash(user_from_db.password, request.form['password']):
        flash('Invalid password/Email',"login")
        return redirect('/')
    session["user_id"]=user_from_db.id
    return redirect('/dashboard')

@app.route('/logout')
def logout():
    session.clear()
    return redirect('/')
    
@app.route('/dashboard')
def dashboard():
    if 'user_id' not in session:
        return redirect('/')
    all_recipes=Recipe.get_all()
    logged_in_user=User.get_by_id({'id': session['user_id']})
    return render_template("display_recipes.html",user= logged_in_user,all_recipes=all_recipes)

