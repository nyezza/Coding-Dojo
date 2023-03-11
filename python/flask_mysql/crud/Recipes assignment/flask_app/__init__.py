from flask import Flask
app=Flask(__name__)

app.secret_key="Encrypt my password !!!!!"

DATABASE= "recipes_db"