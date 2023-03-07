from flask import render_template, redirect , request
from flask_app import app
from flask_app.models.singer_model import Singer



@app.route('/')
def home():
    all_singers = Singer.get_all()
    return render_template("index.html" , all_singers = all_singers)

@app.route('/singers/new')
def new_singer():
    return render_template("new_singer.html")

@app.route('/singers/create', methods=['post'])
def create_singer():
    print(request.form, "****")
    Singer.create(request.form)
    return redirect('/')

@app.route('/singers/<int:singer_id>')
def one_singer(singer_id):
    data = {
        "id": singer_id
    }
    one_singer = Singer.get_by_id(data)
    return render_template("one_singer.html", singer = one_singer)

@app.route("/singers/edit/<int:singer_id>")
def edit_singer(singer_id):
    singer_to_edit = Singer.get_by_id({"id":singer_id})
    return render_template("edit_singer.html", singer = singer_to_edit)

@app.route("/singers/update", methods = ["post"])
def update_singer():
    print("+"*20,request.form,"+"*20)
    Singer.update(request.form)
    return redirect('/')

@app.route("/singers/delete/<int:singer_id>")
def delete_singer(singer_id):
    Singer.delete({"id":singer_id})
    return redirect("/")