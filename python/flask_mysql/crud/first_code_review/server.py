from flask import Flask, render_template
from books_models import Book
app=Flask(__name__)


@app.route('/')
def home():
    all_books=Book.get_all()
    return render_template("index.html",books=all_books)




if __name__==("__main__"):
    app.run(debug = True)
