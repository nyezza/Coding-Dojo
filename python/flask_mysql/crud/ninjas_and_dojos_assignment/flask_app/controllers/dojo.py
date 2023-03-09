from flask import render_template, redirect,request
from flask_app.models.dojos_models import Dojos
from flask_app.models.ninjas_models import Ninjas
from flask_app import app

@app.route('/')
def home():
    return redirect('/dojo')

@app.route('/dojo')
def dojos_display():
    dojos_created=Dojos.get_all_dojos()
    return render_template("index.html",all_dojos=dojos_created)

@app.route('/dojo/create', methods=['post'])
def create_dojos():
    print(request.form)
    Dojos.create(request.form)
    return redirect('/')