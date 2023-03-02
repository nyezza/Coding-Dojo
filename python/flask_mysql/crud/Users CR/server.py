from flask import Flask, render_template, redirect, request
from user_model import Users

app=Flask(__name__)

@app.route('/')
def main():
    return redirect('/user')
    
@app.route('/user')
def all():
    all_users= Users.read_all()
    return render_template("read.html",users_list=all_users)
@app.route('/user/new')
def new():
    return render_template("create.html")

@app.route('/user/create', methods=['post'] )
def create_user():
    print(request.form)
    Users.create(request.form)
    return redirect('/')



if __name__=="__main__":
    app.run(debug = True)