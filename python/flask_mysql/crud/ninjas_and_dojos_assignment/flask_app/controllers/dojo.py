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

@app.route('/dojo/<int:id_dojo>')
def display(id_dojo):
    da={
        "id":id_dojo
    }
    dojo_name=Dojos.get_name_by_id(da)
    dojos_dicover=Dojos.get_by_id(da)
    return render_template("display_dojos_ninjas.html",ninjas_list=dojos_dicover,dojo_name=dojo_name)