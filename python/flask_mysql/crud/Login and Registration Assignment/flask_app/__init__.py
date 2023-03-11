from flask import Flask
app=Flask(__name__)

app.secret_key= 'hash my code !'

DATABASE='login_and_register'