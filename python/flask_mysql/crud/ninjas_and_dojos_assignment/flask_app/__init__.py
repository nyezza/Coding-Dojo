from flask import Flask

app=Flask(__name__)
app.secret_key="my secret key! SHHHH!"
DATABASE='dojos_and_ninjas'