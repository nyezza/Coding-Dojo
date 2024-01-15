
from flask_app.models.user_models import User
from flask_app.models.book_models import Book
from flask_app.models.like_models import Liked
from flask_app import app
from flask import flash,render_template,redirect,session,request
from flask_bcrypt import Bcrypt 


bcrypt = Bcrypt(app)


@app.route('/')
def home():
    return render_template("register.html")

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
    return redirect('/')
    

@app.route('/user/login',methods=['post'])
def login():
    user_from_db=User.get_by_email({'email':request.form['email']})
    if not user_from_db:
        flash('Invalid password/Email',"login")
        return redirect('/')
    if not bcrypt.check_password_hash(user_from_db.password, request.form['password']):
        flash('Invalid password/Email',"login")
        return redirect('/')
    session["user_id"]=user_from_db.id
    return redirect('/books')

@app.route('/logout')
def logout():
    session.clear()
    return redirect('/')
    
@app.route('/books')
def dashboard():
    if 'user_id' not in session:
        return redirect('/')
   
    logged_in_user=User.get_by_id({'id': session['user_id']})
    all_books=Book.get_all()
    return render_template("dashboard.html",user= logged_in_user,books=all_books)

