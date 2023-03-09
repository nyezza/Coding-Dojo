from flask_app.models.dojos_models import Dojos
from flask_app.models.ninjas_models import Ninjas
from flask_app import app
from flask import render_template,redirect,request

@app.route('/ninjas')
def create_ninjas():
    dojoslist=Dojos.get_all_dojos()
    return render_template("create_ninjas.html",all_dojos=dojoslist)

@app.route('/ninjas/new',methods=['post'])
def new_ninjas():
    print (request.form)
    Ninjas.create_ninjas(request.form)
    return redirect('/ninjas')

