from flask import Flask , render_template, redirect , request 
from book_model import Book
app  = Flask(__name__)

@app.route('/')
def home():
    all_books = Book.get_all()
    return render_template("index.html", books = all_books)


@app.route('/books/new')
def new_book():
    return render_template("new_book.html")

@app.route('/books/create', methods=['post'])
def create_book():
    Book.create(request.form)
    return redirect('/')


if __name__ == '__main__':
    app.run(debug = True)