from flask_app.models.book_models import Book
from flask_app.models.user_models import User
from flask_app.models.like_models import Liked
from flask_app import app 
from flask import flash,render_template,session,request,redirect
import re

@app.route('/books/create' , methods=['post'])
def create_book():
    if not Book.validation(request.form):
        flash('Invalid title/description',"create")
        return redirect('/books')
    data={
        **request.form,'user_id':session['user_id']
    }
    Book.create_book(data)
    return redirect('/books')

@app.route('/books/<int:book_id>')
def view_one(book_id):
    if 'user_id' not in session:
        return redirect('/')
    logged_in_user=User.get_by_id({'id': session['user_id']})
    oneBook=Book.get_by_id({'id':book_id})
    liked_book=Book.get_user_book_by_id({'id':book_id})
    return render_template("view_one_book.html",oneBook=oneBook,user=logged_in_user, liked_book=liked_book)

@app.route('/books/edit/<int:book_id>')
def edit_one(book_id):
    if 'user_id' not in session:
        return redirect('/')
    logged_in_user=User.get_by_id({'id': session['user_id']})
    oneBook=Book.get_by_id({'id':book_id})
    liked_book=Book.get_user_book_by_id({'id':book_id})
    return render_template("update_one_book.html",oneBook=oneBook,user=logged_in_user, liked_book=liked_book)

@app.route('/books/update' , methods=['post'])
def update_one():
    if 'user_id' not in session:
        return redirect('/')
    if not Book.validation(request.form):
        flash('Invalid title/description',"create")
        return redirect('/books/edit'+ request.form['id']) 
    Book.update(request.form)
    return redirect('/books')

@app.route('/books/remove/<int:book_id>')
def remove(book_id):
    if 'user_id' not in session:
        return redirect('/')
    Book.remove({'id':book_id})
    return redirect('/books')