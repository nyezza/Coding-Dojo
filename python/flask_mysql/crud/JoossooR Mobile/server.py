from flask import Flask, render_template, request, redirect
from user_model import User
app=Flask(__name__)

@app.route('/')
def main():
    return redirect('/all')

@app.route('/all')
def Read_all():
    all_porters=User.get_all()
    return render_template("index.html", porter_list=all_porters)

@app.route('/porter/new')
def new():
    return render_template("new.html")

@app.route('/porter/create')
def create():
    User.create(request.form)
    return redirect('/')
    









if __name__=="__main__":
    app.run(debug = True)