from flask_app.models.book_models import Book
from flask_app import app 
from flask import flash,render_template,session,request,redirect
import re

@app.route('/books/create' , methods=['post'])
def create_book():
    if not Book.validation(request.form):
        return redirect('/books')
    data={
        **request.form,'user_id':session['user_id']
    }
    Book.create_book(data)
    return redirect('/books')