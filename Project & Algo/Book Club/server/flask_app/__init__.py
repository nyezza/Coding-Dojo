from flask import Flask

app= Flask(__name__)
app.sercret_key = 'hash my code!'
DATABASE = "book_club_db"