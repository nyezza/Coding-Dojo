from flask_app.models.like_models import Liked
from flask_app.models.book_models import Book
from flask_app.models.user_models import User
from flask_app import app 
from flask import flash,render_template,session,request,redirect
import re

@app.route('/like/<int:book_id>')
def add_like(book_id):
    data={
        'user_id':session['user_id'],
        'book_id':book_id
    }
    Liked.add_like(data)
    return redirect('/books')

# @app.route('/save_like',methods=['post'])
# def save_like():
    