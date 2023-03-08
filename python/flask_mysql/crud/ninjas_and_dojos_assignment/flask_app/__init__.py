from flask import Flask

app=Flask(__name__)
app.secret_key="my secret key! SHHHH!"
DATABASE='ninjas_and_dojos'